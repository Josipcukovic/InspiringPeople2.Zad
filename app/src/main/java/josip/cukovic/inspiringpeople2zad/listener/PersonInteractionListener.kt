package josip.cukovic.inspiringpeople2zad.listener

interface PersonInteractionListener {
    fun onRemove(id: Int,position:Int)
    fun onShowQuote(quote: String)
}