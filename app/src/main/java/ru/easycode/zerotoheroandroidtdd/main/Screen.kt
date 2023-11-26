package ru.easycode.zerotoheroandroidtdd.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


interface Screen {
    fun show(supportFragmentManager: FragmentManager, containerId: Int)

    abstract class Replace(private val fragmentClass: Class<out Fragment>): Screen {
        supportFragmentManager.beginTransaction()
            .replace(containerId, fragmentClass.getDeclaredConstructor().newInsance())
            .commit
    }
}
