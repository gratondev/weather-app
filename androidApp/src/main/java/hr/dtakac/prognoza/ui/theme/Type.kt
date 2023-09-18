package hr.dtakac.prognoza.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.sp
import hr.dtakac.prognoza.R

val Manrope = FontFamily(
    Font(R.font.manrope_extrabold, FontWeight.ExtraBold),
    Font(R.font.manrope_medium, FontWeight.Medium),
    Font(R.font.manrope_light, FontWeight.Light),
    Font(R.font.manrope_extralight, FontWeight.ExtraLight),
    Font(R.font.manrope_bold, FontWeight.Bold),
    Font(R.font.manrope_semibold, FontWeight.SemiBold)
)

@Immutable
data class Typography(
    val currentTemperature: TextStyle,
    val headlineSmall: TextStyle,
    val titleLarge: TextStyle,
    val subtitleLarge: TextStyle,
    val titleMedium: TextStyle,
    val subtitleMedium: TextStyle,
    val body: TextStyle,
    val bodySmall: TextStyle,
    val titleSmall: TextStyle,
    val label: TextStyle
) {
    companion object {
        // Despite what linter says, removing the PlatformTextStyle line still causes the text
        // to have excessive top padding which is most noticeable on very large text, such as
        // headlineLarge and headlineSmall
        @Suppress("DEPRECATION")
        fun get(): Typography = Typography(
            currentTemperature = TextStyle(
                fontFamily = Manrope,
                fontWeight = FontWeight.Bold,
                // Font size and letter spacing are dynamically determined
                lineHeightStyle = LineHeightStyle(
                    alignment = LineHeightStyle.Alignment.Proportional,
                    trim = LineHeightStyle.Trim.Both
                ),
                platformStyle = PlatformTextStyle(includeFontPadding = false)
            ),
            headlineSmall = TextStyle(
                fontFamily = Manrope,
                fontWeight = FontWeight.Bold,
                fontSize = 42.sp,
                letterSpacing = (-1.5).sp,
                lineHeightStyle = LineHeightStyle(
                    alignment = LineHeightStyle.Alignment.Proportional,
                    trim = LineHeightStyle.Trim.Both
                ),
                platformStyle = PlatformTextStyle(includeFontPadding = false)
            ),
            titleLarge = TextStyle(
                fontFamily = Manrope,
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp,
                letterSpacing = 0.sp,
            ),
            subtitleLarge = TextStyle(
                fontFamily = Manrope,
                fontWeight = FontWeight.Normal,
                fontSize = 22.sp,
                letterSpacing = 0.sp
            ),
            titleMedium = TextStyle(
                fontFamily = Manrope,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                letterSpacing = 0.25.sp
            ),
            subtitleMedium = TextStyle(
                fontFamily = Manrope,
                fontWeight = FontWeight.Normal,
                fontSize = 18.sp,
                letterSpacing = 0.25.sp
            ),
            titleSmall = TextStyle(
                fontFamily = Manrope,
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                letterSpacing = 0.25.sp
            ),
            body = TextStyle(
                fontFamily = Manrope,
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                letterSpacing = 0.sp
            ),
            bodySmall = TextStyle(
                fontFamily = Manrope,
                fontWeight = FontWeight.Normal,
                fontSize = 14.sp,
                letterSpacing = 0.sp
            ),
            label = TextStyle(
                fontFamily = Manrope,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                letterSpacing = 1.sp
            )
        )
    }
}