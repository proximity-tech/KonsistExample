package com.prasanth.konsistsample

import com.lemonappdev.konsist.api.Konsist
import com.lemonappdev.konsist.api.architecture.KoArchitectureCreator.assertArchitecture
import com.lemonappdev.konsist.api.architecture.Layer
import com.lemonappdev.konsist.api.ext.list.functions
import com.lemonappdev.konsist.api.ext.list.properties
import com.lemonappdev.konsist.api.ext.list.withAllAnnotationsOf
import com.lemonappdev.konsist.api.ext.list.withNameEndingWith
import com.lemonappdev.konsist.api.ext.list.withReturnType
import com.lemonappdev.konsist.api.verify.assertEmpty
import com.lemonappdev.konsist.api.verify.assertNotEmpty
import com.lemonappdev.konsist.api.verify.assertTrue
import com.prasanth.konsistsample.util.SERIALIZABLE
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun `every use case reside in use case package`() {
        Konsist
            .scopeFromProject() // Define the scope containing all Kotlin files present in the project
            .classes() // Get all class declarations
            .withNameEndingWith("UseCase") // Filter classes heaving name ending with 'UseCase'
            .assertTrue { it.resideInPackage("..usecase..") } // Assert that each class resides in 'any domain.usecase any' package
    }

    @Test
    fun `check if classes having serializable annotation override toString`() {
        Konsist
            .scopeFromProject()
            .classes()
            .withAllAnnotationsOf(SERIALIZABLE::class)
            .functions()
            .withNameEndingWith("toString")
            .assertNotEmpty()
    }

    @Test
    fun `check if variables start with small case`() {
        Konsist
            .scopeFromPackage("com.prasanth.konsistsample.model..")
            .classes()
            .properties()
            .forEach {
                assertTrue(it.name.startsWith(it.name[0].lowercase(), ignoreCase = false))
            }
    }

    @Test
    fun `check if functions return type is not a list`() {
        val functions = Konsist
            .scopeFromPackage("com.prasanth.konsistsample.repository..")
            .classes()
            .functions()
        functions
            .withReturnType {
                println(it.name)
                return@withReturnType it.name.startsWith("List")
            }
            .assertEmpty()
    }

    @Test
    fun `clean architecture layers have correct dependencies`() {
        Konsist
            .scopeFromProject() // Define the scope containing all Kotlin files present in project
            .assertArchitecture { // Assert architecture
                // Define layers
                val domain = Layer("UseCase", "com.prasanth.konsistsample.usecase..")
                val viewModel = Layer("ViewModel", "com.prasanth.konsistsample.viemodel..")
                val repository = Layer("Repository", "com.prasanth.konsistsample.repository..")

                // Define architecture assertions
                viewModel.dependsOn(domain)
                domain.dependsOn(repository)
                repository.dependsOnNothing()
            }
    }
}
