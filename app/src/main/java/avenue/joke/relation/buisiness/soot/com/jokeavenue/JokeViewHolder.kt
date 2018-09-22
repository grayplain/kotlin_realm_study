package avenue.joke.relation.buisiness.soot.com.jokeavenue

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView

class JokeViewHolder(view: View): RecyclerView.ViewHolder(view) {

    fun changeJokeText(text: String){
        var jokeText = itemView.findViewById<TextView>(R.id.jokeTextView)
        jokeText.text = text
    }
}