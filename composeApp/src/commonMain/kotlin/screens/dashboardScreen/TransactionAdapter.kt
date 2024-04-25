package screens.dashboardScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.RecentTransactionListItem
import kotlinmultiplatformproject.composeapp.generated.resources.Res
import kotlinmultiplatformproject.composeapp.generated.resources.compose_multiplatform
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

@Composable
fun TransactionAdapter( recentTransactionList: List<RecentTransactionListItem?>) {
    var count = 0
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(recentTransactionList){ country ->
            TransactionsItems(country,count)
            count++
        }
    }
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun TransactionsItems(recentTransactionList: RecentTransactionListItem?,count:Int) {
    var text = ""
    if(count == 0){
        text = "Top UP"
    }else{
        text = "NorthBound"
    }
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth().padding(bottom = 10.dp),
        backgroundColor = Color.White,
        elevation = 4.dp
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
//                Image(
//                    painterResource(Res.drawable.compose_multiplatform.i),
//                    contentDescription = "",
//                    modifier = Modifier
//                        .height(25.dp)
//                        .width(25.dp)
//                )
                Text(
                    text = text ,
                    fontSize = 20.sp,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
            ) {
                Column {
                    Text(
                        text = "$ "+recentTransactionList?.topUp.toString(),
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                    Text(
                        text = "$ "+recentTransactionList?.NorthBound.toString(),
                        color = Color.Black
                    )
                }
                Icon(
                    imageVector = Icons.Default.KeyboardArrowRight,
                    contentDescription = null,
                    modifier = Modifier.padding(start = 10.dp)
                )
            }


        }
    }

}

