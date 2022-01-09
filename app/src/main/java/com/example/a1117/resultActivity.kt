package com.example.a1117

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.math.abs
import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.sql.Ref

class resultActivity : AppCompatActivity() {
    var startyoko = 0
    var starttate = 0
    var goalyoko = 0
    var goaltate = 0

    var ary00 = 0
    var ary01 = 0
    var ary02 = 0
    var ary03 = 0
    var ary04 = 0
    var ary10 = 0
    var ary11 = 0
    var ary12 = 0
    var ary13 = 0
    var ary14 = 0
    var ary20 = 0
    var ary21 = 0
    var ary22 = 0
    var ary23 = 0
    var ary24 = 0
    var ary30 = 0
    var ary31 = 0
    var ary32 = 0
    var ary33 = 0
    var ary34 = 0
    var ary40 = 0
    var ary41 = 0
    var ary42 = 0
    var ary43 = 0
    var ary44 = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fivefive_result_window)

        val resultAct = resultActivity.getInstance()
        resultAct.startyoko = intent.getStringExtra("startYoko").toString().toInt()
        resultAct.starttate = intent.getStringExtra("startTate").toString().toInt()
        resultAct.goalyoko = intent.getStringExtra("goalYoko").toString().toInt()
        resultAct.goaltate= intent.getStringExtra("goalTate").toString().toInt()

        resultAct.ary00 = intent.getStringExtra("wall00").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall01").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall02").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall03").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall04").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall10").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall11").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall12").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall13").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall14").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall20").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall21").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall22").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall23").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall24").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall30").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall31").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall32").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall33").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall34").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall40").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall41").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall42").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall43").toString().toInt()
        resultAct.ary00 = intent.getStringExtra("wall44").toString().toInt()
    }

    fun onbuttonClick(view: View) {
        val intent = Intent(this, fivefiveAnswerActivity::class.java)
        val Answer = findViewById<EditText>(R.id.answer)
        intent.putExtra("Result", result.toString())
        intent.putExtra("answer", Answer.toString())

        startActivity(intent)
    }


    var result: String? = null
    var states = arrayOf(
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0),
    )

    companion object {
        private var instance : resultActivity? = null
        fun getInstance(): resultActivity{
            if (instance == null)
                instance = resultActivity()
            return instance!!
        }
    }

    class GetArray() {
        fun main(args: Array<String>) {
            fun startGoal(a: Int, b: Int, c: Int, d: Int) {          //start goal
                val resultAct = resultActivity.getInstance()
                val grid = Grid(P(a, b), P(c, d)).apply {
                }
                Search(grid).execute(weight = 1.0)

                startGoal(
                    resultAct.startyoko,
                    resultAct.starttate,
                    resultAct.goalyoko,
                    resultAct.goaltate
                )
            }

            fun makestates(
                a0: Int, a1: Int, a2: Int, a3: Int, a4: Int,
                b0: Int, b1: Int, b2: Int, b3: Int, b4: Int,
                c0: Int, c1: Int, c2: Int, c3: Int, c4: Int,
                d0: Int, d1: Int, d2: Int, d3: Int, d4: Int,
                e0: Int, e1: Int, e2: Int, e3: Int, e4: Int
            ) {
                val resultAct = resultActivity.getInstance()
                resultAct.states = arrayOf(
                    arrayOf(a0, a1, a2, a3, a4),
                    arrayOf(b0, b1, b2, b3, b4),
                    arrayOf(c0, c1, c2, c3, c4),
                    arrayOf(d0, d1, d2, d3, d4,),
                    arrayOf(e0, e1, e2, e3, e4,),
                )

                makestates(
                    resultAct.ary00,
                    resultAct.ary01,
                    resultAct.ary02,
                    resultAct.ary03,
                    resultAct.ary04,
                    resultAct.ary10,
                    resultAct.ary11,
                    resultAct.ary12,
                    resultAct.ary13,
                    resultAct.ary14,
                    resultAct.ary20,
                    resultAct.ary21,
                    resultAct.ary22,
                    resultAct.ary23,
                    resultAct.ary24,
                    resultAct.ary30,
                    resultAct.ary31,
                    resultAct.ary32,
                    resultAct.ary33,
                    resultAct.ary34,
                    resultAct.ary40,
                    resultAct.ary41,
                    resultAct.ary42,
                    resultAct.ary43,
                    resultAct.ary44
                )
            }
        }
    }
    class Search(val grid: Grid) {

        fun execute(weight: Double) {

            val resultAct = resultActivity.getInstance()
            val costs = weightedAsterCost(weight)

            if (costs == null) {
                println("unreachable")
                return
            }
            resultAct.result = costs[grid.goal].toString()
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

    class Path {
        val points = mutableListOf<P>()
        fun addPoint(point: P) {
            points.add(point)
        }
    }

    //5,5
    class Grid(val start: P, val goal: P) {

        fun isValid(n: P): Boolean {
            val resultAct = resultActivity.getInstance()
            return (n.i in resultAct.states.indices) && (n.j in resultAct.states[n.i].indices)
        }

        fun state(n: P): Int {
            val resultAct = resultActivity.getInstance()
            check(isValid(n)) { "out of range $n" }
            return resultAct.states[n.i][n.j]
        }

        fun isEmpty(n: P): Boolean {
            return state(n) == 0
        }

        fun neighbors(n: P): List<P> {
            return n.around().filter { isValid(it) && isEmpty(it) }
        }

        fun print(path: Path = Path()) {
            val resultAct = resultActivity.getInstance()
            val sb = StringBuilder()
            sb.append("\n")

            for (i in resultAct.states.indices) {
                for (j in resultAct.states[i].indices) {
                    val s = resultAct.states[i][j]
                    val c = when {
                        P(i, j) == start -> " S "
                        P(i, j) == goal -> " G "
                        path.points.contains(P(i, j)) -> " @ "
                        s == 0 -> "   "
                        s == 1 -> " * "
                        else -> throw IllegalStateException("unknown state $s")
                    }

                    sb.append(c)
                }
                sb.append("\n")
            }
            print(sb.toString())
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
}



