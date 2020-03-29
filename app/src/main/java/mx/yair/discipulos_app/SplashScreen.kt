package mx.yair.discipulos_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import kotlinx.android.synthetic.main.splash_screen.*

class SplashScreen : AppCompatActivity() {
    private val  TIME: Long = 3000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_screen)
        Handler().postDelayed(
            {
                startActivity(
                    Intent(this, MainActivity::class.java)
                )
            },TIME)

        appName.text = "Aplicacion desarrollada para atacar el problema de pobreza en el mundo"
        namesAlumno.text = "Yair Pimentel\t\tA01652823\n\nGermán Reyes\t\tA01336637\n\nDiego Moreno\t\tA01337594"
    }
}
