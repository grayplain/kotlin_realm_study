package avenue.joke.relation.buisiness.soot.com.jokeavenue.JokeAvenueRealm

//これ Realm をアスタリスクで読み込んじゃあかんの？
import io.realm.Realm
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.Required
import java.util.*


//アクセス修飾子を open にしないといかんらしい。
open class JAJokeObject(
        @PrimaryKey open var id: String = UUID.randomUUID().toString(),
        @Required open var jokeTitle: String = "",
        open var jokeText: String = "",
        open var hoge: Int = 0,
        open var huga: Int = 0

    ): RealmObject() {}