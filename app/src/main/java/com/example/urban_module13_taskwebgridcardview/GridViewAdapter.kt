package com.example.urban_module13_taskwebgridcardview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class GridViewAdapter(
    private val list: List<GridViewModal>,
    private val context: Context
) : BaseAdapter() {

    private var layoutInflater: LayoutInflater? = null
    private lateinit var itemPictureIV: ImageView
    private lateinit var itemTitleTV: TextView

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var convertView = convertView
        if (layoutInflater == null) {
            layoutInflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        }

        if (convertView ==  null) {
            convertView = layoutInflater!!.inflate(R.layout.card_item, null)
        }

        itemPictureIV = convertView!!.findViewById(R.id.itemPictureIV)
        itemTitleTV = convertView.findViewById(R.id.itemTitleTV)

        itemPictureIV.setImageResource(list[position].picture)
        itemTitleTV.text = list[position].title

        return convertView
    }

}