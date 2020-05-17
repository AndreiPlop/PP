package chain

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class CEOHandler(var next1: Handler? = null, var next2: Handler? = null, var next3: Handler? = null): Handler {
    override suspend fun handleRequest( messageToBeProcessed: String) = coroutineScope {
        var trimis = messageToBeProcessed.split(":")
        var prioritate = trimis.elementAt(0)
        var mesaj = trimis.elementAt(1)


        if (prioritate == "1") {
            var job=launch{print("rezolvat " + mesaj)}
            job.join()
        }
        else
        {   var job=launch {
            if (next2 != null) {
                print("jos-sus" + mesaj)
                next2?.handleRequest("1:" + mesaj)
            } else {
                print("sus-sus " + mesaj)
                next3?.handleRequest(messageToBeProcessed)
            }
        }
            job.join()
        }
    }
}