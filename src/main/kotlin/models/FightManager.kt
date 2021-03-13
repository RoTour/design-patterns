package models

import models.entity.Character
import models.entity.Entity
import models.entity.Monster
import pause
import printSpacer

class FightManager private constructor(
    private val redTeam: MutableList<Entity>,
    private val blueTeam: MutableList<Entity>
) {
    companion object {
        fun <T : Monster, R : Character> buildFightAgainst(
            player: R,
            opponentClass: Class<T>
        ): FightManager {
            printSpacer()
            val nbOpponents = (1..1).shuffled().first()
            println("FightManagerBuilder: Created $nbOpponents ${opponentClass.simpleName}")
            val opponents = mutableListOf<Entity>()
            for (i in 0 until nbOpponents) {
                opponents.add(opponentClass.getDeclaredConstructor().newInstance())
            }
            return FightManager(mutableListOf(player), opponents)
        }
    }

    fun startFight() {
        redTeam.forEach { it.heal() }
        blueTeam.forEach { it.heal() }
        while (redTeam.isNotEmpty() && blueTeam.isNotEmpty()) {
            playTurn(redTeam, blueTeam)
            playTurn(blueTeam, redTeam)
            pause()
        }
        endFight()
    }

    private fun endFight() {
        if(redTeam.isEmpty() && blueTeam.isNotEmpty()) {
            println("BLUE TEAM WINS !")
        }
        if(blueTeam.isEmpty() && redTeam.isNotEmpty()) {
            println("RED TEAM WINS !")
            redTeam.forEach { it.power += 5 }
        }
        if(redTeam.isEmpty() && blueTeam.isEmpty()) {
            println("DRAW !")
        }
        if(blueTeam.isNotEmpty() && redTeam.isNotEmpty()) {
            println("...wtf result")
        }
        redTeam.clear()
        blueTeam.clear()
    }

    private fun playTurn(playingTeam: MutableList<Entity>, opponentTeam: MutableList<Entity>) {
        playingTeam.forEach {
            if (opponentTeam.isNotEmpty()){
                val spell: Spell?
                val target: Entity?
                if (it is Character) {
                    spell = selectSpell(it)
                    printSpacer()
                    target = selectTarget(opponentTeam)
                    printSpacer()
                } else {
                    spell = it.spells.shuffled().first()
                    target = opponentTeam.shuffled().first()
                }
                val targetKilled = it.castSpell(spell, target)
                if (targetKilled) {
                    opponentTeam.remove(target)
                    println(" --> $target is dead !")
                }
            }
        }
    }

    private fun selectTarget(team: MutableList<Entity>): Entity {
        println("Select target: ")
        return team[selectIntoList(team)]
    }

    private fun selectSpell(character: Character): Spell {
        println("Select spell: ")
        return character.spells[selectIntoList(character.spells)]
        //        var input: String? = ""
//        do {
//            character.spells.forEachIndexed { index, spell -> println("$index-${spell.name}") }
//            input = readLine()
//            printSpacer()
//            try {
//                val nbInput = input?.toInt(10)
//                println("Spell selected: ${character.spells[nbInput ?: 0].name}")
//                return character.spells[nbInput ?: 0]
//            } catch (e: Exception) {
////                e.printStackTrace() // Debug
//                println("Error selecting the spell.")
//                continue
//            }
//        } while (input != "1")
//        return null // Should not happen
    }

    private fun selectIntoList(list: List<Any>): Int {
        var input: String?
        do {
            list.forEachIndexed { index, item -> println("$index-$item") }
            input = readLine()
            try {
                val nbInput = input?.toInt(10)
                return nbInput ?: 0
            } catch (e: Exception) {
//                e.printStackTrace() // Debug
                println("Error during selection")
                continue
            }
        } while (true)
    }
}