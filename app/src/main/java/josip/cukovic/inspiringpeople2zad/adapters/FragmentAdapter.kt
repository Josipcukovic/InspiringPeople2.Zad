package josip.cukovic.inspiringpeople2zad.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import josip.cukovic.inspiringpeople2zad.fragments.AddNewPersonFragment
import josip.cukovic.inspiringpeople2zad.fragments.InspiringPeopleFragment

class FragmentAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    val fragments = arrayOf(
        InspiringPeopleFragment.newInstance(),
        AddNewPersonFragment.newInstance()
    )
    val titles = arrayOf(
        "Inspiring People",
        "Add new person"
    )
    override fun getCount(): Int {
        return fragments.size
    }

    override fun getItem(position: Int): Fragment {
       return fragments[position]
    }
    override fun getPageTitle(position: Int): CharSequence {
        return titles[position]
    }
}