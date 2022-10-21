package snapshotTests

import androidx.compose.foundation.layout.Column
import androidx.compose.ui.test.junit4.createComposeRule
import com.example.todolist.DefaultPreview
import com.example.todolist.ToDoListItem
import com.karumi.shot.ScreenshotTest
import org.junit.Rule
import org.junit.Test

class MainActivityTest: ScreenshotTest {

    @get:Rule
    val composeRule = createComposeRule()

    @Test
    fun defaultPreviewIsDisplayed() {
        composeRule.setContent { DefaultPreview() }
        compareScreenshot(composeRule)
    }

    @Test
    fun addedItemIsDisplayed() {
        composeRule.setContent { ToDoListItem(name = "Hello") }
        compareScreenshot(composeRule)
    }

    @Test
    fun twoAddedItemsAreDisplayed() {
        composeRule.setContent {
            Column() {
                ToDoListItem(name = "Hello")
                ToDoListItem(name = "SecondItem")
            }
        }
        compareScreenshot(composeRule)
    }
}