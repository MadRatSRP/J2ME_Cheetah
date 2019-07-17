package com.madrat.j2me_cheetah

import android.database.SQLException
import android.os.Bundle
import android.telecom.Connection
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.madrat.j2me_cheetah.`object`.cheats
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val db = RoomAsset.databaseBuilder(applicationContext,
            AppDatabase::class.java, "NL_Cheats.db").build()
        val cheats = db.cheatsDao().getAll()
        print(cheats.size)*/

        /*val ma = MyApplication()

        val db = ma.getDatabase()
        val cheatsDao = db?.cheatsDao()
        val cheats = cheatsDao?.getAll()*/


        /*print("Размер базы данных: " + cheats?.size)
        print("Размер базы данных: " + cheats?.size)
        print("Размер базы данных: " + cheats?.size)
        print("Размер базы данных: " + cheats?.size)
        print("Размер базы данных: " + cheats?.size)
        print("Размер базы данных: " + cheats?.size)
        print("Размер базы данных: " + cheats?.size)*/

        //textView.text = cheats?.size.toString()

        getDataFromDatabase()
    }

    fun getDataFromDatabase() {
        println("getDataFromDatabase()")

        var conn: Connection? = null
        var stmt: Statement? = null
        try {
            Class.forName("org.sqlite.JDBC")
            conn = DriverManager.getConnection("jdbc:sqlite:${cheats.basePath}${cheats.dbPath}")

            println("Database was opened")

            stmt = conn.createStatement()

            val rs: ResultSet = stmt.executeQuery("SELECT * FROM cheats")
            while (rs.next()) {
                print(rs.getString("title"))
                /*print("HAHA" + rs.getString("title"))
                print("HAHA" + rs.getString("description"))*/
            }

            /*updatedListOfPairs.forEach {pair ->
                val title = pair.first
                val description = pair.second

                val insertQuery = cheats.returnInsertQueryWithParameters(title, description)
                stmt.execute(insertQuery)
            }

            val rs: ResultSet = stmt.executeQuery(cheats.SQL_SELECT_ALL)
            while (rs.next()) {
                print("\n" + rs.getString(cheats.COLUMN_NAME_TITLE))
                print("\n" + rs.getString(cheats.COLUMN_NAME_DESCRIPTION))
            }*/
        }
        catch (ex: ClassNotFoundException) {
            ex.printStackTrace()
        }
        catch (ex: SQLException) {
            ex.printStackTrace()
        }
        finally {
            try {
                stmt?.close()
                conn?.close()
                println("\nTable cheats successfully updated")
            }
            catch (e: SQLException) { e.printStackTrace() }
        }
    }

    /*fun loadDataFromDatabase() {

        val c: Connection?

        val stmt: Statement?

        try {
            Class.forName("org.sqlite.JDBC")

            c = DriverManager.getConnection("jdbc:sqlite:"+ cheats.basePath + cheats.dbPath)

            println("Database Opened...\n")

            stmt = c.createStatement()

            val title = "1"
            val description = "2"

            val SQL_INSERT_CHEATS = "INSERT INTO cheats " +
                    "(title, description) " +
                    "VALUES ('$title', '$description')"

            stmt.execute(SQL_INSERT_CHEATS)

            /*stmt.execute(cheats.SQL_DELETE_CHEATS)

            stmt.executeUpdate(cheats.SQL_CREATE_CHEATS)*/

            //stmt.execute(SQL_INSERT_CHEATS)

            val rs: ResultSet = stmt.executeQuery("SELECT * FROM cheats")
            while (rs.next()) {
                Log.d("", rs.getString("title"))
                /*print("HAHA" + rs.getString("title"))
                print("HAHA" + rs.getString("description"))*/
            }

            stmt.close()

            c.close()

        } catch (e: Exception) {

            System.err.println(e.javaClass.name + ": " + e.message)

            exitProcess(0)
        }
        println("Table Product Created Successfully!!!")
    }*/
}
