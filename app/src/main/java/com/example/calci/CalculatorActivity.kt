package com.example.calci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.ExpressionBuilder


class CalculatorActivity : AppCompatActivity() {

    var exp: String = ""
    var res: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        val expr = findViewById<TextView>(R.id.expression)
        val result = findViewById<TextView>(R.id.result)
        val b_0 = findViewById<Button>(R.id.button0)
        b_0.setOnClickListener {
            appendToExp(it,'0')
        }

        val b_1 = findViewById<Button>(R.id.button1)
        b_1.setOnClickListener {
            appendToExp(it,'1')
        }

        val b_2 = findViewById<Button>(R.id.button2)
        b_2.setOnClickListener {
            appendToExp(it,'2')
        }

        val b_3 = findViewById<Button>(R.id.button3)
        b_3.setOnClickListener {
            appendToExp(it,'3')
        }

        val b_4 = findViewById<Button>(R.id.button4)
        b_4.setOnClickListener {
            appendToExp(it,'4')
        }
        val b_5 = findViewById<Button>(R.id.button5)
        b_5.setOnClickListener {
            appendToExp(it,'5')
        }
        val b_6 = findViewById<Button>(R.id.button6)
        b_6.setOnClickListener {
            appendToExp(it,'6')
        }
        val b_7 = findViewById<Button>(R.id.button7)
        b_7.setOnClickListener {
            appendToExp(it,'7')
        }
        val b_8 = findViewById<Button>(R.id.button8)
        b_8.setOnClickListener {
            appendToExp(it,'8')
        }
        val b_9 = findViewById<Button>(R.id.button9)
        b_9.setOnClickListener {
            appendToExp(it,'9')
        }
        val b_clr = findViewById<Button>(R.id.button_c)
        b_clr.setOnClickListener {
            exp = ""
            res = ""
            expr.setText(exp)
            result.setText(res)
        }
        val b_po = findViewById<Button>(R.id.button_po)
        b_po.setOnClickListener {
            appendToExp(it,'(')
        }
        val b_pc = findViewById<Button>(R.id.button_pc)
        b_pc.setOnClickListener {
            appendToExp(it,')')
        }
        val b_back = findViewById<Button>(R.id.button_b)
        b_back.setOnClickListener {
            val expr = findViewById<TextView>(R.id.expression)
            exp = exp.dropLast(1)
            expr.setText(exp)
        }
        val b_add = findViewById<Button>(R.id.button_a)
        b_add.setOnClickListener {
            appendToExp(it,'+')
        }
        val b_sub = findViewById<Button>(R.id.button_s)
        b_sub.setOnClickListener {
            appendToExp(it,'-')
        }
        val b_mul = findViewById<Button>(R.id.button_m)
        b_mul.setOnClickListener {
            appendToExp(it,'*')
        }
        val b_div = findViewById<Button>(R.id.button_d)
        b_div.setOnClickListener {
            appendToExp(it,'/')
        }
        val b_pow = findViewById<Button>(R.id.button_pw)
        b_pow.setOnClickListener {
            appendToExp(it,'^')
        }
        val b_eq = findViewById<Button>(R.id.button_eq)
        b_eq.setOnClickListener {
            try {
                val expression = ExpressionBuilder(exp).build()
                val answer = expression.evaluate()
                result.setText(answer.toString())
            } catch(e: Exception) {
                Toast.makeText(this, "something is wrong, please recheck", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun appendToExp(view: View, c: Char ) {
        val expr = findViewById<TextView>(R.id.expression)
        exp = "$exp$c"
        expr.setText(exp)
    }
}