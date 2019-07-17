package com.madrat.j2me_cheetah

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.madrat.j2me_cheetah.model.Cheat
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import okio.Okio

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        returnListOfCheats(applicationContext)
    }
    fun openFileAndConvertItToTheListOfCheats(context: Context, pathToNLCheats: String,
                                              fileId: Int): List<Cheat> {
        val cheatName = getString(R.string.pathToNLCheatsCheat, fileId)

        val moshi = Moshi.Builder().build()
        val cheatsParser = CheatsParser(moshi)

        val assetManager = context.assets
        val inputStream = assetManager.open(pathToNLCheats + cheatName)

        val bufferedSource = Okio.buffer(Okio.source(inputStream))
        val listOfCheats = cheatsParser.parse(JsonReader.of(bufferedSource))
        return listOfCheats
    }
    fun returnListOfCheats(context: Context): ArrayList<Cheat> {
        val listOfCheats = ArrayList<Cheat>()

        val pathToFolderWithPreparedData = getString(R.string.pathToFolderWithPreparedData)
        val pathToFolderWithNLCheats = getString(R.string.pathToFolderWithNLCheats)
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
        return listOfCheats
    }
}
