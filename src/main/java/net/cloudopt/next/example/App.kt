package net.cloudopt.next.example
import com.mysql.cj.core.log.Slf4JLogger
import net.cloudopt.next.jooq.JooqPlugin
import net.cloudopt.next.jooq.Jooqer
import net.cloudopt.next.logging.provider.Slf4jLoggerProvider
import net.cloudopt.next.web.CloudoptServer
import org.jooq.conf.Settings


/*
 * @author: Cloudopt
 * @Time: 2018/2/26
 * @Description: Test Case
 */
fun main(args: Array<String>) {
    CloudoptServer.addPlugin(JooqPlugin())
    CloudoptServer.run()
}
