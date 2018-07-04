package avenue.joke.relation.buisiness.soot.com.jokeavenue

import android.animation.AnimatorInflater
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


import avenue.joke.relation.buisiness.soot.com.jokeavenue.JokeListFragment.OnListFragmentInteractionListener
import avenue.joke.relation.buisiness.soot.com.jokeavenue.dummy.DummyContent.DummyItem

class MyJokeListRecyclerViewAdapter(
        private val mValues: List<DummyItem>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<JokeViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    private var hogei = false
    private var hogeiHeight = 0

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as DummyItem
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
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

        view.setOnClickListener {
            //FIXME: ここに直接タップイベント内部の処理を書くべきではない（こいつの責務外)
            Log.v(10.toString(), "clicked")
            hogei = !hogei

             //TODO: これは viewHolderクラスの担当だな
            if(hogei) {
                val collapseAnimation = ResizeAnimation(view,-1300,hogeiHeight)
                collapseAnimation.duration = 300
                view.startAnimation(collapseAnimation)
            } else {
                val expandAnimation = ResizeAnimation(view,1300,hogeiHeight)
                expandAnimation.duration = 300
                view.startAnimation(expandAnimation)

            }
        }
        return JokeViewHolder(view)
    }

    override fun getItemViewType(position: Int): Int {
        return position % 2
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        Log.v(10.toString(), "onBindViewHolder")
        val aaa = holder.itemView.measuredHeight
        val bbb = holder.itemView.height
        val ccc = holder.itemView.measuredHeightAndState
    }

    override fun getItemCount(): Int = 1
}
