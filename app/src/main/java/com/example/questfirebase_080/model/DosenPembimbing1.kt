package com.example.questfirebase_080.model

data class DosenPembimbing1(
    val id: String,
    val nama: String,
    val alamat: String,
    val jenis_kelamin: String,
    val prodi: String,
){
    constructor():this("","","","","",)
}
