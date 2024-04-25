package screens.dashboardScreen

import Component.TabScreen
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import data.LoginModel
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.ui.tooling.preview.Preview


class DashBoardData(private val loginModel: LoginModel) : Screen {
    @Composable
    override fun Content() {
        DashBoard(loginModel)
    }
}


@OptIn(ExperimentalResourceApi::class)
@Composable
@Preview
fun DashBoard(loginModel: LoginModel) {
    Scaffold(
        bottomBar = {
            TabScreen()
        },
    ) {
        Column(
            modifier = Modifier.padding(it),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize().background(color = Color( 245, 245, 245 ))
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .background(color = Color.Blue),
                    contentAlignment = Alignment.TopStart
                ) {
                    Text(
                        text = "Sign In",
                        modifier = Modifier.padding(16.dp),
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 130.dp),
                        backgroundColor = Color.White,
                        elevation = 4.dp
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Account Balance",
                                    modifier = Modifier.padding(0.dp),
                                    color = Color.Black,
                                )
                                Text(
                                    text = "$  ${loginModel.accountBalance}",
                                    modifier = Modifier.padding(0.dp),
                                    color = Color.Black,
                                    fontSize = 26.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Account Number",
                                    modifier = Modifier.padding(0.dp),
                                    color = Color.Black,
                                )
                                Text(
                                    text = loginModel.accountNumber.toString(),
                                    modifier = Modifier.padding(0.dp),
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(top = 8.dp),
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Text(
                                    text = "Account Status",
                                    modifier = Modifier.padding(0.dp),
                                    color = Color.Black,
                                )
                                Text(
                                    text = loginModel.accountStatus.toString(),
                                    modifier = Modifier.padding(0.dp),
                                    color = Color.Black,
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Bold
                                )
                            }
                            Button(
                                modifier = Modifier
                                    .padding(top = 10.dp)
                                    .fillMaxWidth()
                                    .height(50.dp),
                                onClick = { },
                                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Blue),
                                shape = RoundedCornerShape(5.dp)
                            ) {
                                Text(text = "+ TOP UP", color = Color.White)
                            }
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, top = 8.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Card(
                            modifier = Modifier.weight(1f),
                            backgroundColor = Color.White,
                            elevation = 4.dp
                        ) {
                            Column(

                                modifier = Modifier.fillMaxWidth().padding(10.dp),
                                verticalArrangement = Arrangement.SpaceBetween,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "$ "+ loginModel.TopUpAmount.toString(),
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 10.dp),
                                    fontSize = 14.sp,
                                    text = "Top-Up \n Amount",
                                    color = Color.Black,
                                )
                            }

                        }
                        Card(
                            modifier = Modifier.weight(1f),
                            backgroundColor = Color.White,
                            elevation = 4.dp
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth().padding(10.dp),
                                verticalArrangement = Arrangement.SpaceBetween,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "$ ${loginModel.LowBalanceThrershold}",
                                    color = Color.Black,
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 10.dp),
                                    fontSize = 14.sp,
                                    text = "Low Balance \n Threshold",
                                    color = Color.Black,
                                )
                            }

                        }
                        Card(
                            modifier = Modifier.weight(1f),
                            backgroundColor = Color.White,
                            elevation = 4.dp
                        ) {
                            Column(
                                modifier = Modifier.fillMaxWidth().padding(10.dp),
                                verticalArrangement = Arrangement.SpaceBetween,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = loginModel.AutoPay.toString(),
                                    color = Color.Black,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold
                                )
                                Text(
                                    textAlign = TextAlign.Center,
                                    modifier = Modifier.padding(top = 10.dp),
                                    fontSize = 14.sp,
                                    text = "Top-Up \n Method",
                                    color = Color.Black,
                                )
                            }

                        }

                    }

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 10.dp),
                        backgroundColor = Color.White,
                        elevation = 4.dp
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "VISA",
                                color = Color.Blue,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                            Text(
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp,
                                text = "******7890",
                                color = Color.Black,
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Recent Transactions",
                            color = Color.Black,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            textAlign = TextAlign.Center,
                            fontSize = 14.sp,
                            text = "View All",
                            color = Color.Black,
                        )
                    }
                    Column (
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 10.dp)
                    ){
                        loginModel.recentTransactionList?.let { it1 -> TransactionAdapter(it1) }
                    }




                }
            }
        }
    }

}