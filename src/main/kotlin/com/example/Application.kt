package com.example

import com.example.plugins.configureRouting
import com.example.plugins.configureSerialization
import io.ktor.server.application.*
import org.jsoup.Jsoup

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureRouting()
    configureSerialization()
}

val memedroid = "https://www.memedroid.com/"

// TODO: Move into it's own class, leaving it here for simplicity to demo for now
data class Meme(val title: String, val image: String, val tag: String, val votes: String, val percentLiked: String)
fun scrapeMemeDroid(): List<Meme> {
    val data = mutableListOf<Meme>()
    val document = Jsoup.connect("$memedroid/memes/random").get()
    val events = document.select("div.item-aux-container")

    val tagsContainer = document.select("div.tags-container")

    events.forEachIndexed { index, element ->
        element.apply {
            val title = select("a.item-header-title.dyn-link").text()
            val image = select("a.dyn-link")
                .select("img").attr("src")
            val votes = select("span.item-rating-vote-count").text()
            val percentLiked = select("span.green-1").text()

            val tag = tagsContainer.select("a.dyn-link").eq(index).text() // Uses different container so eq find

            data.add(Meme(title, image, tag, votes, percentLiked))
        }
    }

    return data.toList() //To List to prevent mutations
}
