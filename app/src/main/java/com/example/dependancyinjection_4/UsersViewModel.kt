package com.example.dependancyinjection_4

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class UsersViewModel @Inject constructor(val userRepository: UserRepository) : ViewModel() {

    val character: Flow<PagingData<Result>> = userRepository.getPosts()

    private val _users = MutableStateFlow<Posts?>(null)

    val user: StateFlow<Posts?> = _users

    fun fetchusers(name: String) {

        viewModelScope.launch {
            _users.value = userRepository.getUsers(name)
        }

    }
}