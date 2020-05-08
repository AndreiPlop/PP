data class AndGate8(override var bridge: BridgeDecuplare?): AndGate(bridge) {
    private var entry1: Boolean=false
    private var entry2: Boolean=false
    private var entry3: Boolean=false
    private var entry4: Boolean=false
    private var entry5: Boolean=false
    private var entry6: Boolean=false
    private var entry7: Boolean=false
    private var entry8: Boolean=false
    fun e1(e1: Boolean)=apply{this.entry1=e1}
    fun e2(e2: Boolean)=apply{this.entry2=e2}
    fun e3(e3: Boolean)=apply{this.entry3=e3}
    fun e4(e4: Boolean)=apply{this.entry4=e4}
    fun e5(e1: Boolean)=apply{this.entry5=e1}
    fun e6(e2: Boolean)=apply{this.entry6=e2}
    fun e7(e3: Boolean)=apply{this.entry7=e3}
    fun e8(e4: Boolean)=apply{this.entry8=e4}
    override fun construiestePoarta() {
        print("Poarta AND cu 8 intrari: ")
        bridge?.rezultatCreare()
        println("\nRezultat pentru poarta cu 8 intrari: "+((entry1.and(this.entry2)).and(this.entry3) and(this.entry4)and(this.entry5)and(this.entry6)and(this.entry7)and(this.entry8)))
    }
}