/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun WelcomeScreen(darkTheme: Boolean = isSystemInDarkTheme(), navigateTo: (Screen) -> Unit) {

    val img_logo =
        if (darkTheme) {
            R.drawable.ic_dark_logo
        } else {
            R.drawable.ic_light_logo
        }

    val img_welcome_bg =
        if (darkTheme) {
            R.drawable.ic_dark_welcome_bg
        } else {
            R.drawable.ic_light_welcome_bg
        }

    val img_welcome_illos =
        if (darkTheme) {
            R.drawable.ic_dark_welcome_illos
        } else {
            R.drawable.ic_light_welcome_illos
        }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.primary)
    ) {

        Image(
            imageVector = ImageVector.vectorResource(img_welcome_bg),
            contentDescription = null,
        )

        Column {

            Spacer(modifier = Modifier.height(72.dp))
            Image(
                imageVector = ImageVector.vectorResource(img_welcome_illos),
                contentDescription = null,
                modifier = Modifier.padding(start = 88.dp),
            )
            Spacer(modifier = Modifier.height(48.dp))

            Image(
                imageVector = ImageVector.vectorResource(img_logo),
                contentDescription = null,
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )

            Text(
                "Beautiful home graden solutions",
                style = MaterialTheme.typography.subtitle1,
                modifier = Modifier.align(Alignment.CenterHorizontally),
            )

            Spacer(modifier = Modifier.height(40.dp))

            Button(
                onClick = {},
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(48.dp)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
                    .clip(MaterialTheme.shapes.medium),
//                    .background(MaterialTheme.colors.secondary),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = MaterialTheme.colors.secondary
                )

            ) {
                Text(
                    "Create account",
//                    style = MaterialTheme.typography.button
                )
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Log in",
                style = MaterialTheme.typography.button,
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .clickable {
                        navigateTo(Screen.Login)
                    }

            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun PreviewWelcomeLight() {

    MyTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colors.background) {
            WelcomeScreen(darkTheme = false) {}
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun PreviewWelcomeDark() {

    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            WelcomeScreen(darkTheme = true) {}
        }
    }
}
