package com.widya.foodiest

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.widya.foodiest.databinding.ActivityMainBinding
import com.widya.foodiest.fragment.BreakfestFragment
import com.widya.foodiest.fragment.DessertFragment
import com.widya.foodiest.fragment.VegetarianFragment
import com.widya.foodiest.login.User

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding : ActivityMainBinding
    private lateinit var tv: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        tv =findViewById(R.id.fl_main)

        var usernamee: String? = intent.getParcelableExtra<User>("User")?.username
        var password: String? = intent.getParcelableExtra<User>("User")?.password
        tv.text = "Username: $usernamee dan Password: $password"
        supportActionBar?.hide()
        setCurrentFragment(BreakfestFragment())
        mainBinding.navBottomMain.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.ic_breakfast -> setCurrentFragment(BreakfestFragment())
                R.id.ic_vegetarian -> setCurrentFragment(VegetarianFragment())
                R.id.ic_dessert -> setCurrentFragment(DessertFragment())
            }
            true
        }

    }
    private fun setCurrentFragment(fragment : Fragment) = supportFragmentManager.beginTransaction().apply{
        replace(R.id.fl_main, fragment)
        commit()

    }
}