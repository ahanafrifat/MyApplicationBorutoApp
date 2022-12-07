package com.ahanafrifat.myapplicationborutoapp.presentation.screens.search

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.paging.compose.collectAsLazyPagingItems
import coil.annotation.ExperimentalCoilApi
import com.ahanafrifat.myapplicationborutoapp.presentation.common.ListContent

@ExperimentalCoilApi
@Composable
fun SearchScreen(
    navController: NavHostController,
    searchViewModel: SearchViewModel = hiltViewModel()
) {

    val searchQuery by searchViewModel.searchQuery
    val heroes = searchViewModel.searchedHeroes.collectAsLazyPagingItems()

    Scaffold(topBar = {
        SearchTopBar(
            text = searchQuery,
            onTextChange = {
                searchViewModel.updateSearchQuery(query = it)
            },
            onSearchClicked = {
                searchViewModel.searchHeroes(query = it)
            },
            onCloseClicked = {
                navController.popBackStack()
            }
        )
    },
        content = { padding ->
            Surface(modifier = Modifier.padding(padding)) {
                ListContent(heroes = heroes, navController = navController)
            }
        }
    )

}