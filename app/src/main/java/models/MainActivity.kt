package models

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import models.User
import com.example.marvelvsdc.R
import actividades.PersonajeActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout)

        // Referenciar los elementos de la interfaz

        val usernameEditText = findViewById<EditText>(R.id.usuario)
        val passwordEditText = findViewById<EditText>(R.id.contrasenia)
        val loginButton = findViewById<Button>(R.id.login_button)

        // Establecer listener para el botón de login
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val isValidUser = User.users.any { user ->
                user.email == username && user.password == password
            }


// Verificar las credenciales
            if (isValidUser) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()

                // Redirigir a la actividad PersonajesActivity
                val intent = Intent(this, PersonajeActivity::class.java)
                startActivity(intent)

                // Opcionalmente puedes finalizar la actividad actual si ya no quieres que esté en la pila
                //finish()
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
