package hr.dtakac.prognoza.shared.domain

import hr.dtakac.prognoza.shared.entity.LengthUnit

class GetAllPrecipitationUnits internal constructor() {
    suspend operator fun invoke(): List<LengthUnit> = LengthUnit.values().toList()
}