package com.example.pokemonapp.ui.screens

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.pokemonapp.R
import com.example.pokemonapp.databinding.FragmentMainScreenBinding
import com.example.pokemonapp.ui.adapters.PokemonAdapter
import com.example.pokemonapp.ui.models.MainScreenViewModel
import kotlinx.coroutines.launch

class ScreenActivity : Fragment(R.layout.fragment_main_screen) {
    private var mainScreenViewBinding: FragmentMainScreenBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mainScreenViewBinding = FragmentMainScreenBinding.bind(view)
        val viewModel: MainScreenViewModel by activityViewModels()
        viewModel.getPokemons()
        lifecycleScope.launch {
            viewModel.stateMainScreen.collect{
                if(it.isNumberSorted) {
                    setSortByNumber(view)
                }
                if(it.isNameSorted){
                    setSortByName(view)
                }
                if (it.pokemonList.isNotEmpty()){
                    val adapter  = PokemonAdapter(it.pokemonList){
                        viewModel.selectPokemon(R.color.white, it)
                        viewModel.navigateToAbout()
                    }
                    mainScreenViewBinding?.PokemonList?.adapter = adapter
                }
            }
        }
        val dialog = fragment_change_state_dialog()
        mainScreenViewBinding?.ChangeMode?.setOnClickListener {
            viewModel.showStateChangeDialog(childFragmentManager)
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

