package com.example.droidcafe

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var selected = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener {
            val intent = Intent(this,OrderActivity::class.java)
            intent.putExtra("content",selected)
            startActivity(intent)

        }
    }
    fun order(view:View?)
    {
        val str = when(view?.id)
        {
            R.id.ice ->{"You ordered a Ice Cream with Circle"
                        selected = "Ice Cream"
            }
            R.id.donut ->{"You ordered a Donut Ice Cream"
                selected = "Donut"}
            R.id.froyo ->{ "You ordered a Froyo Ice Cream"
                selected = "Froyo"}
            else ->""
        }

        Toast.makeText(this,selected,Toast.LENGTH_SHORT).show()
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
