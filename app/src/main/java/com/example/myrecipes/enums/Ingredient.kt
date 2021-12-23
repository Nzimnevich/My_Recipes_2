package com.example.myrecipes.enums
//не уверена, что это не sealed class
enum class Ingredient(var title: String, var type: String) {

    SUGAR("Сахар", "Бакалея"),
    BUTTER("Масло", "Животные продукты"),
    EGG("Яйцо", "Животные продукты"),
    WATER("Вода", "Жидкости"),
    STRAWBERRY("Клубника","Ягоды"),
    BLUEBERRY("Ягода", "Ягоды")


}