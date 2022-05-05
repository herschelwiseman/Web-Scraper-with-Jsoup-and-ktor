package com.example.plugins

import com.example.scrapeMemeDroid
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

// TODO: Change routing to some structure later:
// https://ktor.io/docs/structuring-applications.html#group_by_feature
fun Application.configureRouting() {
    routing {
      get("memedroid/random")  {
          //Scrape to get a request
          val scrapedData = scrapeMemeDroid()
          call.respondText("$scrapedData")
      }
    }
}
