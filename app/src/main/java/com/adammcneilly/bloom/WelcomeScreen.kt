package com.adammcneilly.bloom

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.adammcneilly.bloom.ui.theme.BloomTheme
import com.adammcneilly.bloom.ui.theme.Pink900
import com.adammcneilly.bloom.ui.theme.White

@Composable
fun WelcomeScreen(navController: NavController) {
    Surface(
        color = MaterialTheme.colors.primary,
        modifier = Modifier
            .fillMaxSize()
    ) {
        WelcomeBackground()

        WelcomeScreenContent(navController)
    }
}

@Composable
private fun WelcomeScreenContent(navController: NavController) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Spacer(Modifier.height(72.dp))

        LeafImage()

        Spacer(Modifier.height(48.dp))

        LogoImage()

        AppSubtitle()

        Spacer(Modifier.height(40.dp))

        CreateAccountButton()

        Spacer(Modifier.height(8.dp))

        LoginButton(navController)
    }
}

@Composable
private fun LeafImage() {
    val isLight = MaterialTheme.colors.isLight

    val leafImageRes = if (isLight) {
        R.drawable.ic_light_welcome_illos
    } else {
        R.drawable.ic_dark_welcome_illos
    }

    Image(
        painter = painterResource(id = leafImageRes),
        contentDescription = null,
        modifier = Modifier
            .offset(x = 88.dp)
    )
}

@Composable
private fun LogoImage() {
    val isLight = MaterialTheme.colors.isLight

    val logoImageRes = if (isLight) {
        R.drawable.ic_light_logo
    } else {
        R.drawable.ic_dark_logo
    }

    Image(
        painter = painterResource(id = logoImageRes),
        contentDescription = "Bloom",
    )
}

@Composable
private fun AppSubtitle() {
    Text(
        text = "Beautiful home garden solutions",
        style = MaterialTheme.typography.subtitle1,
        modifier = Modifier
            .paddingFromBaseline(32.dp)
    )
}

@Composable
private fun CreateAccountButton() {
    BloomSecondaryButton(
        buttonText = "Create account"
    )
}

@Composable
private fun LoginButton(navController: NavController) {
    val isLight = MaterialTheme.colors.isLight

    val textColor = if (isLight) {
        Pink900
    } else {
        White
    }

    TextButton(
        onClick = {
                  navController.navigate("login")
        },
        shape = MaterialTheme.shapes.medium,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .padding(horizontal = 16.dp),
    ) {
        Text(
            text = "Log in",
            color = textColor,
        )
    }
}

@Composable
private fun WelcomeBackground() {
    val isLight = MaterialTheme.colors.isLight
    val backgroundImageRes = if (isLight) {
        R.drawable.ic_light_welcome_bg
    } else {
        R.drawable.ic_dark_welcome_bg
    }

    Image(
        painterResource(id = backgroundImageRes),
        contentDescription = null,
        contentScale = ContentScale.FillBounds,
        modifier = Modifier
            .fillMaxSize()
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
private fun WelcomeScreenPreview() {
    BloomTheme {
        WelcomeScreen(navController = rememberNavController())
    }
}
