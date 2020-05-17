import chain.CEOHandler
import chain.ExecutiveHandler
import chain.HappyWorkerHandler
import chain.ManagerHandler
import factory.EliteFactory
import factory.FactoryProducer
import factory.HappyWorkerFactory
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    var fact1 = FactoryProducer()
    var fact2=EliteFactory()
    var fact3=HappyWorkerFactory()
    var hand_1:CEOHandler = (factory2.getHandler("ceo") as CEOHandler)
    var hand_2:CEOHandler = (factory2.getHandler("ceo") as CEOHandler)
    var hand_3:ExecutiveHandler = (factory2.getHandler("executive") as ExecutiveHandler)
    var hand_4:ExecutiveHandler = (factory2.getHandler("executive") as ExecutiveHandler)
    var handler5:ManagerHandler = (factory2.getHandler("manager") as ManagerHandler)
    var handler6:ManagerHandler = (factory2.getHandler("manager") as ManagerHandler)
    handler1.next3=handler3
    handler3.next2=handler4
    handler3.next3=handler5
    handler5.next2=handler6
    handler2.next2=handler1
    handler2.next3=handler4
    handler4.next1=handler2
    handler4.next2=handler3
    handler4.next3=handler6
    handler6.next1=handler4
    handler6.next2=handler5

    var m=launch {
        handler1.handleRequest("three-one\n")
    }
    var n=launch {
        handler1.handleRequest("two-two\n")
    }
    var p=launch {
        handler1.handleRequest("one-three\n")
    }
    m.join()
    m.join()
    p.join()


}