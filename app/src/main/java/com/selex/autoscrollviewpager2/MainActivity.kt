package com.selex.autoscrollviewpager2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.viewpager2.widget.ViewPager2

class MainActivity : AppCompatActivity() {

    private lateinit var mAdapter: PagerAdapter
    private lateinit var viewPager: ViewPager2
    private val handler = Handler(Looper.getMainLooper())

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAdapter = PagerAdapter()
        mAdapter.listBanner.add(Banner(R.drawable.naruto1))
        mAdapter.listBanner.add(Banner(R.drawable.naruto2))
        mAdapter.listBanner.add(Banner(R.drawable.naruto3))

        viewPager = findViewById(R.id.viewpager)
        viewPager.adapter = mAdapter
        viewPager.scrollState

        viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(sliderRun)
                handler.postDelayed(sliderRun, 3000)
            }
        })


    }

    private val sliderRun = Runnable {
        if (viewPager.currentItem == mAdapter.itemCount.minus(1)) {
            viewPager.setCurrentItem(0, true)
        } else {
            viewPager.setCurrentItem(viewPager.currentItem + 1, true)
        }
    }

}