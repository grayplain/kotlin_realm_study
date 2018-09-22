package avenue.joke.relation.buisiness.soot.com.jokeavenue

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class JokeListFragment : Fragment() {

    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    private var jokeResults = JokeDataFetcher().fetchMasterJokeData(word = "ジョーク",category = "")

    private var jokeListAdapter: MyJokeListRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var jokeListView = inflater.inflate(R.layout.fragment_jokelist_list, container, false) as RecyclerView

        with(jokeListView) {
            layoutManager = when {
                columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
            }
            jokeResults = JokeDataFetcher().fetchMasterJokeData(word = "",category = "")
            jokeListAdapter = MyJokeListRecyclerViewAdapter(jokeResults, BooleanArray(size = jokeResults.count()), listener)
            adapter = jokeListAdapter as MyJokeListRecyclerViewAdapter
        }

        return jokeListView
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    fun researchJokeList(word: String?) {
        word?.let {
            jokeResults = JokeDataFetcher().fetchMasterJokeData(word = word,category = "")
            jokeListAdapter?.jokeLists = jokeResults
            jokeListAdapter?.notifyDataSetChanged()
        }
    }

    interface OnListFragmentInteractionListener {
        //nop
    }
}
