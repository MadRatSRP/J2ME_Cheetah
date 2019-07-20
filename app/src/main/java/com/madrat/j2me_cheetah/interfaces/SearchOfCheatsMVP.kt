package com.madrat.j2me_cheetah.interfaces

import android.content.Context
import com.madrat.j2me_cheetah.model.Cheat
import com.madrat.j2me_cheetah.model.SpannableCheat

interface SearchOfCheatsMVP {
    interface View {

        fun setupMVP()
        fun updateListOfCheats(listOfCheats: ArrayList<SpannableCheat>)
    }
    interface Presenter {
        fun convertAndSaveSpannableListOfCheats(listOfCheats: ArrayList<Cheat>)
        fun showListOfCheats()
        fun showListOfCheats(updatedListOfCheats: ArrayList<SpannableCheat>)
        fun searchForCheatAndUpdateListOfCheats(cheatName: String)
        fun openFileAndConvertItToTheListOfCheats(context: Context, pathToNLCheats: String,
                                                  fileId: Int): List<Cheat>
        fun updateAndShowListOfCheats(context: Context)
    }
}