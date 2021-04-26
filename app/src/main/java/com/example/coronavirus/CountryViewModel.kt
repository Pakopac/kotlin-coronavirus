package com.example.coronavirus

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coronavirus.api.ApiClient
import com.example.coronavirus.api.ApiResult
import com.example.coronavirus.data.CoronaList
import kotlinx.coroutines.launch

class CountryViewModel : ViewModel() {

    private val searchRequestSuccess: MutableLiveData<CoronaList> = MutableLiveData<CoronaList>()
    val searchRequestError: MutableLiveData<String> = MutableLiveData<String>()

    fun searchRequest() {

        viewModelScope.launch {
            when (val retrofitPost = ApiClient.apiService.getCountries()) {
                is ApiResult.Success<*> -> searchRequestSuccess.postValue(retrofitPost.data as CoronaList?)
            }
        }

    }


}