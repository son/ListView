package com.example.son.listview

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row_main.view.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listView.adapter = Adaptor(this)
    }
}

class Adaptor(context: Context) : BaseAdapter() {

    private val testContext: Context
    private val items = arrayOf("zero", "one", "two", "three", "four", "five", "six")

    init {
        testContext = context
    }

    override fun getCount(): Int {
        return items.count()
    }

    override fun getItem(position: Int): Any {
        return "position: $position"
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val layourInfrator = LayoutInflater.from(testContext)
        val rowMain = layourInfrator.inflate(R.layout.row_main, parent, false)
        rowMain.textView.text = items[position]
        rowMain.textView2.text = "$position"
        return rowMain
    }
}