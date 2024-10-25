package com.example.signup.uipage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signup.R
import com.example.signup.ui.theme.maincolor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpStep3(onNext: () -> Unit, onBack: () -> Unit) {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    Box(modifier = Modifier.fillMaxSize())
    {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.Start
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.Start)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp).clickable {
                        onBack()
                    }
                )

                // Oraliqni to'ldirish uchun Spacer
                Spacer(modifier = Modifier.weight(1f))

                // Markazda matn
                Text(
                    text = "Sign Up",
                    fontSize = 18.sp,
                    color = Color.Black,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )

                // Oxirida yana oraliq to'ldirish uchun Spacer
                Spacer(modifier = Modifier.weight(1f))
            }
            Spacer(modifier = Modifier.padding(top = 20.dp))
            Text(
                text = "Create a Password",
                color = Color.Black,
                fontSize = 30.sp,
                modifier = Modifier.padding(start = 10.dp)
            )

            TextField(
                value = password,
                onValueChange = { password = it },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.Transparent,
                    errorPlaceholderColor = Color.LightGray,
                    focusedIndicatorColor = Color.Transparent, // Fokusda bo'lganda qizil rang
                    unfocusedIndicatorColor = Color.Transparent // Fokusda bo'lmaganda qizil rang
                ),

                textStyle = TextStyle(color = Color.Black, fontSize = 25.sp),
                maxLines = 1,
                placeholder = {
                    Text(
                        "Password",
                        fontSize = 25.sp,
                        color = Color.LightGray
                    )
                }, // Hint matni qo'shilmoqda
                modifier = Modifier
                    .fillMaxWidth()

            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(18.dp) // Aylana o'lchami
                        .background(
                            color = if (passwordVisible) maincolor else Color.White,
                            shape = CircleShape
                        ) // Ichki rangi ko'k
                        .border(
                            width = 2.dp,
                            color = if (passwordVisible) maincolor else Color.LightGray,
                            shape = CircleShape
                        ) // Chegara rangi qizil
                        .clickable {
                            passwordVisible = !passwordVisible
                        }
                )
                Spacer(modifier = Modifier.padding(start = 10.dp))
                Text(text = "Show Password")
            }


        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(16.dp)
                .imePadding(), Arrangement.Bottom
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "2 of 3", modifier = Modifier.align(Alignment.End), fontSize = 15.sp)
            Spacer(modifier = Modifier.height(6.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(10.dp)
                    .clip(RoundedCornerShape(16.dp)),
            ) {
                Spacer(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxHeight()
                        .background(maincolor)
                )

                Spacer(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                        .background(Color.LightGray)
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = onNext,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = maincolor // Tugma rangini yashil qilib qo'yish
                )
            ) {
                Text("Next", color = Color.White) // Matn rangini oq qilib qo'yish
            }
        }
    }
    Spacer(modifier = Modifier.padding(bottom = 8.dp))
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun showSingUp3() {
    SignUpStep3(onNext = {
        println("")
    },
        onBack = {}
    )
}
