package net.cloudopt.next.example.service

import net.cloudopt.next.example.model.Tables
import net.cloudopt.next.example.model.tables.pojos.Todo
import net.cloudopt.next.example.model.tables.records.TodoRecord
import net.cloudopt.next.jooq.JooqManager
import net.cloudopt.next.web.Worker.await
import java.sql.Timestamp


/*
 * @author: Cloudopt
 * @Time: 2018/2/26
 * @Description: Test Case
 */
class TodoService {

    suspend fun getTodoList(): MutableList<Todo> {
        return await { promise ->
            val result = JooqManager.dsl?.selectFrom(Tables.TODO)?.fetch()?.into(Todo::class.java)
            promise.complete(result)
        }
    }

    suspend fun getTodoListById(id: Int): TodoRecord {
        return await { promise ->
            val result = JooqManager.dsl?.selectFrom(Tables.TODO)?.where(Tables.TODO.ID.eq(id))?.fetchOne()
            promise.complete(result)
        }
    }

    suspend fun addTodoList(text: String) {
        val todo = JooqManager.dsl?.newRecord(Tables.TODO)
        todo?.id = 0
        todo?.text = text
        todo?.time = Timestamp(System.currentTimeMillis()).toLocalDateTime()
        todo?.state = 0
        await<Unit> { promise ->
            todo?.insert()
            promise.complete()
        }
    }

    suspend fun updateTodoList(id: Int, state: Int) {
        val todo = JooqManager.dsl?.newRecord(Tables.TODO)
        todo?.id = id
        todo?.state = state
        todo?.time = Timestamp(System.currentTimeMillis()).toLocalDateTime()
        await<Unit> { promise ->
            todo?.update()
            promise.complete()
        }

    }

    suspend fun deleteTodoList(id: Int) {
        val todo = JooqManager.dsl?.newRecord(Tables.TODO)
        todo?.id = id
        await<Unit> { promise ->
            todo?.delete()
            promise.complete()
        }
    }

}