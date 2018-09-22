package avenue.joke.relation.buisiness.soot.com.jokeavenue

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import avenue.joke.relation.buisiness.soot.com.jokeavenue.JokeAvenueRealm.JAJokeObject
import avenue.joke.relation.buisiness.soot.com.jokeavenue.JokeListFragment.OnListFragmentInteractionListener

class MyJokeListRecyclerViewAdapter(
         var jokeLists: List<JAJokeObject>,
         var expandHolderFlags: BooleanArray,
         val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<JokeViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            //nop
        }
    }

    fun clearExpandHolderFlags() {
        for(i in expandHolderFlags.indices) {
            expandHolderFlags[i] = false
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        var layoutId: Int

        layoutId = R.layout.viewholder_joke_contents

        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        var viewHolder = JokeViewHolder(view)

        view.setOnClickListener {
            // nop
        }
        return viewHolder
    }

    override fun getItemViewType(position: Int): Int {
        return position % 2
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        holder.changeJokeText(jokeLists[position].shapeJokeText() ?: "")
    }

    override fun getItemCount(): Int = jokeLists.count()
}
