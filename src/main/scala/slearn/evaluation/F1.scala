package slearn
package evaluation

import types.Label

class F1 extends Evaluator {
  // 必要なフィールドがあれば適宜足すこと

  def add(predicted: Label, supervised: Label): Unit = {
    // ここでtrue/false positive/negativeを集計
  }

  def accuracy: Double = {
    // ここを変更してF1スコアを計算
    1.0
  }
}
