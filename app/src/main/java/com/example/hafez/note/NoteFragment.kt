package com.example.hafez.note

import android.graphics.PorterDuff
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.viewpager.widget.ViewPager
import com.example.hafez.R
import com.google.android.material.tabs.TabLayout

class NoteFragment : Fragment() {
    private lateinit var tabLayout: TabLayout
    private lateinit var viewPager: ViewPager
    private lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.note_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabLayout = view.findViewById(R.id.tabLayout)
        viewPager = view.findViewById(R.id.viewPager)
        navController = Navigation.findNavController(view)

        tabManger()
    }

    private fun tabManger() {
        val adapter = ViewPagerAdapter(parentFragmentManager)

        adapter.addFragment(HighLightsFragment(),"هایلایت ها")
        adapter.addFragment(NotesFragment(),"یادداشت ها")
        adapter.addFragment(SignFragment(),"نشانه ها")

        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

        tabLayout.getTabAt(0)!!.setIcon(R.drawable.highlight)
        tabLayout.getTabAt(1)!!.setIcon(R.drawable.book)
        tabLayout.getTabAt(2)!!.setIcon(R.drawable.sign)

        tabLayout.getTabAt(0)!!.icon!!.setColorFilter(
            resources.getColor(R.color.colorPrimary),
            PorterDuff.Mode.SRC_IN
        )
        tabLayout.getTabAt(1)!!.icon!!.setColorFilter(
            resources.getColor(R.color.lightGray),
            PorterDuff.Mode.SRC_IN
        )
        tabLayout.getTabAt(2)!!.icon!!.setColorFilter(
            resources.getColor(R.color.lightGray),
            PorterDuff.Mode.SRC_IN
        )
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                viewPager.currentItem = tab!!.position
                if (tab.position == 0) {
                    tabLayout.getTabAt(0)!!.icon!!.setColorFilter(
                        resources.getColor(R.color.colorPrimary),
                        PorterDuff.Mode.SRC_IN
                    )
                    tabLayout.getTabAt(1)!!.icon!!.setColorFilter(
                        resources.getColor(R.color.lightGray),
                        PorterDuff.Mode.SRC_IN
                    )
                    tabLayout.getTabAt(2)!!.icon!!.setColorFilter(
                        resources.getColor(R.color.lightGray),
                        PorterDuff.Mode.SRC_IN
                    )
                } else if (tab.position == 1) {
                    tabLayout.getTabAt(0)!!.icon!!.setColorFilter(
                        resources.getColor(R.color.lightGray),
                        PorterDuff.Mode.SRC_IN
                    )
                    tabLayout.getTabAt(1)!!.icon!!.setColorFilter(
                        resources.getColor(R.color.colorPrimary),
                        PorterDuff.Mode.SRC_IN
                    )
                    tabLayout.getTabAt(2)!!.icon!!.setColorFilter(
                        resources.getColor(R.color.lightGray),
                        PorterDuff.Mode.SRC_IN
                    )

                } else if (tab.position == 2) {
                    tabLayout.getTabAt(0)!!.icon!!.setColorFilter(
                        resources.getColor(R.color.lightGray),
                        PorterDuff.Mode.SRC_IN
                    )
                    tabLayout.getTabAt(1)!!.icon!!.setColorFilter(
                        resources.getColor(R.color.lightGray),
                        PorterDuff.Mode.SRC_IN
                    )
                    tabLayout.getTabAt(2)!!.icon!!.setColorFilter(
                        resources.getColor(R.color.colorPrimary),
                        PorterDuff.Mode.SRC_IN
                    )

                }
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
            }
        })

    }
}