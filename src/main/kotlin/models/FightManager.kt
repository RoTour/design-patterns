package models

import models.entity.Character
import models.entity.Entity
import models.entity.Monster

class FightManager private constructor(
    val redTeam: MutableList<Entity>,
    val blueTeam: MutableList<Entity>
    ) {
    companion object {
        fun <T: Monster, R: Character> buildFightAgainst(
            player: R,
            opponentClass: Class<T>
        ): FightManager {
            val nbOpponents = (1..3).shuffled().first()
            println("FightManagerBuilder: creating $nbOpponents opponents")
            val opponents = mutableListOf<Entity>()
            for (i in 0 until nbOpponents){
                opponents.add(opponentClass.getDeclaredConstructor().newInstance())
            }
            return FightManager(mutableListOf(player), opponents)
        }
    }

    fun startFight() {
        while (redTeam.isNotEmpty() && blueTeam.isNotEmpty()) {
            redTeam.forEach {
                if(it is Character) {
                    println("character")
                } else {
                    println("not a character")
                }
            }
            blueTeam.forEach {
                if(it is Character) {
                    println("character")
                } else {
                    println("not a character")
                }
            }
        }
    }
}