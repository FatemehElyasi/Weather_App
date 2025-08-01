package ir.fatemelyasii.weather.view.utils

import java.text.SimpleDateFormat
import java.util.Locale
import java.text.ParseException
import java.util.Date


object DateFormatter {

    private val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault())
    private val outputFormat = SimpleDateFormat("dd MMM yyyy", Locale("EN"))

    fun formatToReadableDate(dateString: String?): String {
        if (dateString.isNullOrEmpty()) return "Unknown date"
        return try {
            val date: Date = inputFormat.parse(dateString) ?: return dateString
            outputFormat.format(date)
        } catch (e: ParseException) {
            dateString
        }
    }
}

