package jp.sujoyu.atsumaru

import createjs.{Container, MouseEvent, Shape}

class PressMoveLayer(game: Game) {

  val container = new Container

  container.hitArea = {
    val rect = new Shape
    rect.graphics.beginFill("#000000").drawRect(0, 0, game.width, game.height)
    rect
  }

  container.on("mousedown", (ev: Object) => {
    game.onMouseDown(ev.asInstanceOf[MouseEvent])
    true
  })
  container.on("pressmove", (ev: Object) => {
    game.onPressMove(ev.asInstanceOf[MouseEvent])
    true
  })
  container.on("pressup", (ev: Object) => {
    game.onPressUp(ev.asInstanceOf[MouseEvent])
    true
  })

  game.stage.addChild(container)
}
