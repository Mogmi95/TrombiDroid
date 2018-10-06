package apps.mogmi.fr.trombidroid.dashboard

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import apps.mogmi.fr.trombidroid.data.Person
import apps.mogmi.fr.trombidroid.R

class DashboardAdapter : RecyclerView.Adapter<DashboardAdapter.PersonHolder>() {

    private val persons: ArrayList<Person> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dashboard, parent, false)
        return PersonHolder(view)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        holder.textView.text = persons[position].name
    }

    public fun update(persons: List<Person>) {
        this.persons.clear()
        this.persons.addAll(persons)
        notifyDataSetChanged()
    }

    class PersonHolder(val view: View) : RecyclerView.ViewHolder(view) {

        val textView: TextView = view.findViewById<TextView>(R.id.item_dashboard_name)
    }
}