package com.madrat.j2me_cheetah.interfaces

import android.view.View

interface AppMVP {
    interface View {

        fun setupMVP()
        fun setupActivity()
        fun addCustomViewForToolbar(customView: android.view.View)
        fun removeCustomViewFromToolbar(customView: android.view.View)
    }
    interface Presenter {

    }
}