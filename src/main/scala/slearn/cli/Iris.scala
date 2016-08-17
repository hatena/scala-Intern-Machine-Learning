package slearn
package cli

import types.{Features, Label}

class Iris extends CLI.Command {
  private def labelOf(label: String): Label =
    if (label == "Iris-setosa") Label.Positive
    else Label.Negative

  private def withCSV[T](fileName: String)(
    block: Iterator[Seq[String]] => T
  ): T = {
    val source = io.Source.fromFile(fileName)
    try {
      block(source.getLines.filter(_.nonEmpty).map(_.split(",").toSeq))
    } finally source.close
  }

  private def withDataSet[T](fileName: String)(
    block: Iterator[(Features, Label)] => T
  ): T = withCSV(fileName)(lines => block(lines.map { fields =>
    (fields.dropRight(1).map(_.toDouble), labelOf(fields.last))
  }))

  def showHelp(): Unit = {
    println(s"${name} <training data set> <test data set>")
  }

  def run(args: String*): Unit = {
    if (args.size < 2) {
      showHelp
      return
    }
    val Seq(trainingSet, tests) = args

    val classifier = new classification.Perceptron
    withDataSet(trainingSet) { it =>
      val trainingSet = it.toSeq
      classifier.train(trainingSet)
    }

    val evaluator = new evaluation.F1
    withDataSet(tests)(_.foreach { case (features, supervised) =>
      val predicted = classifier.predict(features)
      evaluator.add(predicted, supervised)
    })

    println(evaluator.accuracy)
  }
}
