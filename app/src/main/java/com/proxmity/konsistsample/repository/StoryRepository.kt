package com.proxmity.konsistsample.repository

import com.proxmity.konsistsample.model.Feed
import com.proxmity.konsistsample.model.UIFeed
import com.proxmity.konsistsample.viemodel.FeedViewModel

class StoryRepository(feedViewModel: FeedViewModel) : BaseRepository() {
    override fun getPrimaryKey(): String {
        TODO("Not yet implemented")
    }

    override fun mapFeedToUIFeed(feed: Feed): UIFeed {
        TODO("Not yet implemented")
    }
}
