package xyz.somniumproject.simple_login_client.commands

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

class Message(
        var message: String,
        var error: Boolean = false) {
    class Deserializer : ResponseDeserializable<Message> {
        override fun deserialize(content: String) = Gson().fromJson(content, Message::class.java)
    }
}