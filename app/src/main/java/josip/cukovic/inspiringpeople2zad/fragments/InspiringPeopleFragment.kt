package josip.cukovic.inspiringpeople2zad.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import josip.cukovic.inspiringpeople2zad.adapters.PeopleAdapter
import josip.cukovic.inspiringpeople2zad.data.PeopleRepository
import josip.cukovic.inspiringpeople2zad.databinding.FragmentInspiringPeopleBinding
import josip.cukovic.inspiringpeople2zad.listener.PersonInteractionListener

class InspiringPeopleFragment : Fragment() {
    lateinit var inspiringPeopleBinding: FragmentInspiringPeopleBinding

    companion object{
        fun newInstance(): InspiringPeopleFragment{
            return InspiringPeopleFragment()
        }

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        inspiringPeopleBinding = FragmentInspiringPeopleBinding.inflate(inflater,container,false)
        inspiringPeopleBinding.rvInspiringPeople.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
        displayData()
        return inspiringPeopleBinding.root
    }

    private fun displayData() {
        val personListener = object: PersonInteractionListener {
            override fun onRemove(id: Int,position:Int) {
                PeopleRepository.remove(id)
                (inspiringPeopleBinding.rvInspiringPeople.adapter as PeopleAdapter).dataRemoved(PeopleRepository.people,position)
            }

            override fun onShowQuote(quote: String) {
                Toast.makeText(context, quote, Toast.LENGTH_LONG).show()
            }
        }
        inspiringPeopleBinding.rvInspiringPeople.adapter = PeopleAdapter(PeopleRepository.people,personListener)
    }

}