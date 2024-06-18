package com.example.pokemonapp.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.pokemonapp.R
import com.example.pokemonapp.ui.models.MainScreenViewModel
import kotlinx.coroutines.launch

class ScreenActivity : Fragment(R.layout.activity_screen) {
    private fun mainScreenViewBinding(): Fragment? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel  by viewModels<MainScreenViewModel>()
        val button = view.findViewById<ImageButton>(R.id.ChangeMode)
        button.setOnClickListener{
            fragment_change_state_dialog().show(childFragmentManager, "ChangeState")
        }
        lifecycleScope.launch {
            viewModel.stateMainScreen.collect{
                if(it.isNumberSorted) {
                    setSortByNumber(view)
                }
                if(it.isNameSorted){
                    setSortByName(view)
                }
            }
        }
    }

    private fun setSortByNumber(view: View) {
        val imageButton = view.findViewById<ImageButton>(R.id.ChangeMode)
        imageButton.setImageResource(R.drawable.ic_tag)
    }

    private  fun setSortByName(view: View) {
        val imageButton = view.findViewById<ImageButton>(R.id.ChangeMode)
        imageButton.setImageResource(R.drawable.vector_5_)
    }
}

