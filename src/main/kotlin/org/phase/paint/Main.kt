package org.phase.paint

import javafx.application.Application
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.scene.layout.BorderPane
import javafx.stage.Stage

import org.phase.paint.events.setUpAllListeners
import org.phase.paint.window.buildPane
import org.phase.paint.window.Paint

class Main : Application() {
    private fun buildApp() {
        setUpAllListeners()
    }

    private fun loadScene(): Scene {
        val pane = BorderPane()

        pane.left = buildPane()
        pane.center = Paint.canvas

        return Scene(pane, 1200.0, 800.0)
    }

    override fun start(stage: Stage) {
        buildApp()

        stage.title = "Phase Paint"
        stage.scene = loadScene()
        stage.icons.add(Image("file:assets/app.png"))

        stage.show()
    }
}

fun main() {
    Application.launch(Main::class.java)
}
