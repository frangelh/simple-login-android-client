package xyz.somniumproject.simple_login_client.commands

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson

class UserAuthReturn(
        var user: MobileUserCommand,
        var message: Message
) {
    class Deserializer : ResponseDeserializable<UserAuthReturn> {
        override fun deserialize(content: String) = Gson().fromJson(content, UserAuthReturn::class.java)
    }
}
