package jp.sujoyu.atsumaru

import createjs.{MouseEvent, Stage}

import scala.collection.mutable
import scala.util.Random

case class Game(stage: Stage, width: Int, height: Int) {

  val gameObjects: mutable.ArrayBuffer[GameObject] = mutable.ArrayBuffer.empty

  val enemies: mutable.ArrayBuffer[Enemy] = mutable.ArrayBuffer.empty

  val player = new Player(this, width / 2, height - 30)

  def render(timeDelta: Double): Unit = {
    if (Random.nextDouble() > 0.95) {
      new Enemy(this, Random.nextDouble() * stage.canvas.width, 0, player)
    }

    gameObjects.clone().foreach(_.render(timeDelta))
  }

  def onMouseDown(event: MouseEvent): Unit = {
    player.onMouseDown(event)
  }


  def onPressMove(event: MouseEvent): Unit = {
    player.onPressMove(event)
  }

  def onPressUp(event: MouseEvent): Unit = {
    player.onPressUp(event)
  }

}
