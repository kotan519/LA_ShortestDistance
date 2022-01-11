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

        val startButton = findViewById<Button>(R.id.startButton)
        val backButton = findViewById<Button>(R.id.backButton)

        val ffResultAct = resultOfAlgorithm.getInstance()
        ffResultAct.startyoko = intent.getStringExtra("startYoko").toString().toInt()
        ffResultAct.starttate = intent.getStringExtra("startTate").toString().toInt()
        ffResultAct.goalyoko = intent.getStringExtra("goalYoko").toString().toInt()
        ffResultAct.goaltate = intent.getStringExtra("goalTate").toString().toInt()

        ffResultAct.ary00 = intent.getStringExtra("wall00").toString().toInt()
        ffResultAct.ary01 = intent.getStringExtra("wall01").toString().toInt()
        ffResultAct.ary02 = intent.getStringExtra("wall02").toString().toInt()
        ffResultAct.ary03 = intent.getStringExtra("wall03").toString().toInt()
        ffResultAct.ary04 = intent.getStringExtra("wall04").toString().toInt()
        ffResultAct.ary10 = intent.getStringExtra("wall10").toString().toInt()
        ffResultAct.ary11 = intent.getStringExtra("wall11").toString().toInt()
        ffResultAct.ary12 = intent.getStringExtra("wall12").toString().toInt()
        ffResultAct.ary13 = intent.getStringExtra("wall13").toString().toInt()
        ffResultAct.ary14 = intent.getStringExtra("wall14").toString().toInt()
        ffResultAct.ary20 = intent.getStringExtra("wall20").toString().toInt()
        ffResultAct.ary21 = intent.getStringExtra("wall21").toString().toInt()
        ffResultAct.ary22 = intent.getStringExtra("wall22").toString().toInt()
        ffResultAct.ary23 = intent.getStringExtra("wall23").toString().toInt()
        ffResultAct.ary24 = intent.getStringExtra("wall24").toString().toInt()
        ffResultAct.ary30 = intent.getStringExtra("wall30").toString().toInt()
        ffResultAct.ary31 = intent.getStringExtra("wall31").toString().toInt()
        ffResultAct.ary32 = intent.getStringExtra("wall32").toString().toInt()
        ffResultAct.ary33 = intent.getStringExtra("wall33").toString().toInt()
        ffResultAct.ary34 = intent.getStringExtra("wall34").toString().toInt()
        ffResultAct.ary40 = intent.getStringExtra("wall40").toString().toInt()
        ffResultAct.ary41 = intent.getStringExtra("wall41").toString().toInt()
        ffResultAct.ary42 = intent.getStringExtra("wall42").toString().toInt()
        ffResultAct.ary43 = intent.getStringExtra("wall43").toString().toInt()
        ffResultAct.ary44 = intent.getStringExtra("wall44").toString().toInt()

        startButton.setOnClickListener {
            val intent = Intent(this, fivefiveAnswerActivity::class.java)
            val Answer = findViewById<EditText>(R.id.answer).text.toString()
            intent.putExtra("answer", Answer)
            startActivity(intent)
        }

        backButton.setOnClickListener {
            finish()
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
            ffResultAct.CorrectResult = costs[grid.goal]!!
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









































