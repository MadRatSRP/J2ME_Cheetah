package com.madrat.j2me_cheetah.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.madrat.j2me_cheetah.R
import com.madrat.j2me_cheetah.adapter.CheatsAdapter
import com.madrat.j2me_cheetah.interfaces.ListOfCheatsMVP
import com.madrat.j2me_cheetah.model.Cheat
import com.madrat.j2me_cheetah.presenter.ListOfCheatsPresenter
import com.madrat.j2me_cheetah.util.linearManager
import kotlinx.android.synthetic.main.view_list_of_cheats.*
import kotlinx.android.synthetic.main.view_list_of_cheats.view.*

class ListOfCheatsView
    : Fragment(), ListOfCheatsMVP.View {
    private var adapter: CheatsAdapter? = null
    private var locPresenter: ListOfCheatsPresenter? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        context?.let { locPresenter?.updateAndShowListOfCheats(it) }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.view_list_of_cheats,
            container, false)
        adapter = CheatsAdapter()

        setupMVP()

        view.locRecyclerView.linearManager()
        view.locRecyclerView.adapter = adapter
        return view
    }

    override fun setupMVP() {
        locPresenter = ListOfCheatsPresenter(this)
    }
    override fun updateListOfCheats(listOfCheats: ArrayList<Cheat>) {
        adapter?.updateListOfCheats(listOfCheats)
        locRecyclerView.adapter = adapter
    }
}