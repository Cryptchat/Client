package cc.osama.sechat

import android.app.Application
import android.content.Context
import androidx.room.Room
import cc.osama.sechat.ui.MainActivity

class Sechat : Application() {
  companion object {
    var currentChatView: MainActivity? = null

    private var DB_INSTANCE: Database? = null
    fun db(context: Context) =
      DB_INSTANCE ?: synchronized(this) {
        DB_INSTANCE ?: Room.databaseBuilder(
          context,
          Database::class.java,
          "sechat-database"
        ).build().also { DB_INSTANCE = it }
      }
  }
  override fun onCreate() {
    super.onCreate()
  }
}