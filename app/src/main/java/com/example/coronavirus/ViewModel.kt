package com.example.coronavirus

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coronavirus.data.coronaList
import kotlinx.coroutines.launch

class ViewModel : ViewModel() {

    val searchRequestSuccess: MutableLiveData<coronaList> = MutableLiveData<coronaList>()
    val searchRequestError: MutableLiveData<String> = MutableLiveData<String>()

    fun searchRequest(query: String) {

        viewModelScope.launch {
            when (val retrofitPost = ApiClient.apiService.getCountries()) {
                is ApiResult.Success<*> -> searchRequestSuccess.postValue(retrofitPost.data)
                is ApiResult.Error -> searchRequestError.postValue(retrofitPost.exception)
            }
        }

    }


}