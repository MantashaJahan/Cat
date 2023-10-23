package com.example.cat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cat.databinding.ActivityMainBinding
import com.example.cat.databinding.ActivityVarificationBinding
import com.google.firebase.auth.FirebaseAuth

class VarificationActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityVarificationBinding.inflate(layoutInflater)
    }
    var auth: FirebaseAuth ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        auth = FirebaseAuth.getInstance()
        if(auth!!.currentUser!=null){
            startActivity(Intent(this@VarificationActivity,MainActivity::class.java))
            finish()
        }
        binding.phoneET.requestFocus()
        binding.continueBtn.setOnClickListener{
           var intent = intent.putExtra("phonenumber",binding.phoneET.text.toString())
            startActivity(intent)
        }
    }
}