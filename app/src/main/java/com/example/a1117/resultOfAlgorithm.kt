package com.example.a1117

class resultOfAlgorithm {
    companion object {
        private var instance: resultOfAlgorithm? = null
        fun getInstance(): resultOfAlgorithm {
            if (instance == null)
                instance = resultOfAlgorithm()
            return instance!!
        }
    }

    var UnCorrectResult: String = ""
    var CorrectResult = 0

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
}