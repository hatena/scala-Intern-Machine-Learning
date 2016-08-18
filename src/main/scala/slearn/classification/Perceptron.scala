package slearn
package classification

import types.{DataSet, Features, Label}

class Perceptron extends Classifier {
  // 必要なフィールドがあれば適宜足すこと

  def train(trainingSet: DataSet): Unit = {
    // ここに学習アルゴリズムを実装
  }

  def predict(features: Features): Label = {
    // ここを変更して判別アルゴリズムを実装
    Label.Positive
  }
}
