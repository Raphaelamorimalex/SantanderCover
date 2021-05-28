package com.example.santanderreply.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.santanderreply.data.Conta
import com.example.santanderreply.data.local.FakeData


class MainViewModel: ViewModel(){
    private val mutableLiveData: MutableLiveData<Conta> = MutableLiveData()

    fun buscaContaCliente() : LiveData<Conta>{
        mutableLiveData.value = FakeData().getLocalData()

        return mutableLiveData
    }
}