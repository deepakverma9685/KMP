package org.kmp.project

import android.app.Application
import di.initKoin

class TestApp :Application(){
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}