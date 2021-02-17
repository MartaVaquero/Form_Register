package martavg.android.exercicejose

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.transition.Visibility
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.android.synthetic.main.activity_register.nameEditText

class RegisterFormActivity : AppCompatActivity() {

    private var passwordHasText = false
    private var nameHasText = false
    private var surnameHasText = false
    private var emailHasText = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        configureView()
        clearPasswordEditText()
        initView()
    }

    override fun onPause() {
        super.onPause()
        clearPasswordEditText()
    }

    private fun configureView(){
        btnRegister.setOnClickListener {
            resultTextView.visibility = View.VISIBLE
        }
    }

    private fun clearPasswordEditText(){
        passwordEditText.setText("")
        passwordEditText.hint = "contraseña"
    }

    private fun showRegisterButton(){
        btnRegister.isEnabled = passwordHasText && nameHasText && surnameHasText && emailHasText
    }

    private fun initView(){
        passwordEditText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s!=null && s.length > 0 ){
                    passwordHasText = true
                } else {
                    passwordHasText = false
                }
                showRegisterButton()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        nameEditText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s!=null && s.length > 0 ){
                    nameHasText = true
                } else {
                    nameHasText = false
                }
                showRegisterButton()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        surnameEditText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s!=null && s.length > 0 ){
                    surnameHasText = true
                } else {
                    surnameHasText = false
                }
                showRegisterButton()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        emailEditText.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (s!=null && s.length > 0 ){
                    emailHasText = true
                } else {
                    emailHasText = false
                }
                showRegisterButton()
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

    }

}