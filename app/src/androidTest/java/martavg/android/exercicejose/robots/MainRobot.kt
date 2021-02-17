package martavg.android.exercicejose.robots

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.longClickOn
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import kotlinx.android.synthetic.main.activity_main.*
import martavg.android.exercicejose.R
import org.hamcrest.CoreMatchers.not

object MainRobot {

    fun imputName(nombre:String) = apply{
        writeTo(R.id.nameEditText, nombre)
    }

    fun greeting() = apply{
        assertDisplayed(R.id.greetingButton, "Saludar")
        clickOn(R.id.greetingButton)
    }

    fun clearName() = apply{
        clickOn(R.id.clearButton)
    }

    fun checkClear() = apply{
        assertDisplayed(R.id.greetingTextView, "Hola")
    }

    fun checkName(name:String) = apply{
        assertDisplayed("Hola $name")
    }

    fun goToRegister() : RegisterFormRobot {
        clickOn(R.id.registerButton)
        return RegisterFormRobot
    }

}