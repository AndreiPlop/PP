package chain

interface Handler {
    suspend fun handleRequest( messageToBeProcessed: String): Unit?
}