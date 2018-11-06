package apps.mogmi.fr.trombidroid.personinfo

import apps.mogmi.fr.trombidroid.dashboard.DashboardContract
import apps.mogmi.fr.trombidroid.data.Person

/**
 * Contract between the logic and the view of a person info
 */
class PersonInfoContract {

    /**
     * View
     */
    interface View {
        /**
         * Display information about a specific [person]
         */
        fun displayPerson(person: Person)
    }

    /**
     * Logic
     */
    interface Presenter {

        /**
         * Request data about the Person represented by [personId]
         */
        fun requestInfo(personId: Int)

        /**
         * Set [view] as the current view
         */
        fun registerView(view: PersonInfoContract.View)
    }
}