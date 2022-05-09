package com.example

import java.util.PriorityQueue

// Create an algorithm that given a User Profile meme Data
// Returns A Meme(name, imgURL, Optional: Num Likes, tags, etc...)

// Data class Category(val tag: String)
// tags maps <Bunny, 55>, which is Category -> Percent of Memes Liked in category
// Would better data structure be a prio queue, or even just a sorted list?
// Lets use map for now and iterate later)

// Category("Bunny", 25, 100)
data class Category(val name: String, val numLiked: Int, val totalShown: Int)

//data class UserProfileMemeData(tags: Map<String, Int>)

//Uses a priority queue to give us the NEXT category with the lease amount of memes shown
data class UserProfileMemeData(val categoryData: List<Category>, val sortedCategoriesByShown: PriorityQueue<Category>)

// If TAGS is empty OR total count is less than

// We should have a parameter that dictates ratio of memes we show that are "accurate" vs "exploration"

const val EXPLORATION_CONSTANT = .5
fun calculateNextMeme(userData: UserProfileMemeData): Meme {

    //X: [0, 1] if X > .5 then lets give something accurate
    if (Math.random() > EXPLORATION_CONSTANT) {

    }
    //X < .5, lets EXPLORE
    return explore(userData)



}

/**
 * Uses PriorityQueue Poll to figure out what's the category with the lowest # of images shown to a user
 * Shows an image from the category with the least # of images shown to a user so far
 * Ties are not broken in any special way currently, however prio queue currently breaks them which is fine for now
 *
 * @param userData to digest and make an exploration guess based off of
 */
fun explore(userData: UserProfileMemeData): Meme {

    return getMemeFromCategory(userData.sortedCategoriesByShown.poll())

}

fun getMemeFromCategory(category: Category): Meme {
    // We should probably get one of the top memes in this category during exploration, but we can do that later

    // For now we will just access our meme DB that is sorted by TAG
    // TODO: Talk to MEMEDB, memedb.get().sortBy(category.name).first()
    return Meme("test-data title", "test-url", "test-tag", "2", ".5")
}

// We can use # of memes shown in category to build a confidence interval like elo for each one
// As we build confidence interval for each category, at say 100 memes shown (preferably before then), we will
// Assume the user is not interested in the category
// We will need more input factors such as time spent looking at a meme, probably average time spent looking at it
// Since some memes may be complex to look at and everyone looks at it for longer
// A rating bar based on % [0, 100] of how much a user liked said meme












