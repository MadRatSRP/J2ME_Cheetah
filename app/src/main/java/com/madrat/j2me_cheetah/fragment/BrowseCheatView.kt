package com.madrat.j2me_cheetah.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.madrat.j2me_cheetah.R
import com.madrat.j2me_cheetah.util.addFragment
import com.madrat.j2me_cheetah.util.removeFragment
import kotlinx.android.synthetic.main.view_browse_cheat.view.*

class BrowseCheatView: Fragment() {
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        //(activity as AppCompatActivity).addFragment(BrowseCheatButtons.instance, R.id.additionalElementContainer)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val cheatArguments = arguments?.let { BrowseCheatViewArgs.fromBundle(it) }
        val view = inflater.inflate(R.layout.view_browse_cheat, container, false)

        view.bcTitle.text = cheatArguments?.title
        view.bcDescription.text = cheatArguments?.description
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        //(activity as AppCompatActivity).removeFragment(BrowseCheatButtons.instance)
    }
}