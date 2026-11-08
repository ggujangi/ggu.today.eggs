package com.today.eggs.core.model.eggs

import com.today.eggs.core.model.FoodCategory
import com.today.eggs.core.model.FoodStyle

enum class EggStyle : FoodStyle {
    BOILED,
    ROASTED,
    FRIED,
    RAW;

    override val category: FoodCategory = FoodCategory.EGG
}