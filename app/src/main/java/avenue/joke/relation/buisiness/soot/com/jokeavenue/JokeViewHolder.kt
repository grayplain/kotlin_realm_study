package avenue.joke.relation.buisiness.soot.com.jokeavenue

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

// ジョークアベニューで表示するジョーククラスの
class JokeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    //TODO: 動的に本文は変更されないので、これは不要なはず・・・
    // いや、Androidだと onBindView で対象ViewHolderの更新やってるから、ありなのか？
    fun changeJokeText(text: String){
        var jokeText = itemView.findViewById<TextView>(R.id.jokeTextView)
        jokeText.text = text
    }
}