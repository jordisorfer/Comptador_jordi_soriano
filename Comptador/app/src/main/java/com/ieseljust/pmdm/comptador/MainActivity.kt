package com.ieseljust.pmdm.comptador
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.ieseljust.pmdm.comptador.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //Contador usado para registrar las pulsaciones
    var comptador=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Referencia al TextView

        val textViewContador = binding.textViewComptador


        // Inicialitzem el TextView amb el comptador a 0
        textViewContador.setText(comptador.toString())

        // Referencia al botón
        val btAdd=binding.btAdd

        //Fem  la referencia al boto de menos
        val btMenos= binding.btResta

        //Fem la refencia al boto de reset
        val btreset= binding.btReset

        // Asociaciamos una expresióin lambda como
        // respuesta (callback) al evento Clic sobre
        // el botón
        btAdd.setOnClickListener {
            comptador++
            textViewContador.setText(comptador.toString())
        }

        //creem la accio de el boto menos
        btMenos.setOnClickListener{
            comptador--
            textViewContador.setText(comptador.toString())
        }
        btreset.setOnClickListener {
            comptador=0
            textViewContador.setText(comptador.toString())
        }
    }
    override fun onSaveInstanceState(guardaEstado: Bundle) {
        super.onSaveInstanceState(guardaEstado)
        //lo "guardamos" en el Bundle
        guardaEstado.putInt("contador", comptador)
    }

    override fun onRestoreInstanceState(recuperaEstado: Bundle) {
        super.onRestoreInstanceState(recuperaEstado)
        //recuperamos el String del Bundle
        comptador = recuperaEstado.getInt("contador")
        //Seteamos el valor del EditText con el valor de nuestra cadena
        val textViewContador=binding.textViewComptador
        textViewContador.setText(comptador.toString())
    }
}