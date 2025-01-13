package com.example.questfirebase_080.dependenciesinjection

import com.example.questfirebase_080.repository.MahasiswaRepository
import com.example.questfirebase_080.repository.NetworkMahasiswaRepository
import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer{
    val mahasiswaRepository: MahasiswaRepository
}

class MahasiswaContainer: AppContainer{
    private val firestore : FirebaseFirestore =  FirebaseFirestore.getInstance()
    override val mahasiswaRepository: MahasiswaRepository by lazy {
        NetworkMahasiswaRepository(firestore)
    }
}