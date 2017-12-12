package jp.sujoyu.atsumaru

import createjs._
import org.scalajs.dom
import dom.document
import org.scalajs.dom.raw.HTMLCanvasElement

object AtsumaruTutorial {

  def main(args: Array[String]): Unit = {
    document.addEventListener("DOMContentLoaded", (_: dom.Event) => onLoad())
  }

  def onLoad(): Unit = {
    val canvas = document.getElementById("game-canvas")
      .asInstanceOf[HTMLCanvasElement]

    val stage = new StageGL(canvas)
    Touch.enable(stage)
    stage.setClearColor("#eeeeee")

    val game = Game(stage, canvas.width, canvas.height)
    val layer = new PressMoveLayer(game)

    onResize(stage, layer)
    dom.window.addEventListener("resize", (_: Event) => {
      onResize(stage, layer)
    })

    Ticker.on("tick", (ev: Object) => {
      val event = ev.asInstanceOf[Event]

      // メインループ的な
      game.render(event.delta)

      stage.update()
      true
    })
  }

  def onResize(stage: StageGL, layer: PressMoveLayer): Unit = {
    val displayWidth  = stage.canvas.clientWidth
    val displayHeight = stage.canvas.clientHeight

    stage.canvas.width  = displayWidth
    stage.canvas.height = displayHeight

    layer.container.hitArea.scaleX = displayWidth
    layer.container.hitArea.scaleY = displayHeight

    stage.updateViewport(stage.canvas.width, stage.canvas.height)
  }

}
