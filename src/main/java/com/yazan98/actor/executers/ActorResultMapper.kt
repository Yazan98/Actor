package com.yazan98.actor.executers

import com.yazan98.actor.models.ActorApplicationInfo
import com.yazan98.actor.models.ActorController
import com.yazan98.actor.models.ActorRequest
import org.json.JSONArray
import org.json.JSONObject

class ActorResultMapper {

    private val jsonResult: JSONObject by lazy {
        JSONObject()
    }

    fun applyApplicationInfo(app: ActorApplicationInfo) {
        jsonResult.put("info", getApplicationInfo(app))
    }

    fun applyActorRequests(requests: List<ActorController>) {
        val requestsResult = JSONArray()
        requests.forEach {
            requestsResult.put()
        }
        jsonResult.put("item", requestsResult)
    }

    fun printAppResult() {

    }

    private fun getRequestInfo(request: ActorRequest): JSONObject {
        val result = JSONObject()
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
