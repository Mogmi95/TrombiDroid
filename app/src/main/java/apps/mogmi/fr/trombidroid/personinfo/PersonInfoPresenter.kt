package apps.mogmi.fr.trombidroid.personinfo

import apps.mogmi.fr.trombidroid.data.Person

class PersonInfoPresenter : PersonInfoContract.Presenter {

    private var view : PersonInfoContract.View? = null

    override fun requestInfo(personId: Int) {

        val person = Person(
                0,
                "surname",
                "name",
                null,
                "email",
                "job",
                0,
                "login",
                personId,
                "/images/todo"
        )
        view?.displayPerson(person)
    }

    override fun registerView(view: PersonInfoContract.View) {
        this.view = view
    }

}