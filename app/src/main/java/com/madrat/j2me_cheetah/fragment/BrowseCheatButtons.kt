package com.madrat.j2me_cheetah.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.madrat.j2me_cheetah.R
import kotlinx.android.synthetic.main.buttons_bc.*

class BrowseCheatButtons: Fragment() {
    companion object {
        val instance = BrowseCheatButtons()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        bcShare.setOnClickListener {
            Log.d("", "HAHAHAHHA")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.buttons_bc, container, false)
        return view
    }
}