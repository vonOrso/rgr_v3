package com.example.rgr_v3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbar_main.*

class MainActivity : AppCompatActivity() {
    var pagerAdapter: CustomPagerAdapter? = null
    val database = FirebaseDatabase.getInstance()

    companion object {
        private const val TAG = "KotlinActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar_main)
        database.setPersistenceEnabled ( true )

        pagerAdapter = CustomPagerAdapter(supportFragmentManager)
        pagerAdapter!!.addFragments(Fragment_Days("a_monday",database),"Пн")
        pagerAdapter!!.addFragments(Fragment_Days("b_tuesday",database), "Вт")
        pagerAdapter!!.addFragments(Fragment_Days("c_wednesday",database), "Ср")
        pagerAdapter!!.addFragments(Fragment_Days("d_thursday",database), "Чт")
        pagerAdapter!!.addFragments(Fragment_Days("e_friday",database), "Пт")

        costomViewPager.adapter = pagerAdapter
        costomTabLayout.setupWithViewPager(costomViewPager)


    }

}