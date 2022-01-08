package com.example.a1117

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.math.abs
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import java.sql.Ref

class resultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fivefive_result_window)

        val StartButton = findViewById<Button>(R.id.startButton)

        StartButton.setOnClickListener {
            val intent = Intent(this, fivefiveAnswerActivity::class.java)
            val Answer = findViewById<EditText>(R.id.answer)

            intent.putExtra("Result",result.toString())
            intent.putExtra("answer",Answer.text.toString())

            startActivity(intent)
        }
    }

    val startyoko : Int = intent.getStringExtra("startYoko").toString().toInt()
    val starttate : Int = intent.getStringExtra("startTate").toString().toInt()
    val goalyoko : Int = intent.getStringExtra("goalYoko").toString().toInt()
    val goaltate : Int= intent.getStringExtra("goalTate").toString().toInt()

    val ary00 : Int = intent.getStringExtra("wall00").toString().toInt()
    val ary01 : Int = intent.getStringExtra("wall01").toString().toInt()
    val ary02 : Int = intent.getStringExtra("wall02").toString().toInt()
    val ary03 : Int = intent.getStringExtra("wall03").toString().toInt()
    val ary04 : Int = intent.getStringExtra("wall04").toString().toInt()
    val ary10 : Int = intent.getStringExtra("wall10").toString().toInt()
    val ary11 : Int = intent.getStringExtra("wall11").toString().toInt()
    val ary12 : Int = intent.getStringExtra("wall12").toString().toInt()
    val ary13 : Int = intent.getStringExtra("wall13").toString().toInt()
    val ary14 : Int = intent.getStringExtra("wall14").toString().toInt()
    val ary20 : Int = intent.getStringExtra("wall20").toString().toInt()
    val ary21 : Int = intent.getStringExtra("wall21").toString().toInt()
    val ary22 : Int = intent.getStringExtra("wall22").toString().toInt()
    val ary23 : Int = intent.getStringExtra("wall23").toString().toInt()
    val ary24 : Int = intent.getStringExtra("wall24").toString().toInt()
    val ary30 : Int = intent.getStringExtra("wall30").toString().toInt()
    val ary31 : Int = intent.getStringExtra("wall31").toString().toInt()
    val ary32 : Int = intent.getStringExtra("wall32").toString().toInt()
    val ary33 : Int = intent.getStringExtra("wall33").toString().toInt()
    val ary34 : Int = intent.getStringExtra("wall34").toString().toInt()
    val ary40 : Int = intent.getStringExtra("wall40").toString().toInt()
    val ary41 : Int = intent.getStringExtra("wall41").toString().toInt()
    val ary42 : Int = intent.getStringExtra("wall42").toString().toInt()
    val ary43 : Int = intent.getStringExtra("wall43").toString().toInt()
    val ary44 : Int = intent.getStringExtra("wall44").toString().toInt()

    var result: String? = null

    companion object {
        private var instance : resultActivity? = null
        fun  getInstance():  resultActivity{
            if (instance == null)
                instance = resultActivity()
            return instance!!
        }
    }
}

class GetArray(val ResultActivity:resultActivity) {
    var states = arrayOf(
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0),
        arrayOf(0, 0, 0, 0, 0),
    )

    fun main(args: Array<String>) {
        fun startGoal(a: Int, b: Int, c: Int, d: Int) {          //start goal
            val grid = Grid(P(a, b), P(c, d)).apply {
            }
            Search(grid).execute(weight = 1.0)

            startGoal(
                ResultActivity.startyoko,
                ResultActivity.starttate,
                ResultActivity.goalyoko,
                ResultActivity.goaltate
            )
        }

        fun makestates(
            a0: Int, a1: Int, a2: Int, a3: Int, a4: Int,
            b0: Int, b1: Int, b2: Int, b3: Int, b4: Int,
            c0: Int, c1: Int, c2: Int, c3: Int, c4: Int,
            d0: Int, d1: Int, d2: Int, d3: Int, d4: Int,
            e0: Int, e1: Int, e2: Int, e3: Int, e4: Int
        ) {
            states = arrayOf(
                arrayOf(a0, a1, a2, a3, a4),
                arrayOf(b0, b1, b2, b3, b4),
                arrayOf(c0, c1, c2, c3, c4),
                arrayOf(d0, d1, d2, d3, d4,),
                arrayOf(e0, e1, e2, e3, e4,),
            )


            makestates(
                ResultActivity.ary00,
                ResultActivity.ary01,
                ResultActivity.ary02,
                ResultActivity.ary03,
                ResultActivity.ary04,
                ResultActivity.ary10,
                ResultActivity.ary11,
                ResultActivity.ary12,
                ResultActivity.ary13,
                ResultActivity.ary14,
                ResultActivity.ary20,
                ResultActivity.ary21,
                ResultActivity.ary22,
                ResultActivity.ary23,
                ResultActivity.ary24,
                ResultActivity.ary30,
                ResultActivity.ary31,
                ResultActivity.ary32,
                ResultActivity.ary33,
                ResultActivity.ary34,
                ResultActivity.ary40,
                ResultActivity.ary41,
                ResultActivity.ary42,
                ResultActivity.ary43,
                ResultActivity.ary44
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
class Grid(val start: P, val goal: P, val getArray:GetArray) {

    fun isValid(n: P): Boolean {
        return (n.i in getArray.states.indices) && (n.j in getArray.states[n.i].indices)
    }

    fun state(n: P): Int {
        check(isValid(n)) { "out of range $n" }
        return getArray.states[n.i][n.j]
    }

    fun isEmpty(n: P): Boolean {
        return state(n) == 0
    }

    fun neighbors(n: P): List<P> {
        return n.around().filter { isValid(it) && isEmpty(it) }
    }

    fun print(path: Path = Path()) {
        val sb = StringBuilder()
        sb.append("\n")

        for (i in getArray.states.indices) {
            for (j in getArray.states[i].indices) {
                val s = getArray.states[i][j]
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
