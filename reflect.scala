import scala.reflect.runtime.{universe => ru}

object MacroUsageMain {
  def main(args: Array[String]): Unit = {


    val tpe: ru.Mirror = ru.runtimeMirror(getClass.getClassLoader)


    val x = tpe.typeOf[B].decls.foreach {
      symbol: ru.Symbol =>

        symbol match {
          case sbl: ru.TermSymbol if !sbl.isMethod =>

            val term: ru.TermSymbol = tpe.typeOf[B].decl(ru.TermName(sbl.name.toString)).asTerm
            val value = tpe.reflect(new B).reflectField(term).get

            println(value)

          case _ =>
        }

    }


  }

}


class B {
  type a = String
  val y = "Lol"
  val u = {
    "Hi;" +
      "Hello"
  }

  def z() = 12

}

