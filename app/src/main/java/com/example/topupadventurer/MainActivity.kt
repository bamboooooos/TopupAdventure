package com.example.topupadventurer

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.Window
import android.view.WindowManager
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.topupadventurer.GameElement.GameEquip
import com.example.topupadventurer.GameElement.GamePerson
import com.example.topupadventurer.fragment.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_main)
        personalDataInit()
        uiInit()
        controlInit()
    }

    fun personalDataInit(){
        //TODO 加载人物信息
        GamePerson.player= GamePerson()
        var testData: GameEquip = GameEquip(
            0,R.drawable.fusion,"装备", GameEquip.EQUIPCLASS_HAND
        )
        testData.equipAttack= arrayListOf(4,5)
        testData.equipDefense= arrayListOf(6,7)
        testData.equipHealth= arrayListOf(8,9)
        testData.beLoadAble=false
        GamePerson.player.leftHandEquip=testData

    }

    fun uiInit(){
        val windowManager:WindowManager=getSystemService(Context.WINDOW_SERVICE) as WindowManager
        var dm:DisplayMetrics= DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(dm)
        MobileSetting.mobileWidth=(dm.widthPixels/dm.density).toInt()
        MobileSetting.mobileHeight=(dm.heightPixels/dm.density).toInt()
        replaceFragment(HelloFragment())
    }

    fun controlInit(){
        iv_first.setOnClickListener {
            replaceFragment(PersonalFragment())
        }
        iv_second.setOnClickListener {
            replaceFragment(DiamondFragment())
        }
        iv_third.setOnClickListener {
            replaceFragment(AdventureFragment())
        }
        iv_4th.setOnClickListener {
            replaceFragment(ShopFragment())
        }
        iv_5th.setOnClickListener {
            replaceFragment(StrongerFragment())
        }
        iv_6th.setOnClickListener {
            replaceFragment(FusionFragment())
        }
    }

    fun replaceFragment(replacedFragment:Fragment){
        val fragmentManager:FragmentManager=supportFragmentManager
        val transaction:FragmentTransaction=fragmentManager.beginTransaction()
        transaction.replace(R.id.fra_game,replacedFragment)
        transaction.commit()
    }

}