import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

class BankAccount {

    /**
     * The status of the account (open or closed).
     */
    sealed class Status {
        object Open : Status()
        object Closed : Status()
        object Frozen : Status()
    }

    // Properties

    /**
     * The status of the account (open or closed).
     */
    private var status: Status = Status.Open
    private val lock = ReentrantLock()
    var balance: Long = 0L
        /**
         * Thread-safe getter for the balance property.
         */
        get() {
                lock.withLock {
                    check(status != Status.Closed) { "Account is closed" }
                    return field
                }
        }

    /**
     * Adjusts the balance of the account by the given amount.
     * Thread-safe. The tests provide negative amounts as negative numbers,
     * so we don't need a separate withdraw() method.
     */
    fun adjustBalance(amount: Long){
        lock.withLock {
            check(status != Status.Closed) { "Account is closed" }
            check(status != Status.Frozen) { "Account is frozen" }

            balance += amount
        }
    }

    fun close() {
        lock.withLock {
            check(status != Status.Closed) { "Account is already closed" }
            status = Status.Closed
        }
    }
}
