package slearn
package classification

import types.{DataSet, Features, Label}

trait Classifier {
  def train(trainingSet: DataSet): Unit
  def predict(features: Features): Label
}
