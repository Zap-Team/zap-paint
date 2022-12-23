package org.phase.paint.events

import javafx.event.EventHandler
import javafx.scene.input.MouseEvent

import org.phase.paint.window.Paint
import org.phase.paint.tools.Tools

private fun listenMousePressed() {
    val lineWidth = Paint.context.lineWidth

    Paint.canvas.onMousePressed = EventHandler { event: MouseEvent ->
        if (Tools.pen.isSelected) {
            Paint.context.fillRect(
                event.x - lineWidth / 2,
                event.y - lineWidth / 2,
                lineWidth,
                lineWidth,
            )
        } else if (Tools.rubber.isSelected) {
            Paint.context.clearRect(
                event.x - lineWidth / 2,
                event.y - lineWidth / 2,
                lineWidth,
                lineWidth
            )
        }
    }
}

private fun listenMouseDragged() {
    Paint.canvas.onMouseDragged = EventHandler { event: MouseEvent ->
        val lineWidth = Paint.context.lineWidth

        if (Tools.pen.isSelected) {
            Paint.context.fillRect(
                event.x - lineWidth / 2,
                event.y - lineWidth / 2,
                lineWidth,
                lineWidth,
            )
        } else if (Tools.rubber.isSelected) {
            Paint.context.clearRect(
                event.x - lineWidth / 2,
                event.y - lineWidth / 2,
                lineWidth,
                lineWidth
            )
        }
    }
}

private fun listenMouseRealised() {
    Paint.canvas.onMouseReleased = EventHandler { event: MouseEvent ->
        val lineWidth = Paint.context.lineWidth

        if (Tools.pen.isSelected) {
            Paint.context.fillRect(
                event.x - lineWidth / 2,
                event.y - lineWidth / 2,
                lineWidth,
                lineWidth
            )
        } else if (Tools.rubber.isSelected) {
            Paint.context.clearRect(
                event.x - lineWidth / 2,
                event.y - lineWidth / 2,
                lineWidth,
                lineWidth
            )
        }
    }
}

fun setUpAllListeners() {
    listenMousePressed()
    listenMouseDragged()
    listenMouseRealised()
}
