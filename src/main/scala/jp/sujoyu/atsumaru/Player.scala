package jp.sujoyu.atsumaru

import createjs.{Container, MouseEvent, Text}


class Player(game: Game, var x: Double, var y: Double) extends GameObject() {

  private val container = new Container

  container.setTransform(x, y)

  container.addChild({
    val text = new Text("  ^\n/[_]\\", "30px Arial", "black")
    val width = text.getMeasuredWidth()
    val height = text.getMeasuredHeight()
    text.setTransform(-width / 2, -height / 2)
    text.cache(-width / 2, -height / 2, width, height)
    text
  })

  game.stage.addChild(container)

  private var startDragX: Option[Double] = None
  private var startDragY: Option[Double] = None
  private var mouseDownX: Option[Double] = None
  private var mouseDownY: Option[Double] = None

  def render(delta: Double): Unit = {
    container.setTransform(x, y)
  }

  def onMouseDown(event: MouseEvent): Unit = {
    startDragX = Some(x)
    startDragY = Some(y)
    mouseDownX = Some(event.stageX)
    mouseDownY = Some(event.stageY)
  }

  def onPressMove(event: MouseEvent): Unit = {
    for {
      startX <- startDragX
      startY <- startDragY
      downX <- mouseDownX
      downY <- mouseDownY
    } {
      x = startX + event.stageX - downX
      y = startY + event.stageY - downY
    }
  }

  def onPressUp(event: MouseEvent): Unit = {
    startDragX = None
    startDragY = None
    mouseDownX = None
    mouseDownY = None
  }

}
