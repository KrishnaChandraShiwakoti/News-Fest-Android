package com.example.newsfest.View

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.newsfest.R
import kotlinx.coroutines.delay

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            splashBody()
        }
    }
}

@SuppressLint("SuspiciousIndentation")
@Composable
fun splashBody(){
    val context = LocalContext.current
    val activity = context as Activity

    LaunchedEffect(Unit) {
        delay(3000)
        val intent = Intent(context, LoginActivity::class.java)
            context.startActivity(intent)
            activity.finish()
//        if(localEmail.toString().isEmpty()){
//            val intent = Intent(context, LoginActivity::class.java)
//            context.startActivity(intent)
//            activity.finish()
//        }else{
//            val intent = Intent(context, DashboardActitivity::class.java)
//            context.startActivity(intent)
//            activity.finish()
//        }
    }

    Scaffold { innerPadding ->
        Column(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.width(100.dp).height(100.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            CircularProgressIndicator()
        }
    }
}