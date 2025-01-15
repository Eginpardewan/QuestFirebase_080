package com.example.questfirebase_080.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.questfirebase_080.model.Mahasiswa
import com.example.questfirebase_080.repository.MahasiswaRepository
import kotlinx.coroutines.launch

class InsertViewModel (
    private val mhs: MahasiswaRepository
): ViewModel(){
    var uiEvent: InsertUiState by mutableStateOf(InsertUiState())
        private set

    var uiState: FormState by mutableStateOf(FormState.Idle)
        private set

    fun updateState(mahasiswaEvent: MahasiswaEvent){
        uiEvent = uiEvent.copy(
            insertUiEvent = mahasiswaEvent
        )
    }

    fun validateFields(): Boolean{
        val event = uiEvent.insertUiEvent
        val errorState = FormErrorState(
            nim = if(event.nim.isNotEmpty()) null else "Nim tidak boleh kosong",
            nama = if(event.nama.isNotEmpty()) null else "Nim tidak boleh kosong",
            jenis_kelamin = if(event.jenis_kelamin.isNotEmpty()) null else "Nim tidak boleh kosong",
            alamat = if(event.alamat.isNotEmpty()) null else "Nim tidak boleh kosong",
            kelas = if(event.kelas.isNotEmpty()) null else "Nim tidak boleh kosong",
            angkatan = if(event.angkatan.isNotEmpty()) null else "Nim tidak boleh kosong",
            judul_skripsi = if(event.judul_skripsi.isNotEmpty()) null else "Judul tidak boleh kosong",
            dosenPembimbing1 = if(event.dosenPembimbing1.isNotEmpty()) null else "dospem tidak boleh kosong",
            dosenPembimbing2 = if(event.dosenPembimbing2.isNotEmpty()) null else "dospem tidak boleh kosong",
        )

        uiEvent = uiEvent.copy(isEntryValid = errorState)
        return errorState.isValid()
    }

    fun insertMhs(){
        if (validateFields()){
            viewModelScope.launch {
                uiState = FormState.Loading
                try {
                    mhs.insertMahasiswa(uiEvent.insertUiEvent.toMhsModel())
                    uiState = FormState.Success("Data berhasil disimpan")
                } catch (e: Exception){
                    uiState = FormState.Error("Data gagal disimpan")
                }
            }
        } else {
            uiState = FormState.Error("Data tidak valid")
        }
    }
    fun resetForm(){
        uiEvent = InsertUiState()
        uiState = FormState.Idle
    }

    fun resetSnacBarMessage(){
        uiState = FormState.Idle
    }

}

sealed class FormState{
    object Idle : FormState()
    object Loading : FormState()
    data class Success(val message: String) : FormState()
    data class Error(val message: String) : FormState()

}

data class InsertUiState(
    val insertUiEvent: MahasiswaEvent = MahasiswaEvent(),
    val isEntryValid: FormErrorState = FormErrorState()
)

data class FormErrorState(
    val nim: String? = null,
    val nama: String? = null,
    val jenis_kelamin: String? = null,
    val alamat: String? = null,
    val kelas: String? = null,
    val angkatan: String? = null,
    val judul_skripsi: String? = null,
    val dosenPembimbing1: String? = null,
    val dosenPembimbing2: String? = null

){
    fun isValid(): Boolean {
        return nim == null
                && nama == null
                && jenis_kelamin == null
                && alamat == null
                && kelas == null
                && angkatan == null
                && judul_skripsi == null
                && dosenPembimbing1 == null
                && dosenPembimbing2 == null
    }
}

fun MahasiswaEvent.toMhsModel() : Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    jenis_kelamin = jenis_kelamin,
    alamat = alamat,
    kelas = kelas,
    angkatan = angkatan,
    judul_skripsi = judul_skripsi,
    dosenPembimbing1 = dosenPembimbing1,
    dosenPembimbing2 = dosenPembimbing2

    )

data class MahasiswaEvent(
    val nim: String = "",
    val nama: String = "",
    val jenis_kelamin: String = "",
    val alamat: String = "",
    val kelas: String = "",
    val angkatan: String = "",
    val judul_skripsi: String = "",
    val dosenPembimbing1: String = "",
    val dosenPembimbing2: String = ""
)