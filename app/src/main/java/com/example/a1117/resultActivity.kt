package com.example.a1117

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.math.abs
import android.content.Intent
import android.view.View
import android.widget.EditText

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
        resultAct.startyoko = intent.getIntExtra("startYoko", 0)
        resultAct.starttate = intent.getIntExtra("startTate", 0)
        resultAct.goalyoko = intent.getIntExtra("goalYoko", 0)
        resultAct.goaltate = intent.getIntExtra("goalTate", 0)

        resultAct.ary00 = intent.getIntExtra("wall00", 0)
        resultAct.ary00 = intent.getIntExtra("wall01", 0)
        resultAct.ary00 = intent.getIntExtra("wall02", 0)
        resultAct.ary00 = intent.getIntExtra("wall03", 0)
        resultAct.ary00 = intent.getIntExtra("wall04", 0)
        resultAct.ary00 = intent.getIntExtra("wall10", 0)
        resultAct.ary00 = intent.getIntExtra("wall11", 0)
        resultAct.ary00 = intent.getIntExtra("wall12", 0)
        resultAct.ary00 = intent.getIntExtra("wall13", 0)
        resultAct.ary00 = intent.getIntExtra("wall14", 0)
        resultAct.ary00 = intent.getIntExtra("wall20", 0)
        resultAct.ary00 = intent.getIntExtra("wall21", 0)
        resultAct.ary00 = intent.getIntExtra("wall22", 0)
        resultAct.ary00 = intent.getIntExtra("wall23", 0)
        resultAct.ary00 = intent.getIntExtra("wall24", 0)
        resultAct.ary00 = intent.getIntExtra("wall30", 0)
        resultAct.ary00 = intent.getIntExtra("wall31", 0)
        resultAct.ary00 = intent.getIntExtra("wall32", 0)
        resultAct.ary00 = intent.getIntExtra("wall33", 0)
        resultAct.ary00 = intent.getIntExtra("wall34", 0)
        resultAct.ary00 = intent.getIntExtra("wall40", 0)
        resultAct.ary00 = intent.getIntExtra("wall41", 0)
        resultAct.ary00 = intent.getIntExtra("wall42", 0)
        resultAct.ary00 = intent.getIntExtra("wall43", 0)
        resultAct.ary00 = intent.getIntExtra("wall44", 0)
    }

    fun onbuttonClick(view: View) {
        val intent = Intent(this, fivefiveAnswerActivity::class.java)
        val Answer = findViewById<EditText>(R.id.answer).toString()
        intent.putExtra("Result", result)
        intent.putExtra("answer", Answer)

        startActivity(intent)
    }


    var result: String = ""
    var states = arrayOf(
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0),
    )

    companion object {
        private var instance: resultActivity? = null
        fun getInstance(): resultActivity {
            if (instance == null)
                instance = resultActivity()
            return instance!!
        }
    }

    class GetArray() {

        val resultAct = resultActivity.getInstance()
        fun main(args: Array<String>) {
            fun startGoal(a: Int, b: Int, c: Int, d: Int) {          //start goal
                val grid = Grid(P(a, b), P(c, d)).apply {
                }
                Search(grid).execute(weight = 1.0)
                return
            }
            startGoal(
                resultAct.startyoko,
                resultAct.starttate,
                resultAct.goalyoko,
                resultAct.goaltate
            )

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
                    arrayOf(d0, d1, d2, d3, d4),
                    arrayOf(e0, e1, e2, e3, e4),
                )
                return
            }

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

    class Search(val grid: Grid) {

        fun execute(weight: Double) {

            val resultAct = resultActivity.getInstance()
            val costs = weightedAsterCost(weight)

            if (costs == null) {
                resultAct.result = "unreachable"
                return
            } else {
                resultAct.result = costs[grid.goal].toString()
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

    class Path {
        val points = mutableListOf<P>()
        fun addPoint(point: P) {
            points.add(point)
        }
    }

    //5,5
    class Grid(val start: P, val goal: P) {
        val resultAct = resultActivity.getInstance()
        fun isValid(n: P): Boolean {
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



