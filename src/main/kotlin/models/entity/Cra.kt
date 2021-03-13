package models.entity

import models.Spell

class Cra : Character() {
    override var power = 10
    override val spells: MutableList<Spell> = mutableListOf(
        Spell("Fleche magique", 10, 15),
        Spell("Fleche d'expiation", 15, 20),
        Spell("Fleche punitive", 12, 18),
    )
}