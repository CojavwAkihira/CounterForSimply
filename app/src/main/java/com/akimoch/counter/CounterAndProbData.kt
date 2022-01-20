package com.akimoch.counter

import com.opencsv.bean.CsvBindByPosition

data class CounterAndProbData(
    @CsvBindByPosition(position = 0)
    var playedGames: Int = 0,

    @CsvBindByPosition(position = 1)
    var counter1: Int = 0,

    @CsvBindByPosition(position = 2)
    var counter2: Int = 0,

    @CsvBindByPosition(position = 3)
    var counter3: Int = 0,

    @CsvBindByPosition(position = 4)
    var counter4: Int = 0,

    @CsvBindByPosition(position = 5)
    var counter5: Int = 0,

    @CsvBindByPosition(position = 6)
    var counter6: Int = 0,

    @CsvBindByPosition(position = 7)
    var counter7: Int = 0,

    @CsvBindByPosition(position = 8)
    var counter8: Int = 0,

    @CsvBindByPosition(position = 9)
    var counter9: Int = 0,

    @CsvBindByPosition(position = 10)
    var counter10: Int = 0,

    @CsvBindByPosition(position = 11)
    var counter11: Int = 0,

    @CsvBindByPosition(position = 12)
    var counter12: Int = 0,

    @CsvBindByPosition(position = 13)
    var prob1: Double = 0.000,

    @CsvBindByPosition(position = 14)
    var prob2: Double = 0.000,

    @CsvBindByPosition(position = 15)
    var prob3: Double = 0.000,

    @CsvBindByPosition(position = 16)
    var prob4: Double = 0.000,

    @CsvBindByPosition(position = 17)
    var prob5: Double = 0.000,

    @CsvBindByPosition(position = 18)
    var prob6: Double = 0.000,

    @CsvBindByPosition(position = 19)
    var prob7: Double = 0.000,

    @CsvBindByPosition(position = 20)
    var prob8: Double = 0.000,

    @CsvBindByPosition(position = 21)
    var prob9: Double = 0.000,

    @CsvBindByPosition(position = 22)
    var prob10: Double = 0.000,

    @CsvBindByPosition(position = 23)
    var prob11: Double = 0.000,

    @CsvBindByPosition(position = 24)
    var prob12: Double = 0.000
)
