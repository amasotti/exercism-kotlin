interface Dequeable<T> {
    fun push(value: T)
    fun pop(): T?
    fun unshift(value: T)
    fun shift(): T?
}

class ListNode<T>(var value: T) {
    var next: ListNode<T>? = null
    var prev: ListNode<T>? = null
}


class Deque<T>: Dequeable<T> {

    private var head: ListNode<T>? = null
    private var tail: ListNode<T>? = null

    // Add element at the end of the Deque
    override fun push(value: T) {
        val node = ListNode(value)
        if (tail == null) {
            head = node
        } else {
            tail?.next = node
            node.prev = tail
        }
        tail = node
    }

    // Remove element from the end of the Deque
    override fun pop(): T? {
        val node = tail?.value

        if (tail?.prev == null) {
            head = null
            tail = null
        } else {
            tail = tail?.prev
            tail?.next = null
        }
        return node
    }

    // Add element at the beginning of the Deque
    override fun unshift(value: T) {
        val node = ListNode(value)
        if (head == null) {
            tail = node
        } else {
            head?.prev = node
            node.next = head
        }
        head = node
    }

    // Remove element from the beginning of the Deque
    override fun shift(): T? {
        val node = head?.value
        if (head?.next !== null) {
            head = head?.next
            head?.prev = null
        } else {
            head = null
            tail = null
        }
        return node
    }
}
