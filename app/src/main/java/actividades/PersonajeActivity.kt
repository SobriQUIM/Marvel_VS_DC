package actividades

import adapters.PersonajesAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import models.Personaje
import com.example.marvelvsdc.R
import actividades.PersonajeDetailActivity


class PersonajeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.principal)

        val ourCharacters = listOf(
            // Personajes de DC
            Personaje("https://i.imgur.com/S3OGqV6.jpeg",
                "Batman",
                2),
            Personaje("https://e00-elmundo.uecdn.es/assets/multimedia/imagenes/2022/08/03/16595421832009.jpg", "Superman", 2),
            Personaje("https://upload.wikimedia.org/wikipedia/en/b/b7/Flash_%28Barry_Allen%29.png", "Flash", 2),
            Personaje("https://www.mundodeportivo.com/alfabeta/hero/2023/11/wonder-woman.1698964414.6042.jpg?width=768&aspect_ratio=16:9&format=nowebp", "Wonderwoman", 2),
            Personaje("https://i.etsystatic.com/43909860/r/il/4e9028/4957760900/il_570xN.4957760900_owmq.jpg", "Joker", 2),

            // Personajes de Marvel
            Personaje("https://img2.rtve.es/i/?w=1600&i=1442912664626.jpg", "Spiderman", 1),
            Personaje("https://e1.pngegg.com/pngimages/819/968/png-clipart-iron-man-iron-man.png", "Iron Man", 1),
            Personaje("https://m.media-amazon.com/images/I/51LCQiQkZpL._AC_UF894,1000_QL80_.jpg", "Deadpool", 1),
            Personaje("https://es.gizmodo.com/app/uploads/2023/09/2e8db2e5ecf432a7fb98197789e76eb1.jpg", "Wolverine", 1),
            Personaje("https://i.blogs.es/ef60de/thanos/375_375.webp", "Thanos", 1),


        )

        setupRecyclerView(findViewById(R.id.marvel_characters_list),
            ourCharacters.filter { personaje -> personaje.PublisherId == 2 })

        setupRecyclerView(findViewById(R.id.dc_characters_list),
            ourCharacters.filter { personaje -> personaje.PublisherId == 1 })
    }

    private fun setupRecyclerView(recyclerView: RecyclerView, data: List<Personaje>) {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.adapter = PersonajesAdapter(data) { personaje ->
            // Navegar a PersonajeDetailActivity con los datos del personaje
            val intent = Intent(this, PersonajeDetailActivity::class.java).apply {
                putExtra("heroName", personaje.name)
                putExtra("heroImageUrl", personaje.imageUrl)
                putExtra("heroPublisherId", personaje.PublisherId)
            }
            startActivity(intent)
        }
    }
}
