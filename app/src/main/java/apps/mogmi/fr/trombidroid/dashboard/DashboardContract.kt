package apps.mogmi.fr.trombidroid.dashboard

import apps.mogmi.fr.trombidroid.data.Person

/**
 * Contract between the logic and the view of the dashboard
 */
class DashboardContract {

    /**
     * The view part
     */
    interface View {

        /**
         * Display the list of [persons]
         */
        fun displayPersons(persons: List<Person>)

        /**
         * Display a specific [person]
         */
        fun displayPerson(person: Person)

    }

    /**
     * Logical part
     */
    interface Presenter {

        /**
         * Request new data
         */
        fun requestUpdate()

        /**
         * Request details about a specific [person]
         */
        fun requestPersonDetails(person: Person)

        /**
         * Set [view] as the current view
         */
        fun registerView(view: View)
    }
}