package chain

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class HappyWorkerHandler(var next1: Handler? = null, var next2: Handler? = null, var next3: Handler? = null): Handler {
    override suspend fun handleRequest(messageToBeProcessed: String) = coroutineScope {
        var trimis=messageToBeProcessed.split(":")
        var prioritate=trimis.elementAt(0)
        var mesaj=trimis.elementAt(1)
        if(prioritate=="4") {
            var job=launch {
                if (next1 == null) {
                    print("sus-jos " + mesaj)
                    next2?.handleRequest(messageToBeProcessed)
                } else {
                    print("jos-jos" + mesaj)
                    next1?.handleRequest(messageToBeProcessed)
                }
            }
            job.join()
        }

        else
        {
            var job=launch {
            throw Exception("nimeni")
            }
            job.join()
        }
    }
}