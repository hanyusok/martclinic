package com.example.martclinic.network

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest

object SupabaseClient {
    val client = createSupabaseClient(
        supabaseUrl = "http://martclinic.cafe24.com:8000",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.ewogICJyb2xlIjogImFub24iLAogICJpc3MiOiAic3VwYWJhc2UiLAogICJpYXQiOiAxNzMwOTkxNjAwLAogICJleHAiOiAxODg4NzU4MDAwCn0.lA6CORXNZ8FLfK3_Y0dVo7XgavbtrdOfNZh1ursbjQQ"
    ){
        install(Postgrest)
    }
}