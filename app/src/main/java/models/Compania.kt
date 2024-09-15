package models

import android.media.Image

data class Compania(val id : Int, val name : String, val image : String){
    companion object{
        val publisherList = listOf(
            Compania(1,"Marvel", ""),
            Compania(2,"DC", "")
        )
    }
}