data class AndGate3(override var bridge: BridgeDecuplare?): AndGate(bridge) {
    private var entry1: Boolean=false
    private var entry2: Boolean=false
    private var entry3: Boolean=false
    fun e1(e1: Boolean)=apply{this.entry1=e1}
    fun e2(e2: Boolean)=apply{this.entry2=e2}
    fun e3(e3: Boolean)=apply{this.entry3=e3}
    override fun construiestePoarta() {
        print("Poarta AND cu 3 intrari: ")
        bridge?.rezultatCreare()
        println("\nRezultat pentru poarta cu 3 intrari: " + ((entry1.and(this.entry2)).and(this.entry3)))
    }
}
