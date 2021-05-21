package net.cloudopt.next.example.controller

import net.cloudopt.next.web.Resource
import net.cloudopt.next.web.annotation.API
import net.cloudopt.next.web.annotation.GET

@API("/")
class IndexController : Resource() {

    @GET
    fun get() {
        renderHtml {
            template {
                name = "index"
            }
        }
    }

}