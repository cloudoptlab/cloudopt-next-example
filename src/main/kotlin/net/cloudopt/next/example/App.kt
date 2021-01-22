package net.cloudopt.next.example

import net.cloudopt.next.jooq.JooqPlugin
import net.cloudopt.next.web.NextServer


/*
 * @author: Cloudopt
 * @Time: 2018/2/26
 * @Description: Test Case
 */
fun main() {
    System.getProperties().setProperty("org.jooq.no-logo", "true")
    NextServer.addPlugin(JooqPlugin())
    NextServer.run()
}
