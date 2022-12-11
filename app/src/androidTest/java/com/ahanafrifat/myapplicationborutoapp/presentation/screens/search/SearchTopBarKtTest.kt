package com.ahanafrifat.myapplicationborutoapp.presentation.screens.search

import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchTopBarKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun openSearchWidget_addInputText_assert_inputText() {
        val text = mutableStateOf("")
        composeTestRule.setContent {
            SearchWidget(
                text = text.value,
                onTextChange = {
                    text.value = it
                },
                onCloseClicked = {

                },
                onSearchClicked = {

                }
            )
        }
        composeTestRule.onNodeWithContentDescription("TextField")
            .performTextInput("Ahanaf")
        composeTestRule.onNodeWithContentDescription("TextField")
            .assertTextEquals("Ahanaf")
    }

    @Test
    fun openSearchWidget_addInputText_pressCloseButtonOnce_assertInputText() {
        val text = mutableStateOf("")
        composeTestRule.setContent {
            SearchWidget(
                text = text.value,
                onTextChange = {
                    text.value = it
                },
                onCloseClicked = {

                },
                onSearchClicked = {

                }
            )
        }
        composeTestRule.onNodeWithContentDescription("TextField")
            .performTextInput("Ahanaf")
        composeTestRule.onNodeWithContentDescription("CloseButton")
            .performClick()
        composeTestRule.onNodeWithContentDescription("TextField")
            .assertTextContains("")
    }

    @Test
    fun openSearchWidget_addInputText_pressCloseButtonTwice_assertClosedState() {
        val text = mutableStateOf("")
        val searchWidgetShown = mutableStateOf(true)
        composeTestRule.setContent {
            if (searchWidgetShown.value) {
                SearchWidget(
                    text = text.value,
                    onTextChange = {
                        text.value = it
                    },
                    onCloseClicked = {
                        searchWidgetShown.value = false
                    },
                    onSearchClicked = {

                    }
                )
            }
        }
        composeTestRule.onNodeWithContentDescription("TextField")
            .performTextInput("Ahanaf")
        composeTestRule.onNodeWithContentDescription("CloseButton")
            .performClick()
        composeTestRule.onNodeWithContentDescription("CloseButton")
            .performClick()
        composeTestRule.onNodeWithContentDescription("SearchWidget")
            .assertDoesNotExist()
    }

    @Test
    fun openSearchWidget_pressCloseButtonOnceWhenInputIsEmpty_assertClosedState() {
        val text = mutableStateOf("")
        val searchWidgetShown = mutableStateOf(true)
        composeTestRule.setContent {
            if (searchWidgetShown.value) {
                SearchWidget(
                    text = text.value,
                    onTextChange = {
                        text.value = it
                    },
                    onCloseClicked = {
                        searchWidgetShown.value = false
                    },
                    onSearchClicked = {

                    }
                )
            }
        }
        composeTestRule.onNodeWithContentDescription("CloseButton")
            .performClick()
        composeTestRule.onNodeWithContentDescription("SearchWidget")
            .assertDoesNotExist()
    }

}