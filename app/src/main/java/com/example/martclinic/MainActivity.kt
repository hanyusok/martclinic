package com.example.martclinic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.martclinic.ui.screens.ClinicsList
import com.example.martclinic.ui.theme.MartClinicTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MartClinicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) {
                    ClinicsList()
                }
            }
        }
    }
}



