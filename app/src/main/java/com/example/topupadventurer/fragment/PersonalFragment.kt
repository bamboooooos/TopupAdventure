package com.example.topupadventurer.fragment

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.topupadventurer.GameElement.GameEquip
import com.example.topupadventurer.GameElement.GameItem
import com.example.topupadventurer.GameElement.GamePerson
import com.example.topupadventurer.MobileSetting
import com.example.topupadventurer.PersonalBagAdapter
import com.example.topupadventurer.R
import kotlinx.android.synthetic.main.fragment_personal.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class PersonalFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    val things:ArrayList<GameItem> =ArrayList()
    var isShowHighlight:Boolean=false
    lateinit var player:GamePerson

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val theView:View=inflater.inflate(R.layout.fragment_personal, container, false)
        UIInit(theView)
        personalDataInit()
        ListenerInit(theView)
        return theView
    }

    fun UIInit(theView:View){
        recyclerView=theView.findViewById(R.id.rv_personal_bag)
        //计算屏幕够放几列物品
        var howColumn :Int=((MobileSetting.mobileWidth-68-100)/80).toInt()
        val manager:StaggeredGridLayoutManager=
            StaggeredGridLayoutManager(howColumn,StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager=manager
        testDataInit()
        var bagAdapter=PersonalBagAdapter(things)
        recyclerView.adapter=bagAdapter
        bagAdapter.notifyDataSetChanged()
    }


    fun personalDataInit(){
        //TODO 加载人物信息
        player=GamePerson()
        var testData:GameEquip=GameEquip(
            0,R.drawable.fusion,"装备",GameEquip.EQUIPCLASS_HAND
        )
        testData.equipAttack= arrayListOf(4,5)
        testData.equipDefense= arrayListOf(6,7)
        testData.equipHealth= arrayListOf(8,9)
        player.leftHandEquip=testData

    }

    fun ListenerInit(theView:View){
        theView.findViewById<Button>(R.id.btn_unload_one).setOnClickListener {
            var visible:Int
            if (isShowHighlight){
                visible=View.GONE
                btn_unload_one.background=resources.getDrawable(R.drawable.sharp_person)
                isShowHighlight=false
            }else{
                visible=View.VISIBLE
                btn_unload_one.setBackgroundColor(Color.parseColor("#33006699"))
                isShowHighlight=true
            }
            iv_select_head.visibility=visible
            iv_select_left_hand.visibility=visible
            iv_select_right_hand.visibility=visible
            iv_select_left_shoe.visibility=visible
            iv_select_right_shoe.visibility=visible
            iv_select_left_weapon.visibility=visible
            iv_select_right_weapon.visibility=visible
            iv_select_pants.visibility=visible
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