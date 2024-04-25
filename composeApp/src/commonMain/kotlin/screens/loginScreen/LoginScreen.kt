package screens.loginScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview
import screens.dashboardScreen.DashBoardData


data object LoginData :Screen{

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val screenModel: LoginViewModel = getScreenModel()
        var screenState: Int by remember{mutableStateOf(0)}

         LoginScreen(onLogin = {
              screenState = 1
         })
        when(screenState){
            1 ->{
                println("data is 1 here")
                val objects by screenModel.onLogin().collectAsState(initial = null)

                if(objects!=null){
                    println("data is ${objects!!.accountBalance}")
                    navigator.push(DashBoardData(objects!!))
                }
            }

        }


    }

}



@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun LoginScreen(
    onLogin: () -> Unit,

    ) {
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf("") }
    var emailError by remember { mutableStateOf("") }
    var showPassword by remember { mutableStateOf(false) }

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .background(color = Color.Blue),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(text = "Sign In",
                    modifier = Modifier.padding(16.dp),
                    color = Color.White,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )

            }
            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth().padding(start = 20.dp,end = 20.dp, top = 16.dp)
                ,
                label = { Text("Email Address") },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                ),


            )
            Text(text = "This will be the same as the Email Address you use to login on the website",
                modifier = Modifier.padding(start = 20.dp,end = 20.dp, top = 10.dp),
                color = Color.Black,
            )
            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth().padding(start = 20.dp,end = 20.dp, top = 16.dp),
                label = { Text("Password") },
                singleLine = true,
                colors = TextFieldDefaults.textFieldColors(
                    backgroundColor = Color.White,
                ),
                trailingIcon = {
                    IconButton(onClick = { showPassword = !showPassword }) {
                        Icon(
                            imageVector = if (showPassword) Icons.Outlined.Add else Icons.Outlined.AccountBox,
                            contentDescription = if (showPassword) "Show Password" else "Hide Password"
                        )
                    }
                },
                visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
            )
            Button(modifier = Modifier
                .padding(start = 20.dp,end = 20.dp, top = 60.dp)
                .fillMaxWidth()
                .height(50.dp),
                onClick = {onLogin() },
                colors = ButtonDefaults.buttonColors( backgroundColor = Color.Blue),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text(text="SIGN IN", color = Color.White)
            }


        }

    }
}
