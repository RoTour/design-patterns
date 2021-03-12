package models.entity

import java.util.*

abstract class Entity {
    companion object {
        var idGenerator: Long = 0
    }
    val id: Long = idGenerator++
    abstract var pv: Int
}