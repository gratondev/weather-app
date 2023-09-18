# Changelog
All notable changes to the Android app will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Backlog]
### Fixed
- Widget text reacts to system dark/light theme on <= Android 11
### Added
- iOS support

## [3.5.0] - 2023-05-30
### Added
Huge thank you to everyone who contributed translations and to @ryder203 for putting the app on Crowdin! If there are any translation issues, please raise them on Crowdin. There's a link in the project README.
- Chinese Simplified
- Chinese Traditional
- Czech
- Danish
- Dutch
- Finnish
- French
- Greek
- Hungarian
- Italian
- Japanese
- Norwegian
- Polish
- Portuguese
- Portuguese, Brazilian
- Romanian
- Spanish
- Swedish
- Turkish
- Ukranian

## [3.4.1] - 2023-02-26
### Fixed
- System back button closes app instead of drawer 
- Russian translations
- German translations

## [3.4.0] - 2023-02-25
### Added
- German translations
- Russian translations

## [3.3.0] - 2023-01-01
### Changed
- Shorter weather condition descriptions
### Added 
- Open-Meteo weather data provider
- Separate credit and licenses screen
- Data provider footers when searching places and displaying forecast
### Fixed
- Widget sharp corners on <= Android 11

## [3.2.1] - 2022-12-20
### Changed
- Places search bar underline is in text color when idle and primary with track when loading

## [3.2.0] - 2022-12-20
### Note
- For the widget changes to apply, you may need to remove and add them again
### Added
- Ability to delete saved places
### Fixed
- Widget crashing due to missing isNightModeActive
- Widget only clickable on edges
- Widget hours clipped
- Widget not expanding to 5 cells
### Changed
- Tiny widget displays temp and icon instead of place
- Small widget tweaked dimensions (slight reduction)
- More vibrant app colors thanks to Material You

## [3.1.0] - 2022-12-09
### Added
- Option to determine mood from device wallpaper on Android 12+
### Fixed
- Current temperature too big on some devices
- Coming day background flashing on mood and theme change
### Changed
- Reduce weather icon sizes
- Manually create dark weather icon SVGs from yr.no default ones
- Update SVG -> PNG conversion scripts
- Optimize app color changes
- Snow is near-white in dark mode

## [3.0.1] - 2022-12-04
### Changed
- Widget data refreshes more frugally than main screen
- Reduce current temperature size
- High and low temp separated by /
- Čvorovi -> Čvor

## [3.0.0] - 2022-12-01
### Note
- Uninstall previous version before installing this one
### Changed
- Make app mood a business rule
- Allow external feels like and mood
- Measure pressure in millibar and inches of mercury
- Feels like calculated by wind chill
- Refactored to Kotlin Multiplatform Mobile
- Coming item expands to card
- Coming item has morning, afternoon, evening and night icons
- Add dark mode icons
- Better app icon
### Fixed
- Hourly and coming data cells wider than they need to be
- Current hour pairs too close together
- Inconsistent spacing between hour and coming data columns
- Forecast not scrolling in horizontal orientation
- Device default theme changes to one from settings on first start
- Wind speed not hiding when 0
- Feels like temperature always same as air temperature
- Long time format (like 2 Uhr PM in German)
### Added
- Unit conversion tests

## [2.2.2] - 2022-11-06
### Fixed
- Forecast not updating to show the current hour when offline

## [2.2.1] - 2022-11-5
### Added
- This changelog :)
### Changed
- Fixed forecast not updating after some time

## [2.2.0] - 2022-11-4
### Note
- Uninstall the app before installing this update. This release migrated to 
an entirely new way of storing data.
### Changed
- Main description and precipitation now have same text style
- Unify space-dot-space format of descriptive text with a value for all languages
- Refactor settings UI code to use a list of settings items
- Replace Retrofit with ktor-client
- Replace Room with SQLDelight
- Make all modules other than app pure Kotlin/JVM modules
- Fix temperatures being displayed as -0
- Fix precipitation being displayed as 0 in or 0 cm, it now gets omitted if 0
- When no precipitation, expand description fully
- Update libraries
- Round knots to nearest integer
- Reduce widget padding