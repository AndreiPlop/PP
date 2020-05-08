data class AndGate4(override var bridge: BridgeDecuplare?): AndGate(bridge) {
    private var entry1: Boolean=false
    private var entry2: Boolean=false
    private var entry3: Boolean=false
    private var entry4: Boolean=false
    fun e1(e1: Boolean)=apply{this.entry1=e1}
    fun e2(e2: Boolean)=apply{this.entry2=e2}
    fun e3(e3: Boolean)=apply{this.entry3=e3}
    fun e4(e4: Boolean)=apply{this.entry4=e4}
    override fun construiestePoarta() {
        print("Poarta AND cu 4 intrari: ")
        bridge?.rezultatCreare()
        println("\nRezultat pentru poarta cu 4 intrari: "+((entry1.and(this.entry2)).and(this.entry3) and(this.entry4)))
    }
}