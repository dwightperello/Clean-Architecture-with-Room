package com.meat.cleanarchitecture_with_room.presentation.wordInfo

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.meat.cleanarchitecture_with_room.core.util.Resource
import com.meat.cleanarchitecture_with_room.core.util.UIEvent
import com.meat.cleanarchitecture_with_room.domain.model.WordInfo
import com.meat.cleanarchitecture_with_room.domain.use_case.getWordInfoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordInfoViewModel @Inject constructor(private val wordInfoUseCase: getWordInfoUseCase) :ViewModel() {

    private val _searchQuery = mutableStateOf("")
    val SearchQuery: State<String> = _searchQuery

    private val _state = mutableStateOf(WordInfoState())
    val State: State<WordInfoState> = _state

    private val _eventFlow= MutableSharedFlow<UIEvent>()
    val eventFlow= _eventFlow.asSharedFlow()

    private var searchJob: Job? = null

    private  fun onSearch(query:String){
        _searchQuery.value = query
        searchJob?.cancel()
        searchJob= viewModelScope.launch {
            delay(500L)
            wordInfoUseCase(query)
                .onEach { result ->
                    when    (result){
                        is Resource.Success ->{
                            _state.value= State.value.copy(
                                result.data?: emptyList(),
                                false
                            )
                        }
                        is Resource.Error ->{
                            _state.value= State.value.copy(
                                result.data?: emptyList(),
                                false
                            )
                            _eventFlow.emit(UIEvent.ShowSnackbar(result.message?: "Unknown Error"))
                        }

                        is Resource.Loading ->{
                            _state.value=State.value.copy(
                                result.data?: emptyList()
                                ,true
                            )
                        }
                    }
                }.launchIn(viewModelScope)
        }


    }
}