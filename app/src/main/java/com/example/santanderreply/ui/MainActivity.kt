package com.example.santanderreply.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.santanderreply.R
import com.example.santanderreply.data.Conta

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        buscarContaCliente()
    }
    private fun buscarContaCliente(){
        mainViewModel.buscaContaCliente().observe(this, Observer { result ->
            bindOnView(result)
        })
    }
    private fun bindOnView(conta: Conta){
            findViewById<TextView>(R.id.tv_agencia).text = conta.agencia
            findViewById<TextView>(R.id.tv_conta).text = conta.numero
            findViewById<TextView>(R.id.valor_saldo).text = conta.saldo
            findViewById<TextView>(R.id.v_saldo_limite).text = conta.limite_disponivel
            findViewById<TextView>(R.id.num_card).text = conta.cartao.numeroCartao
            findViewById<TextView>(R.id.tv_usuario).text = conta.cliente.nome
        }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.main_menu,menu)
        return super.onCreateOptionsMenu(menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId){
            R.id.item_1 -> {
                Log.d("Click","Click item 1")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}