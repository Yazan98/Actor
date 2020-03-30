package com.yazan98.actor.executers

import com.yazan98.actor.models.ActorApplicationInfo
import com.yazan98.actor.models.ActorController
import com.yazan98.actor.models.ActorRequest
import com.yazan98.actor.models.ActorRequestContent
import org.json.JSONArray
import org.json.JSONObject
import java.io.File
import java.io.FileWriter

class ActorResultMapper {

    private lateinit var app: ActorApplicationInfo
    private val jsonResult: JSONObject by lazy {
        JSONObject()
    }

    fun applyApplicationInfo(app: ActorApplicationInfo) {
        this.app = app
        jsonResult.put("info", getApplicationInfo(app))
    }

    fun applyActorRequests(requests: List<ActorController>) {
        val requestsResult = JSONArray()
        requests.forEach {
            requestsResult.put(getActorController(it))
        }
        jsonResult.put("item", requestsResult)
    }

    fun printAppResult() {
        File("actor").mkdir()
        val writer = FileWriter("actor/postman-collection.json")
        writer.write(jsonResult.toString())
        writer.close()
    }

    private fun getActorController(controller: ActorController): JSONObject {
        val result = JSONObject()
        result.put("name", controller.name)
        result.put("description", controller.description)
        result.put("item", getControllerRequests(controller.item))
        return result
    }

    private fun getControllerRequests(requests: List<ActorRequest>): JSONArray {
        val result = JSONArray()
        requests.forEach {
            result.put(getRequestInfo(it))
        }
        return result
    }

    private fun getRequestInfo(request: ActorRequest): JSONObject {
        val result = JSONObject()
        result.put("name", request.name)
        result.put("request", getRequestDetails(request.request))
        return result
    }

    private fun getRequestDetails(request: ActorRequestContent): JSONObject {
        val result = JSONObject()
        val url = JSONObject()
        val headers = JSONArray()
        val queries = JSONArray()

        request.headers.forEach {
            val header = JSONObject()
            header.put("key", it.key)
            header.put("value", it.value)
            headers.put(header)
        }

        result.put("method", request.method)
        result.put("header", headers)

        request.url?.let {
            url.put("raw", it.raw)
            url.put("protocol", it.protocol)
            url.put("host", it.host)
            url.put("port", it.port)

            it.query.forEach {
                val query = JSONObject()
                query.put("key", it.key)
                query.put("value", it.value)
                queries.put(query)
            }
            url.put("query", queries)
        }

        result.put("url", url)
        result.put("body", ActorBodyMapper().getRequestBody(request.body))

        return result
    }

    private fun getApplicationInfo(app: ActorApplicationInfo): JSONObject {
        val result: JSONObject = JSONObject()
        result.put("_postman_id", app._postman_id)
        result.put("name", app.name)
        result.put("description", app.description)
        result.put("schema", app.schema)
        return result
    }

}
