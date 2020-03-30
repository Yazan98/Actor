package com.yazan98.actor.executers

import org.json.JSONArray
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList


class ActorBodyMapper {

    private val jsonResult: JSONObject by lazy {
        JSONObject()
    }

    fun getRequestBody(requestBody: Any): String {
        requestBody.javaClass.declaredFields?.let {
            it.forEach {
                when (it.type) {
                    String::class.java, java.lang.String::class.java -> jsonResult.put(it.name, "")
                    Long::class.java, Double::class.java, Float::class.java, Byte::class.java -> jsonResult.put(it.name, 0)
                    java.lang.Long::class.java, java.lang.Double::class.java, java.lang.Float::class.java, java.lang.Byte::class.java -> jsonResult.put(it.name, 0)
                    List::class.java, ArrayList::class.java, LinkedList::class.java -> jsonResult.put(it.name, JSONArray())
                    java.util.List::class.java, java.util.ArrayList::class.java, java.util.LinkedList::class.java -> jsonResult.put(it.name, JSONArray())
                }
            }
        }
        return jsonResult.toString()
    }

}