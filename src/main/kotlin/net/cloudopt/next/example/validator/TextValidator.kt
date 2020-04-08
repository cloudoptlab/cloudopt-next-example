package net.cloudopt.next.example.validator

import net.cloudopt.next.example.model.TodoModel
import net.cloudopt.next.web.Resource
import net.cloudopt.next.web.Validator


/*
 * @author: Cloudopt
 * @Time: 2018/2/28
 * @Description: Test Case
 */
class TextValidator : Validator {

    private val m = TodoModel()

    override fun validate(resource: Resource): Boolean {
        var text = resource.getParam("text")
        return !text.isNullOrBlank()
    }

    override fun error(resource: Resource) {
        var map = HashMap<String, String>()
        map.put("error", "100000")
        map.put("errorMessage", "Text is error!")
        resource.renderJson(map)
    }


}