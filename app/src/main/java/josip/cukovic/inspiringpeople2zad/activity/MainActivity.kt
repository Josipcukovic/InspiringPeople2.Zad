package josip.cukovic.inspiringpeople2zad.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import josip.cukovic.inspiringpeople2zad.R
import josip.cukovic.inspiringpeople2zad.adapters.FragmentAdapter
import josip.cukovic.inspiringpeople2zad.adapters.PeopleAdapter
import josip.cukovic.inspiringpeople2zad.data.PeopleRepository
import josip.cukovic.inspiringpeople2zad.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setupUI()
    }

    lateinit var  viewPager: ViewPager
    private fun setupUI() {
        viewPager = mainBinding.viewPager
        viewPager.adapter = FragmentAdapter(supportFragmentManager)
        mainBinding.tabLayout.setupWithViewPager(viewPager)

        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                if(position == 0){
                    val adapter = findViewById<RecyclerView>(R.id.rv_inspiring_people).adapter as PeopleAdapter
                    adapter.dataAdded(PeopleRepository.people)
                    findViewById<RecyclerView>(R.id.rv_inspiring_people).scrollToPosition(adapter.itemCount-1)
                }
            }

        })
    }
}