package apps.mogmi.fr.trombidroid.dashboard

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import apps.mogmi.fr.trombidroid.R
import apps.mogmi.fr.trombidroid.data.Person
import kotlinx.android.synthetic.main.dashboard.view.*


class DashboardView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0,
        defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes), DashboardContract.View {

    private var adapter: DashboardAdapter
    private var presenter: DashboardPresenter

    init {
        LayoutInflater.from(getContext()).inflate(R.layout.dashboard, this, true);
        adapter = DashboardAdapter()

        dashboard_view_recycler_view.apply {
            layoutManager = LinearLayoutManager(context).apply { orientation = VERTICAL }
            adapter = this@DashboardView.adapter
        }

        presenter = DashboardPresenter()
        presenter.registerView(this)
        presenter.requestUpdate()
    }

    override fun displayPersons(persons: List<Person>) {
        adapter.update(persons)
    }
}