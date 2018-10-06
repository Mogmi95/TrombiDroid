package apps.mogmi.fr.trombidroid.dashboard

import android.content.Context
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.support.v7.widget.RecyclerView
import apps.mogmi.fr.trombidroid.data.Person
import apps.mogmi.fr.trombidroid.R

class DashboardView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0,
        defStyleRes: Int = 0
) : LinearLayout(context, attrs, defStyle, defStyleRes), DashboardContract.View {

    private var recyclerView : RecyclerView
    private var adapter: DashboardAdapter
    private var presenter: DashboardPresenter

    init {
        LayoutInflater.from(getContext()).inflate(R.layout.dashboard, this, true);

        recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val manager = LinearLayoutManager(context)
        manager.orientation = VERTICAL
        recyclerView.layoutManager = manager

        adapter = DashboardAdapter()
        recyclerView.adapter = adapter

        presenter = DashboardPresenter()
        presenter.registerView(this)
        presenter.requestUpdate()
    }

    override fun displayPersons(persons: List<Person>) {
        adapter.update(persons)
    }
}