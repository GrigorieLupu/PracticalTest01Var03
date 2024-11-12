package ro.pub.cs.system.eim.practicaltest01var03

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var03MainActivity : AppCompatActivity() {

    private lateinit var editTextNumber1: EditText
    private lateinit var editTextNumber2: EditText
    private lateinit var textViewMessage: TextView
    private val REQUEST_CODE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.acitivity_practical_test01_var03_main)

        // Referinte la elementele din interfata
        editTextNumber1 = findViewById(R.id.editTextNumber1)
        editTextNumber2 = findViewById(R.id.editTextNumber2)
        val buttonAdd = findViewById<Button>(R.id.buttonAdd)
        val buttonSubtract = findViewById<Button>(R.id.buttonSubtract)
        textViewMessage = findViewById(R.id.textViewMessage)
        val buttonChangeActivity = findViewById<Button>(R.id.buttonChangeActivity)
        val buttonInvokeApp = findViewById<Button>(R.id.buttonInvokeApp)

        // Functia pentru operatia de adunare
        buttonAdd.setOnClickListener {
            val num1 = editTextNumber1.text.toString().toIntOrNull()
            val num2 = editTextNumber2.text.toString().toIntOrNull()

            if (num1 != null && num2 != null) {
                val result = num1 + num2
                textViewMessage.text = "Rezultatul adunării este: $result"
            } else {
                textViewMessage.text = "Introduceti numere valide in ambele campuri!"
            }
        }

        // Functia pentru operatia de scadere
        buttonSubtract.setOnClickListener {
            val num1 = editTextNumber1.text.toString().toIntOrNull()
            val num2 = editTextNumber2.text.toString().toIntOrNull()

            if (num1 != null && num2 != null) {
                val result = num1 - num2
                textViewMessage.text = "Rezultatul scăderii este: $result"
            } else {
                textViewMessage.text = "Introduceti numere valide in ambele campuri!"
            }
        }

        // Functia pentru schimbarea activitatii
        buttonChangeActivity.setOnClickListener {
            val intent = Intent(this, PracticalTest03Var03SecondaryActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

        // Functia pentru invocarea altei aplicatii
        buttonInvokeApp.setOnClickListener {
            val intent = Intent("com.example.otherapp.ACTION")
            startActivityForResult(intent, REQUEST_CODE)
        }

        // Restore the state if available
        if (savedInstanceState != null) {
            editTextNumber1.setText(savedInstanceState.getString("editTextNumber1"))
            editTextNumber2.setText(savedInstanceState.getString("editTextNumber2"))
            textViewMessage.text = savedInstanceState.getString("textViewMessage")
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("editTextNumber1", editTextNumber1.text.toString())
        outState.putString("editTextNumber2", editTextNumber2.text.toString())
        outState.putString("textViewMessage", textViewMessage.text.toString())
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        editTextNumber1.setText(savedInstanceState.getString("editTextNumber1"))
        editTextNumber2.setText(savedInstanceState.getString("editTextNumber2"))
        textViewMessage.text = savedInstanceState.getString("textViewMessage")
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val result = data?.getStringExtra("result")
            Toast.makeText(this, "Result: $result", Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        val intent = Intent(this, PracticalTest01Var03Service::class.java)
        stopService(intent)
        super.onDestroy()
    }



}