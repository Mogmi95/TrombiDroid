package apps.mogmi.fr.trombidroid.dashboard

import apps.mogmi.fr.trombidroid.data.Person

class DashboardContract {

    interface View {
        fun displayPersons(persons: List<Person>)
    }

    interface Presenter {
        fun requestUpdate()
        fun registerView(view: View)
    }

}