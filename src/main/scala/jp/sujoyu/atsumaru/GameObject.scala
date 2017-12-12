package jp.sujoyu.atsumaru

import createjs.{DisplayObject, Event}

abstract class GameObject() {

  def render(timeDelta: Double): Unit

}
