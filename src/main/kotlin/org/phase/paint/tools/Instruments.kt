package org.phase.paint.tools

import javafx.event.EventHandler
import javafx.geometry.Pos
import javafx.scene.control.ColorPicker
import javafx.scene.control.Label
import javafx.scene.control.Slider
import javafx.scene.control.ToggleButton
import javafx.scene.paint.Color

import org.phase.paint.window.Paint

interface PaintObject {
    fun build()
}

class ColorPicker : ColorPicker(Color.BLACK), PaintObject {
    override fun build() {
        onAction = EventHandler {
            Paint.context.fill = value
        }
    }
}

class Pen : ToggleButton("Ручка"), PaintObject {
    override fun build() {

    }
}

class Rubber : ToggleButton("Ластик"), PaintObject {
    override fun build() {
    }
}

class SizeSlider : Slider(), PaintObject {
    override fun build() {
        valueProperty().addListener { _ ->
            Tools.sizeSliderBar.text = String.format("%.1f", value)
            Paint.context.lineWidth = value
        }
    }
}

class SizeSliderBar : Label("3,0"), PaintObject {
    override fun build() {
        alignment = Pos.TOP_CENTER
    }
}
