package apps.mogmi.fr.trombidroid.dashboard

import android.util.Log
import apps.mogmi.fr.trombidroid.data.Person
import apps.mogmi.fr.trombidroid.request.TrombiService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


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

    override fun requestUpdate() {
        val customType = object : TypeToken<List<Person>>() {}.type
        // val persons = Gson().fromJson<List<Person>>(json, customType)
        // view?.displayPersons(persons)

        val retrofit = Retrofit.Builder()
                .baseUrl("https://trombi.mogmi.fr/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(TrombiService::class.java)

        service.listPersons().enqueue(object: Callback<List<Person>> {
            override fun onFailure(call: Call<List<Person>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<Person>>, response: Response<List<Person>>) {
                val persons = response.body()

                Log.i("ParsingResult", persons?.toString() ?: "ERROR")
                view?.displayPersons(persons ?: listOf())
            }

        })
    }

    override fun requestPersonDetails(person: Person) {
        view?.displayPerson(person)
    }

}