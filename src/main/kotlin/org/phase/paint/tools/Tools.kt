package org.phase.paint.tools

import javafx.scene.Cursor
import javafx.scene.control.ToggleButton
import javafx.scene.control.ToggleGroup

class Tools {
    companion object {
        @JvmStatic private val tools = ToggleGroup()

        @JvmStatic val pen = Pen()
        @JvmStatic val rubber = Rubber()
        @JvmStatic val colorPicker = ColorPicker()
        @JvmStatic val sizeSlider = SizeSlider()
        @JvmStatic val sizeSliderBar = SizeSliderBar()
        @JvmStatic val array = arrayOf<PaintObject>(
            pen,
            rubber,
            colorPicker,
            sizeSlider,
            sizeSliderBar
        )

        @JvmStatic fun buildAllTools() {
            for (button in array) {
                button.build()

                if (button is ToggleButton) {
                    button.minWidth = 110.0
                    button.toggleGroup = tools
                    button.cursor = Cursor.HAND
                    button.style = "-fx-background-radius: 5"
                }
            }
        }
    }
}
