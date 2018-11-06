package apps.mogmi.fr.trombidroid.dashboard

import android.content.Context
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import android.widget.LinearLayout
import apps.mogmi.fr.trombidroid.R
import apps.mogmi.fr.trombidroid.R.id.dashboard_view_recycler_view
import apps.mogmi.fr.trombidroid.data.Person
import apps.mogmi.fr.trombidroid.personinfo.PersonInfoActivity
import kotlinx.android.synthetic.main.dashboard.view.*
import java.security.AccessController.getContext


class DashboardView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0,
        defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyle, defStyleRes), DashboardContract.View {


    private var adapter: DashboardAdapter
    private var presenter: DashboardPresenter

    init {
        LayoutInflater.from(getContext()).inflate(R.layout.dashboard, this, true);
        adapter = DashboardAdapter()

        dashboard_view_recycler_view.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = this@DashboardView.adapter
        }

        presenter = DashboardPresenter().apply {
            registerView(this@DashboardView)
        }

        adapter.listener = object : DashboardAdapter.Listener {
            override fun onPersonSelected(person: Person) {
                presenter.requestPersonDetails(person)
            }
        }

        presenter.requestUpdate()
    }

    override fun displayPersons(persons: List<Person>) {
        adapter.update(persons)
    }

    override fun displayPerson(person: Person) {
        PersonInfoActivity.startActivity(context, person.id)
    }
}