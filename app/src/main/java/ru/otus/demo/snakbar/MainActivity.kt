package ru.otus.demo.snakbar

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val fab = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener { view ->
            // Создание экземпляра Snackbar
            val snackbar = Snackbar.make(view, "Our Snackbar", Snackbar.LENGTH_INDEFINITE)
            // Устанавливаем цвет текста кнопки действий
            snackbar.setActionTextColor(ContextCompat.getColor(this, R.color.indigo))
            // Получение snackbar view
            val snackbarView = snackbar.view

            // Изменение цвета текста
            val snackbarTextId = com.google.android.material.R.id.snackbar_text
            val textView = snackbarView.findViewById<View>(snackbarTextId) as TextView
            textView.setTextColor(ContextCompat.getColor(this, android.R.color.white))
            // Изменение цвета фона
            snackbarView.setBackgroundColor(Color.GRAY)
            //Создание и добавление Snackbar.Callback
            val snCallback: Snackbar.Callback = object : Snackbar.Callback() {
                override fun onShown(sb: Snackbar) {
                    //TODO
                }

                override fun onDismissed(snBar: Snackbar, event: Int) {
                    //TODO
                }
            }
            snackbar.addCallback(snCallback)
            snackbar.show()
            //Убрать Snackbar.Callback
            snackbar.removeCallback(snCallback)
            view.postDelayed({
                snackbar.dismiss()
            }, 5000)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean { // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean { // Handle action bar item clicks here. The action bar will
// automatically handle clicks on the Home/Up button, so long
// as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}