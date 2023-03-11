package com.jeremy.adv160420020week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.Navigation


class ResultFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null)
        {
            val playerScore = ResultFragmentArgs.fromBundle(requireArguments()).playerScore

            var scoreTurn = view.findViewById<TextView>(R.id.txtScore)
            scoreTurn.text = "$playerScore"
        }

        val btnBackToMainScreen = view.findViewById<Button>(R.id.btnBackMainScreen)
        btnBackToMainScreen.setOnClickListener {
            val action = ResultFragmentDirections.actionBackToMainScreen()
            Navigation.findNavController(it).navigate(action)
        }
    }
}