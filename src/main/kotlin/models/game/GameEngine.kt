package models.game

import factories.EntityFactory
import models.FightManager
import models.entity.*
import printSpacer

class GameEngine {

    enum class GameState {
        STOPPED,
        PAUSED,
        STARTED,
    }
    var gameState = GameState.STOPPED
    private val eventManager = EventManager()
    private lateinit var player: Character

    init {
        gameState = GameState.STARTED
        startGame()
    }

    private fun startGame() {
        selectCharacter()

        while (gameState != GameState.STOPPED) {
            readUserAction()
            eventManager.runAllEvents()
        }
    }


    private fun selectCharacter() {
        var input: String? = ""
        while (input != "0" && input != "1" && input != "2"){
            println("Select you Character: ")
            println("0-Cra    1-Iop    2-Enutrof")
            input = readLine()
            when (input) {
                "0" -> player = EntityFactory.create(Cra::class.java)
                "1" -> player = EntityFactory.create(Iop::class.java)
                "2" -> player = EntityFactory.create(Enutrof::class.java)
            }
        }
        println("Player created! Your class: ${player.javaClass.canonicalName} (enter to continue)")
        readLine()
        printSpacer()
    }

    private fun readUserAction() {
        var input: String? = ""
        while (input != "0" && input != "1" && input != "2") {
            println("Select you action: ")
            println("0-Exit Game    1-Start a Fight")
            input = readLine()
            when (input) {
                // Exit the game
                "0" -> eventManager.addEvent(Event { gameState = GameState.STOPPED })
                // Pick an opponent
                "1" -> eventManager.addEvent(Event {
                    FightManager.buildFightAgainst(player, Bouftou::class.java).startFight()
                })
                // Start a quest
                "2" -> eventManager.addEvent(Event { })
            }
        }
    }


}