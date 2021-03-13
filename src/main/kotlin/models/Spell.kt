package models

class Spell(
    val name: String,
    val baseDmgMin: Int,
    val baseDmgMax: Int,
    val baseCritRate: Int = 25) {
}