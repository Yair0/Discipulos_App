package mx.yair.discipulos_app

import android.content.Context
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray

class PovertyDataVolley(val context:Context, val url:String, val countryAdapter:CountryInfoRA, val loadingText:TextView){
    val queue = Volley.newRequestQueue(context)
    fun requestAPIData(){
        val countryList = ArrayList<CountryData>()

        Log.d("URL", url)
        val request = JsonArrayRequest(
            Request.Method.GET, url, null,
            Response.Listener<JSONArray> { response ->
                // Gets the part of the API response with the country data
                val countries = response.getJSONArray(1)

                for (i in 0 until countries.length()) {
                    val country = countries.getJSONObject(i)
                    val id = country.getString("id")
                    val countryName = country.getString("name")
                    val region = country.getJSONObject("region").getString("value")
                    val income = country.getJSONObject("incomeLevel").getString("value")
                    val info = "$id, $countryName, $region, $income"

                    // Objects with Aggregates in these values means it's a continent, not a country
                    // so it won't get added to the country list
                    if (region != "Aggregates" && income != "Aggregates") {
                        val countryObject = CountryData(countryName, income, region)
                        countryList.add(countryObject)
                    }
                }
                countryAdapter.setData(countryList)
                loadingText.setText("")
            },
            Response.ErrorListener {
                Log.e("Volley Error", it.toString())
                Toast.makeText(context, "That didn't work!" + it.toString(), Toast.LENGTH_SHORT).show()
            })

        queue.add(request)
    }
}