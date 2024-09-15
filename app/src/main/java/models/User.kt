package models

data class User(val name:String,val email:String,val password: String){
    //Mensaje de bienvenida al usuario
    val computedName :String get() = "Hola, $name"
    companion object{
        //Lista de Usuarios
        val users = listOf(
            User("Juan","juanfr97@hotmail.com","admin"),
            User("Cesar","cesar3434@hotmail.com","admin"),
            User("Manola","manola64@hotmail.com","admin"),
            User("1","1","1")
        )
    }
}