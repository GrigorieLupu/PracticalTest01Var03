package ro.pub.cs.systems.eim.practicaltest01var03

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var03MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_main)

        val firstNumberEditText = findViewById<EditText>(R.id.firstNumber)
        val secondNumberEditText = findViewById<EditText>(R.id.secondNumber)
        val resultMessageTextView = findViewById<TextView>(R.id.resultMessage)
        val addButton = findViewById<Button>(R.id.addButton)
        val subtractButton = findViewById<Button>(R.id.subtractButton)

        addButton.setOnClickListener {
            val firstNumber = firstNumberEditText.text.toString().toIntOrNull()
            val secondNumber = secondNumberEditText.text.toString().toIntOrNull()
            if (firstNumber != null && secondNumber != null) {
                val result = firstNumber + secondNumber
                resultMessageTextView.text = "Result: $result"
            } else {
                resultMessageTextView.text = "Please enter valid numbers"
            }
        }

        subtractButton.setOnClickListener {
            val firstNumber = firstNumberEditText.text.toString().toIntOrNull()
            val secondNumber = secondNumberEditText.text.toString().toIntOrNull()
            if (firstNumber != null && secondNumber != null) {
                val result = firstNumber - secondNumber
                resultMessageTextView.text = "Result: $result"
            } else {
                resultMessageTextView.text = "Please enter valid numbers"
            }
        }
    }
}