package models.game

class EventManager {
    private val eventStack: MutableList<Event> = mutableListOf()

    fun runNextEvent() {
        if (eventStack.isEmpty()) return
        eventStack.removeAt(0).action()
    }

    fun runAllEvents() {
        eventStack.forEach { it.action() }
    }

    fun addEvent(event: Event) {
        eventStack.add(event)
    }
}