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

        tail?.next = node
        node.prev = tail
        tail = node

        if (head == null) head = node
    }

    // Remove element from the end of the Deque
    override fun pop(): T? {
        val node = tail?.value

        tail = tail?.prev
        tail?.next = null
        if (tail == null) head = null

        return node
    }

    // Add element at the beginning of the Deque
    override fun unshift(value: T) {
        val node = ListNode(value)

        node.next = head
        head?.prev = node
        head = node
        // If the tail is null (empty deque), make the new node the tail
        if (tail == null) tail = node
    }

    // Remove element from the beginning of the Deque
    override fun shift(): T? {
        val node = head?.value
        head = head?.next
        head?.prev = null
        // If head is null (empty deque), also set tail to null
        if (head == null) tail = null

        return node
    }
}
