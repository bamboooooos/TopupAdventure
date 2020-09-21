package com.example.topupadventurer.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.topupadventurer.GameElement.GameEquip
import com.example.topupadventurer.GameElement.GameItem
import com.example.topupadventurer.GameElement.GamePerson
import com.example.topupadventurer.MobileSetting
import com.example.topupadventurer.PersonalBagAdapter
import com.example.topupadventurer.R
import com.example.topupadventurer.view.ItemDetailDialog
import kotlinx.android.synthetic.main.fragment_personal.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class PersonalFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    val things:ArrayList<GameItem> =GamePerson.player.bagItems
    var isShowHighlight:Boolean=false
    var player:GamePerson= GamePerson.player

    lateinit var theView: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        theView=inflater.inflate(R.layout.fragment_personal, container, false)
        UIInit()
        ListenerInit(theView)
        return theView
    }

    fun UIInit(){
        recyclerView=theView.findViewById(R.id.rv_personal_bag)
        //计算屏幕够放几列物品
        var howColumn :Int=((MobileSetting.mobileWidth-68-100)/80).toInt()
        val manager:StaggeredGridLayoutManager=
            StaggeredGridLayoutManager(howColumn,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager=manager
        testDataInit()
        var bagAdapter=PersonalBagAdapter(things)
        bagAdapter.inPersonalFragment(this)
        recyclerView.adapter=bagAdapter
        bagAdapter.notifyDataSetChanged()
        reloadEquip()
        /**------------人物装备栏显示图标--------------**/

    }


    fun reloadEquip(){
        if(player.headEquip!=null){
            theView!!.findViewById<ImageView>(R.id.iv_personal_head).isEnabled=true
            theView!!.findViewById<ImageView>(R.id.iv_personal_head).setImageResource(player.headEquip!!.itemImage)
        }else{
            theView!!.findViewById<ImageView>(R.id.iv_personal_head).isEnabled=false
        }

        if(player.leftHandEquip!=null){
            theView!!.findViewById<ImageView>(R.id.iv_personal_left_hand).isEnabled=true
            theView!!.findViewById<ImageView>(R.id.iv_personal_left_hand).setImageResource(player.leftHandEquip!!.itemImage)
        }else{
            theView!!.findViewById<ImageView>(R.id.iv_personal_left_hand).isEnabled=false
        }

        if(player.rightHandEquip!=null){
            theView!!.findViewById<ImageView>(R.id.iv_personal_right_hand).isEnabled=true
            theView!!.findViewById<ImageView>(R.id.iv_personal_right_hand).setImageResource(player.rightHandEquip!!.itemImage)
        }else{
            theView!!.findViewById<ImageView>(R.id.iv_personal_right_hand).isEnabled=false
        }

        if(player.leftShoeEquip!=null){
            theView!!.findViewById<ImageView>(R.id.iv_personal_left_shoe).isEnabled=true
            theView!!.findViewById<ImageView>(R.id.iv_personal_left_shoe).setImageResource(player.leftShoeEquip!!.itemImage)
        }else{
            theView!!.findViewById<ImageView>(R.id.iv_personal_left_shoe).isEnabled=false
        }

        if(player.rightShoeEquip!=null){
            theView!!.findViewById<ImageView>(R.id.iv_personal_right_shoe).isEnabled=true
            theView!!.findViewById<ImageView>(R.id.iv_personal_right_shoe).setImageResource(player.rightShoeEquip!!.itemImage)
        }else{
            theView!!.findViewById<ImageView>(R.id.iv_personal_right_shoe).isEnabled=false
        }

        if(player.leftWeaponEquip!=null){
            theView!!.findViewById<ImageView>(R.id.iv_personal_left_weapon).isEnabled=true
            theView!!.findViewById<ImageView>(R.id.iv_personal_left_weapon).setImageResource(player.leftWeaponEquip!!.itemImage)
        }else{
            theView!!.findViewById<ImageView>(R.id.iv_personal_left_weapon).isEnabled=false
        }

        if(player.rightWeaponEquip!=null){
            theView!!.findViewById<ImageView>(R.id.iv_personal_right_weapon).isEnabled=true
            theView!!.findViewById<ImageView>(R.id.iv_personal_right_weapon).setImageResource(player.rightWeaponEquip!!.itemImage)
        }else{
            theView!!.findViewById<ImageView>(R.id.iv_personal_right_weapon).isEnabled=false
        }

        if(player.pantsEquip!=null){
            theView!!.findViewById<ImageView>(R.id.iv_personal_pants).isEnabled=true
            theView!!.findViewById<ImageView>(R.id.iv_personal_pants).setImageResource(player.pantsEquip!!.itemImage)
        }else{
            theView!!.findViewById<ImageView>(R.id.iv_personal_pants).isEnabled=false
        }
    }




    fun ListenerInit(theView:View){
        theView.findViewById<Button>(R.id.btn_unload_one).setOnClickListener {
            var visible:Int
            var visible1:Int
            if (isShowHighlight){
                visible=View.INVISIBLE
                visible1=View.VISIBLE
                btn_unload_one.background=resources.getDrawable(R.drawable.sharp_person)
                isShowHighlight=false
            }else{
                visible=View.VISIBLE
                visible1=View.INVISIBLE
                btn_unload_one.setBackgroundColor(Color.parseColor("#33006699"))
                isShowHighlight=true
            }
            iv_select_head.visibility=visible
            iv_personal_head.visibility=visible1
            iv_select_left_hand.visibility=visible
            iv_personal_left_hand.visibility=visible1
            iv_select_right_hand.visibility=visible
            iv_personal_right_hand.visibility=visible1
            iv_select_left_shoe.visibility=visible
            iv_personal_left_shoe.visibility=visible1
            iv_select_right_shoe.visibility=visible
            iv_personal_right_shoe.visibility=visible1
            iv_select_left_weapon.visibility=visible
            iv_personal_left_weapon.visibility=visible1
            iv_select_right_weapon.visibility=visible
            iv_personal_right_weapon.visibility=visible1
            iv_select_pants.visibility=visible
            iv_personal_pants.visibility=visible1
        }
        /**---------------装备栏点击显示事件----------------**/
        theView!!.findViewById<ImageView>(R.id.iv_personal_head).setOnClickListener {
            ItemDetailDialog(context!!,player.headEquip,GameEquip.EQUIPCLASS_HEAD,player).clickOnBody().show()
        }
        theView!!.findViewById<ImageView>(R.id.iv_personal_left_hand).setOnClickListener {
            ItemDetailDialog(context!!,player.leftHandEquip,GameEquip.EQUIPCLASS_HAND,player).clickOnBody().show()
        }
        theView!!.findViewById<ImageView>(R.id.iv_personal_right_hand).setOnClickListener {
            ItemDetailDialog(context!!,player.rightHandEquip,GameEquip.EQUIPCLASS_HAND,player).clickOnBody().show()
        }
        theView!!.findViewById<ImageView>(R.id.iv_personal_left_weapon).setOnClickListener {
            ItemDetailDialog(context!!,player.leftWeaponEquip,GameEquip.EQUIPCLASS_LEFT_WEAPON,player).clickOnBody().show()
        }
        theView!!.findViewById<ImageView>(R.id.iv_personal_right_weapon).setOnClickListener {
            ItemDetailDialog(context!!,player.rightWeaponEquip,GameEquip.EQUIPCLASS_RIGHT_WEAPON,player).clickOnBody().show()
        }
        theView!!.findViewById<ImageView>(R.id.iv_personal_left_shoe).setOnClickListener {
            ItemDetailDialog(context!!,player.leftShoeEquip,GameEquip.EQUIPCLASS_SHOE,player).clickOnBody().show()
        }
        theView!!.findViewById<ImageView>(R.id.iv_personal_right_shoe).setOnClickListener {
            ItemDetailDialog(context!!,player.rightShoeEquip,GameEquip.EQUIPCLASS_SHOE,player).clickOnBody().show()
        }
        theView!!.findViewById<ImageView>(R.id.iv_personal_pants).setOnClickListener {
            ItemDetailDialog(context!!,player.pantsEquip,GameEquip.EQUIPCLASS_PANTS,player).clickOnBody().show()
        }
    }

    fun testDataInit(){
        var testData:GameEquip=GameEquip(
            0,R.drawable.fusion,"装备",GameEquip.EQUIPCLASS_LEFT_WEAPON
        )
        testData.equipAttack= arrayListOf(4,5)
        testData.equipDefense= arrayListOf(6,7)
        testData.equipHealth= arrayListOf(8,9)
        things.add(testData)
        var testData2:GameEquip=GameEquip(
            0,R.drawable.fusion,"装备",GameEquip.EQUIPCLASS_HAND
        )
        testData2.equipAttack= arrayListOf(4,5)
        testData2.equipDefense= arrayListOf(6,7)
        testData2.equipHealth= arrayListOf(8,9)
        things.add(testData2)
        for (i in 1..40){
            things.add(
                GameItem(
                    0,
                    R.drawable.fusion,
                    "第" + things.size + "个物品",
                    if (things.size > 3) things.size - 3 else things.size
                )
            )
        }
        for (i in 1..40) {
            things.add(
                GameEquip(
                    0,
                    R.drawable.fusion,
                    "第" + things.size + "个装备物品",
                    GameEquip.EQUIPCLASS_NONE
                )
            )
        }
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            PersonalFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}