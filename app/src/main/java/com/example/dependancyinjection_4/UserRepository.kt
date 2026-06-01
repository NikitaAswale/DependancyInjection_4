package com.example.dependancyinjection_4

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(val apiService: APIService, val postAPIService: PostAPIService) {

    fun getPosts () : Flow<PagingData<Result>> {
        return Pager(
            config = PagingConfig(
                pageSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {
                CharacterPagingSource(apiService)
            }
        ).flow
    }

    suspend fun getUsers(name : String) : Posts{
        return postAPIService.getUsers(name)
    }

}