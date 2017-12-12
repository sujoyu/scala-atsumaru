package jp.sujoyu.atsumaru

import createjs.{Container, Text}

class PlayerBullet(game: Game, var x: Double, var y: Double) extends GameObject() {

  val container = new Container
  container.setTransform(x, y)

  container.addChild({
    val text = new Text("^", "20px Arial", "black")
    val width = 20
    val height = 20
    text.setTransform(-width / 2, -height / 2)
    text.cache(-width / 2, -height / 2, width, height)
    text
  })

  game.stage.addChild(container)
  game.gameObjects += this

  private val hitSize = 15

  override def render(timeDelta: Double): Unit = {
    y -= 300 * timeDelta / 1000
    container.setTransform(x, y)

    if (y < 0) {
      destroy()
    }

    game.enemies.forall { enemy =>
      if (Math.abs(enemy.x - x) < hitSize && Math.abs(enemy.y - y) < hitSize) {
        enemy.destroy()
        destroy()
        false
      } else {
        true
      }
    }
  }

  def destroy(): Unit = {
    game.gameObjects -= this
    game.stage.removeChild(container)
  }

}
