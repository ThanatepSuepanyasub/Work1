package com.example.work1

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var edit1 : EditText
    private lateinit var edit2 : EditText
    private lateinit var ans : TextView

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edit1 = findViewById(R.id.edit1)
        edit2 = findViewById(R.id.edit2)
        ans = findViewById(R.id.ans)


        // Set click listeners for operator buttons
        findViewById<Button>(R.id.b1).setOnClickListener { calculate('+') }
        findViewById<Button>(R.id.b2).setOnClickListener { calculate('-') }
        findViewById<Button>(R.id.b3).setOnClickListener { calculate('*') }
        findViewById<Button>(R.id.b4).setOnClickListener { calculate('/') }
        findViewById<Button>(R.id.b5).setOnClickListener { calculate('%') }
        findViewById<Button>(R.id.b6).setOnClickListener { clearInputs() }
    }


    private fun calculate(operator: Char) {
        val num1 = edit1.text.toString()
        val num2 = edit2.text.toString()

        if (num1.isBlank() || num2.isBlank()) {
            showToast("กรุณากรอกทั้งสองค่า")
            return
        }

        val operand1 = num1.toDouble()
        val operand2 = num2.toDouble()

        val result = when (operator) {
            '+' -> operand1 + operand2
            '-' -> operand1 - operand2
            '*' -> operand1 * operand2
            '/' -> {
                if (operand2 == 0.0) {
                    showToast("ห้ามหารด้วย 0")
                    return
                }
                operand1 / operand2
            }
            '%' -> {
                if (operand2 == 0.0) {
                    showToast("ห้ามหารด้วย 0")
                    return
                }
                operand1 % operand2
            }
            else -> {
                showToast("เครื่องหมายไม่ถูกต้อง")
                return
            }
        }

        ans.text = "$result"

    }

    private fun clearInputs() {
        edit1.text.clear()
        edit2.text.clear()
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}