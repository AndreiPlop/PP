class Birth(val year: Int, val Month: Int, val Day: Int){
    override fun toString() : String{
        return "($Day.$Month.$year)"
    }
}

class Contact(val Name: String, val Phone: String, val BirthDate: Birth){
    fun Print() {
        println("Name: $Name, Mobile: $Phone, Date: $BirthDate")
    }
}
fun cautareContact(agenda:MutableList<Contact>,Phone: String)
{
    // agenda.filter{it.Phone==Phone}.forEach({it.Print()})
    for (persoana in agenda)
    {
        if(persoana.Phone==Phone) {
            println("\nPersoana cautata este:")
            persoana.Print()
        }
    }
}
fun deleteContact(agenda:MutableList<Contact>,nume:String)
{
    for (persoana in agenda)
        if(persoana.Name==nume)
        {agenda.remove(persoana)
            break}
}
fun main(args : Array<String>){
    val agenda = mutableListOf<Contact>()


    agenda.add(Contact("Radu", "0753554987", Birth(1976, 1, 30)))
    agenda += Contact("Maria", "0764564100", Birth(2004, 5, 24))
    agenda += Contact("Marius" , "0232476538", Birth(1965, 6, 2))
    agenda += Contact("Andrei", "0740619751", Birth(1953, 5, 3))
    for (persoana in agenda){
        persoana.Print()
    }
    println("\nAgenda dupa eliminare contact [Maria]:")
    agenda.removeAt(1)
    for (persoana in agenda){
        persoana.Print()
    }
    agenda.remove(Contact("Marius" , "0232476538", Birth(1965, 6, 2)))
    println("\nAgenda dupa eliminare contact [Marius]:")
    agenda.removeAt(1)
    for (persoana in agenda){
        persoana.Print()
    }

    cautareContact(agenda,"0740619751")

    println("\nAgenda dupa ce a fost stearsa persoana cautata este:")
    deleteContact(agenda,"Andrei")
    for (persoana in agenda)
    {
        persoana.Print()
    }
}


