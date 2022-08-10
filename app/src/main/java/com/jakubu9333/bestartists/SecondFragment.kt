package com.jakubu9333.bestartists

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.fragment.app.viewModels
import com.jakubu9333.bestartists.databinding.FragmentSecondBinding



class SecondFragment : Fragment() {

    private val viewModel: SpotifyViewModel by viewModels()

    private fun auth(){
        startActivity(Intent(activity, AuthSpotify::class.java))
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        val bind = FragmentSecondBinding.inflate(inflater)
        bind.lifecycleOwner = this
        val vm = viewModel
        val key = activity?.getSharedPreferences("SPOTIFY", 0)?.getString("token", null)
        //var success=false
       /* val handler = CoroutineExceptionHandler { _, exception ->
            println("CoroutineExceptionHandler got $exception")
        }*/

        auth()
        if (key != null){

            vm.getInfoAboutMe(key)
        }
        //success=true


        bind.viewModel = vm
        return bind.root
    }

}