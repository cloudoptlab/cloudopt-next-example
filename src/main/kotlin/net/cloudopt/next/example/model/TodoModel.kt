package net.cloudopt.next.example.model

import com.alibaba.fastjson.JSONObject
import net.cloudopt.next.example.orm.Tables
import net.cloudopt.next.example.orm.tables.daos.TodoDao
import net.cloudopt.next.example.orm.tables.pojos.Todo
import net.cloudopt.next.jooq.Jooqer
import net.cloudopt.next.json.Jsoner
import java.sql.Date
import java.sql.Timestamp


/*
 * @author: Cloudopt
 * @Time: 2018/2/26
 * @Description: Test Case
 */
class TodoModel {

    private val dao = TodoDao(Jooqer.configuration)

    fun getTodoList(): MutableList<Todo> {

//      -First
//      return Jooqer.dsl?.selectFrom(Tables.TODO)?.fetch()?.map{record ->
//          return@map TodoBean(record.getValue(Todo.TODO.ID),
//                  record.getValue(Todo.TODO.TEXT),
//                  record.getValue(Todo.TODO.STATE),
//                  record.getValue(Todo.TODO.TIME).toLocalDateTime())
//      } as MutableList<TodoBean>

//      -Second
//      return Jooqer.dsl?.selectFrom(Tables.TODO)?.fetch()?.into(Todo::class.java)?.toMutableList() ?: arrayListOf()

//      -Third
        return dao.findAll().toMutableList()

    }

    fun getTodoListById(id:Int): Todo? {
        return dao.findById(id)
    }

    fun addTodoList(text: String) {
        var todo = Todo()
        todo.state = 0
        todo.text = text
        todo.time = Timestamp(System.currentTimeMillis())
        dao.insert(todo)
    }

    fun updateTodoList(id: Int?) {
        var todo = dao.findById(id)
        if(todo.state == 0){
            todo.state = 1
        }else{
            todo.state = 0
        }
        dao.update(todo)
    }

    fun deleteTodoList(id: Int?) {
        dao.deleteById(id)
    }

}