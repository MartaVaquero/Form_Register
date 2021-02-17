package martavg.android.exercicejose

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        clearNameText()
    }

    override fun onPause() {
        super.onPause()
        clearNameText()
    }


    private fun greeting() {
        val name = nameEditText.text.toString()
        greetingTextView.text = "Hola $name"
    }

    private fun clearNameText(){
        nameEditText.setText("")
        nameEditText.hint = "Introduce aquí tu nombre!"
        greetingTextView.setText("")
        greetingTextView.hint = "Hola"
    }

    private fun initView(){
        greetingButton.setOnClickListener {
            greeting()
        }
        clearButton.setOnClickListener {
            clearNameText()
        }
        registerButton.setOnClickListener {
            goToRegisterActivity()
        }
        nameEditText.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                if (s!=null && s.length > 0 ){
                    greetingButton.isEnabled = true
                } else {
                    greetingButton.isEnabled = false
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }


    private fun goToRegisterActivity() {
        val registerActivityIntent = Intent(this, RegisterFormActivity::class.java)
        startActivity(registerActivityIntent)
    }

}



