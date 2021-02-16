package com.example.android.navigationadvancedsample.scren1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.android.navigationadvancedsample.MainActivity
import com.example.android.navigationadvancedsample.NavControllerContainer
import com.example.android.navigationadvancedsample.R

class GateFragment1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_gate1, container, false)
        view.findViewById<Button>(R.id.btn_enter).setOnClickListener {
//            (activity as MainActivity).findNavController().navigate()
            val startNavController = NavControllerContainer.startNavController
            startNavController?.navigate(R.id.action_gateBotomNav_to_mainBotNavFragment3)
        }

        return view;
    }
}