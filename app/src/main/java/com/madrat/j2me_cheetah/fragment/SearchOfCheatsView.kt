package com.madrat.j2me_cheetah.fragment

import android.os.Bundle
import android.text.Editable
import android.text.Spannable
import android.text.TextWatcher
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.madrat.j2me_cheetah.R
import com.madrat.j2me_cheetah.adapter.SpannableCheatsAdapter
import com.madrat.j2me_cheetah.interfaces.SearchOfCheatsMVP
import com.madrat.j2me_cheetah.model.SpannableCheat
import com.madrat.j2me_cheetah.presenter.SearchOfCheatsPresenter
import com.madrat.j2me_cheetah.util.linearManager
import kotlinx.android.synthetic.main.view_search_of_cheats.*
import kotlinx.android.synthetic.main.view_search_of_cheats.view.*

class SearchOfCheatsView
    : Fragment(), SearchOfCheatsMVP.View {
    private var adapter: SpannableCheatsAdapter? = null
    private var presenter: SearchOfCheatsPresenter? = null

    private val spanHighlight by lazy {
        ForegroundColorSpan(
            ResourcesCompat.getColor(resources, R.color.colorAccent, null)
        )
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        context?.let { presenter?.updateAndShowListOfCheats(it) }

        socSearchBar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int,
                                           count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int,
                                       before: Int, count: Int) {
                updateSearch()
                highlight()
            }
        })
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.view_search_of_cheats,
            container, false)
        adapter = SpannableCheatsAdapter()

        setupMVP()

        view.socRecyclerView.linearManager()
        view.socRecyclerView.adapter = adapter
        return view
    }

    override fun setupMVP() {
        presenter = SearchOfCheatsPresenter(this)
    }
    override fun updateListOfCheats(listOfCheats: ArrayList<SpannableCheat>) {
        adapter?.updateSpannableListOfCheats(listOfCheats)
        socRecyclerView.adapter = adapter
    }
    private fun updateSearch() {
        val cheatName = socSearchBar.text

        if (cheatName?.length == 0) {
            presenter?.showListOfCheats()
        } else {
            presenter?.searchForCheatAndUpdateListOfCheats(cheatName.toString())
        }
    }
    private fun highlight() {
        val cheatName = socSearchBar.text
        adapter?.returnListOfCheats()?.forEach { cheat ->
            cheat.title.getSpans(0, cheat.title.length, ForegroundColorSpan::class.java).forEach {
                cheat.title.removeSpan(it)
            }
            if (cheat.title.contains(cheatName, true)) {
                val index = cheat.title.toString().indexOf(cheatName.toString(), 0, true)
                cheat.title.setSpan(spanHighlight, index, index + cheatName.length, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            }
        }
    }
}