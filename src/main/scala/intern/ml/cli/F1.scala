package intern.ml
package cli

import types.Label.{Positive, Negative}

class F1 extends CLI.Command {
  def run(args: String*): Unit = {
    val eval = new evaluation.F1
    DataSet.foreach { case (predicted, supervised) =>
      eval.add(predicted, supervised)
    }
    println(eval.accuracy)
  }

  private final val DataSet = Seq(
    (Positive, Positive),
    (Negative, Positive),
    (Positive, Positive),
    (Negative, Positive),
    (Positive, Negative),
    (Positive, Positive),
    (Positive, Negative),
    (Negative, Negative),
    (Negative, Positive)
  )
}
