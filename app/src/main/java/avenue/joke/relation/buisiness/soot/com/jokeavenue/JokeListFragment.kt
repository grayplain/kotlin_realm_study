package avenue.joke.relation.buisiness.soot.com.jokeavenue

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class JokeListFragment : Fragment() {

    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    //TODO: Fragment には Realm を意識させたくないので、できればインタフェース経由でデータをやりとりしたい。
    // Realm 以外の DB ライブラリを使うこともあるだろうし。
    private var jokeResults = JokeDataFetcher().fetchMasterJokeData(word = "医師",category = "")


    //TODO: なんとなくだが、わざわざアダプターをインスタンス変数として持つのは違うようなきがする。
    private var jokeListAdapter: MyJokeListRecyclerViewAdapter? = null
    //onCreateView の前に呼ばれるらしいが・・・。 onCreateView だけでいいんじゃないか？
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val jokeListView = inflater.inflate(R.layout.fragment_jokelist_list, container, false)

        // Set the adapter
        if (jokeListView is RecyclerView) {
            with(jokeListView) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                jokeResults = JokeDataFetcher().fetchMasterJokeData(word = "",category = "")

                adapter = MyJokeListRecyclerViewAdapter(jokeResults,
                                                        BooleanArray(size = jokeResults.count()),
                                                        listener)
                jokeListAdapter = adapter as MyJokeListRecyclerViewAdapter
            }
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
            これでうまく更新されない・・・。
            jokeListAdapter?.notifyDataSetChanged()
        }
    }

    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        //fun onListFragmentInteraction(item: DummyItem?)
    }
}
