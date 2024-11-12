package ro.pub.cs.system.eim.practicaltest01var03

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PracticalTest03Var03SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var03_secondary)

        findViewById<Button>(R.id.registerButton).setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("result", "Correct")
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }

        findViewById<Button>(R.id.cancelButton).setOnClickListener {
            val resultIntent = Intent()
            resultIntent.putExtra("result", "Incorrect")
            setResult(Activity.RESULT_OK, resultIntent)
            finish()
        }
    }
}