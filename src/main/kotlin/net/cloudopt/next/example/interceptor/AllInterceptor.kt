package net.cloudopt.next.example.interceptor

import net.cloudopt.next.web.Interceptor
import net.cloudopt.next.web.Resource

class AllInterceptor : Interceptor {

    override suspend fun intercept(resource: Resource): Boolean {
        println("Through the intercept!")
        return true
    }

    override suspend fun response(resource: Resource): Resource {
        return resource
    }


}