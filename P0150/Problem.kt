import java.util.*

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val ops = Stack<Int>()
        tokens.map {
            when (it) {
                "+" -> ops.push(ops.pop() + ops.pop())
                "*" -> ops.push(ops.pop() * ops.pop())
                "-" -> {
                    val first = ops.pop()
                    val second = ops.pop()
                    ops.push(second - first)
                }
                "/" -> {
                    val first = ops.pop()
                    val second = ops.pop()
                    ops.push(second / first)
                }
                else -> ops.push(it.toInt())
            }
        }
        return ops.pop()
    }
}