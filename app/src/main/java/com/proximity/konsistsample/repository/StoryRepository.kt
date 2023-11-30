package com.proximity.konsistsample.repository

import com.proximity.konsistsample.model.Feed
import com.proximity.konsistsample.model.UIFeed
import com.proximity.konsistsample.viemodel.FeedViewModel

class StoryRepository(feedViewModel: FeedViewModel) : BaseRepository() {
    override fun getPrimaryKey(): String {
        TODO("Not yet implemented")
    }

    override fun mapFeedToUIFeed(feed: Feed): UIFeed {
        TODO("Not yet implemented")
    }
}
