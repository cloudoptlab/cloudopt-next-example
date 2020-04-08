package net.cloudopt.next.example
import net.cloudopt.next.jooq.JooqPlugin
import net.cloudopt.next.web.CloudoptServer


/*
 * @author: Cloudopt
 * @Time: 2018/2/26
 * @Description: Test Case
 */
fun main() {
    CloudoptServer.addPlugin(JooqPlugin())
    CloudoptServer.run()
}
