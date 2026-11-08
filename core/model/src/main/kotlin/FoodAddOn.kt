package com.today.eggs.core.model

sealed interface FoodAddOn {
    enum class Seasoning : FoodAddOn {
        SALT,
        PEPPER,
        SUGAR,
        KETCHUP,
        SOY_SAUCE;
    }

    enum class SidePairing : FoodAddOn {
        KIMCHI,
        MILK,
        CHEESE;
    }

    data class Custom(val name: String) : FoodAddOn
}