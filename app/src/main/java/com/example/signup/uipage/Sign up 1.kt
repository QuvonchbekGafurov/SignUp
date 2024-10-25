package com.example.signup.uipage

import android.graphics.MaskFilter
import android.text.style.MaskFilterSpan
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.formatWithSkeleton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.traceEventStart
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.signup.MaskVisualTransformation
import com.example.signup.R
import com.example.signup.ui.theme.DarkGreen
import com.example.signup.ui.theme.maincolor

@Composable
fun SignUpStep1(onNext: () -> Unit) {
    var Name by remember { mutableStateOf("") }
    var adress by remember { mutableStateOf("") }
    var phonenumber by remember { mutableStateOf("") }
    var Birthday by remember { mutableStateOf("") }
    val maskPhone = MaskVisualTransformation("+998 ## ###-##-##")
    val maskBirhtday = MaskVisualTransformation("##/##/####")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            Row(modifier = Modifier.fillMaxWidth()) {
                Image(
                    painter = painterResource(id = R.drawable.back),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp),
                    alignment = Alignment.CenterStart
                )
            }
            Text(
                text = "Create Account",
                style = MaterialTheme.typography.headlineLarge,
                modifier = Modifier,
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(top = 10.dp))
            Text(
                text = "Fill your information below or register with your social account",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                ,
                fontSize = 15.sp,// Optional padding for spacing
                color = Color.LightGray,
                textAlign = TextAlign.Center // Matnni markazlashtirish
            )


            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = Name,
                onValueChange = { Name = "" + it },
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Your Name") }, // Hint matni qo'shilmoqda
                shape = RoundedCornerShape(30.dp),
                textStyle = TextStyle(color = Color.Black)
            )
            OutlinedTextField(
                value = Birthday,
                onValueChange = {
                    if (Birthday.length < 8) {
                        Birthday = it.filter { it.isDigit() }
                    }
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Birthday") },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("DD/MM/YYYY") }, // Hint matni qo'shilmoqda
                shape = RoundedCornerShape(30.dp),
                textStyle = TextStyle(color = Color.Black),
                visualTransformation = maskBirhtday

            )

            OutlinedTextField(
                value = adress,
                onValueChange = { adress = "" + it },
                label = { Text("Address") },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Enter Your Location") }, // Hint matni qo'shilmoqda
                shape = RoundedCornerShape(30.dp),
                textStyle = TextStyle(color = Color.Black)

            )
            OutlinedTextField(
                value = phonenumber,
                onValueChange = {
                    if (phonenumber.length < 9) {
                        phonenumber = it.filter { it.isDigit() }
                    }
                },
                visualTransformation = maskPhone,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                label = { Text("Phone Number") },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("+998 __ ___ __ __") }, // Hint matni qo'shilmoqda
                shape = RoundedCornerShape(30.dp),
                textStyle = TextStyle(color = Color.Black)
            )

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


        }
    }

}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun showSignup1() {
    SignUpStep1(onNext = {
        // Bu yerda keyingi sahnaga o'tishni amalga oshirishingiz mumkin
        println("Login tugmasi bosildi!")
    })
}