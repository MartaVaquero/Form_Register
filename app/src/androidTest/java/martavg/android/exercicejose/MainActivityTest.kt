package martavg.android.exercicejose

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.schibsted.spain.barista.assertion.BaristaCheckedAssertions.assertChecked
import com.schibsted.spain.barista.assertion.BaristaHintAssertions.assertHint
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.schibsted.spain.barista.interaction.BaristaClickInteractions.clickOn
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import martavg.android.exercicejose.robots.MainRobot
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val activityrule = ActivityTestRule(MainActivity::class.java)

    //Espresso Tests

    @Test
    fun greetingButtonFuncionality(){
        Espresso.onView(ViewMatchers.withHint("Introduce aquí tu nombre!"))
                .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.nameEditText))
                .perform(ViewActions.replaceText("Prueba"))

        Espresso.onView(ViewMatchers.withId(R.id.greetingButton))
                .perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.greetingTextView))
                .check(ViewAssertions
                        .matches(ViewMatchers.withText("Hola Prueba")))

    }

    //RobotTest

    @Test
    fun robotGreetingTest(){
        MainRobot.imputName("Prueba")
                .greeting()
                .checkName("Prueba")
    }

    @Test
    fun robotClearTest(){
        MainRobot.imputName("Saludo")
                .greeting()
                .checkName("Saludo")
                .clearName()
                .checkClear()
    }

    //Acceptance Test
    @Test
    fun robotGoToRegisterTest(){
        MainRobot.goToRegister()
                .imputName2("Marta")
                .imputSurname("Vaquero")
                .imputEmail("marta.vaquero@cabify.com")
                .imputPassword("123456")
                .imputPhoneNumber("91234567890")
                .chooseSpinner()
                .materialCheckBox()
                .register()
    }

    @Test
    fun robotMainActivityTest(){
        MainRobot.imputName("Marta")
            .greeting()
            .checkName("Marta")
            .clearName()
            .checkClear()
    }

}