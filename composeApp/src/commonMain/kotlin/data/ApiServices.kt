package data

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

interface ApiServices {
    suspend fun onLogin(): LoginModel
}


class onLoginApi(private val client: HttpClient) : ApiServices {
    companion object {
        private const val API_URL =
            "https://a5eec17c-b46d-4afb-8504-b179fe201d34.mock.pstmn.io/Login"
    }

    override suspend fun onLogin():LoginModel {
       return try {
           client.get(API_URL).body()
       }catch (e: Exception){
         LoginModel()
       }
    }
}