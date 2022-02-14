package com.example.myrecipes

import com.example.myrecipes.enums.Dishes
import com.example.myrecipes.ui.search.FilterHolder
import org.junit.Assert
import org.junit.Test

class FakeFoodRepositoryTest {

    @Test
    fun assertMethodSortRecipe() {
        var filterHolder = FilterHolder()
        filterHolder.selectedDish = Dishes.DESSERT.toString()
        var list = FakeFoodRepository().sortRecipe(filterHolder)
        Assert.assertNotNull("not null", list)
    }
}