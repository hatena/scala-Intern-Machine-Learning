package intern.ml
package types

sealed abstract class Label private (value: Int) {
  def toInt(): Int = value
  def positive: Boolean = value > 0
  def negative: Boolean = value < 0
}
object Label {
  case object Positive extends Label(1)
  case object Negative extends Label(-1)
}
