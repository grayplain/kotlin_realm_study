package avenue.joke.relation.buisiness.soot.com.jokeavenue

import android.app.Application
import android.util.Log
import avenue.joke.relation.buisiness.soot.com.jokeavenue.JokeAvenueRealm.JAJokeObject
import io.realm.Realm
import io.realm.RealmConfiguration

class JokeAvenueApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        loadRealmDB()
    }

    fun loadRealmDB() {
        Realm.init(this)

        val DBName = "JAJokeDB.realm"
        val conf = RealmConfiguration.Builder()
                .assetFile(DBName)
                .name(DBName)
                .schemaVersion(1)
                .readOnly()
                .build()

        Realm.setDefaultConfiguration(conf)
    }
}
