package xyz.somniumproject.simple_login_client.commands

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

class MobileUserCommand(
        var token: String,
        var profiles: List<String>
) {
    class Deserializer : ResponseDeserializable<MobileUserCommand> {
        override fun deserialize(content: String) = Gson().fromJson(content, MobileUserCommand::class.java)
    }
}
