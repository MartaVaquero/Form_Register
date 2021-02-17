package martavg.android.exercicejose.robots

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.matcher.ViewMatchers
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import com.schibsted.spain.barista.interaction.BaristaSpinnerInteractions.clickSpinnerItem
import martavg.android.exercicejose.R
import martavg.android.exercicejose.R.id.surnameEditText

object RegisterFormRobot {

    fun imputName2(nombre:String) = apply{
        writeTo(R.id.nameEditText, nombre)
    }

    fun imputSurname(surname:String) = apply {
        writeTo(R.id.surnameEditText, surname)
    }

    fun imputEmail(email:String) = apply {
        writeTo(R.id.emailEditText, email)
    }

    fun imputPassword(password:String) = apply {
        writeTo(R.id.passwordEditText, password)
    }

    fun imputPhoneNumber(phone:String) = apply {
        writeTo(R.id.phoneEditText, phone)
    }

    fun chooseSpinner() = apply {
        clickSpinnerItem(R.id.cityEditText, 0)
    }

    fun materialCheckBox() = apply {
        clickOn(R.id.termsAndCondictionsCheckBox)
    }

    fun register() = apply {
        clickOn(R.id.btnRegister)
    }
}