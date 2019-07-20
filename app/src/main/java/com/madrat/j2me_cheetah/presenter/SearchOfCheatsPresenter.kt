package com.madrat.j2me_cheetah.presenter

import android.content.Context
import android.util.Log
import com.madrat.j2me_cheetah.R
import com.madrat.j2me_cheetah.interfaces.SearchOfCheatsMVP
import com.madrat.j2me_cheetah.model.Cheat
import com.madrat.j2me_cheetah.model.SpannableCheat
import com.madrat.j2me_cheetah.util.CheatsParser
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import okio.Okio

class SearchOfCheatsPresenter(private val locView: SearchOfCheatsMVP.View)
    : SearchOfCheatsMVP.Presenter {
    private val spannableListOfCheats = ArrayList<SpannableCheat>()

    override fun convertAndSaveSpannableListOfCheats(listOfCheats: ArrayList<Cheat>) {
        val spannableListOfCheats = ArrayList<SpannableCheat>()
        listOfCheats.forEach {
            spannableListOfCheats.add(SpannableCheat(
                it.cheatTitle, it.cheatDescription))
        }
        this.spannableListOfCheats.addAll(spannableListOfCheats)
    }
    override fun showListOfCheats() {
        locView.updateListOfCheats(this.spannableListOfCheats)
    }
    override fun showListOfCheats(updatedListOfCheats: ArrayList<SpannableCheat>) {
        locView.updateListOfCheats(updatedListOfCheats)
    }
    override fun searchForCheatAndUpdateListOfCheats(cheatName: String) {
        val updatedListOfCheats = spannableListOfCheats.filter {
            it.title.contains(cheatName, true)
        } as ArrayList<SpannableCheat>
        showListOfCheats(updatedListOfCheats)
    }
    override fun openFileAndConvertItToTheListOfCheats(context: Context, pathToNLCheats: String,
                                                       fileId: Int): List<Cheat> {
        val cheatName = context.getString(R.string.pathToNLCheatsCheat, fileId)

        val moshi = Moshi.Builder().build()
        val cheatsParser = CheatsParser(moshi)

        val assetManager = context.assets
        val inputStream = assetManager.open(pathToNLCheats + cheatName)

        val bufferedSource = Okio.buffer(Okio.source(inputStream))
        return cheatsParser.parse(JsonReader.of(bufferedSource))
    }
    override fun updateAndShowListOfCheats(context: Context) {
        val listOfCheats = ArrayList<Cheat>()

        val pathToFolderWithPreparedData = context.getString(R.string.pathToFolderWithPreparedData)
        val pathToFolderWithNLCheats = context.getString(R.string.pathToFolderWithNLCheats)
        val pathToNLCheats = pathToFolderWithPreparedData + pathToFolderWithNLCheats

        val firstListOfCheats
                = openFileAndConvertItToTheListOfCheats(context, pathToNLCheats, 1)
        val secondListOfCheats
                = openFileAndConvertItToTheListOfCheats(context, pathToNLCheats, 2)
        val thirdListOfCheats
                = openFileAndConvertItToTheListOfCheats(context, pathToNLCheats, 3)
        val fourthListOfCheats
                = openFileAndConvertItToTheListOfCheats(context, pathToNLCheats, 4)
        val fifthListOfCheats
                = openFileAndConvertItToTheListOfCheats(context, pathToNLCheats, 5)
        val sixthListOfCheats
                = openFileAndConvertItToTheListOfCheats(context, pathToNLCheats, 6)

        listOfCheats.addAll(firstListOfCheats)
        listOfCheats.addAll(secondListOfCheats)
        listOfCheats.addAll(thirdListOfCheats)
        listOfCheats.addAll(fourthListOfCheats)
        listOfCheats.addAll(fifthListOfCheats)
        listOfCheats.addAll(sixthListOfCheats)

        Log.d("", "${listOfCheats.size}")

        convertAndSaveSpannableListOfCheats(listOfCheats)
        showListOfCheats()
    }
}