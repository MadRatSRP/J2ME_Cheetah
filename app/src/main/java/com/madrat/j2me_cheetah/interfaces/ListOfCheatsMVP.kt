package com.madrat.j2me_cheetah.interfaces

import android.content.Context
import com.madrat.j2me_cheetah.model.Cheat

interface ListOfCheatsMVP {
    interface View {

        fun setupMVP()
        fun updateListOfCheats(listOfCheats: ArrayList<Cheat>)
    }
    interface Presenter {

        fun openFileAndConvertItToTheListOfCheats(context: Context, pathToNLCheats: String, fileId: Int): List<Cheat>
        fun updateAndShowListOfCheats(context: Context)
        fun showListOfCheats(listOfCheats: ArrayList<Cheat>)
    }
}