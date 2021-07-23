package org.dripto.mfaapispring

fun main() {
    val list: List<Int> = updates.split("\n")
        .filter { it.startsWith("updated") }
        .map { it.trim().split(" ")[1].toInt() }
        .toList()
        .sorted()
    val set = list.toSet()
    println("size: ${list.size}")
    println("repeats: ${list.size != set.size}")
    set.forEach {find -> if (list.filter { it == find }.size > 1) println("multiple $find") }
    (1..100).forEach { if(!set.contains(it)) println("no $it") }
}

val updates = """
    updated: 21
    not updated: 22
    updated: 23
    not updated: 24
    not updated: 25
    not updated: 26
    updated: 27
    updated: 28
    updated: 29
    updated: 30
    updated: 52
    not updated: 53
    updated: 54
    updated: 55
    not updated: 56
    updated: 57
    not updated: 58
    updated: 59
    not updated: 60
    updated: 61
    not updated: 62
    updated: 63
    not updated: 64
    not updated: 65
    updated: 66
    not updated: 67
    not updated: 68
    updated: 69
    not updated: 70
    not updated: 71
    not updated: 82
    updated: 83
    not updated: 84
    not updated: 85
    not updated: 86
    not updated: 87
    updated: 88
    not updated: 89
    not updated: 90
    not updated: 91
    not updated: 11
    not updated: 2
    updated: 12
    not updated: 3
    updated: 13
    updated: 14
    not updated: 4
    not updated: 5
    updated: 6
    not updated: 15
    not updated: 32
    updated: 33
    not updated: 34
    not updated: 22
    not updated: 24
    updated: 25
    updated: 26
    not updated: 38
    not updated: 39
    not updated: 41
    not updated: 70
    updated: 80
    not updated: 71
    not updated: 81
    updated: 82
    not updated: 92
    updated: 84
    not updated: 85
    not updated: 93
    updated: 86
    updated: 2
    not updated: 1
    not updated: 3
    updated: 4
    not updated: 17
    not updated: 5
    not updated: 8
    updated: 18
    not updated: 15
    updated: 10
    not updated: 49
    not updated: 38
    updated: 39
    updated: 41
    not updated: 70
    updated: 62
    updated: 71
    not updated: 81
    not updated: 65
    updated: 92
    not updated: 31
    updated: 49
    updated: 32
    not updated: 38
    updated: 34
    updated: 70
    updated: 22
    not updated: 58
    updated: 81
    not updated: 65
    updated: 31
    updated: 38
    not updated: 58
    not updated: 65
    not updated: 32
    not updated: 33
    not updated: 34
    updated: 35
    updated: 36
    updated: 37
    not updated: 38
    not updated: 39
    updated: 40
    not updated: 41
    not updated: 42
    not updated: 43
    updated: 44
    not updated: 45
    updated: 46
    not updated: 47
    not updated: 48
    not updated: 49
    not updated: 50
    not updated: 51
    not updated: 72
    updated: 73
    not updated: 74
    updated: 75
    updated: 76
    not updated: 77
    updated: 78
    updated: 79
    not updated: 80
    not updated: 81
    not updated: 92
    not updated: 93
    updated: 94
    not updated: 95
    not updated: 96
    not updated: 97
    updated: 98
    not updated: 99
    not updated: 100
    not updated: 1
    updated: 16
    updated: 7
    not updated: 17
    not updated: 8
    not updated: 18
    updated: 19
    updated: 9
    not updated: 10
    updated: 20
    not updated: 31
    updated: 42
    updated: 53
    not updated: 43
    not updated: 45
    updated: 56
    updated: 47
    not updated: 58
    not updated: 60
    not updated: 48
    not updated: 49
    updated: 50
    updated: 51
    not updated: 62
    updated: 64
    updated: 72
    not updated: 65
    updated: 74
    updated: 67
    updated: 68
    updated: 77
    updated: 87
    updated: 95
    updated: 89
    updated: 90
    updated: 96
    not updated: 97
    updated: 91
    not updated: 99
    updated: 100
    updated: 11
    not updated: 31
    not updated: 32
    not updated: 34
    updated: 43
    updated: 45
    not updated: 22
    updated: 24
    not updated: 58
    updated: 60
    updated: 48
    not updated: 85
    not updated: 93
    updated: 1
    updated: 97
    not updated: 3
    updated: 17
    not updated: 99
    not updated: 5
    updated: 8
    not updated: 15
    updated: 85
    updated: 93
    not updated: 3
    updated: 99
    updated: 5
    updated: 15
    not updated: 3
    updated: 58
    updated: 3
    updated: 65
""".trimIndent()