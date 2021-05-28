package com.example.santanderreply.data.local

import com.example.santanderreply.data.Cartao
import com.example.santanderreply.data.Cliente
import com.example.santanderreply.data.Conta

class FakeData {
    fun getLocalData(): Conta {
        val cliente = Cliente("Raphael")
        val cartao = Cartao("86235689")
        return Conta(
            "0122864-8",
            "4443",
            "R$ 2.045,80",
            "R$ 2.345,80",
            cliente,
            cartao
        )
    }
}