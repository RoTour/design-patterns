package models.game

object EventManager {
    private val eventStack: MutableList<Event> = mutableListOf()
    private val listeners = mutableListOf<EventListener>()

    fun notifySubscribers() {
        listeners.forEach { it.update() }
    }

    fun subscribe(listener: EventListener) {
        listeners.add(listener)
    }

    fun unsubscribe(listener: EventListener) {
        listeners.remove(listener)
    }

    fun runNextEvent() {
        if (eventStack.isEmpty()) return
        eventStack.removeAt(0).action()
    }

    fun runAllEvents() {
        eventStack.forEach { it.action() }
        eventStack.clear()
    }

    fun addEvent(event: Event) {
        eventStack.add(event)
    }
}