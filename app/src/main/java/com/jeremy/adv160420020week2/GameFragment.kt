package com.jeremy.adv160420020week2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.navigation.Navigation
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

        //Random Angka 1 Sampai 50
        val random = Random()
        val numberone = random.nextInt(200)
        val numbertwo = random.nextInt(200)

        //Deklarasi Variabel Untuk Menampung Angka Random
        val oneNumber = view.findViewById<TextView>(R.id.txtAngka1)
        val twoNumber = view.findViewById<TextView>(R.id.txtAngka2)
        oneNumber.text = "$numberone"
        twoNumber.text = "$numbertwo"
        //Deklarasi Variabel Score
        var playerScore = 0
        //Hitung Penjumlahan
        var hitung = numberone + numbertwo

        val submitAnswerBtn = view.findViewById<Button>(R.id.btnSubmitAnswer)
        submitAnswerBtn.setOnClickListener {
            //Mengecek apakah jawaban user sama dengan hasil pertambahan
            var result = view.findViewById<EditText>(R.id.txtJawaban)
            if(result.toString() == hitung.toString())
            {
                //Jika Jawaban Benar Maka Code Dibawah Dijalankan dengan nilai/skor 1
                playerScore+=1
                val action = GameFragmentDirections.actionResultFragment(playerScore)
                Navigation.findNavController(it).navigate(action)
            }
            else if(result.toString() != hitung.toString())
            {
                //Jika Jawaban Salah Maka Code Dibawah Dijalankan dengan nilai/skor 0
                val action = GameFragmentDirections.actionResultFragment(playerScore)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }
}