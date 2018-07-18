package avenue.joke.relation.buisiness.soot.com.jokeavenue

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import avenue.joke.relation.buisiness.soot.com.jokeavenue.JokeAvenueRealm.JAJokeObject
import io.realm.Realm
import io.realm.RealmConfiguration
import java.util.*

class TopMenuActivity : AppCompatActivity() {

    /*
    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                message.setText(R.string.title_home)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                message.setText(R.string.title_dashboard)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                message.setText(R.string.title_notifications)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }
    */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_test)

        /*
        createJAJokeObject("jyo-ku",text = "本文",huga = 11)
        val test = Realm.getDefaultInstance().where(JAJokeObject::class.java).findAll()
        var aaa = test[0]?.jokeText
        */
        loadRealmDB()
    }

    fun loadRealmDB() {
        Realm.init(this)

        val hhhoooogggeee = assets.list("")

        //val conf = RealmConfiguration.Builder().assetFile("JAJokeDB.realm").readOnly().build()
        val conf = RealmConfiguration.Builder().assetFile("pokemon.realm")
                .name("pokemon.realm")
                .schemaVersion(1)
                .readOnly()
                .build()

        Realm.setDefaultConfiguration(conf)
        val realmInstance = Realm.getDefaultInstance()
        //val hoge = realmInstance.where(JAJokeObject::class.java).findAll()
        Log.d("hoge","huga")
    }

    //
    fun createJAJokeObject(title:String,text:String, huga:Int = 0){
    // TODO: こいつの中身は Activity 自体がもってるべきではない。
        Realm.init(this)
        //このインスタンスは Singleton として持ってるほうがいいの？
        var realm = Realm.getDefaultInstance()

        realm.executeTransaction {
            var testObj = realm.createObject(JAJokeObject::class.java , UUID.randomUUID().toString())
            testObj.jokeTitle = "ジョークのタイトル"
            testObj.jokeText  = "ジョークの本文"
            testObj.huga = 1
            testObj.hoge = 2
            realm.copyToRealm(testObj)
        }
    }
}
