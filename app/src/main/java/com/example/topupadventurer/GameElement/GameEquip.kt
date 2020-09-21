package com.example.topupadventurer.GameElement

class GameEquip :GameItem{

    //攻击属性采用千分制，属性值从0到1000，计算时计算涨幅0%~100%
    //防御属性固定值，<50时固定减伤，>=50时 50/(50+x)>50?a:b 取较大值
    //血量属性固定值和百分比并存，先计算固定值后计算百分比,当属性大于0时固定增长，小于0时，百分比增幅绝对值

    companion object{
        const val EQUIPCLASS_NONE:Int=0
        const val EQUIPCLASS_HEAD:Int=1
        const val EQUIPCLASS_HAND:Int=2
        const val EQUIPCLASS_SHOE:Int=3
        const val EQUIPCLASS_PANTS:Int=4
        const val EQUIPCLASS_LEFT_WEAPON:Int=5
        const val EQUIPCLASS_RIGHT_WEAPON:Int=6
        const val EQUIPCLASS_RIGHT_HAND:Int=12
        const val EQUIPCLASS_RIGHT_SHOE:Int=13

        const val ATTRIBUTE_ATTACK:Int=-1
        const val ATTRIBUTE_DEFENSE:Int=-2
        const val ATTRIBUTE_HEALTH:Int=-3
    }

    var equipClass:Int= EQUIPCLASS_NONE
    var equipAttack:ArrayList<Int> = ArrayList()
    var equipDefense:ArrayList<Int> =ArrayList()
    var equipHealth:ArrayList<Int> =ArrayList()

    var beLoadAble:Boolean=true

    constructor(itemId:Int,itemImage:Int,itemName:String,equipClass: Int):super(itemId,itemImage,itemName,-10){  //-10是一个标记位，不显示数量，且真实数量为1
        this.equipClass=equipClass
        canUsed=false
    }

    fun setAttribute(attrs:HashMap<Int,ArrayList<Int>>){
        equipAttack=attrs.getOrDefault(ATTRIBUTE_DEFENSE,ArrayList())
        equipDefense=attrs.getOrDefault(ATTRIBUTE_DEFENSE,ArrayList())
        equipHealth=attrs.getOrDefault(ATTRIBUTE_HEALTH,ArrayList())
    }

    fun getFinalAttr(attrClass:Int):Int{
        var result:Int=0
        var toCalculate:ArrayList<Int> = ArrayList()
        when(attrClass){
            ATTRIBUTE_DEFENSE ->{
                toCalculate=equipAttack
            }
            ATTRIBUTE_DEFENSE ->{
                toCalculate=equipDefense
            }
            ATTRIBUTE_HEALTH->{
                toCalculate=equipHealth
            }
        }
        for(i in toCalculate){
            result+=i
        }
        return result
    }

}