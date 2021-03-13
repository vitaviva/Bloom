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
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Card
import androidx.compose.material.Checkbox
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun HomeScreen(
    darkTheme: Boolean = isSystemInDarkTheme()
) {

    Scaffold(
        bottomBar = {
            BottomNavigation()
        }
    ) {
        Column {
            OutlinedTextField(
                value = "", onValueChange = {},
                placeholder = {
                    Text("Search")
                },
                leadingIcon = {
                    Image(
                        imageVector = Icons.Default.Search, "",
                        modifier = Modifier.size(18.dp),
                        colorFilter = ColorFilter.tint(
                            MaterialTheme.colors.onPrimary
                        )
                    )
                },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp)
            )

            Box(
                modifier = Modifier
                    .height(32.dp)
                    .padding(start = 16.dp)
            ) {
                Text(
                    "Browse themes",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier

                        .align(Alignment.BottomStart),
                )
            }

            LazyRow(modifier = Modifier.padding(top = 8.dp)) {
                items(rowData.size) {
                    RowItem(
                        modifier = Modifier.padding(start = 8.dp),
                        itemInfo = rowData[it]
                    )
                }
            }

            Row(
                modifier = Modifier
                    .height(40.dp)
                    .padding(start = 16.dp, end = 16.dp)
            ) {
                Text(
                    "Design your home garden",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.Bottom)
                )
                Image(
                    imageVector = Icons.Default.FilterList,
                    contentDescription = "",
                    modifier = Modifier.align(Alignment.Bottom),
                    colorFilter = ColorFilter.tint(
                        MaterialTheme.colors.onPrimary
                    )
                )
            }

            var checkedSet by remember {
                mutableStateOf(emptySet<ItemInfo>())
            }

            LazyColumn(Modifier.padding(16.dp)) {
                items(cloumnData.size) { it ->
                    val item = cloumnData[it]
                    ColumnItem(
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .fillMaxWidth(),
                        itemInfo = item,
                        checked = item in checkedSet,
                        onCheckedChange = {
                            checkedSet = if (it) checkedSet.toMutableSet().apply {
                                add(item)
                            } else checkedSet.toMutableSet().apply {
                                remove(item)
                            }
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun RowItem(modifier: Modifier, itemInfo: ItemInfo) {
    Card(
        modifier = modifier
            .padding(4.dp)
            .size(136.dp)
            .border(0.5.dp, Color.Gray, shape = MaterialTheme.shapes.small)
            .shadow(4.dp),
        shape = MaterialTheme.shapes.small,
    ) {

        Box {
            Image(
                bitmap = ImageBitmap.imageResource(id = itemInfo.image), contentDescription = "",
                contentScale = ContentScale.FillBounds,
            )
            Text(
                itemInfo.name,
                style = MaterialTheme.typography.h2,
                modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .fillMaxWidth()
                    .align(Alignment.BottomStart)
                    .padding(start = 16.dp, top = 8.dp, bottom = 8.dp)
            )
        }
    }
}

@Composable
fun ColumnItem(
    modifier: Modifier,
    itemInfo: ItemInfo,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(modifier.height(64.dp)) {

        Image(
            bitmap = ImageBitmap.imageResource(id = itemInfo.image), "",
            modifier = Modifier
                .size(64.dp)
                .clip(MaterialTheme.shapes.small),
            contentScale = ContentScale.FillBounds
        )

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 8.dp)
        ) {
            Text(
                text = itemInfo.name, style = MaterialTheme.typography.h2,
                modifier = Modifier.padding(start = 8.dp, top = 8.dp)
            )

            Text(
                text = itemInfo.description,
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 8.dp)
            )

            Checkbox(
                checked = checked,
                onCheckedChange = onCheckedChange,
                modifier = Modifier.align(Alignment.CenterEnd)
            )

            Divider(modifier = Modifier.align(Alignment.BottomStart))
        }
    }
}

@Composable
fun BottomNavigation() {
    var current by remember { mutableStateOf(navigationItem[0]) }

    BottomNavigation(
        modifier = Modifier
            .fillMaxWidth()
            .shadow(16.dp)
    ) {
        navigationItem.forEach { item ->
            BottomNavigationItem(
                label = { Text(text = item.first) },
                icon = { Icon(item.second, null) },
                selected = current == item,
                onClick = {
                    current = item
                },
                // alwaysShowLabels is used to set if you want to show the labels always or
                // just for the current item.
                alwaysShowLabel = true
            )
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun PreviewHomeLight() {

    MyTheme(darkTheme = false) {
        Surface(color = MaterialTheme.colors.background) {
            HomeScreen(darkTheme = false)
        }
    }
}

@Preview(widthDp = 360, heightDp = 640)
@Composable
fun PreviewHomeDark() {

    MyTheme(darkTheme = true) {
        Surface(color = MaterialTheme.colors.background) {
            HomeScreen(darkTheme = true)
        }
    }
}
