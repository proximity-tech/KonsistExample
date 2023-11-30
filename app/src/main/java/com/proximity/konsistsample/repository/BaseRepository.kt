package com.proximity.konsistsample.repository

import com.proximity.konsistsample.model.Feed
import com.proximity.konsistsample.model.UIFeed
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class BaseRepository {
    protected var _isLoading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    abstract fun getPrimaryKey(): String
    abstract fun mapFeedToUIFeed(feed: Feed): UIFeed
    fun getFeedList(): List<String> {
        return listOf()
    }
}
