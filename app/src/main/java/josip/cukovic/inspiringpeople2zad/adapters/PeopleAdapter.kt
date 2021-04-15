package josip.cukovic.inspiringpeople2zad.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import josip.cukovic.inspiringpeople2zad.R
import josip.cukovic.inspiringpeople2zad.listener.PersonInteractionListener
import josip.cukovic.inspiringpeople2zad.model.InspiringPerson

class PeopleAdapter(people : MutableList<InspiringPerson>, personListener: PersonInteractionListener): RecyclerView.Adapter<PeopleHolder>() {
    private val people : MutableList<InspiringPerson> = mutableListOf()
    private val personListener: PersonInteractionListener
    init {
        this.people.addAll(people)
        this.personListener = personListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.person_layout,parent,false)
        return PeopleHolder(view,parent.context)
    }

    override fun onBindViewHolder(holder: PeopleHolder, position: Int) = holder.bind(people[position],personListener)

    override fun getItemCount(): Int = people.size

    fun dataAdded(person: MutableList<InspiringPerson>){
        val number = itemCount
        this.people.clear()
        this.people.addAll((person))
        if(itemCount == number) return
        notifyItemInserted(itemCount - 1)
    }

    fun dataRemoved(person: MutableList<InspiringPerson>,position: Int){
        this.people.clear()
        this.people.addAll((person))
        notifyItemRemoved(position)
    }
}