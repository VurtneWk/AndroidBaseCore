package com.vurtnewk.core

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy

/**
 * createTime:  2024/12/26 23:55
 * author:      vurtnewk
 * description: BaseApplication
 */
open class BaseApplication: Application() {


    var logTag : String = "vTag"


    override fun onCreate() {
        super.onCreate()
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)  // (Optional) Whether to show thread info or not. Default true
            .methodCount(0)         // (Optional) How many method line to show. Default 2
            .methodOffset(7)        // (Optional) Hides internal method calls up to offset. Default 5
            .tag(logTag)   // (Optional) Global tag for every log. Default PRETTY_LOGGER
            .build()
        Logger.addLogAdapter(AndroidLogAdapter(formatStrategy))
    }

}