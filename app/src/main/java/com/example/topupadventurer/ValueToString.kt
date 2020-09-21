package com.example.topupadventurer

import com.example.topupadventurer.GameElement.GameEquip

class ValueToString {
    companion object{
        fun vts(value:Int):String{
            when(value){
                GameEquip.ATTRIBUTE_HEALTH->
                    return "血量"
                GameEquip.ATTRIBUTE_DEFENSE->
                    return "防御"
                GameEquip.ATTRIBUTE_ATTACK->
                    return "攻击"
                /**  value=0  **/
                GameEquip.EQUIPCLASS_NONE->
                    return "无"
                GameEquip.EQUIPCLASS_HEAD->
                    return "头盔"
                GameEquip.EQUIPCLASS_HAND->
                    return "护手"
                GameEquip.EQUIPCLASS_SHOE->
                    return "腿铠"
                GameEquip.EQUIPCLASS_PANTS->
                    return "裤甲"
                GameEquip.EQUIPCLASS_LEFT_WEAPON->
                    return "左手武器"
                GameEquip.EQUIPCLASS_RIGHT_WEAPON->
                    return "右手武器"
                /** value=6 **/

                /** value=12 **/
                GameEquip.EQUIPCLASS_RIGHT_HAND->
                    return "右手护手"
                GameEquip.EQUIPCLASS_RIGHT_SHOE->
                    return "右腿腿铠"
            }
            return "错误"
        }
    }
}