package slearn
package cli

import types.{Features, Label}

class Iris extends CLI.Command {
  final val TargetLabel = "Iris-setosa"
  final val Iteration = 1

  def showHelp(): Unit = {
    println(s"${name} <training data set> <test data set> [<size>]")
  }

  def run(args: String*): Unit = {
    if (args.size < 2) {
      showHelp
      return
    }
    val Seq(trainingSet, tests, _*) = args
    val n = args.lift(2).map(_.toInt).getOrElse(Int.MaxValue)

    val classifier = new classification.Perceptron
    val evalTraining = new evaluation.F1
    withDataSet(trainingSet) { it =>
      val trainingSet = it.toSeq.take(n)
      1 to Iteration foreach { _ =>
        classifier.train(trainingSet)
      }

      evaluate(classifier, trainingSet.iterator, evalTraining)
    }

    val evalTest = new evaluation.F1
    withDataSet(tests) { testSet =>
      evaluate(classifier, testSet, evalTest)
    }

    println(Seq(evalTraining.accuracy, evalTest.accuracy).mkString(" "))
  }

  type Input = Iterator[(Features, Label)]

  private def labelOf(label: String): Label =
    if (label == TargetLabel) Label.Positive
    else Label.Negative

  private def withCSV[T](fileName: String)(
    block: Iterator[Seq[String]] => T
  ): T = {
    val source = io.Source.fromFile(fileName)
    try {
      block(source.getLines.filter(_.nonEmpty).map(_.split(",").toSeq))
    } finally source.close
  }

  private def withDataSet[T](fileName: String)(block: Input => T): T =
    withCSV(fileName)(lines => block(lines.map { fields =>
      (fields.dropRight(1).map(_.toDouble), labelOf(fields.last))
    }))

  private def evaluate(
    classifier: classification.Classifier,
    data: Input,
    evaluator: evaluation.Evaluator
  ): Unit = {
    data.foreach { case (features, supervised) =>
      val predicted = classifier.predict(features)
      evaluator.add(predicted, supervised)
    }
  }
}
