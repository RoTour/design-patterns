package models.entity

import models.Spell

abstract class Character : Entity() {
    abstract var power: Int
    abstract val spells: MutableList<Spell>
    private var kamas: Int = 0
    override var pv: Int = 50

}