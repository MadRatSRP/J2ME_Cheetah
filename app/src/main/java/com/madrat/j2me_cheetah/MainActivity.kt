package com.madrat.j2me_cheetah

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.madrat.j2me_cheetah.model.Cheat
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi
import kotlinx.android.synthetic.main.activity_main.*
import okio.BufferedSource
import okio.Okio
import org.apache.commons.io.IOUtils

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       /* val fileToString = openFile("nl_cheats_#1.json")
        val listOfCheats = fileToString?.let { convertStringToArrayOfCheats(it) }

        Log.d("", "${listOfCheats?.size}")*/

        val array = openFileAndConvertItToTheListOfCheats("nl_cheats_#1.json")
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

    /*fun openFile(filePath: String): String? {
        val assetManager = applicationContext.assets//.openFd("PreparedFilesWithCheats/NL_Cheats/")
        val inputStream = assetManager.open("PreparedFilesWithCheats/NL_Cheats/$filePath")
        val totalString = IOUtils.toString(inputStream)
        return totalString
    }
    fun convertStringToArrayOfCheats(string: String): ArrayList<Cheat> {
        val listOfCheats = ArrayList<Cheat>()
        val moshi = Moshi.Builder().build()
        val jsonAdapter: JsonAdapter<Cheat> = moshi.adapter(Cheat::class.java)


        val cheat = jsonAdapter.fromJson(string)
        cheat?.let { it1 -> listOfCheats.add(it1) }
        return listOfCheats
    }*/
}
