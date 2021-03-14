package com.example.androiddevchallenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.navigate

@Composable
fun Login(navController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.ic_login), contentDescription = null,
        modifier = Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds)
        Column(
            modifier = Modifier.fillMaxSize().padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val emailAddress = rememberSaveable{ mutableStateOf("")}
            val password = rememberSaveable{ mutableStateOf("")}
            Text("LOG IN",
                style = MaterialTheme.typography.h1.copy(MaterialTheme.colors.onBackground))
            Spacer(modifier = Modifier.height(32.dp))
            TextField(value = emailAddress.value , onValueChange = { emailAddress.value = it },
            label = {Text("Email address",
                style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface))},
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth().background(MaterialTheme.colors.onSecondary)
                )
            Spacer(modifier = Modifier.height(8.dp))
            TextField(value = password.value , onValueChange = { password.value = it },
                visualTransformation = PasswordVisualTransformation(),
                label = {Text("Password",
                    style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onSurface))},
                modifier = Modifier
                    .height(56.dp)
                    .fillMaxWidth().background(MaterialTheme.colors.onSecondary)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(onClick = { navController.navigate("Home") },
                modifier = Modifier.height(72.dp).fillMaxWidth(),
             shape = MaterialTheme.shapes.medium) {
                Text("LOG IN")
            }

            val text = with(AnnotatedString.Builder("Don't have an account? Sign Up")){
                addStyle(style = SpanStyle(textDecoration = TextDecoration.Underline),
                start = 23, end = 30)
                toAnnotatedString()
            }
            ClickableText(text = text, style = MaterialTheme.typography.body1.copy(color = MaterialTheme.colors.onBackground),
            modifier = Modifier.height(32.dp).padding(top =16.dp), onClick = {})
        }
    }
}