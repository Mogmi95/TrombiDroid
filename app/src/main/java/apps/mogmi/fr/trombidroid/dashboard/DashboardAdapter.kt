package apps.mogmi.fr.trombidroid.dashboard

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import apps.mogmi.fr.trombidroid.data.Person

class DashboardAdapter : RecyclerView.Adapter<DashboardAdapter.PersonHolder>() {

    private val persons: ArrayList<Person> = ArrayList()
    var listener: Listener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonHolder {
        val view = PersonItemView(parent.context).apply {
            layoutParams = RecyclerView.LayoutParams(
                    RecyclerView.LayoutParams.MATCH_PARENT,
                    RecyclerView.LayoutParams.WRAP_CONTENT
            )
        }
        view.listener = object: PersonItemView.Listener {
            override fun onPersonSelected(person: Person) {
                listener?.onPersonSelected(person)
            }
        }
        return PersonHolder(view)
    }

    override fun getItemCount(): Int {
        return persons.size
    }

    override fun onBindViewHolder(holder: PersonHolder, position: Int) {
        holder.view.viewModel = persons[position]
    }

    fun update(persons: List<Person>) {
        this.persons.clear()
        this.persons.addAll(persons)
        notifyDataSetChanged()
    }

    class PersonHolder(val view: PersonItemView) : RecyclerView.ViewHolder(view)

    interface Listener {

        /**
         * The user selected a [person]
         */
        fun onPersonSelected(person: Person)
    }
}