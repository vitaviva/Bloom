package com.example.androiddevchallenge

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun LoginScreen(
    darkTheme: Boolean = isSystemInDarkTheme(),
    navigateTo: (Screen) -> Unit
) {

    Column(Modifier.fillMaxHeight()) {

        Spacer(modifier = Modifier.height(184.dp))

        Text(
            "Log in with email",
            style = MaterialTheme.typography.h1,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        OutlinedTextField(
            value = "",
            onValueChange = {},
            placeholder = {
                Text("Email address")
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
        )

        OutlinedTextField(
            value = "", onValueChange = {},
            placeholder = {
                Text("Password(8+ characters)")
            }, modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
                .padding(start = 8.dp, end = 8.dp)
        )

        Text(
            "By clicking below, you agree to our Terms of Use and consent \n to our Privacy Policy.",
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 24.dp, bottom = 16.dp)
        )


        Button(
            onClick = {
                navigateTo(Screen.Home)
            },
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .height(60.dp)
                .fillMaxWidth()
                .padding(start = 10.dp, end = 10.dp)
                .clip(MaterialTheme.shapes.medium),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = MaterialTheme.colors.secondary
            )
        ) {
            Text("Log in", style = MaterialTheme.typography.button)
        }

    }
}


@Preview
@Composable
fun PreviewLoginLight() {

    MyTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colors.background) {
            LoginScreen(darkTheme = false) {}

        }
    }
}

@Preview
@Composable
fun PreviewLoginDark() {

    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            LoginScreen(darkTheme = true) {}
        }
    }
}

