package intern.ml
package cli

class Iris extends CLI.Command with CLI.DataLoader {
  final val TargetLabel = "Iris-setosa"
  final val Iteration = 1

  def targetLabel = TargetLabel

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
    val evalTest = new evaluation.F1

    withDataSet(trainingSet) { it =>
      val trainingSet = it.toSeq.take(n)
      1 to Iteration foreach { _ =>
        classifier.train(trainingSet)
      }

      evaluate(classifier, trainingSet.iterator, evalTraining)
    }

    withDataSet(tests) { testSet =>
      evaluate(classifier, testSet, evalTest)
    }

    println(Seq(evalTraining.accuracy, evalTest.accuracy).mkString(" "))
  }

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
