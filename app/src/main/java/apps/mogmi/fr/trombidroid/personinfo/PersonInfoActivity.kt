package apps.mogmi.fr.trombidroid.personinfo

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import apps.mogmi.fr.trombidroid.R
import apps.mogmi.fr.trombidroid.dashboard.PersonDetailsView
import apps.mogmi.fr.trombidroid.data.Person
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_person_info.*
import java.util.*
import apps.mogmi.fr.trombidroid.MainActivity
import android.content.Intent
import android.util.AttributeSet
import android.view.View
import java.security.InvalidParameterException


public class PersonInfoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PERSON_ID = "EXTRA_PERSON_ID"

        /**
         * Starts an Activity using the [context] that will display information about a person
         * identified by its [personId],
         */
        public fun startActivity(context: Context,
                                 personId: Int) {
            val intent = Intent(context, PersonInfoActivity::class.java)
            intent.putExtra(EXTRA_PERSON_ID, personId)
            context.startActivity(intent)
        }
    }

    private val internalView: PersonInfoContract.View = object : PersonInfoContract.View {
        override fun displayPerson(person: Person) {
            activity_person_info_name.text = person.name
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val personId = intent.getIntExtra(EXTRA_PERSON_ID, -1)
        if (personId < 0) {
            throw InvalidParameterException("Please use the startActivity pattern")
        }

        setContentView(R.layout.activity_person_info)

        val presenter: PersonInfoContract.Presenter = PersonInfoPresenter()
        presenter.registerView(internalView)
        presenter.requestInfo(personId)

    }
}
