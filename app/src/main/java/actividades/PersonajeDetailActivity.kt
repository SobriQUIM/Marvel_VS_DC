package actividades

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.example.marvelvsdc.R

class PersonajeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.listas_personajes_activity)

        // Obtener los datos del héroe desde el Intent
        val personajeName = intent.getStringExtra("heroName")
        val personajeImageUrl = intent.getStringExtra("heroImageUrl")
        val personajePublisherId = intent.getIntExtra("heroPublisherId", -1)

        // Mostrar los datos en la vista
        val personajeNameTextView = findViewById<TextView>(R.id.personajeDetailName) // Corregido para que sea el ID correcto
        val personajePublisherTextView = findViewById<TextView>(R.id.personajeDetailPublisher)
        val personajeImageView = findViewById<ImageView>(R.id.personajeDetailImage)

        // Establecer texto en los TextViews
        personajeNameTextView.text = personajeName
        personajePublisherTextView.text = "Publisher ID: $personajePublisherId"

        println(personajeImageUrl)
        // Cargar la imagen usando Picasso
        Picasso.get()
            .load(personajeImageUrl)
            .into(personajeImageView)

        // Configurar el botón de "Volver"
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()  // Cierra esta actividad y vuelve a la anterior
        }
    }
}
