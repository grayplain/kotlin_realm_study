package avenue.joke.relation.buisiness.soot.com.jokeavenue

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import avenue.joke.relation.buisiness.soot.com.jokeavenue.Animation.ResizeAnimation
import avenue.joke.relation.buisiness.soot.com.jokeavenue.JokeAvenueRealm.JAJokeObject
import avenue.joke.relation.buisiness.soot.com.jokeavenue.JokeListFragment.OnListFragmentInteractionListener

class MyJokeListRecyclerViewAdapter(
        // TODO: Realm のモデルを Entityとして直接使うのってアリか・・・？これはほかのコードを見たほうがいいかも。
        private val jokeLists: List<JAJokeObject>,
        private var expandHolderFlags: MutableList<Boolean>,
        private val mListener: OnListFragmentInteractionListener?)
    : RecyclerView.Adapter<JokeViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            /*
            val item = v.tag as DummyItem
            mListener?.onListFragmentInteraction(item)
            */
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
                val collapseAnimation = ResizeAnimation(longe, -400, 500)
                collapseAnimation.duration = 300
                view.startAnimation(collapseAnimation)
            } else {
                val expandAnimation = ResizeAnimation(longe, 400, 150)
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
        val babar = jokeLists[position].jokeTitle ?: ""
        holder.changeJokeText(babar)
    }

    override fun getItemCount(): Int = 5
}
