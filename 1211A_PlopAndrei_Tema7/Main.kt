import java.io.File
import java.sql.Timestamp

fun main(agrs : Array<String>) {

    val text_mutable_list = mutableListOf("")
    File("/var/log/apt/history.log").forEachLine {
        if (it.contains("Start-Date") or it.contains("Commandline")) {
            text_mutable_list.add(it) // adaug doar Start-Date-ul si CommandLine-ul
        }
    }
    text_mutable_list.removeAt(0)
    val new_text_mutable_list = mutableListOf("")
    new_text_mutable_list.removeAt(0)
    for( i in text_mutable_list){
        if (i[0] == 'S') {
            new_text_mutable_list.add(i.substring(12))
        } else {
            new_text_mutable_list.add(i)
        }
    }
    println(new_text_mutable_list)

    var obj1 = HistoryLogRecord(new_text_mutable_list[2],new_text_mutable_list[3])
    var obj2 = HistoryLogRecord(new_text_mutable_list[0],new_text_mutable_list[1])

    println("\nTimestamp-ul primului obiect este: " + obj1.time_stamp)
    println("Timestamp-ul celui de-al 2lea obiect este: " + obj2.time_stamp)
    println("Rezultatul functiei compareTo( >0 -> obj1 > obj2, <0 -> obj1 < obj2, =0 -> obj1 == obj2) este: ")
    if(obj1.compareTo(obj2) > 0) {
        println(">0")
    } else {
        if(obj1.compareTo(obj2) < 0){
            println("<0")
        }
        else{
            println("=0")
        }
    }

    var obj3 = maxim(obj1,obj2)
    println("\nFunctia de maxim: ")
    println("Timestamp-ul primului obiect este: " + obj1.time_stamp)
    println("Timestamp-ul celui de-al 2lea obiect este: " + obj2.time_stamp)
    println("Timestamp-ul celui de-al 3lea obiect, obiectul unde s-a pus maximul timestamp-ului dintre primul si al 2lea obiect este: " + obj3.time_stamp)

    val lungime:Int = new_text_mutable_list.size
    val map_hash: MutableMap<String, String> = hashMapOf(
        Pair(
            new_text_mutable_list[0],
            (new_text_mutable_list[0] + " -> " + new_text_mutable_list[1])
        )
    )

    for( iterator in 2 until lungime step 2) {
        map_hash.put(new_text_mutable_list[iterator], ((new_text_mutable_list[2] + " -> " + new_text_mutable_list[iterator+1])))
    }
    println("\nInainte de functia Find And Replace: ")
    map_hash.forEach {
        println("${it.key},${it.value}")
    }
    println("\nApelul functiei Find And Replace: ")
    var map_hash1: MutableMap<String, String> = findReplace(obj1, obj2, map_hash)

    println("\nRezultatul returnat de functia Find And Replace: ")
    map_hash1.forEach {
        println("${it.key},${it.value}")
    }

}

class HistoryLogRecord(time_stamp: String, commandLine: String): Comparable<HistoryLogRecord>{
    var time_stamp = time_stamp
    var commandLine = commandLine

    override fun compareTo(other: HistoryLogRecord): Int {
        val time_stamp_1 = time_stamp
        val time_stamp_2 = other.time_stamp

        val an1 = time_stamp_1.substring(1,3).toInt() * 777600000
        val an2 = time_stamp_2.substring(1,3).toInt() * 777600000

        val luna1 = time_stamp_1.substring(4,6).toInt() * 12960000
        val luna2 = time_stamp_2.substring(4,6).toInt() * 12960000

        val zi1 = time_stamp_1.substring(7,10).toInt() * 216000
        val zi2 = time_stamp_2.substring(7,10).toInt() * 216000

        val ora1 = time_stamp_1.substring(11,12).toInt() * 3600
        val ora2 = time_stamp_2.substring(11,12).toInt() * 3600

        val min1 = time_stamp_1.substring(13,15).toInt() * 60
        val min2 = time_stamp_2.substring(13,19).toInt() * 60

        val sec1 = time_stamp_1.substring(19,20).toInt()
        val sec2 = time_stamp_2.substring(19,20).toInt()

        val timpSec1 = sec1 + min1 + ora1 + zi1 + luna1 + an1
        val timpSec2 = sec2 + min2 + ora2 + zi2 + luna2 + an2

        if(timpSec1 > timpSec2){
            return 1
        } else {
            if(timpSec1 < timpSec2) {
                return -1
            } else {
                return 0
            }
        }
    }
}

fun <T: Comparable<T>>maxim(first: T, second: T) : T {
    var k = first.compareTo(second)
    if (k >= 0 ){

        return first
    }
    else {
        return second
    }
}

fun <T>findReplace(obj1: HistoryLogRecord, obj2: HistoryLogRecord, obj3: MutableMap<String, out T>) : MutableMap<String, T> {
    val filter = obj3.toMutableMap()
    if (obj3.containsKey(obj1.time_stamp)) {
        val a = obj3.remove(obj1.time_stamp)
        filter.put(obj2.time_stamp, a!!)
        filter.forEach {
            println("${it.key},${it.value}")
        }
    }
    return filter
}