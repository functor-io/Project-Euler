package problems

import java.io.File

fun main() {
    val sample: MutableList<List<Int>> = mutableListOf()
    File("resources/Project-81.txt").forEachLine {
        val tmp = it
            .split(",")
            .map { value -> value.toInt() }
        sample.add(tmp)
    }

    val pathSums = MutableList(sample.size + 1){ MutableList(sample[0].size + 1){Integer.MAX_VALUE} }
    pathSums[sample.size - 1][sample[0].size - 1] = sample[sample.size - 1][sample[0].size - 1]

    var row = sample.size - 1
    while(row >= 0){
        var col = sample[0].size - 1
        while(col >= 0){
            if(pathSums[row][col] == Integer.MAX_VALUE) {
                val min = if(pathSums[row+1][col]<pathSums[row][col+1]) pathSums[row+1][col] else pathSums[row][col+1]
                pathSums[row][col] = sample[row][col] + min
            }
            col -= 1
        }
        row -= 1
    }
    println(pathSums[0][0])
}
