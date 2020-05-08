data class AndGate2 (override var bridge: BridgeDecuplare?): AndGate(bridge) {
    private var entry1: Boolean=false
    private var entry2: Boolean=false
    fun e1(e1: Boolean)=apply{this.entry1=e1}
    fun e2(e2: Boolean)=apply{this.entry2=e2}
    override fun construiestePoarta() {
        print("Poarta AND cu 2 intrari: ")
        bridge?.rezultatCreare()
        println("\nRezultat pentru poarta cu 2 intrari: "+(entry2.let{entry1.and(it)}))
    }
}