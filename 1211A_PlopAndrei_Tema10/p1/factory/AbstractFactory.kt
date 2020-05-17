package factory

import chain.CEOHandler
import chain.Handler

abstract class AbstractFactory {
    abstract fun getHandler(handler: String): Handler
}