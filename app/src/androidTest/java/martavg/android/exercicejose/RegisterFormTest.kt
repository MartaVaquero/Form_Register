package martavg.android.exercicejose

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.replaceText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import martavg.android.exercicejose.robots.MainRobot
import martavg.android.exercicejose.robots.RegisterFormRobot
import org.hamcrest.CoreMatchers.not
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegisterFormTest {
    @get:Rule
    val activityrule = ActivityTestRule(RegisterFormActivity::class.java)

    //Espresso Tests

    @Test
    fun registerButtonFuncionality(){
        onView(withHint("Nombre"))
                .check(matches(isDisplayed()))

        onView(withHint("Apellidos"))
                .check(matches(isDisplayed()))

        onView(withText("Registrado"))
                .check(matches(not(isDisplayed())))

        onView(withId(R.id.nameEditText))
                .perform(replaceText("Test"))

        onView(withId(R.id.surnameEditText))
                .perform(replaceText("Prueba"))

        onView(withId(R.id.emailEditText))
                .perform(replaceText("test.prueba@cabify.com"))

        onView(withId(R.id.passwordEditText))
                .perform(replaceText("12345"))

        onView(withId(R.id.btnRegister))
                .perform(click())

        onView(withText("Registrado"))
                .check(matches(isDisplayed()))
    }

    //Robot Tests

    @Test
    fun robotRegisterFuncionalityTest(){
        RegisterFormRobot.imputName2("Test")
                .imputSurname("Prueba")
                .imputEmail("test.prueba@cabify.com")
                .imputPassword("12345")
                .register()


    }

}