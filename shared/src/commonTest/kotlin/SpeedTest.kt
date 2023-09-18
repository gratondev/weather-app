import hr.dtakac.prognoza.shared.entity.BeaufortScale
import hr.dtakac.prognoza.shared.entity.Speed
import hr.dtakac.prognoza.shared.entity.SpeedUnit
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SpeedTest { // Not Ookla ;)
    @Test
    fun `throws exception when less than 0`() {
        assertFailsWith<IllegalStateException> {
            Speed(-20.0, SpeedUnit.METRE_PER_SECOND)
        }
    }

    @Test
    fun `converts meters per second to others`() {
        val speed = Speed(2.0, SpeedUnit.METRE_PER_SECOND)
        assertSpeedsAreAsExpected(
            speed = speed,
            expectedMps = 2.0,
            expectedKmh = 7.2,
            expectedMph = 4.4738,
            expectedBeaufort = BeaufortScale.LIGHT_BREEZE,
            expectedKt = 3.8876
        )
    }

    @Test
    fun `converts miles per hour to others`() {
        val speed = Speed(2.0, SpeedUnit.MILE_PER_HOUR)
        assertSpeedsAreAsExpected(
            speed = speed,
            expectedMps = 0.8940,
            expectedKmh = 3.2187,
            expectedMph = 2.0,
            expectedBeaufort = BeaufortScale.LIGHT_AIR,
            expectedKt = 1.7380
        )
    }

    @Test
    fun `converts kilometers per hour to others`() {
        val speed = Speed(2.0, SpeedUnit.KILOMETRE_PER_HOUR)
        assertSpeedsAreAsExpected(
            speed = speed,
            expectedMps = 0.5556,
            expectedKmh = 2.0,
            expectedMph = 1.2427,
            expectedBeaufort = BeaufortScale.LIGHT_AIR,
            expectedKt = 1.0799
        )
    }

    @Test
    fun `converts knots to others`() {
        val speed = Speed(2.0, SpeedUnit.KNOT)
        assertSpeedsAreAsExpected(
            speed = speed,
            expectedMps = 1.0289,
            expectedKmh = 3.7040,
            expectedMph = 2.3016,
            expectedBeaufort = BeaufortScale.LIGHT_AIR,
            expectedKt = 2.0
        )
    }

    private fun assertSpeedsAreAsExpected(
        speed: Speed,
        expectedMps: Double,
        expectedKmh: Double,
        expectedMph: Double,
        expectedKt: Double,
        expectedBeaufort: BeaufortScale
    ) {
        val tolerance = 0.0001
        assertEquals(
            expected = expectedKt,
            actual = speed.knot,
            absoluteTolerance = tolerance
        )
        assertEquals(
            expected = expectedMph,
            actual = speed.milePerHour,
            absoluteTolerance = tolerance
        )
        assertEquals(
            expected = expectedMps,
            actual = speed.metrePerSecond,
            absoluteTolerance = tolerance
        )
        assertEquals(
            expected = expectedKmh,
            actual = speed.kilometrePerHour,
            absoluteTolerance = tolerance
        )
        assertEquals(
            expected = expectedBeaufort,
            actual = speed.beaufortScale
        )
    }
}