package com.example.pokemonapp.Screen

import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.RadioGroup
import androidx.fragment.app.Fragment
import com.example.pokemonapp.R
import com.example.pokemonapp.fragment_change_state_dialog

class ScreenActivity : Fragment(R.layout.activity_screen) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val changeModeButton = view.findViewById<ImageButton>(R.id.ChangeMode)
        val dialog = fragment_change_state_dialog()
        val checkedChangeListener= RadioGroup.OnCheckedChangeListener {
            group: RadioGroup?, checkedId: Int ->
           when(checkedId){
               R.id.NameCheck -> {
                   setSortByName(view)
               }
               R.id.NumberCheck -> {
                   setSortByNumber(view)
               }
           }
            dialog.dismiss()
        }
        dialog.setOnCheckedChangeListener(checkedChangeListener)
        changeModeButton.setOnClickListener {
            dialog.show(
                parentFragmentManager,"ChangeStateDialog")
        }
    }

    fun setSortByNumber(view:View) {
        val imageButton= view.findViewById<ImageButton>(R.id.ChangeStateGroup)
        imageButton.setImageResource(R.drawable.ic_tag)
    }
    fun setSortByName(view: View){
        val imageButton=view.findViewById<ImageButton>(R.id.ChangeStateGroup)
        imageButton.setImageResource(R.drawable.vector_5_)
    }
}

