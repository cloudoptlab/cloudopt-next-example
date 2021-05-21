package net.cloudopt.next.example

import net.cloudopt.next.jooq.JooqPlugin
import net.cloudopt.next.web.NextServer


fun main() {
    System.getProperties().setProperty("org.jooq.no-logo", "true")
    NextServer.addPlugin(JooqPlugin())
    NextServer.run()
}
