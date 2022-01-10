package com.example.a1117

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.math.abs
import android.content.Intent
import android.widget.Button
import android.widget.EditText

class fivefiveResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fivefive_result_window)

        val Answer = findViewById<EditText>(R.id.answer).toString()
        val startButton = findViewById<Button>(R.id.startButton)

        val ffResultAct = resultOfAlgorithm.getInstance()
        ffResultAct.startyoko = intent.getIntExtra("startYoko", 0)
        ffResultAct.starttate = intent.getIntExtra("startTate", 0)
        ffResultAct.goalyoko = intent.getIntExtra("goalYoko", 0)
        ffResultAct.goaltate = intent.getIntExtra("goalTate", 0)

        ffResultAct.ary00 = intent.getIntExtra("wall00", 0)
        ffResultAct.ary01 = intent.getIntExtra("wall01", 0)
        ffResultAct.ary02 = intent.getIntExtra("wall02", 0)
        ffResultAct.ary03 = intent.getIntExtra("wall03", 0)
        ffResultAct.ary04 = intent.getIntExtra("wall04", 0)
        ffResultAct.ary10 = intent.getIntExtra("wall10", 0)
        ffResultAct.ary11 = intent.getIntExtra("wall11", 0)
        ffResultAct.ary12 = intent.getIntExtra("wall12", 0)
        ffResultAct.ary13 = intent.getIntExtra("wall13", 0)
        ffResultAct.ary14 = intent.getIntExtra("wall14", 0)
        ffResultAct.ary20 = intent.getIntExtra("wall20", 0)
        ffResultAct.ary21 = intent.getIntExtra("wall21", 0)
        ffResultAct.ary22 = intent.getIntExtra("wall22", 0)
        ffResultAct.ary23 = intent.getIntExtra("wall23", 0)
        ffResultAct.ary24 = intent.getIntExtra("wall24", 0)
        ffResultAct.ary30 = intent.getIntExtra("wall30", 0)
        ffResultAct.ary31 = intent.getIntExtra("wall31", 0)
        ffResultAct.ary32 = intent.getIntExtra("wall32", 0)
        ffResultAct.ary33 = intent.getIntExtra("wall33", 0)
        ffResultAct.ary34 = intent.getIntExtra("wall34", 0)
        ffResultAct.ary40 = intent.getIntExtra("wall40", 0)
        ffResultAct.ary41 = intent.getIntExtra("wall41", 0)
        ffResultAct.ary42 = intent.getIntExtra("wall42", 0)
        ffResultAct.ary43 = intent.getIntExtra("wall43", 0)
        ffResultAct.ary44 = intent.getIntExtra("wall44", 0)

        startButton.setOnClickListener{
            val intent = Intent(this, fivefiveAnswerActivity::class.java)
            intent.putExtra("answer", Answer)
            startActivity(intent)
        }
    }
}

val ffResultAct = resultOfAlgorithm.getInstance()
fun main(args: Array<String>) {
    val grid = Grid(P(ffResultAct.startyoko, ffResultAct.starttate), P(ffResultAct.goalyoko, ffResultAct.goaltate)).apply {
    }
    Search(grid).execute(weight = 1.0)
}

class Search(val grid: Grid) {
    val ffResultAct = resultOfAlgorithm.getInstance()
    fun execute(weight: Double) {
        val costs = weightedAsterCost(weight)

        if (costs == null) {
            ffResultAct.UnCorrectResult = "Unreached"
            return
        } else {
            ffResultAct.CorrectResult = costs[grid.goal].toString().toInt()
            return
        }
    }

    private fun weightedAsterCost(weight: Double): Map<P, Int>? {
        // h: heuristic function
        val h = { n: P -> weight * n.distance(grid.goal) }

        val costs = mutableMapOf<P, Int>().apply { this[grid.start] = 0 }
        val queue = PriorityQueue<PC>().apply { add(PC(grid.start, h(grid.start))) }
        while (queue.isNotEmpty()) {
            val p = queue.poll().point
            if (p == grid.goal) return costs
            grid.neighbors(p).forEach { n ->
                val cost = costs[p]!! + p.distance(n)
                if (costs[n] == null || cost < costs[n]!!) {
                    costs[n] = cost
                    queue.add(PC(n, cost + h(n)))
                }
            }
        }
        return null // the goal is unreachable
    }
}

class PC(val point: P, private val cost: Double) : Comparable<PC> {
    override fun compareTo(other: PC): Int {
        return when {
            cost == other.cost -> 0
            cost < other.cost -> -1
            cost > other.cost -> 1
            else -> throw  IllegalStateException("$cost <-> ${other.cost}")
        }
    }
}

//5,5
class Grid(val start: P, val goal: P) {
    val ffResultAct = resultOfAlgorithm.getInstance()
    val states = arrayOf(
        arrayOf(ffResultAct.ary00, ffResultAct.ary01, ffResultAct.ary02, ffResultAct.ary03, ffResultAct.ary04),
        arrayOf(ffResultAct.ary10, ffResultAct.ary11, ffResultAct.ary12, ffResultAct.ary13, ffResultAct.ary14),
        arrayOf(ffResultAct.ary20, ffResultAct.ary21, ffResultAct.ary22, ffResultAct.ary23, ffResultAct.ary24),
        arrayOf(ffResultAct.ary30, ffResultAct.ary31, ffResultAct.ary32, ffResultAct.ary33, ffResultAct.ary34),
        arrayOf(ffResultAct.ary40, ffResultAct.ary41, ffResultAct.ary42, ffResultAct.ary43, ffResultAct.ary44)
    )

    fun isValid(n: P): Boolean {
        return (n.i in states.indices) && (n.j in states[n.i].indices)
    }

    fun state(n: P): Int {
        check(isValid(n)) { "out of range $n" }
        return states[n.i][n.j]
    }

    fun isEmpty(n: P): Boolean {
        return state(n) == 0
    }

    fun neighbors(n: P): List<P> {
        return n.around().filter { isValid(it) && isEmpty(it) }
    }
}

//Pointclass
data class P(val i: Int, val j: Int) {
    fun around(): Array<P> {
        return arrayOf(up(), left(), down(), right())
    }

    // Manhattan distance
    fun distance(o: P): Int {
        return abs(i - o.i) + abs(j - o.j)
    }

    fun up(): P {
        return P(i - 1, j)
    }

    fun down(): P {
        return P(i + 1, j)
    }

    fun left(): P {
        return P(i, j - 1)
    }

    fun right(): P {
        return P(i, j + 1)
    }

    override fun toString(): String {
        return "($i, $j)"
    }
}




































