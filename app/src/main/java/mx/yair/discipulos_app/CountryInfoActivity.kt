package mx.yair.discipulos_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_country_info.*


class CountryInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_country_info)

        val country = intent.getSerializableExtra("country") as? CountryData
        countryName.text = country!!.countryName
        income.text = country!!.income

        if (country!!.income == "Low income"){
            incomeImageView.setImageResource(R.drawable.sad)

        }else if (country!!.income == "High income"){
            incomeImageView.setImageResource(R.drawable.happy)
        }

    }
}
