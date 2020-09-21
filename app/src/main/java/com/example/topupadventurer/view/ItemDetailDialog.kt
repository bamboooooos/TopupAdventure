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
import com.example.topupadventurer.GameElement.GamePerson
import com.example.topupadventurer.PersonalBagAdapter
import com.example.topupadventurer.R
import com.example.topupadventurer.ValueToString
import com.example.topupadventurer.fragment.PersonalFragment
import kotlinx.android.synthetic.main.dialog_item_detail.*


class ItemDetailDialog:AlertDialog{

    var itemToShow:GameItem=GameItem(0,R.drawable.fusion,"默认物品",0)
    var addrInBag:Int=0
    var player:GamePerson
    var adapter:PersonalBagAdapter?=null
    var fragment:PersonalFragment?=null
    var equipInbody:Boolean=false

    constructor(context: Context,data:GameItem?,addrInBag:Int,player:GamePerson):super(context){
        this.addrInBag=addrInBag
        this.player=player
        if(data!=null) {
            itemToShow = data
        }
    }

    fun inBag(adapter:PersonalBagAdapter){  //在背包
        this.adapter=adapter
    }

    fun inBody(fragment:PersonalFragment){    //设置身上装备刷新效果
        this.fragment=fragment
    }

    fun clickOnBody():ItemDetailDialog{
        equipInbody=true
        return this
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

            if (equipInbody){
                btn_dialog_1.visibility = View.INVISIBLE
                btn_dialog_2.visibility = View.INVISIBLE
                btn_dialog_3.visibility = View.INVISIBLE
            }
            else
            if (data.beLoadAble) {
                if (data.equipClass == GameEquip.EQUIPCLASS_SHOE || data.equipClass == GameEquip.EQUIPCLASS_HAND) {
                    btn_dialog_1.visibility = View.VISIBLE
                    setButton1("装备(左)", View.OnClickListener {
                        //装备在背包的装备事件
                        player.loadEquip(data,data.equipClass,addrInBag)
                        Toast.makeText(context, "点击了装备(左)", Toast.LENGTH_SHORT).show()
                        dismiss()
                        if(adapter!=null)
                            adapter!!.notifyDataSetChanged()
                        if(fragment!=null)
                            fragment!!.reloadEquip()
                    })
                    btn_dialog_2.visibility = View.VISIBLE
                    setButton2("装备(右)", View.OnClickListener {
                        //装备在背包的装备事件
                        player.loadEquip(data,data.equipClass+10,addrInBag)
                        Toast.makeText(context, "点击了装备(右)", Toast.LENGTH_SHORT).show()
                        dismiss()
                        if(adapter!=null)
                            adapter!!.notifyDataSetChanged()
                        if(fragment!=null)
                            fragment!!.reloadEquip()
                    })
                } else {
                    btn_dialog_1.visibility = View.VISIBLE
                    setButton1("装备", View.OnClickListener {
                        //装备在背包的装备事件
                        player.loadEquip(data,data.equipClass,addrInBag)
                        Toast.makeText(context, "点击了装备", Toast.LENGTH_SHORT).show()
                        dismiss()
                        if(adapter!=null)
                            adapter!!.notifyDataSetChanged()
                        if(fragment!=null)
                            fragment!!.reloadEquip()
                    })
                }
            }



        }
        tv_dialog_detail.text=detailToshow

        if (data.canUsed){
            btn_dialog_3.visibility=View.VISIBLE
            setButton3("使用",View.OnClickListener {
                //TODO 物品在背包的使用事件,需要判断数量
                Toast.makeText(context,"点击了使用",Toast.LENGTH_SHORT).show()
                if(adapter!=null)
                    adapter!!.notifyDataSetChanged()
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