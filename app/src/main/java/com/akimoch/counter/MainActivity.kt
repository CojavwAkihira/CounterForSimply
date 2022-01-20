package com.akimoch.counter

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.*
import androidx.appcompat.app.AlertDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import java.io.BufferedReader
import java.io.File

class MainActivity : AppCompatActivity() {

    private var data = CounterAndProbData()
    private var inc: Int = 1
    private var saveData: String = ""

    // counter / data = result (Integer)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val file = File(applicationContext.filesDir, "tmp.csv")
        if(!file.exists()) {
            this@MainActivity.openFileOutput("tmp.csv", Context.MODE_PRIVATE).use {
                it.write(saveData.toByteArray())
            }
        }

        display()
    }

    override fun onStart() {
        super.onStart()

        val file = File(applicationContext.filesDir, "tmp.csv")
        saveData = file.bufferedReader().use(BufferedReader::readText)
        if(saveData != "") {
            saveDataLoad(saveData)
        }
    }

    override fun onStop() {
        super.onStop()
        saveDataCreate()
        this@MainActivity.openFileOutput("tmp.csv", Context.MODE_PRIVATE).use {
            it.write(saveData.toByteArray())
        }
    }

    private fun saveDataCreate() {
        saveData = data.playedGames.toString() + "," +
                data.counter1.toString() + "," +
                data.counter2.toString() + "," +
                data.counter3.toString() + "," +
                data.counter4.toString() + "," +
                data.counter5.toString() + "," +
                data.counter6.toString() + "," +
                data.counter7.toString() + "," +
                data.counter8.toString() + "," +
                data.counter9.toString() + "," +
                data.counter10.toString() + "," +
                data.counter11.toString() + "," +
                data.counter12.toString() + "," +
                data.prob1.toString() + "," +
                data.prob2.toString() + "," +
                data.prob3.toString() + "," +
                data.prob4.toString() + "," +
                data.prob5.toString() + "," +
                data.prob6.toString() + "," +
                data.prob7.toString() + "," +
                data.prob8.toString() + "," +
                data.prob9.toString() + "," +
                data.prob10.toString() + "," +
                data.prob11.toString() + "," +
                data.prob12.toString()
    }

    private fun saveDataLoad(saveData: String) {
        val parseData = saveData.split(",")

        data.playedGames = parseData[0].toInt()
        data.counter1 = parseData[1].toInt()
        data.counter2 = parseData[2].toInt()
        data.counter3 = parseData[3].toInt()
        data.counter4 = parseData[4].toInt()
        data.counter5 = parseData[5].toInt()
        data.counter6 = parseData[6].toInt()
        data.counter7 = parseData[7].toInt()
        data.counter8 = parseData[8].toInt()
        data.counter9 = parseData[9].toInt()
        data.counter10 = parseData[10].toInt()
        data.counter11 = parseData[11].toInt()
        data.counter12 = parseData[12].toInt()

        data.prob1 = parseData[13].toDouble()
        data.prob2 = parseData[14].toDouble()
        data.prob3 = parseData[15].toDouble()
        data.prob4 = parseData[16].toDouble()
        data.prob5 = parseData[17].toDouble()
        data.prob6 = parseData[18].toDouble()
        data.prob7 = parseData[19].toDouble()
        data.prob8 = parseData[20].toDouble()
        data.prob9 = parseData[21].toDouble()
        data.prob10 = parseData[22].toDouble()
        data.prob11 = parseData[23].toDouble()
        data.prob12 = parseData[24].toDouble()

        val iButton: Button = findViewById(R.id.playedNumInputButton)
        iButton.text = data.playedGames.toString()

        display()
    }

    override fun onKeyDown(keyCode: Int, event : KeyEvent?): Boolean {
        when(keyCode) {
            KeyEvent.KEYCODE_1 -> {
                data.counter1+= inc
            }
            KeyEvent.KEYCODE_2 -> {
                data.counter2+= inc
            }
            KeyEvent.KEYCODE_3 -> {
                data.counter3+= inc
            }
            KeyEvent.KEYCODE_4 -> {
                data.counter4+= inc
            }
            KeyEvent.KEYCODE_5 -> {
                data.counter5+= inc
            }
            KeyEvent.KEYCODE_6 -> {
                data.counter6+= inc
            }
            KeyEvent.KEYCODE_7 -> {
                data.counter7+= inc
            }
            KeyEvent.KEYCODE_8 -> {
                data.counter8+= inc
            }
            KeyEvent.KEYCODE_9 -> {
                data.counter9+= inc
            }
            // * button
            17 -> {
                data.counter10+= inc
            }
            KeyEvent.KEYCODE_0 -> {
                data.counter11+= inc
            }
            // # button
            18 -> {
                data.counter12+= inc
            }
            // mail button
            131 -> {
                //data clear function
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("データクリア")
                    .setMessage("データをリセットしますか？")
                    .setPositiveButton("OK") { _, _ ->
                        // OK button pressed
                        reset()
                    }
                    .setNegativeButton("Cancel", null)
                    .show()
                    display()
            }
            // browser button
            132 -> {
                //toggle inc/dec function
                AlertDialog.Builder(this@MainActivity)
                    .setTitle("加算/減算反転")
                    .setMessage("カウントを反転させますか？")
                    .setPositiveButton("OK") { _, _ ->
                        // OK button pressed
                        inc = if(inc == 1) -1 else 1
                    }
                    .setNegativeButton("Cancel", null)
                    .show()
            }
            
            else -> {
                // Toast.makeText(this@MainActivity, keyCode.toString(), Toast.LENGTH_SHORT).show()
                return super.onKeyDown(keyCode, event)
            }
        }
        calculation()
        display()
        return true
    }

    private fun calculation() {
        if(data.playedGames != 0) {
            if(data.counter1 != 0) {
                data.prob1 = data.playedGames.toDouble() / data.counter1
            } else {
                data.prob1 = 0.000
            }
            if(data.counter2 != 0) {
                data.prob2 = data.playedGames.toDouble() / data.counter2
            } else {
                data.prob2 = 0.000
            }
            if(data.counter3 != 0) {
                data.prob3 = data.playedGames.toDouble() / data.counter3
            } else {
                data.prob3 = 0.000
            }
            if(data.counter4 != 0) {
                data.prob4 = data.playedGames.toDouble() / data.counter4
            } else {
                data.prob4 = 0.000
            }
            if(data.counter5 != 0) {
                data.prob5 = data.playedGames.toDouble() / data.counter5
            } else {
                data.prob5 = 0.000
            }
            if(data.counter6 != 0) {
                data.prob6 = data.playedGames.toDouble() / data.counter6
            } else {
                data.prob6 = 0.000
            }
            if(data.counter7 != 0) {
                data.prob7 = data.playedGames.toDouble() / data.counter7
            } else {
                data.prob7 = 0.000
            }
            if(data.counter8 != 0) {
                data.prob8 = data.playedGames.toDouble() / data.counter8
            } else {
                data.prob8 = 0.000
            }
            if(data.counter9 != 0) {
                data.prob9 = data.playedGames.toDouble() / data.counter9
            } else {
                data.prob9 = 0.000
            }
            if(data.counter10 != 0) {
                data.prob10 = data.playedGames.toDouble() / data.counter10
            } else {
                data.prob10 = 0.000
            }
            if(data.counter11 != 0) {
                data.prob11 = data.playedGames.toDouble() / data.counter11
            } else {
                data.prob11 = 0.000
            }
            if(data.counter12 != 0) {
                data.prob12 = data.playedGames.toDouble() / data.counter12
            } else {
                data.prob12 = 0.000
            }
        }
    }

    private fun Double?.formattedString(fractionDigits:Int, usesGroupingSeparator: Boolean): String{
        // nullの場合は空文字
        if(this == null) return ""
        var format = "%.${fractionDigits}f"
        if(usesGroupingSeparator){
            format = "%,.${fractionDigits}f"
        }
        return format.format(this)
    }

    private fun reset() {
        data = CounterAndProbData()

        val iButton: Button = findViewById(R.id.playedNumInputButton)
        iButton.text = data.playedGames.toString()

        display()
    }

    private fun display() {
        val vCounter1: TextView = findViewById(R.id.Counter1)
        val vCounter2: TextView = findViewById(R.id.Counter2)
        val vCounter3: TextView = findViewById(R.id.Counter3)
        val vCounter4: TextView = findViewById(R.id.Counter4)
        val vCounter5: TextView = findViewById(R.id.Counter5)
        val vCounter6: TextView = findViewById(R.id.Counter6)
        val vCounter7: TextView = findViewById(R.id.Counter7)
        val vCounter8: TextView = findViewById(R.id.Counter8)
        val vCounter9: TextView = findViewById(R.id.Counter9)
        val vCounter10: TextView = findViewById(R.id.Counter10)
        val vCounter11: TextView = findViewById(R.id.Counter11)
        val vCounter12: TextView = findViewById(R.id.Counter12)

        vCounter1.text = data.counter1.toString()
        vCounter2.text = data.counter2.toString()
        vCounter3.text = data.counter3.toString()
        vCounter4.text = data.counter4.toString()
        vCounter5.text = data.counter5.toString()
        vCounter6.text = data.counter6.toString()
        vCounter7.text = data.counter7.toString()
        vCounter8.text = data.counter8.toString()
        vCounter9.text = data.counter9.toString()
        vCounter10.text = data.counter10.toString()
        vCounter11.text = data.counter11.toString()
        vCounter12.text = data.counter12.toString()

        val vProb1: TextView = findViewById(R.id.Prob1)
        val vProb2: TextView = findViewById(R.id.Prob2)
        val vProb3: TextView = findViewById(R.id.Prob3)
        val vProb4: TextView = findViewById(R.id.Prob4)
        val vProb5: TextView = findViewById(R.id.Prob5)
        val vProb6: TextView = findViewById(R.id.Prob6)
        val vProb7: TextView = findViewById(R.id.Prob7)
        val vProb8: TextView = findViewById(R.id.Prob8)
        val vProb9: TextView = findViewById(R.id.Prob9)
        val vProb10: TextView = findViewById(R.id.Prob10)
        val vProb11: TextView = findViewById(R.id.Prob11)
        val vProb12: TextView = findViewById(R.id.Prob12)

        vProb1.text = data.prob1.formattedString(3, true)
        vProb2.text = data.prob2.formattedString(3, true)
        vProb3.text = data.prob3.formattedString(3, true)
        vProb4.text = data.prob4.formattedString(3, true)
        vProb5.text = data.prob5.formattedString(3, true)
        vProb6.text = data.prob6.formattedString(3, true)
        vProb7.text = data.prob7.formattedString(3, true)
        vProb8.text = data.prob8.formattedString(3, true)
        vProb9.text = data.prob9.formattedString(3, true)
        vProb10.text = data.prob10.formattedString(3, true)
        vProb11.text = data.prob11.formattedString(3, true)
        vProb12.text = data.prob12.formattedString(3, true)
    }

    fun playedNumInputButton(view: android.view.View) {
        val builder = MaterialAlertDialogBuilder(this@MainActivity)
        val contentLayout = layoutInflater.inflate(R.layout.popup_window, null)
        val etInput = contentLayout.findViewById<EditText>(R.id.inputNum)

        builder.setView(contentLayout)

        builder.setPositiveButton(R.string.okay) { _, _ ->
            data.playedGames = etInput.text.toString().toInt()
            findViewById<Button>(R.id.playedNumInputButton).text = data.playedGames.toString()
            calculation()
            display()
        }

        val dialog = builder.create()
        dialog.show()
    }
}