package chain

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class ManagerHandler(var next1: Handler? = null, var next2: Handler? = null, var next3: Handler? = null): Handler {
    override suspend fun handleRequest(messageToBeProcessed: String) = coroutineScope {
        var trimis=messageToBeProcessed.split(":")
        var prioritate=trimis.elementAt(0)
        var mesaj=trimis.elementAt(1)
        if(prioritate=="3") {
            var job=launch{
            if (next1 == null) {
                print("sus-jos " + mesaj)
                next2?.handleRequest(messageToBeProcessed)
            } else {
                print("jos-jos " + mesaj)
                next1?.handleRequest(messageToBeProcessed)
            }
                }
            job.join()
        }
        else
        {
            var job=launch {
                if (next1 != null) {
                    print("jos-jos " + mesaj)
                    next1?.handleRequest(messageToBeProcessed)
                } else {
                    print("jos-sus " + mesaj)
                    next3?.handleRequest(messageToBeProcessed)
                }
            }
            job.join()
        }
    }
}