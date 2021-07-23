package org.dripto.mfaapispring

fun main() {
    val list: List<Int> = nums.split("\n").toList()
        .map { it.toInt() }.sorted()
    val set = list.toSet()
    println("size: ${list.size}")
    println("repeats: ${list.size != set.size}")
    set.forEach {find -> if (list.filter { it == find }.size > 1) println("multiple $find") }
    (1..100).forEach { if(!set.contains(it)) println("no $it") }
}

val nums = """
    60
    61
    62
    63
    64
    3
    4
    5
    6
    69
    75
    76
    77
    78
    79
    95
    94
    14
    52
    53
    54
    55
    56
    57
    58
    59
    65
    66
    67
    68
    37
    80
    81
    82
    83
    84
    7
    8
    9
    10
    11
    12
    25
    26
    27
    28
    29
    30
    96
    97
    98
    99
    100
    1
    2
    41
    42
    43
    44
    45
    46
    38
    39
    40
    90
    91
    92
    93
    47
    31
    32
    33
    34
    35
    36
    13
    48
    49
    50
    51
    70
    71
    72
    73
    74
    15
    16
    17
    18
    19
    20
    21
    22
    23
    24
    85
    86
    87
    88
    89
    54
""".trimIndent()
