package net.cloudopt.next.example.controller

import net.cloudopt.next.example.interceptor.AllInterceptor
import net.cloudopt.next.example.model.TodoModel
import net.cloudopt.next.example.validator.IdValidator
import net.cloudopt.next.example.validator.TextValidator
import net.cloudopt.next.web.Resource
import net.cloudopt.next.web.Validator
import net.cloudopt.next.web.route.*

/*
 * @author: Cloudopt
 * @Time: 2018/2/26
 * @Description: Test Case
 */
@API("/api/v1/todo",interceptor = arrayOf(AllInterceptor::class))
class TodoController : Resource() {

    private val m = TodoModel()

    @GET
    fun get() {
        renderJson(m.getTodoList())
    }

    @POST(valid = arrayOf(TextValidator::class))
    fun post() {
        m.addTodoList(getParam("text") ?: "")
        renderJson(result("success"))
    }

    @PUT("/:id", valid = arrayOf(IdValidator::class))
    fun put() {
        m.updateTodoList(getParam("id")?.toInt())
        renderJson(result("success"))
    }

    @DELETE("/:id", valid = arrayOf(IdValidator::class))
    fun delete() {
        m.deleteTodoList(getParam("id")?.toInt())
        renderJson(result("success"))
    }

    fun result(s: String): HashMap<String, String> {
        var map = HashMap<String, String>()
        map.put("result", s)
        return map
    }

}