package slearn

object Main {
  val commands = cli.CLI.fromNamespace("slearn.cli")

  def showHelp(): Unit =
    println(s"Commands:\n ${commands.list.map(_.name).mkString("\n ")}")

  def main(args: Array[String]): Unit = {
    if (args.isEmpty) {
      showHelp
      return
    }

    try commands.run(args.head, args.tail) catch {
      case e: cli.CLI.Command.NotFound => showHelp
    }
  }
}
