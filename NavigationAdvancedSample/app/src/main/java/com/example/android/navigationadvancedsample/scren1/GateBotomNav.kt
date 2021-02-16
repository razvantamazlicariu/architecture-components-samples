package com.example.android.navigationadvancedsample.scren1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigationadvancedsample.R
import com.example.android.navigationadvancedsample.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class GateBotomNav : Fragment() {
    private var currentNavController: LiveData<NavController>? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_gate_botom_nav, container, false)
        setupBottomNavigationBar(view)
        return view
    }

    private fun setupBottomNavigationBar(view: View) {
        val navGraphIds = listOf(R.navigation.gate1, R.navigation.gate2)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_nav)
        val controller = bottomNavigationView.setupWithNavController(
                navGraphIds = navGraphIds,
                fragmentManager = childFragmentManager,
                containerId = R.id.nav_host_container,
                intent = activity!!.intent
        )

        controller.observe(viewLifecycleOwner, Observer { navController ->
            NavigationUI.setupActionBarWithNavController(activity as AppCompatActivity, navController)
        })
        currentNavController = controller
    }
}