package slearn
package classification

import types.{Features, Label, TrainingSet}

class Perceptron extends Classifier {
  def train(trainingSet: TrainingSet): Unit = {
    // ここに学習アルゴリズムを実装
  }

  def predict(features: Features): Label = {
    // ここを変更して判別アルゴリズムを実装
    Label.Positive
  }
}
