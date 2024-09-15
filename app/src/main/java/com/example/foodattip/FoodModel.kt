package com.example.foodattip

import androidx.camera.core.processing.SurfaceProcessorNode.In

data class FoodModel(
    val name :String,
    val image:String,
    val description:String,
    val diningTime :String,
    val id:Int,
)
