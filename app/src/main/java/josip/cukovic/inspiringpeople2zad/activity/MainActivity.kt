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

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
    }

    lateinit var  viewPagerr: ViewPager
    private fun setupUI() {
        viewPagerr = findViewById<ViewPager>(R.id.viewPager)
        viewPagerr.adapter = FragmentAdapter(supportFragmentManager)
        findViewById<TabLayout>(R.id.tabLayout).setupWithViewPager(viewPagerr)

        viewPagerr?.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {

            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }
            override fun onPageSelected(position: Int) {
                if(viewPagerr.currentItem == 0){
                    val adapter = (findViewById<RecyclerView>(R.id.rv_inspiring_people).adapter as PeopleAdapter)
                    adapter.dataAdded(PeopleRepository.people)
                    findViewById<RecyclerView>(R.id.rv_inspiring_people).scrollToPosition(adapter.itemCount-1)
                }
            }

        })
    }
}