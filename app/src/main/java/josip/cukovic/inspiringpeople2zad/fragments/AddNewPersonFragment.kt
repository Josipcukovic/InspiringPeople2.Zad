package josip.cukovic.inspiringpeople2zad.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import josip.cukovic.inspiringpeople2zad.data.PeopleRepository
import josip.cukovic.inspiringpeople2zad.databinding.FragmentAddPersonBinding
import josip.cukovic.inspiringpeople2zad.model.InspiringPerson

class AddNewPersonFragment: Fragment() {
    companion object {
        fun newInstance(): AddNewPersonFragment{
            return AddNewPersonFragment()
        }
    }
    private lateinit var addNewPersonBinding: FragmentAddPersonBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        addNewPersonBinding = FragmentAddPersonBinding.inflate(inflater,container,false)
        setupUI()
        return addNewPersonBinding.root
    }

    private fun setupUI() = addNewPersonBinding.btnSavePerson.setOnClickListener{ addPerson()}

    private fun addPerson() {
        val name = addNewPersonBinding.etInputName.text.toString().trim()
        val year = addNewPersonBinding.etInputDate.text.toString().trim()
        val description = addNewPersonBinding.etInputDescription.text.toString().trim()
        val quote = addNewPersonBinding.etInputQuote.text.toString().trim()
        val quotes = mutableListOf<String>()
        quotes.add(quote)
        if(!isFilled(name,year,description,quote)){
            Toast.makeText(context, "Please fill in all fields", Toast.LENGTH_LONG).show()
            return
        }
        if(name == "null" ||year == "null" || description == "null") return
        addNewPersonToRepository(name,year,description,quotes)
    }
    private fun isFilled(name: String,year: String,description: String, quote : String) : Boolean{
        if(name.isEmpty() || year.isEmpty() || description.isEmpty() ||quote.isEmpty())return false else return true
    }

    private fun addNewPersonToRepository(name : String,
                                         year : String,
                                         description : String,
                                         quotes : MutableList<String>
    ) = PeopleRepository.add(InspiringPerson(name, year, description, quotes))
}