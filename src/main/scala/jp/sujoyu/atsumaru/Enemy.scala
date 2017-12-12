package jp.sujoyu.atsumaru

import createjs.{Container, Text}

class Enemy(game: Game, var x: Double, var y: Double, player: Player) extends GameObject() {

  val container = new Container
  container.setTransform(x, y)

  container.addChild({
    val text = new Text("<*>", "15px Arial", "red")
    val width = 50
    val height = 30
    text.setTransform(-width / 2, -height / 2)
    text.cache(-width / 2, -height / 2, width, height)
    text
  })

  game.stage.addChild(container)
  game.gameObjects += this
  game.enemies += this

  private val dx = player.x - x
  private val dy = player.y - y

  override def render(timeDelta: Double): Unit = {
    x += timeDelta / 1000 * dx / 2
    y += timeDelta / 1000 * dy

    container.setTransform(x, y)

    if (y > game.stage.canvas.height) {
      destroy()
    }
  }

  def destroy(): Unit = {
    game.enemies -= this
    game.gameObjects -= this
    game.stage.removeChild(container)
  }

}
