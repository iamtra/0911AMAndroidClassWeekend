package com.pheaktra.developer.base.core

import androidx.lifecycle.ViewModel

interface BaseViewModelInterface {
    fun onLoad()
}

open class BaseViewModel : ViewModel(), BaseViewModelInterface {
    override fun onLoad() {

    }
}