package factories

import models.entity.Entity

object EntityFactory {
    fun <T: Entity> create(entity: Class<T>): T {
        return entity.getDeclaredConstructor().newInstance()
    }
}
