package com.example.questfirebase_080.model

import com.example.questfirebase_080.repository.DosenPembimbing1Repository

data class Mahasiswa (
    val nim: String,
    val nama: String,
    val alamat: String,
    val jenis_kelamin: String,
    val kelas: String,
    val angkatan: String,
    val judul_skripsi: String,
    val dosenPembimbing1: String,
    val dosenPembimbing2: String
){
    constructor():this("","","","","","","","","")
}