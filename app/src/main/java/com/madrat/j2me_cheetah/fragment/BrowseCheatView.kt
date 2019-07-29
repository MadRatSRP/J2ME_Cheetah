package com.madrat.j2me_cheetah.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.madrat.j2me_cheetah.R
import com.madrat.j2me_cheetah.activity.AppActivity
import kotlinx.android.synthetic.main.view_browse_cheat.view.*

class BrowseCheatView: Fragment() {
    private var bcElementsLayout: View? = null

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        /*bcElementsLayout = View.inflate(context, R.layout.elements_bc, null)

        val bcShare: ImageButton? = bcElementsLayout?.findViewById(R.id.bcShare)

        bcElementsLayout?.let { (activity as AppActivity).addCustomViewForToolbar(it) }

        bcShare?.setOnClickListener {
            Log.d("", "HAHAHAHHA")
        }*/
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
        //bcElementsLayout?.let { (activity as AppActivity).removeCustomViewFromToolbar(it) }

        bcElementsLayout = null
        super.onDestroyView()
    }
}