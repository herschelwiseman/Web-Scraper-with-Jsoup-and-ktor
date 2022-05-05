# Web-Scraper-with-Jsoup-and-ktor

This scrapes from https://www.memedroid.com/memes/random to get random memes with the parameters: Title, Tag, # votes, % of votes that are likes, imgurl

To run the scraper:

Run `Application.kt` to start the server(If you are using Intellij, Navigate to Application.kt and press the green arrow), or `./gradlew :project-name:run`

Then make a get request to `localhost:8080/memes/random` to receive a list of Memes.  

If you are using intellij, I have left a template that will run a get request for you by pressing the green play button.  
Navigate to `generated-requests.http` and select play: ![image](https://user-images.githubusercontent.com/47089224/166983114-cd638a61-17e7-49a7-a380-d27140e93ee9.png)

Get returns a list of Memes where a Meme is:

```kotlin data class Meme(val title: String, val image: String, val tag: String, val votes: String, val percentLiked: String)```
