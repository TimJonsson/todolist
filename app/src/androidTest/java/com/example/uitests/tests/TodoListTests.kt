package com.example.uitests.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.uitests.commonHelpers.SetupHelper
import com.example.uitests.screenObjects.AddItemScreen
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TodoListTests{

    val addItemScreen = AddItemScreen()

    val itemOne = "Do this"
    val itemTwo = "Also do this"


    @Before
    fun setUpDevice() {
        SetupHelper.startMainActivityFromHomeScreen()
    }

    @Test
    fun addedItemIsDisplaying() {
        addItemScreen.writeText(itemOne)
        addItemScreen.clickSaveButton()
        addItemScreen.verifyTextIsDisplaying(itemOne)
    }

    @Test
    fun addSeveralItems() {
        addItemScreen.writeText(itemOne)
        addItemScreen.clickSaveButton()
        addItemScreen.writeText(itemTwo)
        addItemScreen.clickSaveButton()
        addItemScreen.verifyTextIsDisplaying(itemOne)
        addItemScreen.verifyTextIsDisplaying(itemTwo)
    }
}