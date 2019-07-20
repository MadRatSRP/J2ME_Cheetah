package com.madrat.j2me_cheetah.adapter

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.madrat.j2me_cheetah.R
import com.madrat.j2me_cheetah.util.inflate
import com.madrat.j2me_cheetah.model.Cheat
import com.madrat.j2me_cheetah.model.SpannableCheat
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.list_cheats.*

class SpannableCheatsAdapter
    : RecyclerView.Adapter<SpannableCheatsAdapter.SpannableCheatsHolder>() {
    private val spannableListOfCheats = ArrayList<SpannableCheat>()

    fun returnListOfCheats()
            = spannableListOfCheats
    fun updateSpannableListOfCheats(newSpannableListOfCheats: ArrayList<SpannableCheat>) {
        spannableListOfCheats.clear()
        spannableListOfCheats.addAll(newSpannableListOfCheats)
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpannableCheatsHolder
            = SpannableCheatsHolder(parent.inflate(R.layout.list_cheats))
    override fun onBindViewHolder(holder: SpannableCheatsHolder, position: Int)
            = holder.bind(spannableListOfCheats[position])
    override fun getItemCount(): Int
            = spannableListOfCheats.size

    inner class SpannableCheatsHolder internal constructor(override val containerView: View)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun bind(spannableCheat: SpannableCheat) {
            cheatTitle.text = spannableCheat.title
        }
    }
}