package mx.yair.discipulos_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var countryAdapter : CountryInfoRA

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setRecyclerView()

        Log.i("API url:", apiURL())

        val loadingText = findViewById<TextView>(R.id.loadingText)
        PovertyDataVolley(this, apiURL(), countryAdapter, loadingText).requestAPIData()
    }

    private fun setRecyclerView(){
        countries_recycler_view.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            countryAdapter = CountryInfoRA()
            adapter = countryAdapter
        }
    }

    private fun apiURL():String{
        val url = "https://api.worldbank.org/V2/country?format=json&per_page=50" // All countries
        //val url = "https://api.worldbank.org/V2/country?format=json&per_page=10" // Only first 10 countries
        return url
    }
}
