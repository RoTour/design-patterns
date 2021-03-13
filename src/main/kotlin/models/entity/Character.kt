package models.entity

import models.Spell

abstract class Character : Entity() {

    private var kamas: Int = 0
    override var maxPv: Int = 50
    override var actualPv: Int = 50
}