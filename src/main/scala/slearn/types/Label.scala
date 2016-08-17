package slearn
package types

sealed abstract class Label(value: Int) {
  def toInt(): Int = value
}
object Label {
  case object Positive extends Label(1)
  case object Negative extends Label(-1)
}
