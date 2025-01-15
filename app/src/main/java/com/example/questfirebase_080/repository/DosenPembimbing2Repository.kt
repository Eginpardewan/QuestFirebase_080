package com.example.questfirebase_080.repository

import com.example.questfirebase_080.model.DosenPembimbing2
import kotlinx.coroutines.flow.Flow

interface DosenPembimbing2Repository {
    suspend fun getDosenPembimbing2(): Flow<List<DosenPembimbing2Repository>>

    suspend fun insertDosenPembimbing2(dosenPembimbing2: DosenPembimbing2)

    suspend fun updateDosenPembimbing2(dosenPembimbing2: DosenPembimbing2)

    suspend fun deleteDosenPembimbing2i(dosenPembimbing2: DosenPembimbing2)

    suspend fun getDosenPembimbing2iById(id: String): Flow<DosenPembimbing2>
}