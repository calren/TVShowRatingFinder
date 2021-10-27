package com.caren.tvshowratingfinder

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.core.net.toUri
import coil.load

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.getTvShowInfo("Squid Game")

        // 1. Observe when the values of the tv show title and rating changes
        // 2. Update the UI when the values change


        // Observing the specific value: currentlyDisplayedTvShowName
        // Whenever the value changes,
        viewModel.currentlyDisplayedTvShowName.observe(this,
            {
                // Code to execute when 'currentlyDisplayedTvShowName' value changes
                findViewById<TextView>(R.id.tvShowTitleTextView).text = it
            })

        viewModel.currentlyDisplayedTvShowRating.observe(this,
            {
                findViewById<TextView>(R.id.ratingTextView).text = it.ratingScore.toString()
            })

        viewModel.currentlyDisplayedTvShowImage.observe(this,
            {
                findViewById<ImageView>(R.id.imageView).load(
                    it.imageUrl?.toUri()?.buildUpon()?.scheme("https")?.build()
                )
            })
    }
}