package factory
import chain.*

class HappyWorkerFactory: AbstractFactory() {
    override fun getHandler(handler: String): Handler {
        return when(handler){
            "happy"->HappyWorkerHandler()
            else ->throw Exception("NU E SUPORTAT")
        }
    }
}