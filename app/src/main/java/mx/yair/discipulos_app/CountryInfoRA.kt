package mx.yair.discipulos_app

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.country_layout.view.*
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


class CountryInfoRA : RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    private  var countries: List<CountryData> = ArrayList()

    // Creates the layout
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return CountryViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.country_layout, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is CountryViewHolder -> {
                holder.bind(countries.get(position))
                holder.itemView.setOnClickListener {
                    val contexto = it.context
                    val intent = Intent(contexto, CountryInfoActivity::class.java)
                    intent.putExtra("country", countries[position])
                    contexto.startActivity(intent)
                }
            }
        }

    }

    fun setData(listCountries: List<CountryData>){
        countries = listCountries
        notifyDataSetChanged()
    }

    class CountryViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val name = itemView.countryName
        val region = itemView.region
        val image = itemView.countryImage
        var flagurl:String? = null
        fun bind(country: CountryData){
            name.text = country.countryName
            region.text = country.region
            flagurl = country.url
            Glide.with(itemView).load(flagurl).error(R.drawable.itesm_logo).apply(RequestOptions.overrideOf(200,200)).into(image)
        }
    }







}