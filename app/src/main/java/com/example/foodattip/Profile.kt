package com.example.foodattip

import android.provider.ContactsContract.Profile
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import kotlin.random.Random

@Composable
fun Profile(list:MutableList<FoodModel>) {


    Scaffold() {

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxWidth()
        ) {
            Text(
                "Your Bill",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 30.sp
            )


            if (list.isNotEmpty()) {
                Surface(
                    modifier = Modifier.padding(10.dp),
                    shadowElevation = 10.dp,
                    shape = RoundedCornerShape(20.dp)
                ) {
                    Column(modifier = Modifier) {
                        Surface(
                            modifier = Modifier
                                .fillMaxWidth()
                                .heightIn(min = 100.dp)
                        ) {
                            Image(
                                rememberAsyncImagePainter(model = list[0].image),
                                contentDescription = "",
                                contentScale = ContentScale.FillWidth
                            )

                        }
                        Column (modifier = Modifier.padding(30.dp)){
                            list.forEach {
                                Row(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(),
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ) {
                                    Text(it.name)

                                    Text(Random.nextInt(1, 10).toString())

                                }
                            }

                            Text("Your Order will be Prepared in 30 mins",
                                fontSize = 20.sp,
                                color = Color.Red,
                                modifier = Modifier.padding(10.dp)
                            )

                            Text(
                                "Total =  " + Random.nextInt(200, 5000).toString(),
                                fontSize = 30.sp
                            )

                            Text(
                                "Thanks For Your Order",
                                fontSize = 30.sp
                            )

                        }
                    }
                }
            }


        }
    }
}

@Composable
fun OrderedFood(it: FoodModel) {

}
