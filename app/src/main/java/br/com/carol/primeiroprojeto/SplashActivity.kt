package br.com.carol.primeiroprojeto

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        carrega()
    }

    private fun carrega(){
        Handler().postDelayed({chamarProximaTela()},  2000L)
    }

    private fun chamarProximaTela() {
        var proximaTelaIntent = Intent(this,FormularioActivity::class.java)
        startActivity(proximaTelaIntent)
        finish()
    }
}
