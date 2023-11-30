package com.prasanth.konsistsample.repository

import com.prasanth.konsistsample.model.Feed
import com.prasanth.konsistsample.model.UIFeed
import com.prasanth.konsistsample.viemodel.FeedViewModel

class StoryRepository(feedViewModel: FeedViewModel) : BaseRepository() {
    override fun getPrimaryKey(): String {
        TODO("Not yet implemented")
    }

    override fun mapFeedToUIFeed(feed: Feed): UIFeed {
        TODO("Not yet implemented")
    }
}
