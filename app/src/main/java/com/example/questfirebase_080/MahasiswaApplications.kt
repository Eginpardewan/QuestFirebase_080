package com.example.questfirebase_080

import android.app.Application
import com.example.questfirebase_080.dependenciesinjection.AppContainer
import com.example.questfirebase_080.dependenciesinjection.MahasiswaContainer


class MahasiswaApplication: Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}