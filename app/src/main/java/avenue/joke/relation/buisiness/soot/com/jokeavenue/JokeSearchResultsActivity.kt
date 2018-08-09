package avenue.joke.relation.buisiness.soot.com.jokeavenue

import android.app.Fragment
import android.app.FragmentManager
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.widget.SearchView

class JokeSearchResultsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joke_search_results)

        var searchView = findViewById<SearchView>(R.id.joke_searchview)

        val jokeListFragment = supportFragmentManager.findFragmentById(R.id.joke_results_fragment) as JokeListFragment

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            //TODO: 内部処理は別で管理しぃ。
           override fun onQueryTextSubmit(text: String?): Boolean {
                // 検索キーが押下された
                jokeListFragment.researchJokeList(text)
                Log.d("hog", "submit text: $text")
                return true
            }

            override fun onQueryTextChange(text: String?): Boolean {
                // テキストが変更された
                Log.d("hog", "change text: $text")
                return false
            }
        })
    }
}