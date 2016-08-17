package slearn
package classification

import types.{Features, Label, TrainingSet}

trait Classifier {
  def train(trainingSet: TrainingSet): Unit
  def predict(features: Features): Label
}
