package apps.mogmi.fr.trombidroid.dashboard

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.widget.FrameLayout
import apps.mogmi.fr.trombidroid.R
import apps.mogmi.fr.trombidroid.R.id.person_item_view_avatar
import apps.mogmi.fr.trombidroid.R.id.person_item_view_name
import apps.mogmi.fr.trombidroid.data.Person
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.person_item_view.view.*

class PersonItemView @JvmOverloads constructor(
        context: Context,
        attrs: AttributeSet? = null,
        defStyle: Int = 0,
        defStyleRes: Int = 0
) : FrameLayout(context, attrs, defStyle, defStyleRes) {

    var listener: Listener? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.person_item_view, this)

        setOnClickListener {
            viewModel?.let { listener?.onPersonSelected(it) }
        }
    }

    var viewModel: Person? = null
        set(value) {
            value?.let {
                Picasso.get().load(value.pictureUrl).into(person_item_view_avatar)
                person_item_view_name.text = value.name
            }
            field = value
        }

    interface Listener {

        /**
         * The user selected a [person]
         */
        fun onPersonSelected(person: Person)
    }
}



