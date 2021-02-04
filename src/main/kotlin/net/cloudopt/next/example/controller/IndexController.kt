package net.cloudopt.next.example.controller

import net.cloudopt.next.web.Resource
import net.cloudopt.next.web.route.API
import net.cloudopt.next.web.route.GET


/*
 * @author: Cloudopt
 * @Time: 2018/2/26
 * @Description: Test Case
 */
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