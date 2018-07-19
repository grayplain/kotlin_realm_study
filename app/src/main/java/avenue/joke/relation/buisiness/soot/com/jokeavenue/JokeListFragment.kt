package avenue.joke.relation.buisiness.soot.com.jokeavenue

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import avenue.joke.relation.buisiness.soot.com.jokeavenue.dummy.DummyContent
import avenue.joke.relation.buisiness.soot.com.jokeavenue.dummy.DummyContent.DummyItem

class JokeListFragment : Fragment() {

    private var columnCount = 1

    private var listener: OnListFragmentInteractionListener? = null

    //onCreateView の前に呼ばれるらしいが・・・。 onCreateView だけでいいんじゃないか？
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_jokelist_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = when {
                    columnCount <= 1 -> LinearLayoutManager(context)
                    else -> GridLayoutManager(context, columnCount)
                }
                adapter = MyJokeListRecyclerViewAdapter(DummyContent.ITEMS,
                                                mutableListOf(false,false,false,false,false,
                                            false,false,false,false,false), listener)
            }
        }
        return view
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onListFragmentInteraction(item: DummyItem?)
    }
}
