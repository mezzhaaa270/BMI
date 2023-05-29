package com.example.bmi

import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.bmi.R

internal class LatBmi : AppCompatActivity() {
    var btncek: Button? = null
    var btnexit: Button? = null
    var btnclear: Button? = null
    var editnama: EditText? = null
    var edittinggi: EditText? = null
    var editberat: EditText? = null
    var hasilideal: EditText? = null
    var hasilket1: EditText? = null
    var hasilket2: EditText? = null
    var rdblaki: RadioButton? = null
    var rdbperempuan: RadioButton? = null
    var radioGroup: RadioGroup? = null
    var h1 = 0
    var ti = 0
    var bt = 0
    var temp = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btncek = findViewById<View>(R.id.btncek) as Button
        btnexit = findViewById<View>(R.id.btnexit) as Button
        editnama = findViewById<View>(R.id.editnama) as EditText
        edittinggi = findViewById<View>(R.id.edittinggi) as EditText
        editberat = findViewById<View>(R.id.editberat) as EditText
        hasilideal = findViewById<View>(R.id.hasilideal) as EditText
        hasilket1 = findViewById<View>(R.id.hasilket1) as EditText
        hasilket2 = findViewById<View>(R.id.hasilket2) as EditText
        rdblaki = findViewById<View>(R.id.rdbLaki) as RadioButton
        rdbperempuan = findViewById<View>(R.id.rdbPerempuan) as RadioButton
        btnclear = findViewById<View>(R.id.btnclear) as Button
        radioGroup = findViewById<View>(R.id.radioGroup) as RadioGroup
        btncek!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                proses()
            }

            private fun proses() {
                val ti = edittinggi!!.text.toString().toInt()
                val bt = editberat!!.text.toString().toInt()
                if (rdblaki!!.isSelected) {
                    h1 = ti - 100
                } else if (rdbperempuan!!.isSelected) {
                    h1 = ti - 104
                }
                temp = Integer.toString(h1)
                if (h1 < bt) {
                    hasilideal!!.setText(temp)
                    hasilket1!!.setText("Maaf " + editnama!!.text + " ,Sepertinya anda Overweight:( ")
                    hasilket2!!.setText("Banyaklah berolahraga dan hindari makanan berkolesterol")
                } else if (h1 > bt) {
                    hasilideal!!.setText(temp)
                    hasilket1!!.setText("Maaf " + editnama!!.text + " , Sepertinya anda Underweight:( ")
                    hasilket2!!.setText("Banyaklah mengkonsumsi makanan yang berkarbohidrat")
                } else {
                    hasilideal!!.setText(temp)
                    hasilket1!!.setText("Hallo " + editnama!!.text + " ,Berat badan anda sudah ideal:) ")
                    hasilket2!!.setText("Lanjutkan pola makan teratur dan gaya hidup sehat :) ")
                }
            }
        })
        btnexit!!.setOnClickListener { System.exit(0) }
        btnclear!!.setOnClickListener {
            editnama!!.setText("")
            editberat!!.setText("")
            edittinggi!!.setText("")
            hasilideal!!.setText("")
            hasilket1!!.setText("")
            hasilket2!!.setText("")
            radioGroup!!.clearCheck()
        }
    }
}