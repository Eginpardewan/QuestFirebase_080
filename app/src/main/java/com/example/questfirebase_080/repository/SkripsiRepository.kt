package com.example.questfirebase_080.repository

import com.example.questfirebase_080.model.Skripsi
import kotlinx.coroutines.flow.Flow

interface SkripsiRepository {
    suspend fun getSkripsi(): Flow<List<Skripsi>>

    suspend fun insertSkripsi(skripsi: Skripsi)

    suspend fun updateSkripsi(skripsi: Skripsi)

    suspend fun deleteSKripsi(skripsi: Skripsi)

    suspend fun getSkripsiById(id: String): Flow<Skripsi>
}