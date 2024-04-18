package lesson1

abstract class BoundedStack<T>(private val maxCount: Int = 32) /* Постусловие: создан новый пустой стек, размер которого ограничен значением maxCount */ {

    private val stack = mutableListOf<T>()

    var push_status: Int = PUSH_NIL
        private set
    var peek_status: Int = PEEK_NIL
        private set
    var pop_status: Int = POP_NIL
        private set

    // Предусловие: количество элементов в стеке меньше максимально допустимого
    // Постусловие: в стек добавлено новое значение
    fun push(value: T) {
        push_status = if (size() < maxCount) {
            stack.add(value)
            PUSH_OK
        } else {
            PUSH_ERR
        }
    }

    // Предусловие: стек не пустой
    fun peek(): T {
        peek_status = if (size() <= 0) PEEK_ERR else PEEK_OK
        return stack.last()
    }

    // Предусловие: стек не пустой
    // Постусловие: удален верхний элемент
    fun pop() {
        pop_status = if (size() <= 0) {
            POP_ERR
        } else {
            POP_OK
        }
        stack.removeLast()
    }

    fun size(): Int {
        return stack.size
    }

    // Постусловие: стек пустой
    fun clear() {
        stack.clear()
    }

    companion object {
        const val PUSH_NIL = 0
        const val PUSH_ERR = 1
        const val PUSH_OK = 2
        const val POP_NIL = 0
        const val POP_ERR = 1
        const val POP_OK = 2
        const val PEEK_NIL = 0
        const val PEEK_ERR = 1
        const val PEEK_OK = 2
    }
}