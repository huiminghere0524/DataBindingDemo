package com.example.databindingdemo


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.databindingdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var aPerson : Person = Person("ali","123456","ali@gmail.com","123 Jalan ABC")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.personData = aPerson

        binding.btnUpdate.setOnClickListener( ){
            aPerson.email = "xxx@gmail.com"
            aPerson.address = "123 Jalan XYZ"

            binding.apply { invalidateAll() }
        }

        binding.tvName.text = aPerson.name
        binding.tvIc.text = aPerson.ic
        binding.tvEmail.text = aPerson.email
        binding.tvAddress.text = aPerson.address
    }
}