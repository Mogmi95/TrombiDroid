package apps.mogmi.fr.trombidroid.dashboard

import android.util.Log
import apps.mogmi.fr.trombidroid.data.Person
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DashboardPresenter : DashboardContract.Presenter {

    private var view : DashboardContract.View? = null

    val json = """
        [{
            "arrival": 1395270000,
            "surname": "O'Neil",
            "name": "Jack",
            "team_id": 2,
            "email": "oneil@sg1.com",
            "job": "Colonel",
            "birthday": 0,
            "login": "joneil",
            "id": 2,
            "picture": "/photo/joneil"
        }]
    """

    override fun registerView(view: DashboardContract.View) {
        this.view = view
    }

    public override fun requestUpdate() {
        val customType = object : TypeToken<List<Person>>() {}.type
        val persons = Gson().fromJson<List<Person>>(json, customType)
        Log.i("ParsingResult", persons?.toString() ?: "ERROR")

        view?.displayPersons(persons)
    }

}