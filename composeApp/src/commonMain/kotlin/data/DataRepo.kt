package data

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class DataRepo(
    private val apiServices: ApiServices,
) {
    private val scope = CoroutineScope(SupervisorJob())

//    fun onLogin(): Flow<List<LoginModel>>{
//        apiServices.onLogin()
//    }

    //fun getObjectById(objectId: Int): Flow<MuseumObject?> = museumStorage.getObjectById(objectId)



//    suspend fun getProducts(productId: Int) = flow<RepositoryResult<out Product>> {
//
//
//
//        productApi.getProducts(productId)
//            .onSuccess {
//                emit(RepositoryResult.Success(it.toProduct()))
//            }.onFailure {
//                emit(RepositoryResult.Error(null, "TODO)"))
//            }
//    }.onStart {
//        emit(RepositoryResult.Loading)
//    }

     fun  getLogin () :  Flow<LoginModel?>{
       return  runBlocking { MutableStateFlow(apiServices.onLogin())  }
    }
}