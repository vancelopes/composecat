package com.vancelopes.composecat.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vancelopes.composecat.common.Resource
import com.vancelopes.composecat.domain.model.Cat
import com.vancelopes.composecat.domain.usecase.GetCats
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CatsViewModel @Inject constructor(private val getCats: GetCats) : ViewModel() {

    private val _state = mutableStateOf(CatViewState())
    val state: State<CatViewState> = _state

    init { getCats() }

    private fun getCats() {
        viewModelScope.launch {
            getCats.invoke(0, 10).onEach { resource ->
                when(resource) {
                    is Resource.Loading -> {
                        _state.value = state.value.copy(
                            cats = resource.data ?: emptyList(),
                            isLoading = true
                        )
                    }
                    is Resource.Error -> {
                        _state.value = state.value.copy(
                            cats = resource.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                    is Resource.Success -> {
                        _state.value = state.value.copy(
                            cats = resource.data ?: emptyList(),
                            isLoading = false
                        )
                    }
                }
            }.launchIn(this)
        }
    }
}

data class CatViewState (
    val cats : List<Cat> = emptyList(),
    val isLoading: Boolean = false
)