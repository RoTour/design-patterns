package models.game

import models.entity.Character

class VictoryListener(private val player: Character) : EventListener{
    override fun update() {
        player.power+=10
        println("Power + 10 (${player.power})")
    }
}