package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Spa
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.Spa
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter.Companion.tint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun Home(){
    Scaffold(bottomBar ={ BottomActionBar()},floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,floatingActionButton = {FloatButton()}) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            val search = rememberSaveable { mutableStateOf("") }
            Spacer(modifier = Modifier.height(56.dp))
            TextField(
                value = search.value,
                onValueChange = { search.value = it },
                label = {
                    Text(
                        text = "Search",
                        style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface)
                    )
                },
                leadingIcon = {
                    Icon(
                        Icons.Outlined.Search,
                        contentDescription = null,
                        Modifier.size(18.dp)
                    )
                },
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth()
                    .background(color = MaterialTheme.colors.onSecondary)
            )
            Text(
                "FAVORITE COLLECTIONS",
                style = MaterialTheme.typography.h2.copy(color = MaterialTheme.colors.onBackground),
                modifier = Modifier
                    .height(40.dp)
                    .padding(top = 26.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            LazyRow{ items(favorities) { Column {
                FavoriteCollections(it.first)
                Spacer(modifier = Modifier.height(8.dp))
                FavoriteCollections(it.second) }
            }
            }
            Text(
                "ALIGN YOUR BODY",
                style = MaterialTheme.typography.h2.copy(color = MaterialTheme.colors.onBackground),
                modifier = Modifier
                    .height(56.dp)
                    .padding(top = 30.dp)
            )
            LazyRow{ items(alignbodies){ AlignCollections(it) } }
            Text(
                "ALIGN YOUR MIND",
                style = MaterialTheme.typography.h2.copy(color = MaterialTheme.colors.onBackground),
                modifier = Modifier
                    .height(56.dp)
                    .padding(top = 30.dp)
            )
            LazyRow { items(alignminds) { AlignCollections(it) }}
        }
    }
}

@Composable
fun FloatButton() {
    FloatingActionButton(onClick = {}, shape = CircleShape, backgroundColor = MaterialTheme.colors.onSurface) {
        Image(Icons.Filled.PlayArrow, contentDescription = null, colorFilter = tint(MaterialTheme.colors.onSecondary))
    }
}

@Composable
fun BottomActionBar() {
    val selectedMenu = rememberSaveable{ mutableStateOf("HOME")}
    BottomAppBar( backgroundColor = MaterialTheme.colors.background){
        BottomNavigationItem(selected = selectedMenu.value == "HOME" ,
            onClick = {selectedMenu.value = "HOME"},label = {Text("Home", style =
            MaterialTheme.typography.caption.copy(MaterialTheme.colors.onBackground))},
            icon = { Icon(if(selectedMenu.value == "HOME")Icons.Filled.Spa else Icons.Outlined.Spa,
                contentDescription = null ) }
        )
        BottomNavigationItem(selected = selectedMenu.value == "PROFILE" ,
            onClick = {selectedMenu.value = "PROFILE"},label = {Text("PROFILE", style =
            MaterialTheme.typography.caption.copy(MaterialTheme.colors.onBackground))},
            icon = { Icon(if(selectedMenu.value == "PROFILE")Icons.Filled.AccountCircle else Icons.Outlined.AccountCircle,
                contentDescription = null ) }
        )
    }
}

//@Composable
//fun AlignMindCollections() {
//    Image(painter = painterResource(id = R.drawable.pexels_elly_fairytale), contentDescription = null,
//        modifier = Modifier
//            .height(88.dp)
//            .width(88.dp)
//            .clip(shape = CircleShape),
//        contentScale = ContentScale.Crop)
//}

@Composable
fun AlignCollections(item: Item) {
    Column(modifier = Modifier.padding(end = 8.dp).height(112.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(item.Image), contentDescription = null,
            modifier = Modifier
                .height(88.dp)
                .width(88.dp)
                .clip(shape = CircleShape),
            contentScale = ContentScale.Crop)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = item.name,modifier = Modifier.height(24.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.h3.copy(color= MaterialTheme.colors.onSurface))
    }
}

@Composable
fun FavoriteCollections(item: Item) {
    Card(modifier = Modifier.padding(end =8.dp)
        .height(56.dp)
        .width(192.dp),shape = MaterialTheme.shapes.small){
        Row(modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically){
            Image(painterResource(item.Image), null,
                modifier = Modifier.size(56.dp), contentScale = ContentScale.Crop)
            Text(item.name, modifier = Modifier
                .fillMaxWidth(), textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h3.copy(color= MaterialTheme.colors.onSurface) )
        }
    }
}
