package com.madrat.j2me_cheetah.util

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.moshi.JsonReader

inline fun <T : Any> JsonReader.readArrayToList(body: () -> T?): List<T> {
    val result = mutableListOf<T>()
    beginArray()
    while (hasNext()) {
        body()?.let { result.add(it) }
    }
    endArray()
    return result
}
//ViewGroup
fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this, false)
}
//RecyclerView extensions
fun RecyclerView.linearManager() {
    this.layoutManager = LinearLayoutManager(context)
}
//Fragment extensions
fun AppCompatActivity.addFragment(fragment: Fragment, id: Int) {
    this.supportFragmentManager?.beginTransaction()
        ?.replace(id, fragment)
        ?.commit()
}
fun AppCompatActivity.removeFragment(fragment: Fragment) {
    this.supportFragmentManager?.beginTransaction()
        ?.remove(fragment)
        ?.commit()
}
