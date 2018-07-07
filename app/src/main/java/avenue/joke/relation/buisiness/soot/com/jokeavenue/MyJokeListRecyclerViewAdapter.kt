package avenue.joke.relation.buisiness.soot.com.jokeavenue

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


import avenue.joke.relation.buisiness.soot.com.jokeavenue.JokeListFragment.OnListFragmentInteractionListener
import avenue.joke.relation.buisiness.soot.com.jokeavenue.dummy.DummyContent.DummyItem

class MyJokeListRecyclerViewAdapter(
        private val mValues: List<DummyItem>,
        private var expandHolderFlags: MutableList<Boolean>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<JokeViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    fun clearExpandHolderFlags() {
        for(i in expandHolderFlags.indices) {
            expandHolderFlags[i] = false
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        Log.v(10.toString(), "onCreateViewHolder")
        var layoutId: Int
        /*
        if(false) {
            layoutId = R.layout.viewholder_joke_collapse
        } else {
            layoutId = R.layout.viewholder_joke_expansion
        }
        */

        layoutId = R.layout.viewholder_joke_expansion

        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        var viewHolder = JokeViewHolder(view)

        view.setOnClickListener {
            //FIXME: ここに直接タップイベント内部の処理を書くべきではない（こいつの責務外)

            val pos = viewHolder.adapterPosition
            expandHolderFlags[pos] = !expandHolderFlags[pos]

            val longe = viewHolder.itemView.findViewById<TextView>(R.id.jokeTextView)
            val longeHeight = longe.height
            val longeMeasuredHeight = longe.measuredHeight
             //TODO: これは viewHolderクラスの担当だな
            if(expandHolderFlags[pos]) {
                val collapseAnimation = ResizeAnimation(longe,-400,500)
                collapseAnimation.duration = 300
                view.startAnimation(collapseAnimation)
            } else {
                val expandAnimation = ResizeAnimation(longe,400,150)
                expandAnimation.duration = 300
                view.startAnimation(expandAnimation)

            }
        }
        return viewHolder
    }

    override fun getItemViewType(position: Int): Int {
        return position % 2
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        Log.v(10.toString(), "onBindViewHolder")
    }

    override fun getItemCount(): Int = 10
}
