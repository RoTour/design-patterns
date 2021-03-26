package models.entity

import models.Spell

class Iop: Character() {
    override var power = 10
    override val spells: MutableList<Spell> = mutableListOf(
        Spell("Pression", 14, 18),
        Spell("Concentration", 9, 13),
        Spell("Epee destructrice", 20, 40),
    )
}