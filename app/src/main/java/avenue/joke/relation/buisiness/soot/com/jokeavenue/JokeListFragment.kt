package avenue.joke.relation.buisiness.soot.com.jokeavenue

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class JokeListFragment : Fragment() {

    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    //onCreateView の前に呼ばれるらしいが・・・。 onCreateView だけでいいんじゃないか？
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val jokeListView = inflater.inflate(R.layout.fragment_jokelist_list, container, false)

        val topJokeSearchView = activity?.findViewById<SearchView>(R.id.joke_searchview)

        /*
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(text: String?): Boolean {
                // 検索キーが押下された
                Log.d("hog", "submit text: $text")
                return false
            }

            override fun onQueryTextChange(text: String?): Boolean {
                // テキストが変更された
                Log.d("hog", "change text: $text")
                return false
            }
        })
        */

        // Set the adapter
        if (jokeListView is RecyclerView) {
            with(jokeListView) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }

                val mojimojiKun = JokeDataFetcher().fetchMasterJokeData(word = "医師",category = "")

                adapter = MyJokeListRecyclerViewAdapter(mojimojiKun,
                                                        BooleanArray(size = mojimojiKun.count()),
                                                        listener)
            }
        }
        return jokeListView
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        //fun onListFragmentInteraction(item: DummyItem?)
    }
}
