package com.example.signup.uipage


import android.graphics.Paint.Style
import android.webkit.WebSettings.TextSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.signup.R
import com.example.signup.ui.theme.DarkGreen
import com.example.signup.ui.theme.maincolor
import java.net.CookieStore


// 1. Login ekrani
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(onNext: () -> Unit) {
    Box(modifier = Modifier.background(Color.White)) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(Color.White),

            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Log In",
                modifier = Modifier,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = DarkGreen
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Hi! Welcome",
                modifier = Modifier,
                fontSize = 25.sp,
                color = Color.LightGray
            )
            Spacer(modifier = Modifier.height(50.dp))

            var password by rememberSaveable { mutableStateOf("") }
            var email by rememberSaveable { mutableStateOf("") }

            var passwordVisible by remember { mutableStateOf(false) }

            TextField(
                value = email,
                label = { Text("Email Address") },
                onValueChange = { email = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    errorPlaceholderColor = Color.LightGray,
                    unfocusedIndicatorColor = Color.LightGray // Fokusda bo'lmaganida chiziq rang
                ),
                textStyle = TextStyle(color = Color.Black),
                maxLines = 1,
                placeholder = { Text("Enter your email") }, // Hint matni qo'shilmoqda
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)// Kenglikni to'liq qamrab olish
            )

            TextField(
                value = password,
                maxLines = 1,
                onValueChange = { password = it },
                label = { Text("Password") },
                placeholder = { Text("Enter your password") },
                textStyle = TextStyle(color = Color.Black),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val description = if (passwordVisible) "Hide password" else "Show password"
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        val image =
                            if (passwordVisible) R.drawable.baseline_remove_red_eye_24 else R.drawable.img
                        Icon(
                            modifier = Modifier.size(20.dp),
                            painter = painterResource(id = image),
                            contentDescription = description
                        )
                    }
                },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    errorPlaceholderColor = Color.LightGray,
                    unfocusedIndicatorColor = Color.LightGray // Fokusda bo'lmaganida chiziq rang
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 15.dp)
            )
            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = onNext,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = maincolor // Tugma rangini yashil qilib qo'yish
                )
            ) {
                Text("Log In", color = Color.White) // Matn rangini oq qilib qo'yish
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "Forgotten your password ?",
                modifier = Modifier,
                fontSize = 15.sp,
                fontWeight = FontWeight.Bold,
                color = DarkGreen
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(

                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically // Vertikal markazga joylashtirish

            ) {
                Divider(
                    color = Color.Gray,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "Or Sign in whith",
                    color = Color.LightGray,
                    modifier = Modifier.padding(horizontal = 8.dp), // Matnni chiziqdan bir oz ajratish
                )
                Divider(
                    color = Color.Gray,
                    modifier = Modifier.weight(1f) // Chiziqning kengligini belgilaydi
                )
            }

            Spacer(modifier = Modifier.height(60.dp))

            Row(
                modifier = Modifier.padding(horizontal = 30.dp),

                ) {
                Image(
                    painter = painterResource(id = R.drawable.group2),
                    contentDescription = "Group Image", // Tasvirni ta'riflovchi matn

                    modifier = Modifier
                        .weight(1f)
                        .height(70.dp), // O'lcham
                    contentScale = ContentScale.Fit // Tasvirni kesish uchun
                )
                Image(
                    painter = painterResource(id = R.drawable.group14),
                    contentDescription = "Group Image", // Tasvirni ta'riflovchi matn
                    modifier = Modifier
                        .weight(1f)
                        .height(70.dp), // O'lcham
                    contentScale = ContentScale.Fit // Tasvirni kesish uchun
                )
                Image(
                    painter = painterResource(id = R.drawable.group3),
                    contentDescription = "Group Image", // Tasvirni ta'riflovchi matn
                    modifier = Modifier
                        .weight(1f)
                        .height(70.dp), // O'lcham
                    contentScale = ContentScale.Fit // Tasvirni kesish uchun
                )

            }
            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Don't have an account?",
                modifier = Modifier,
                fontSize = 15.sp,
                color = Color.LightGray
            )

            Text(
                text = "Create an account",
                modifier = Modifier,
                fontSize = 15.sp,
                color = maincolor
            )


        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun showLogin() {
    LoginScreen(onNext = {
        // Bu yerda keyingi sahnaga o'tishni amalga oshirishingiz mumkin
        println("Login tugmasi bosildi!")
    })
}