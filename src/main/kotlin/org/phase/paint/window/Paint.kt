package org.phase.paint.window

import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.canvas.Canvas
import javafx.scene.canvas.GraphicsContext
import javafx.scene.layout.VBox

import org.phase.paint.tools.Tools

class Paint {
    companion object {
        @JvmStatic val canvas = Canvas(1080.0, 790.0)
        @JvmStatic val context: GraphicsContext = canvas.graphicsContext2D
        @JvmStatic lateinit var oldContext: GraphicsContext

        @JvmStatic fun copyContext() {
            oldContext = context
        }
    }
}

fun buildPane(): VBox {
    val leftPane = VBox(10.0)

    leftPane.padding = Insets(5.0)
    leftPane.style = "-fx-background-color: #999"
    leftPane.prefWidth = 110.0

    Tools.buildAllTools()
    leftPane.children.addAll(
        Tools.array.map { tool -> tool as Node }
    )

    return leftPane
}
