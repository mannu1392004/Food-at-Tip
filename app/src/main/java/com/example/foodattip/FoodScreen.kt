package com.example.foodattip

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun FoodScreen(qrans: MutableState<String>, onClick: (Int) -> Unit) {
    val list = FoodData.indianFoodList
    Scaffold(modifier = Modifier.fillMaxWidth()) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            Column(
                modifier = Modifier.padding(start = 30.dp, end = 30.dp),

                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    "Table No. ${qrans.value}",
                    fontSize = 30.sp,
                    modifier = Modifier.padding(30.dp)
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxWidth(),
                ) {
                    items(list) {
                        FoodItem(foodModel = it) { id ->
                            onClick(id)
                        }
                    }
                }

            }
        }

    }
}

@Composable
fun FoodItem(foodModel: FoodModel, onClick: (Int) -> Unit) {

    Surface(
        modifier = Modifier
            .clickable { onClick(foodModel.id) }
            .padding(10.dp)
            .fillMaxWidth(), shadowElevation = 10.dp,
        shape = RoundedCornerShape(10.dp)
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 150.dp)
            ) {
                Image(
                    painter = rememberAsyncImagePainter(foodModel.image),
                    contentDescription = null,
                    modifier = Modifier.fillMaxWidth(),
                    contentScale = ContentScale.FillWidth,
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column {
                    Text(
                        foodModel.name, modifier = Modifier
                            .align(Alignment.Start)
                            .padding(10.dp)
                    )
                    Text(
                        foodModel.diningTime, modifier = Modifier
                            .align(Alignment.Start)
                            .padding(10.dp)
                    )
                }
                Column {
                    Text(
                        "Only 500", modifier = Modifier
                            .align(Alignment.Start)
                            .padding(10.dp)
                    )
                    Text(
                        "Rating - 4 Star", modifier = Modifier
                            .align(Alignment.Start)
                            .padding(10.dp)
                    )
                }


            }
        }
    }

}
