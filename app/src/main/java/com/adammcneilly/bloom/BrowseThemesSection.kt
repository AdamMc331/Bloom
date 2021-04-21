package com.adammcneilly.bloom

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adammcneilly.bloom.ui.theme.BloomTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BrowseThemesSection(themes: List<PlantTheme>) {
    Column(
        modifier = Modifier.fillMaxWidth(),
    ) {
        Text(
            text = "Browse themes",
            style = MaterialTheme.typography.h1,
            modifier = Modifier
                .paddingFromBaseline(32.dp)
                .padding(horizontal = 16.dp),
        )

        Spacer(Modifier.height(16.dp))
        
        LazyVerticalGrid(cells = GridCells.Fixed(2)) {
            themes.forEach { theme ->
                item {
                    PlantThemeCard(plantTheme = theme)
                }
            }
        }
//        LazyGr(
//            horizontalArrangement = Arrangement.spacedBy(8.dp),
//            modifier = Modifier
//                .horizontalScroll(rememberScrollState())
//                .padding(horizontal = 16.dp),
//        ) {
//            themes.forEach { theme ->
//                PlantThemeCard(theme)
//            }
//        }
    }
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
private fun BrowseThemesSectionPreview() {
    BloomTheme {
        Surface {
            BrowseThemesSection(themes = defaultPlantThemes)
        }
    }
}
