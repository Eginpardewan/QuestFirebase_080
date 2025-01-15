package com.example.questfirebase_080.repository

import com.example.questfirebase_080.model.DosenPembimbing1
import com.example.questfirebase_080.model.DosenPembimbing2
import kotlinx.coroutines.flow.Flow

interface DosenPembimbing1Repository {
    suspend fun getDosenPembimbing1(): Flow<List<DosenPembimbing1Repository>>

    suspend fun insertDosenPembimbing2(dosenPembimbing1: DosenPembimbing1)

    suspend fun updateDosenPembimbing2(dosenPembimbing1: DosenPembimbing1)

    suspend fun deleteDosenPembimbing1(dosenPembimbing1: DosenPembimbing1)

    suspend fun getDosenPembimbing1iById(id: String): Flow<DosenPembimbing1>
}