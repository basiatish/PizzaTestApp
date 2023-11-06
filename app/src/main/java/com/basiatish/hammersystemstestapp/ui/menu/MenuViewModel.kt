package com.basiatish.hammersystemstestapp.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.basiatish.domain.entities.MenuItem
import com.basiatish.domain.usecases.GetMenuUseCase
import com.basiatish.domain.common.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val getMenuUseCase: GetMenuUseCase
) : ViewModel() {

    private val _menu = MutableLiveData<List<MenuItem>>()
    val menu: LiveData<List<MenuItem>> = _menu

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getMenu() {
        viewModelScope.launch {
            _menu.value = listOf()
            when (val response = getMenuUseCase.invoke()) {
                is Result.Success -> {
                    _menu.value = response.resultData
                }
                is Result.Error -> {
                    _error.postValue(response.exception.message)
                }
            }
        }
    }

}