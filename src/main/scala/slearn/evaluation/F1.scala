package slearn
package evaluation

import types.{Accuracy, Label}

class F1 extends Evaluator {
  def add(predicted: Label, supervised: Label): Unit = {
    // ここを変更してtrue/false positive/negativeを集計
  }

  def accuracy: Accuracy = {
    // ここを変更してF1スコアを計算
    1.0
  }
}
