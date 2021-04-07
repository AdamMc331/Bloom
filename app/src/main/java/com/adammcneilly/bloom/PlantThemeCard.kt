package com.adammcneilly.bloom

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.adammcneilly.bloom.ui.theme.BloomTheme

@Composable
fun PlantThemeCard(plantTheme: PlantTheme) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier
            .size(136.dp),
    ) {
        Column {
            Image(
                painterResource(id = plantTheme.imageRes),
                contentDescription = "${plantTheme.title} Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(136.dp)
                    .height(96.dp)
            )

            Text(
                text = plantTheme.title,
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .paddingFromBaseline(top = 24.dp)
                    .padding(horizontal = 16.dp),
            )
        }
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
private fun PlantThemeCardPreview() {
    BloomTheme {
        PlantThemeCard(
            plantTheme = defaultPlantThemes.first()
        )
    }
}