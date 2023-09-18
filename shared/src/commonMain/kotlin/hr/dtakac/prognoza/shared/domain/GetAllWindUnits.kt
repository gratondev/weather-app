package hr.dtakac.prognoza.shared.domain

import hr.dtakac.prognoza.shared.entity.SpeedUnit

class GetAllWindUnits internal constructor() {
    suspend operator fun invoke(): List<SpeedUnit> = SpeedUnit.values().toList()
}