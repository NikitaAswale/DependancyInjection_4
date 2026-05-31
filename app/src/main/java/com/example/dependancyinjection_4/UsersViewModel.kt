package com.example.dependancyinjection_4

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(userRepository: UserRepository) : ViewModel() {

    val character : Flow<PagingData<Result>> = userRepository.getPosts()
}