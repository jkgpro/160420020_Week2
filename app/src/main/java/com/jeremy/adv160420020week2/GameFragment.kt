package com.jeremy.adv160420020week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.android.material.textfield.TextInputEditText
import java.util.*


class GameFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    //Untuk pindah ke halaman lain (GameFragment -> MainFragment)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null)
        {
            val playerName = GameFragmentArgs.fromBundle(requireArguments()).playerName

            var playerTurn = view.findViewById<TextView>(R.id.txtTurn)
            playerTurn.text = "$playerName's turn"
        }
        val backBtn = view.findViewById<Button>(R.id.btnBack)
        backBtn.setOnClickListener {
            val action = GameFragmentDirections.actionMainFragment()
            Navigation.findNavController(it).navigate(action)
        }

        val submitAnswerBtn = view.findViewById<Button>(R.id.btnSubmitAnswer)
        submitAnswerBtn.setOnClickListener {
            val action = GameFragmentDirections.actionResultFragment()
            Navigation.findNavController(it).navigate(action)
            val result = view.findViewById<EditText>(R.id.txtHasil)
            val random = Random()
            val numberone = random.nextInt(10)
            val numbertwo = random.nextInt(20)

            //Deklarasi Variabel Untuk Menampung Angka Random
            var oneNumber = view.findViewById<TextView>(R.id.txtAngka1)
            var twoNumber = view.findViewById<TextView>(R.id.txtAngka2)

            oneNumber.text = "$numberone"
            twoNumber.text = "$numbertwo"
            val hitung = twoNumber
            if (result == hitung)
            {
                println("Berhasil")
            }

        }
    }
}