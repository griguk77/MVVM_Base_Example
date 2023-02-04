package ru.myitschool.lab23

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import ru.myitschool.lab23.databinding.ActivityMainBinding
import ru.myitschool.lab23.databinding.ContentMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        binding.content.getRandomNum.setOnClickListener {
            val m = binding.content.meanVal.text.toString().toDouble()
            val v = binding.content.varianceValue.text.toString().toDouble()
            viewModel.setValue(Math.exp(Math.sqrt(v) * Random().nextGaussian() + m))
        }
        viewModel.value.observe(this) {
            binding.content.randomNumberResult.text = it.toString()
        }
    }
}