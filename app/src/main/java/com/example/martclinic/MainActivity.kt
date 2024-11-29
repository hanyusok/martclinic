package com.example.martclinic

import android.app.LauncherActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import com.example.martclinic.ui.theme.MartClinicTheme
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

val supabase = createSupabaseClient(
    supabaseUrl = "http://martclinic.cafe24.com:8000",
    supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.ewogICJyb2xlIjogImFub24iLAogICJpc3MiOiAic3VwYWJhc2UiLAogICJpYXQiOiAxNzMwOTkxNjAwLAogICJleHAiOiAxODg4NzU4MDAwCn0.lA6CORXNZ8FLfK3_Y0dVo7XgavbtrdOfNZh1ursbjQQ"
) {
    install(Postgrest)
}


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MartClinicTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ClinicsList()
                }
            }
        }
    }
}

@Serializable
data class Clinic (
    val id: Int,
    @SerialName("created_at") val createdAt: String? = null,
    @SerialName("province")  val province: String? = null,
    @SerialName("city")    val city: String? = null,
    @SerialName("clinic_name")  val clinicName: String? = null,
    @SerialName("phone_number") val phoneNumber: String? = null,
    @SerialName("category") val category: String? = null,
    @SerialName("rat_available") val ratAvailable: Boolean? = null,
    @SerialName("address") val address: String? = null,
)

@Composable
fun ClinicsList(){
    val clinics = remember { mutableStateListOf<Clinic>() }
    LaunchedEffect(Unit)  {
        withContext(Dispatchers.IO){
            val response = supabase.postgrest["clinics"].select().decodeList<Clinic>()
            clinics.addAll(response)
        }
    }
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(clinics) { clinic ->
            ListItem(headlineContent = { Text(clinic.clinicName ?: "") })
        }
    }
}

