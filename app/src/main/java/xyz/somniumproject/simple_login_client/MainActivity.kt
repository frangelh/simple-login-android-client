package xyz.somniumproject.simple_login_client

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.result.Result
import com.github.kittinunf.result.getAs
import kotlinx.android.synthetic.main.activity_main.*
import xyz.somniumproject.simple_login_client.commands.UserAuthReturn

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txt_ip.setText("192.168.0.251")
        txt_username.setText("admin")
        txt_password.setText("admin")
        btn_signin.setOnClickListener {
            if (txt_username.text.toString().isNotEmpty() && txt_password.text.toString().isNotEmpty()) {
                Fuel.get("http://" + txt_ip.text.toString() + ":8080/auth/login/",
                        listOf("user" to txt_username.text.toString(),
                                "password" to txt_password.text.toString())
                ).responseObject(UserAuthReturn.Deserializer()) { req, res, result ->
                    when (result) {
                        is Result.Failure -> println(result)
                        is Result.Success -> {
                            val userReturn: UserAuthReturn? = result.getAs()
                            val message = userReturn?.message?.message
                            val token = userReturn?.user?.token
                            val profiles = userReturn?.user?.profiles
                            txt_console.text.append("Message: $message \n Token: $token \n Profiles: $profiles \n")
                            txt_console.text.append("---------------------------------------------------")

                        }
                    }
                }
            }
        }
    }
}
