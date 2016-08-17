package slearn
package evaluation

import types.{Accuracy, Label}

trait Evaluator {
  def add(predicted: Label, supervised: Label): Unit
  def accuracy: Accuracy
}
