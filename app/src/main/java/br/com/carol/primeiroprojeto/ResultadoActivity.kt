package br.com.carol.primeiroprojeto

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.widget.Toast
import br.com.carol.primeiroprojeto.extensions.format
import br.com.carol.primeiroprojeto.utils.ConstantesExtra
import kotlinx.android.synthetic.main.activity_resultado.*
import kotlin.math.roundToInt

class ResultadoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val peso = intent.extras.getString(ConstantesExtra.KEY_PESO)
        val altura = intent.extras.getString(ConstantesExtra.KEY_ALTURA)
        //Toast.makeText(this,peso,Toast.LENGTH_SHORT).show()

        calcularIMC(peso.toDouble(),altura.toDouble())

    }

    override fun onSupportNavigateUp(): Boolean{
        finish()
        return true
    }

    private fun calcularIMC(peso: Double, altura: Double) {
        val imc = peso / (altura * altura)

        when(imc){
            in 0..17->{
                tvIMC.setText(imc.format(0))
                tvIMCDescricao.text=getString(R.string.label_magreza)
                setImage(R.drawable.magreza)
            }
            in 17.1..18.5->{
                tvIMC.setText(imc.format(0))
                tvIMCDescricao.text=getString(R.string.label_abaixo_peso)
                setImage(R.drawable.abaixo)
            }
            in 18.6..24.9->{
                tvIMC.setText(imc.format(0))
                tvIMCDescricao.text=getString(R.string.label_peso_ideal)
                setImage(R.drawable.ideal)
            }
            in 25.0..29.9->{
                tvIMC.setText(imc.format(0))
                tvIMCDescricao.text=getString(R.string.label_levemente_acima)
                setImage(R.drawable.sobre)
            }
            in 30.0..34.9->{
                tvIMC.setText(imc.format(0))
                tvIMCDescricao.text=getString(R.string.label_obesidade1)
                setImage(R.drawable.obesidade)
            }
            in 35.0..39.9->{
                tvIMC.setText(imc.format(0))
                tvIMCDescricao.text=getString(R.string.label_obesidade2)
                setImage(R.drawable.obesidade)
            }
            else ->{
                tvIMC.setText(imc.format(0))
                tvIMCDescricao.text=getString(R.string.label_obesidade3)
                setImage(R.drawable.obesidade)
            }
        }

    }

    private fun setImage(resourceId: Int) {
        ivIMC.setImageDrawable(
                ContextCompat.getDrawable(this,resourceId))
    }

}
