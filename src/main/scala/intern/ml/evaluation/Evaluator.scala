package intern.ml
package evaluation

import types.Label

trait Evaluator {
  def add(predicted: Label, supervised: Label): Unit
  def accuracy: Double
}
