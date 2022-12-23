package org.phase.paint.events

import java.util.Stack

class History<T>(val length: Int = 64) : Stack<T>() {
    private fun checkLength() {
        if (super.size > length) {
            super.removeAt(0)
        }
    }

    override fun add(element: T): Boolean {
        checkLength()
        return super.add(element)
    }
}
