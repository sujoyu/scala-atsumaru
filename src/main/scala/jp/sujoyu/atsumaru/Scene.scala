package jp.sujoyu.atsumaru

sealed abstract class Scene(name: String, next: Scene)

object Scene {

  object Title extends Scene("title", Battle)

  object Battle extends Scene("battle", Result)

  object Result extends Scene("result", Title)

}