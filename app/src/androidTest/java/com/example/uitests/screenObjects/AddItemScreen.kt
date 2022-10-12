package com.example.uitests.screenObjects

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import com.example.uitests.commonHelpers.SetupHelper
import org.junit.Assert.assertEquals

class AddItemScreen {

    private val setupHelper = SetupHelper()


    val saveButton: UiObject = setupHelper.device.findObject(
        UiSelector().descriptionContains("SaveButton"))

    val textField: UiObject = setupHelper.device.findObject(
        UiSelector().descriptionContains("NewItemTextField"))

    val textIsDisplaying: UiObject = setupHelper.device.findObject(
        UiSelector().text("Do this"))

    fun writeText (text: String) {
        textField.click()
        textField.legacySetText(text)
    }

    fun clickSaveButton() {
        saveButton.click()
    }

    fun verifyTextIsDisplaying() {
        assertEquals(textIsDisplaying.text, "Do this")
    }
}