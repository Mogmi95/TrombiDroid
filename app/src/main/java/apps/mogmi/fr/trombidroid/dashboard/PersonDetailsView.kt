package apps.mogmi.fr.trombidroid.dashboard

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import apps.mogmi.fr.trombidroid.R
import apps.mogmi.fr.trombidroid.data.Person
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.person_details_view.view.*
import kotlinx.android.synthetic.main.person_item_view.view.*

class PersonDetailsView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0,
        defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyle, defStyleRes) {

    var listener: Listener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.person_details_view, this)

        setOnClickListener {
            listener?.onQuitDetails()
        }
    }

    var viewModel: Person? = null
        set(value) {
            value?.let {
                Picasso.get().load(value.pictureUrl).into(person_details_view_avatar)
                person_details_view_name.text = value.name
            }
            field = value
        }

    interface Listener {

        /**
         * The user requested to exit the detailed view
         */
        fun onQuitDetails()
    }
}



