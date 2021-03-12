package models.entity

abstract class Character : Entity() {
    override var pv: Int = 50
    private var kamas: Int = 0
    abstract var power: Int

    fun endOfQuest(reward: Int) {
        if (reward < 0) return
        kamas+=reward
    }
}