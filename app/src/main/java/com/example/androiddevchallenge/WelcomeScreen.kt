package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

@Composable
fun Welcome(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.ic_welcome), contentDescription = null,
        modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
        Column(
            modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(painterResource(id = R.drawable.ic_logo), null,
            modifier = Modifier.align(Alignment.CenterHorizontally))
            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {}, modifier = Modifier
                    .height(72.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.primary)
            ) {
                Text("SIGN UP", color = MaterialTheme.colors.onPrimary)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                onClick = { navController.navigate("Login") }, modifier = Modifier
                    .height(72.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = MaterialTheme.shapes.medium,
                colors = ButtonDefaults.buttonColors(MaterialTheme.colors.secondary)
            ) {
                Text("LOG IN")
            }
        }
    }
}