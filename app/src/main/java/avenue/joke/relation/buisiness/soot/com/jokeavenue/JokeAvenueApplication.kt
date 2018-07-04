package avenue.joke.relation.buisiness.soot.com.jokeavenue

import android.app.Application
import io.realm.Realm

class JokeAvenueApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}
