package models.entity

import models.Spell

abstract class Entity {
    companion object {
        var idGenerator: Long = 0
    }
    val id: Long = idGenerator++
    abstract var maxPv: Int
    abstract var actualPv: Int
    abstract val spells: MutableList<Spell>
    abstract var power: Int

    fun castSpell(spell: Spell, target: Entity): Boolean {
        println("${javaClass.simpleName} casts ${spell.name} to $target")
        val damage = ((spell.baseDmgMin..spell.baseDmgMax).shuffled().first() + power)
        target.actualPv -= damage
        println(" --> Inflicted: $damage to $target")
        if (target.actualPv > target.maxPv) target.actualPv = target.maxPv // When healed
        if (target.actualPv < 0) target.actualPv = 0
        return target.actualPv == 0
    }

    override fun toString(): String {
        return ("${this.javaClass.simpleName} (PV: $actualPv)")
    }

    fun heal() {
        actualPv = maxPv
    }
}