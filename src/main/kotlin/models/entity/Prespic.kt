package models.entity

import models.Spell

class Prespic: Monster() {
    override var maxPv: Int = 89
    override var actualPv: Int = 77
    override var power: Int = 0
    override val spells: MutableList<Spell> = mutableListOf(
        Spell("Picpic", 20, 30),
    )
}