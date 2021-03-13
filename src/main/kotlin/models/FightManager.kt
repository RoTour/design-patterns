package models

import models.entity.Entity
import models.entity.Monster

class FightManager(val redTeam: MutableList<Entity>, val blue: MutableList<Entity>) {
    companion object {
        fun startFight(entityClass: Class<Monster>) {

        }
    }
}