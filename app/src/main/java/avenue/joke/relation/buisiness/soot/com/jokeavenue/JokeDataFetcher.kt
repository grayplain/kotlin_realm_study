package avenue.joke.relation.buisiness.soot.com.jokeavenue

import avenue.joke.relation.buisiness.soot.com.jokeavenue.JokeAvenueRealm.JAJokeObject
import io.realm.Realm
import io.realm.RealmQuery
import io.realm.RealmResults

//
class JokeDataFetcher() {
    fun fetchAllMasterJokeData(limit: Int = 10): RealmResults<JAJokeObject> {
        return Realm.getDefaultInstance().where(JAJokeObject::class.java).findAll()
    }

    fun fetchMasterJokeData(word: String,category: String, limit: Int = 10): RealmResults<JAJokeObject> {
        return Realm.getDefaultInstance().where(JAJokeObject::class.java).contains("jokeText",word).findAll()
    }
}