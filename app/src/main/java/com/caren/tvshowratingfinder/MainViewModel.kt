package com.caren.tvshowratingfinder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.caren.tvshowratingfinder.network.TVMazeApi
import com.caren.tvshowratingfinder.network.TvShowResponseImageObject
import com.caren.tvshowratingfinder.network.TvShowResponseRatingObject
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    // Only accessible by ViewModel, only updatable by ViewModel
    private val _currentlyDisplayedTvShowName = MutableLiveData<String>()
    val currentlyDisplayedTvShowName: LiveData<String> = _currentlyDisplayedTvShowName

    private val _currentlyDisplayedTvShowRating = MutableLiveData<TvShowResponseRatingObject>()
    val currentlyDisplayedTvShowRating: LiveData<TvShowResponseRatingObject> = _currentlyDisplayedTvShowRating

    private val _currentlyDisplayedTvShowImage = MutableLiveData<TvShowResponseImageObject>()
    val currentlyDisplayedTvShowImage: LiveData<TvShowResponseImageObject> = _currentlyDisplayedTvShowImage


    // Make a network call to get info about 'Squid Game'
    fun getTvShowInfo(tvShowName: String) {
        viewModelScope.launch {
            val response = TVMazeApi.retrofitService.getTvShow(tvShowName)
            _currentlyDisplayedTvShowName.value = response.name

            _currentlyDisplayedTvShowRating.value = response.rating

            _currentlyDisplayedTvShowImage.value = response.image
        }
    }

}