package net.cloudopt.next.example.interceptor

import net.cloudopt.next.web.Interceptor
import net.cloudopt.next.web.Resource


/*
 * @author: Cloudopt
 * @Time: 2018/2/28
 * @Description: Test Case
 */
class AllInterceptor : Interceptor {

    override fun intercept(resource: Resource): Boolean {
        println("Through the intercept!")
        return true
    }

    override fun response(resource: Resource): Resource {
        return resource
    }


}