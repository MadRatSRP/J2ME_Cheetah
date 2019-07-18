package com.madrat.j2me_cheetah.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madrat.j2me_cheetah.R
import com.madrat.j2me_cheetah.util.inflate
import com.madrat.j2me_cheetah.model.Cheat
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_cheats.*

class CheatsAdapter
    : RecyclerView.Adapter<CheatsAdapter.CheatsHolder>() {
    private val listOfCheats = ArrayList<Cheat>()

    fun updateListOfCheats(newListOfCheats: ArrayList<Cheat>) {
        listOfCheats.clear()
        listOfCheats.addAll(newListOfCheats)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheatsHolder
            = CheatsHolder(parent.inflate(R.layout.list_cheats))
    override fun onBindViewHolder(holder: CheatsHolder, position: Int)
            = holder.bind(listOfCheats[position])
    override fun getItemCount(): Int
            = listOfCheats.size

    inner class CheatsHolder internal constructor(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(cheat: Cheat) {
            cheatTitle.text = cheat.cheatTitle
        }
    }
}