package com.madrat.j2me_cheetah.model

import android.text.Spannable
import android.text.SpannableString

data class SpannableCheat(
    val title: Spannable,
    val description: String) {
    constructor(title: String, description: String)
            : this(SpannableString(title), description)
}