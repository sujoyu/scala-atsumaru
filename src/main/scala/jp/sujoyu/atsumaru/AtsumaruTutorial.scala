package jp.sujoyu.atsumaru

import createjs._
import org.scalajs.dom
import org.scalajs.dom.raw.HTMLCanvasElement

object AtsumaruTutorial {

  def main(): Unit = {
    dom.window.addEventListener("DOMContentLoaded", (_: dom.Event) => onLoad())
  }

  def onLoad(): Unit = {
    val canvas = dom.document.getElementById("game-canvas")
      .asInstanceOf[HTMLCanvasElement]

    val stage = new StageGL(canvas)
    Touch.enable(stage)
    stage.setClearColor("#eeeeee")

    val game = Game(stage, canvas.width, canvas.height)

    Ticker.on("tick", (ev: Object) => {
      val event = ev.asInstanceOf[Event]

      // メインループ的な
      game.render(event.delta)

      true
    })
  }

}
