package com.example.martclinic.ui.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.martclinic.data.Clinic
import com.example.martclinic.network.SupabaseClient.client
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun ClinicsList(){
    val clinics = remember { mutableStateListOf<Clinic>() }
    LaunchedEffect(Unit)  {
        withContext(Dispatchers.IO){
            val response = client.postgrest["clinics"].select().decodeList<Clinic>()
            clinics.addAll(response)
        }
    }
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(clinics) { clinic ->
            ListItem(headlineContent = { Text(clinic.clinicName ?: "") })
        }
    }
}
