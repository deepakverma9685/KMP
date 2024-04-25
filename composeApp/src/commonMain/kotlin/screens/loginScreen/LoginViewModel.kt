package screens.loginScreen

import cafe.adriel.voyager.core.model.ScreenModel
import data.DataRepo
import data.LoginModel
import kotlinx.coroutines.flow.Flow


class LoginViewModel(private val dataRepo: DataRepo) : ScreenModel {
    fun onLogin(): Flow<LoginModel?> = dataRepo.getLogin()
}