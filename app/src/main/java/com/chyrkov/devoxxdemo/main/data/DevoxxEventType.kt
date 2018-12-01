package com.chyrkov.devoxxdemo.main.data

enum class DevoxxEventType(val type: String?) {

    MISC("misc"),
    LECTURE("lecture"),
    UNDEFINED(null);

    companion object {

        fun fromString(name: String?): DevoxxEventType {
            if (name == null) {
                return DevoxxEventType.UNDEFINED
            }
            for (value in DevoxxEventType.values()) {
                if (value.type == name) {
                    return value
                }
            }
            return DevoxxEventType.UNDEFINED
        }
    }
}