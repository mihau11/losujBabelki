package com.nkodem.losujbbelki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.nkodem.losujbbelki.databinding.ActivityMainBinding
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        var labelki = arrayListOf<TextView>(binding.l0,binding.l1,binding.l2,binding.l3,binding.l4,binding.l5,binding.l6,binding.l7,binding.l8)
        var butonki = arrayOf(binding.b0,binding.b1,binding.b2,binding.b3,binding.b4,binding.b5,binding.b6,binding.b7,binding.b8)
        binding.losuj.setOnClickListener {
            for (element in labelki){
                element.text= kotlin.random.Random.nextInt(10,100).toString()
            }
        }
        binding.sortuj.setOnClickListener {
            binding.textView2.text=" "
            var liczby= arrayOf("")
            var pomocnicza = liczby.toMutableList()
            for (index in 0..8){
                if(butonki[index].isChecked){
                    pomocnicza.add(labelki[index].text.toString())
                }
            }
            liczby=pomocnicza.toTypedArray()
            val len = liczby.size
            for (i in 0 until (len - 1)) {
                for (j in 0 until (len - i - 1)) {
                    if (liczby[j].compareTo(liczby[j + 1]) > 0) {
                        val zapas = liczby[j]
                        liczby[j] = liczby[j + 1]
                        liczby[j + 1] = zapas
                    }
                }
            }

            for (element in liczby){
                binding.textView2.text=binding.textView2.text.toString()+element+" "
            }
        }
    }
}