package com.llc.astrologer

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import androidx.navigation.fragment.NavHostFragment
import com.llc.astrologer.databinding.ActivityMainBinding
import com.llc.astrologer.josarr.JosarrFragment
import com.llc.astrologer.mahar_bote.MaharBoteFragment
import com.llc.astrologer.maharbote_thetyout.MaharBoteThetYoutFragment
import com.llc.astrologer.thet_yout.ThetYoutFragment


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController
    }
}