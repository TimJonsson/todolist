package com.example.uitests.screenObjects

import androidx.test.uiautomator.UiObject
import androidx.test.uiautomator.UiSelector
import com.example.uitests.commonHelpers.SetupHelper
import org.junit.Assert.assertEquals

class AddItemScreen {


    val saveButton: UiObject = SetupHelper.device.findObject(
        UiSelector().descriptionContains("SaveButton"))

    val textField: UiObject = SetupHelper.device.findObject(
        UiSelector().descriptionContains("NewItemTextField"))

    fun writeText (text: String) {
        textField.click()
        textField.legacySetText(text)
    }

    fun clickSaveButton() {
        saveButton.click()
    }

    fun verifyTextIsDisplaying(text: String) {
        val textIsDisplaying = SetupHelper.device.findObject(
            UiSelector().text(text))
        assertEquals(textIsDisplaying.exists(), true)
    }
}