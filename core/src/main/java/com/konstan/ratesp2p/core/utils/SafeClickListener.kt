package com.konstan.ratesp2p.core.utils

import android.os.SystemClock
import android.view.View

class SafeClickListener(
    private var defaultInterval: Int = 1000,
    private val onSafeClick: (View) -> Unit
) : View.OnClickListener {

    private var lastTimeClicked: Long = 0

    /**
     * Действие при нажатии
     */
    override fun onClick(v: View) {
        if (SystemClock.elapsedRealtime() - lastTimeClicked < defaultInterval) {
            return
        }
        lastTimeClicked = SystemClock.elapsedRealtime()
        onSafeClick(v)
    }
}