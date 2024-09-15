package com.example.foodattip

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun FoodMenu(id: Int,onClick: (FoodModel) -> Unit) {

    val number = remember { mutableStateOf("") }
    val list = FoodData.indianFoodList
    val foodModel = list.find { it.id == id }
    foodModel?.name?.let {
        Column (modifier = Modifier.verticalScroll(rememberScrollState())){
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 100.dp)
            ) {
                Image(
                    rememberAsyncImagePainter(model = foodModel.image),
                    contentDescription = "",
                    contentScale = ContentScale.FillWidth
                )
            }
            Text(
                it,
                fontSize = 40.sp,
                modifier = Modifier.padding(start = 30.dp)
            )


            Text(
                foodModel.diningTime,
                Modifier.padding(start = 30.dp, end = 30.dp, top = 10.dp)
            )
            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                foodModel.description,
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 30.dp, end = 30.dp)
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "Only 500 Rupee",
                    fontSize = 20.sp,
                    modifier = Modifier.padding(start = 30.dp, end = 30.dp)
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Quantity: ")
                    BasicTextField(value = number.value, onValueChange = {
                        number.value = it
                    })
                }

            }

            Spacer(modifier = Modifier.padding(10.dp))

            Text(
                "Overall Rating - 4 Star",
                fontSize = 20.sp,
                modifier = Modifier.padding(start = 30.dp, end = 30.dp)
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Surface(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = androidx.compose.ui.graphics.Color.Black
                )
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text("Mannu     4 Star")
                    Text("${foodModel.name} Taste was good must try")


                }
            }

            Surface(
                modifier = Modifier.fillMaxWidth().padding(10.dp),
                shape = RoundedCornerShape(10.dp),
                border = BorderStroke(
                    width = 1.dp,
                    color = androidx.compose.ui.graphics.Color.Black
                )
            ) {
                Column(modifier = Modifier.padding(10.dp)) {
                    Text("Xyz     2 Star")
                    Text("${foodModel.name} not properly cooked")


                }
            }



            Row(modifier = Modifier.fillMaxSize()) {
                Button(
                    onClick = {
                        onClick(foodModel)
                    },
                    modifier = Modifier
                        .align(Alignment.Bottom)
                        .padding(40.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        "Order Now",
                        modifier = Modifier.padding(10.dp)
                    )
                }
            }

        }

    }

}