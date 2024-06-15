package com.example.pokemonapp

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.view.Gravity
import android.widget.RadioGroup
import androidx.fragment.app.DialogFragment

class fragment_change_state_dialog(): DialogFragment() {
    private var onCheckedChangeListener: RadioGroup.OnCheckedChangeListener? = null
   @SuppressLint("MissingInflatedId")
   override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
      val dialog = activity?.let {
           val builder = AlertDialog.Builder(it)
           builder.create()
       } ?: throw IllegalStateException()
       val view = layoutInflater.inflate(R.layout.fragment_change_state_dialog,null)
       dialog.setView(view)
       dialog.context.setTheme(R.style.StateAlertDialog)
       dialog.window?.attributes.let {
           it?.gravity = Gravity.END or Gravity.TOP
           it?.verticalMargin= 0.15f
       }
       val radioGroup = view.findViewById<RadioGroup>(R.id.ChangeStateGroup)
       val onCheckedStateChangeListener = null
       radioGroup.setOnCheckedChangeListener(onCheckedStateChangeListener)
       return dialog
       }
    fun setOnCheckedChangeListener(listener: RadioGroup.OnCheckedChangeListener){
        var onCheckedStateChangeListener = listener
    }
    }

