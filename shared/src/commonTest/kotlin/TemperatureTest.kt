import hr.dtakac.prognoza.shared.entity.Temperature
import hr.dtakac.prognoza.shared.entity.TemperatureUnit
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class TemperatureTest {
    private val tolerance = 0.0001

    @Test
    fun `converts to fahrenheit when celsius from -50 to 50`() {
        val celsiusToExpectedFahrenheit = mapOf(
            -50.0 to -58.0,
            -40.0 to -40.0,
            -30.0 to -22.0,
            -20.0 to -4.0,
            -10.0 to 14.0,
            0.0 to 32.0,
            10.0 to 50.0,
            20.0 to 68.0,
            30.0 to 86.0,
            40.0 to 104.0,
            50.0 to 122.0
        )
        celsiusToExpectedFahrenheit.keys
            .map { it to Temperature(it, TemperatureUnit.DEGREE_CELSIUS).fahrenheit }
            .forEach { (celsius, actualFahrenheit) ->
                assertEquals(
                    expected = celsiusToExpectedFahrenheit[celsius]!!,
                    actual = actualFahrenheit,
                    absoluteTolerance = tolerance
                )
            }
    }

    @Test
    fun `converts to celsius when fahrenheit from -58 to 122`() {
        val fahrenheitToExpectedCelsius = mapOf(
            -58.0 to -50.0,
            -40.0 to -40.0,
            -22.0 to -30.0,
            -4.0 to -20.0,
            14.0 to -10.0,
            32.0 to 0.0,
            50.0 to 10.0,
            68.0 to 20.0,
            86.0 to 30.0,
            104.0 to 40.0,
            122.0 to 50.0
        )
        fahrenheitToExpectedCelsius.keys
            .map { it to Temperature(it, TemperatureUnit.DEGREE_FAHRENHEIT).celsius }
            .forEach { (fahrenheit, actualCelsius) ->
                assertEquals(
                    expected = fahrenheitToExpectedCelsius[fahrenheit]!!,
                    actual = actualCelsius,
                    absoluteTolerance = tolerance
                )
            }
    }

    @Test
    fun `throws exception when celsius less than 0K`() {
        assertFailsWith<IllegalStateException> {
            Temperature(-280.0, TemperatureUnit.DEGREE_CELSIUS)
        }
    }
}