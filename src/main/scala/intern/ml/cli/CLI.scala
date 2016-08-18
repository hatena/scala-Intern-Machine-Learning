package intern.ml
package cli

import org.reflections.Reflections
import scala.collection.JavaConverters._

class CLI(commands: CLI.Map) {
  def list: Seq[CLI.Command] = commands.values.toSeq.sortBy(_.name)
  def run(name: String, args: Seq[String]): Unit = {
    commands.get(CLI.normalize(name)).getOrElse {
      throw new CLI.Command.NotFound(s"Command not found: $name")
    }.run(args: _*)
  }
}

object CLI {
  trait Command {
    def run(args: String*): Unit
    def name: String =
      CLI.normalize(".*[.]".r.replaceAllIn(getClass.getName, ""))
  }
  object Command {
    final class NotFound(msg: String) extends Error(msg)
  }

  type Map = scala.collection.Map[String, Command]

  def normalize(name: String): String =
    name.take(1).toLowerCase + "[A-Z\\d]".r.replaceAllIn(name.drop(1), { m =>
      "-" + m.group(0).toLowerCase
    })

  def fromNamespace(ns: String): CLI = {
    val reflections = new Reflections(ns)
    val classes = reflections.getSubTypesOf(classOf[Command]).asScala.toSet
    new CLI(classes.map(_.newInstance.asInstanceOf[Command]).map { cmd =>
      cmd.name -> cmd
    }.toMap)
  }
}
