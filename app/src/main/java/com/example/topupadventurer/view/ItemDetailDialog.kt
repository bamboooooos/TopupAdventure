package com.example.topupadventurer.view

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.View
import android.view.WindowManager
import android.widget.ExpandableListView
import android.widget.Toast
import com.example.topupadventurer.GameElement.GameEquip
import com.example.topupadventurer.GameElement.GameItem
import com.example.topupadventurer.R
import com.example.topupadventurer.ValueToString
import kotlinx.android.synthetic.main.dialog_item_detail.*


class ItemDetailDialog:AlertDialog{

    lateinit var itemToShow:GameItem

    constructor(context: Context,data:GameItem):super(context){
        itemToShow=data
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_item_detail)
        val dm: DisplayMetrics = context.resources.getDisplayMetrics()
        var p:WindowManager.LayoutParams=window!!.attributes
        p.height = (dm.heightPixels * 0.5).toInt()
        p.width = (dm.widthPixels * 0.2).toInt()
        window!!.attributes=p
        dataInit(itemToShow)
        this.setCancelable(true)
    }

    fun dataInit(data:GameItem){
        tv_dialog_title.text=itemToShow.itemName
        var detailToshow:String=data.detail+"\n"
        if(data is GameEquip){
            data as GameEquip
            tv_dialog_title.text=itemToShow.itemName+"-"+ValueToString.vts(data.equipClass)
            for(i in data.equipAttack){
                detailToshow+="攻击增加了"+i+"\n"
            }
            for(i in data.equipDefense){
                detailToshow+="防御增加了"+i+"\n"
            }
            for(i in data.equipHealth){
                detailToshow+="血量增加了"+i+"\n"
            }

            if(data.equipClass==GameEquip.EQUIPCLASS_SHOE||data.equipClass==GameEquip.EQUIPCLASS_HAND){
                btn_dialog_1.visibility=View.VISIBLE
                setButton1("装备(左)",View.OnClickListener {
                    //TODO 装备在背包的装备事件
                    Toast.makeText(context,"点击了使用",Toast.LENGTH_SHORT).show()
                })
                btn_dialog_2.visibility=View.VISIBLE
                setButton2("装备(右)",View.OnClickListener {
                    //TODO 装备在背包的装备事件
                    Toast.makeText(context,"点击了使用",Toast.LENGTH_SHORT).show()
                })
            }else{
                btn_dialog_1.visibility=View.VISIBLE
                setButton1("装备",View.OnClickListener {
                    //TODO 装备在背包的装备事件
                    Toast.makeText(context,"点击了使用",Toast.LENGTH_SHORT).show()
                })
            }



        }
        tv_dialog_detail.text=detailToshow

        if (data.canUsed){
            btn_dialog_3.visibility=View.VISIBLE
            setButton3("使用",View.OnClickListener {
                //TODO 物品在背包的使用事件
                Toast.makeText(context,"点击了使用",Toast.LENGTH_SHORT).show()
            })
        }
    }

    fun setButton1(title:String,clickListener: View.OnClickListener){
        btn_dialog_1.text=title
        btn_dialog_1.setOnClickListener(clickListener)
    }
    fun setButton2(title:String,clickListener: View.OnClickListener){
        btn_dialog_2.text=title
        btn_dialog_2.setOnClickListener(clickListener)
    }
    fun setButton3(title:String,clickListener: View.OnClickListener){
        btn_dialog_3.text=title
        btn_dialog_3.setOnClickListener(clickListener)
    }

}