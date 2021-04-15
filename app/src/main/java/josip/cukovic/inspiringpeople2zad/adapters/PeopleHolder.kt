package josip.cukovic.inspiringpeople2zad.adapters

import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import josip.cukovic.inspiringpeople2zad.databinding.PersonLayoutBinding
import josip.cukovic.inspiringpeople2zad.listener.PersonInteractionListener
import josip.cukovic.inspiringpeople2zad.model.InspiringPerson

class PeopleHolder(itemView: View, private val context: Context): RecyclerView.ViewHolder(itemView) {

    fun bind(person : InspiringPerson, personListener: PersonInteractionListener){
        val itemBinding = PersonLayoutBinding.bind(itemView)
        itemBinding.ivPersonImage.setImageResource(person.image)
        itemBinding.tvName.text = person.name
        itemBinding.tvDate.text = person.dateOfDeath
        itemBinding.tvDescription.text = person.description

        itemBinding.ivPersonImage.setOnClickListener{personListener.onShowQuote(person.randomQuote())}
        itemView.setOnLongClickListener{personListener.onRemove(person.personId,adapterPosition); true;}

    }



}