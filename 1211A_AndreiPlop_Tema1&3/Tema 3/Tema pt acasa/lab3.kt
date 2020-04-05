import java.io.File

fun main(args: Array<String>)
{
    val In=File("in.txt").readLines()
    val Out=File("out.txt").writer()

    for( k in In) {
        if ("\\s{2,}\\d+\\s{2,}".toRegex().matches(k))
            continue
        if (k.isBlank())
            continue
        var a = "\\s{2,}".toRegex().replace(k, " ")
        a = "^\\s".toRegex().replace(a, "")
        Out.write(a)
        Out.write("\n")
    }
    Out.close()
}