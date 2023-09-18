package hr.dtakac.prognoza.presentation.forecast

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hr.dtakac.prognoza.shared.domain.GetForecast
import hr.dtakac.prognoza.shared.domain.GetForecastResult
import kotlinx.coroutines.*
import javax.inject.Inject

@HiltViewModel
class ForecastViewModel @Inject constructor(
    private val getForecast: GetForecast,
    private val mapper: ForecastUiMapper
) : ViewModel() {
    private val _state: MutableState<ForecastState> = mutableStateOf(ForecastState())
    val state: State<ForecastState> get() = _state

    fun getState() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            _state.value = when (val result = getForecast()) {
                is GetForecastResult.Success -> _state.value.copy(
                    forecast = mapper.mapToForecastUi(result),
                    error = null
                )
                is GetForecastResult.Empty -> _state.value.copy(
                    error = mapper.mapToError(result)
                )
            }
            _state.value = _state.value.copy(isLoading = false)
        }
    }
}