package models.entity

import models.Spell

class Enutrof: Character() {
    override var power = 10
    override val spells: MutableList<Spell> = mutableListOf(
        Spell("Lancé de piece", 8, 11),
        Spell("Pelle du jugement", 15, 25),
        Spell("Roulage de pelle", 12, 18),
    )
}