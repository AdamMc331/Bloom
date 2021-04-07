package com.adammcneilly.bloom

import android.content.res.Configuration
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adammcneilly.bloom.ui.theme.BloomTheme

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val currentState: State<HomeViewState> = homeViewModel.viewState.collectAsState()

    HomeScreenScaffold(currentState.value)
}

@Composable
private fun HomeScreenLoader(
    paddingValues: PaddingValues
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        )
    }
}

@Composable
private fun HomeScreenScaffold(
    state: HomeViewState,
) {
    Scaffold(
        bottomBar = {
            BloomBottomBar()
        }
    ) { paddingValues ->
        if (state.showLoading) {
            HomeScreenLoader(paddingValues)
        } else {
            HomeScreenContent(
                paddingValues,
                state
            )
        }
    }
}

@Composable
private fun BloomBottomBar() {
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        BloomBottomButton(
            selected = true,
            icon = Icons.Default.Home,
            labelText = "Home"
        )
        BloomBottomButton(
            selected = false,
            icon = Icons.Default.FavoriteBorder,
            labelText = "Favorites"
        )
        BloomBottomButton(
            selected = false,
            icon = Icons.Default.AccountCircle,
            labelText = "Profile"
        )
        BloomBottomButton(
            selected = false,
            icon = Icons.Default.ShoppingCart,
            labelText = "Cart"
        )
    }
}

@Composable
private fun RowScope.BloomBottomButton(
    selected: Boolean,
    icon: ImageVector,
    labelText: String,
) {
    BottomNavigationItem(
        selected = selected,
        onClick = { /*TODO*/ },
        icon = {
            Icon(
                icon,
                contentDescription = null,
            )
        },
        label = {
            Text(labelText)
        }
    )
}

@Composable
private fun HomeScreenContent(
    paddingValues: PaddingValues,
    state: HomeViewState,
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(paddingValues)
        ) {
            Spacer(Modifier.height(40.dp))

            SearchInput()

            BrowseThemesSection(
                state.plantThemes
            )

            HomeGardenSection(
                state.homeGardenItems
            )
        }
    }
}

@Composable
private fun HomeGardenSection(
    homeGardenItems: List<PlantTheme>
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = "Design your home garden",
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .paddingFromBaseline(
                    top = 40.dp,
                    bottom = 16.dp,
                )
                .weight(1F),
        )

        Icon(
            Icons.Default.FilterList,
            contentDescription = "Filter",
            modifier = Modifier
                .size(24.dp)
        )
    }

    Column(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .padding(bottom = 16.dp),
    ) {
        homeGardenItems.forEach { theme ->
            HomeGardenListItem(theme)
        }
    }
}

@Composable
private fun BrowseThemesSection(themes: List<PlantTheme>) {
    Text(
        text = "Browse themes",
        style = MaterialTheme.typography.h1,
        modifier = Modifier
            .paddingFromBaseline(32.dp)
            .padding(horizontal = 16.dp),
    )

    Spacer(Modifier.height(16.dp))

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier
            .horizontalScroll(rememberScrollState())
            .padding(horizontal = 16.dp),
    ) {
        themes.forEach { theme ->
            PlantThemeCard(theme)
        }
    }
}

@Composable
private fun SearchInput() {
    OutlinedTextField(
        value = "",
        onValueChange = {},
        label = {
            Text("Search")
        },
        leadingIcon = {
            Icon(
                Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier
                    .size(18.dp)
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
    )
}

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
)
@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO,
)
@Composable
private fun HomeScreenPreview() {
    val previewState = HomeViewState(
        plantThemes = defaultPlantThemes,
        homeGardenItems = homeGardenItems.take(2),
    )

    BloomTheme {
        HomeScreenScaffold(previewState)
    }
}
