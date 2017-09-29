package com.marekmacko.kotlinapp.ui

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.marekmacko.kotlinapp.R
import com.marekmacko.kotlinapp.data.ui.Forecast
import com.marekmacko.kotlinapp.data.response.Temperature
import com.marekmacko.kotlinapp.util.loadFromUrl
import kotlinx.android.synthetic.main.fragment_daily_forecast.*


class DailyForecastFragment : Fragment() {

    companion object {
        private const val DAILY_FORECAST_KEY = "daily_forecast_key"

        fun newInstance(forecast: Forecast): DailyForecastFragment {
            val args = Bundle()
            args.putSerializable(DAILY_FORECAST_KEY, forecast)
            val dialog = DailyForecastFragment()
            dialog.arguments = args
            return dialog
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
            inflater.inflate(R.layout.fragment_daily_forecast, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val forecast = getForecastFromArgs()
        setupTitle(forecast.date)
        bindViewsWithForecast(forecast)
    }

    private fun getForecastFromArgs(): Forecast =
            arguments.getSerializable(DAILY_FORECAST_KEY) as Forecast

    private fun setupTitle(date: String) {
        activity.title = date
    }

    // TODO: make different model
    private fun bindViewsWithForecast(forecast: Forecast) = with(forecast) {
        iconView.loadFromUrl(iconUrl)
        descriptionView.text = description
        pressureValueView.text = ""
        humidityValueView.text = ""
//        bindTemperature(temp)
    }

    private fun bindTemperature(temp: Temperature) = with(temp) {
        tempDayValueView.text = day.toString()
        tempMorningValueView.text = morn.toString()
        tempEveningValueView.text = eve.toString()
        tempNightValueView.text = night.toString()
        tempMinValueView.text = min.toString()
        tempMaxValueView.text = max.toString()
    }
}
