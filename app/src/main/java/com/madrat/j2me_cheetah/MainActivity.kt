package com.madrat.j2me_cheetah

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

        val array: List<Cheat> = openFileAndConvertItToTheListOfCheats("nl_cheats_#1.json")
        Log.d("", "${array.size}")
    }
    fun openFileAndConvertItToTheListOfCheats(filePath: String): List<Cheat> {
        val moshi = Moshi.Builder().build()
        val cheatsParser = CheatsParser(moshi)

        val assetManager = applicationContext.assets//.openFd("PreparedFilesWithCheats/NL_Cheats/")
        val inputStream = assetManager.open("PreparedFilesWithCheats/NL_Cheats/$filePath")

        val bufferedSource = Okio.buffer(Okio.source(inputStream))
        val listOfCheats = cheatsParser.parse(JsonReader.of(bufferedSource))
        return listOfCheats
    }
}
