package com.example.uitests.tests

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.uitests.commonHelpers.SetupHelper
import com.example.uitests.screenObjects.AddItemScreen
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class TodoListTests{

    val setupHelper = SetupHelper()
    val addItemScreen = AddItemScreen()

    @Before
    fun setUpDevice() {
        setupHelper.startMainActivityFromHomeScreen()
    }

    @Test
    fun addItemMakeSureItemIsDisplaying() {
        addItemScreen.writeText("Do this")
        addItemScreen.clickSaveButton()
        addItemScreen.verifyTextIsDisplaying()
    }
}