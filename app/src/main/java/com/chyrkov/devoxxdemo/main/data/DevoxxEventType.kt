package com.chyrkov.devoxxdemo.main.data

import com.chyrkov.devoxxdemo.R

enum class DevoxxEventType(val type: String?) {

    METHODOLOGY("methodology"),
    CLOUD("cloud"),
    SERVER("server"),
    ML("ml"),
    BIGDATA("bigdata"),
    JVM("JVM"),
    MOBILE("mobile"),
    ARCHITECTURE("architecture"),
    WEB("web"),
    UNDEFINED(null);

    fun colorResource(): Int {
        return when (this) {
            METHODOLOGY -> R.color.methodology
            CLOUD -> R.color.cloud
            SERVER -> R.color.server
            ML -> R.color.ml
            BIGDATA -> R.color.bigdata
            JVM -> R.color.jvm
            MOBILE -> R.color.mobile
            ARCHITECTURE -> R.color.architecture
            WEB -> R.color.web
            UNDEFINED -> R.color.undefined
        }
    }
}