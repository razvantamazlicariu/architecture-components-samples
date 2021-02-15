package com.example.android.navigationadvancedsample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import java.lang.ref.WeakReference


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class MainBotNavFragment : Fragment() {
    private var currentNavController: LiveData<NavController>? = null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_main_bot_nav, container, false)
        setupBottomNavigationBar(view)
        return view;
    }

    private fun setupBottomNavigationBar(view: View) {

//        val navController = Navigation.findNavController(view, R.id.activity_main_nav_host_fragment)
//        val navController = findViewNavController(view)

//        NavigationUI.setupWithNavController(bottomNavigationView, controller!!)

        val navGraphIds = listOf(R.navigation.home, R.navigation.list, R.navigation.form)

        val bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_nav)
        val controller = bottomNavigationView.setupWithNavController(
                navGraphIds = navGraphIds,
                fragmentManager = parentFragmentManager,
                containerId = R.id.activity_main_nav_host_fragment,
                intent = activity!!.intent
        )

        // Whenever the selected controller changes, setup the action bar.
        controller.observe(viewLifecycleOwner, Observer { navController ->
//            setupActionBarWithNavController(navController)
        })
        currentNavController = controller
    }

    fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
    }

    private fun findViewNavController(view: View?): NavController? {
        var view = view
        while (view != null) {
            val controller = getViewNavController(view)
            if (controller != null) {
                return controller
            }
            val parent = view.parent
            view = if (parent is View) (parent as View) else null
        }
        return null
    }

    private fun getViewNavController(view: View): NavController? {
        val tag = view.getTag(R.id.nav_controller_view_tag)
        var controller: NavController? = null
        if (tag is WeakReference<*>) {
            controller = (tag as WeakReference<NavController?>).get()
        } else if (tag is NavController) {
            controller = tag
        }
        return controller
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MainBotNavFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
                MainBotNavFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_PARAM1, param1)
                        putString(ARG_PARAM2, param2)
                    }
                }
    }
}