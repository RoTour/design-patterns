package models.entity

import models.Spell

class Bouftou: Monster() {
    override var maxPv: Int = 77
    override var actualPv: Int = 77
    override var power: Int = 0
    override val spells: MutableList<Spell> = mutableListOf(
        Spell("Machouillage", 10, 20),
    )
}