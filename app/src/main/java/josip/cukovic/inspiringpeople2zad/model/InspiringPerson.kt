package josip.cukovic.inspiringpeople2zad.model

import josip.cukovic.inspiringpeople2zad.R

class InspiringPerson(val name:String, val dateOfDeath : String, val description : String, quotes : MutableList<String>, val image : Int = R.drawable.character) {
    private val quotes : MutableList<String> = mutableListOf()
    init {
        this.quotes.addAll(quotes)
    }
    val personId = getPersonId()
    companion object{
        private var Id = 0
        fun getPersonId(): Int {
            Id++
            return  Id
        }
    }
    fun randomQuote():String{
        val randomPosition = (0 until quotes.size).random()
        return this.quotes[randomPosition]
    }

}