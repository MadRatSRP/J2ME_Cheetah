package com.madrat.j2me_cheetah.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.madrat.j2me_cheetah.R
import kotlinx.android.synthetic.main.view_browse_cheat.view.*

class BrowseCheatView: Fragment() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.view_browse_cheat,
            container, false)

        val cheatArguments = arguments?.let { BrowseCheatViewArgs.fromBundle(it) }
        view.bcTitle.text = cheatArguments?.title
        view.bcDescription.text = cheatArguments?.description
        return view
    }
}