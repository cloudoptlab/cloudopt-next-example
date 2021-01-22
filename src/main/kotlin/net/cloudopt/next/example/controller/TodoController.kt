package net.cloudopt.next.example.controller

import net.cloudopt.next.example.interceptor.AllInterceptor
import net.cloudopt.next.example.service.TodoService
import net.cloudopt.next.web.Resource
import net.cloudopt.next.web.Worker.global
import net.cloudopt.next.web.route.*
import javax.validation.constraints.Max
import javax.validation.constraints.Min
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

/*
 * @author: Cloudopt
 * @Time: 2018/2/26
 * @Description: Test Case
 */
@API("/api/v1/todo", interceptor = [AllInterceptor::class])
class TodoController : Resource() {

    private val todoService = TodoService()

    @GET
    suspend fun get() {
        renderJson(todoService.getTodoList())
    }

    @POST
    fun post(
        @Parameter("text")
        @NotBlank
        text: String
    ) {
        global{
            todoService.addTodoList(text)
            renderJson(result("success"))
        }
    }

    @PUT("/:id")
    fun put(
        @Parameter("id")
        @NotNull
        @Min(-1)
        id: Int,
        @Parameter("state")
        @NotNull
        @Min(-1)
        @Max(2)
        state: Int
    ) {
        global{
            todoService.updateTodoList(id, state)
            renderJson(result("success"))
        }
    }

    @DELETE("/:id")
    fun delete(
        @Parameter("id")
        @NotNull
        @Min(-1)
        id: Int
    ) {
        global{
            todoService.deleteTodoList(id)
            renderJson(result("success"))
        }
    }

    private fun result(any: Any): HashMap<String, Any> {
        val map = HashMap<String, Any>()
        map["result"] = any
        return map
    }

}