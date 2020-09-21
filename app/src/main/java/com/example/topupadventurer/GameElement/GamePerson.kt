package com.example.topupadventurer.GameElement

import android.util.Log
import android.widget.Toast

class GamePerson {

    companion object{
        var player:GamePerson=GamePerson()
    }

    var personAttrAttack:Int=50
    var personAttrDefense:Int=10
    var personAttrHealth:Int=200
    var headEquip:GameEquip?=null
    var leftHandEquip:GameEquip?=null
    var rightHandEquip:GameEquip?=null
    var leftWeaponEquip:GameEquip?=null
    var rightWeaponEquip:GameEquip?=null
    var leftShoeEquip:GameEquip?=null
    var rightShoeEquip:GameEquip?=null
    var pantsEquip:GameEquip?=null

    var bagItems:ArrayList<GameItem> = ArrayList()

    fun addSomethingToBag(item: GameItem){    //获得物品
        bagItems.add(item)
    }

    fun loseSomethingFromBag(index:Int,number:Int):Boolean{      //按序列号失去物品,失去数量
        var toRemove:GameItem=bagItems[index]
        if (toRemove is GameEquip){
            bagItems.removeAt(index)
            return true
        }
        var result:Int=bagItems[index].itemTimes-number
        when {
            result>0 ->{
                bagItems[index].itemTimes=result
                return true
            }
            result==0 ->{
                bagItems.removeAt(index)
                return true
            }
            result<0 ->{
                //TODO 数量不够，无法扣除
            }
        }
        return false
    }

    fun loseSomethingFromBag(id:Int,number: Int,log:String):Boolean{      //按id索引并失去物品，若搜索不到id便弹出提示
        for (indexItem:GameItem in bagItems) {
            if (indexItem.itemId == id) {
                if (indexItem is GameEquip) {
                    bagItems.remove(indexItem)
                    return true
                }
                var result = indexItem.itemTimes - number
                when {
                    result > 0 -> {
                        indexItem.itemTimes = result
                        return true
                    }
                    result == 0 -> {
                        bagItems.remove(indexItem)
                        return true
                    }
                    result < 0 -> {
                        //TODO 数量不够，无法扣除
                        Log.d("lin", log)
                        return false
                    }
                }
                break
            }

        }
        Log.d("lin", log)
        return false
    }

    fun unLoadEquip(location: Int){
        when(location){
            GameEquip.EQUIPCLASS_HAND->{  //左手
                if (leftHandEquip!=null) {
                    addSomethingToBag(leftHandEquip!!)
                    leftHandEquip=null
                }
            }
            GameEquip.EQUIPCLASS_RIGHT_HAND->{  //右手
                if (rightHandEquip!=null) {
                    addSomethingToBag(rightHandEquip!!)
                    rightHandEquip=null
                }
            }
            GameEquip.EQUIPCLASS_SHOE->{  //左腿
                if (leftShoeEquip!=null) {
                    addSomethingToBag(leftShoeEquip!!)
                    leftShoeEquip=null
                }
            }
            GameEquip.EQUIPCLASS_RIGHT_SHOE->{  //右腿
                if (rightShoeEquip!=null) {
                    addSomethingToBag(rightShoeEquip!!)
                    leftShoeEquip=null
                }
            }
            GameEquip.EQUIPCLASS_HEAD->{  //头
                if (headEquip!=null) {
                    addSomethingToBag(headEquip!!)
                    headEquip=null
                }
            }
            GameEquip.EQUIPCLASS_PANTS->{  //裤衩
                if (pantsEquip!=null) {
                    addSomethingToBag(pantsEquip!!)
                    pantsEquip=null
                }
            }
            GameEquip.EQUIPCLASS_LEFT_WEAPON->{  //左武器
                if (leftWeaponEquip!=null) {
                    addSomethingToBag(leftWeaponEquip!!)
                    leftWeaponEquip=null
                }
            }
            GameEquip.EQUIPCLASS_RIGHT_WEAPON->{  //右武器
                if (rightWeaponEquip!=null) {
                    addSomethingToBag(rightWeaponEquip!!)
                    rightWeaponEquip=null
                }
            }
        }
    }

    fun unLoadAllEquip(){
        if (leftHandEquip != null) {
            addSomethingToBag(leftHandEquip!!)
            leftHandEquip = null
        }
        if (rightHandEquip != null) {
            addSomethingToBag(rightHandEquip!!)
            rightHandEquip = null
        }
        if (leftShoeEquip != null) {
            addSomethingToBag(leftShoeEquip!!)
            leftShoeEquip = null
        }
        if (rightShoeEquip != null) {
            addSomethingToBag(rightShoeEquip!!)
            leftShoeEquip = null
        }
        if (headEquip != null) {
            addSomethingToBag(headEquip!!)
            headEquip = null
        }
        if (pantsEquip != null) {
            addSomethingToBag(pantsEquip!!)
            pantsEquip = null
        }
        if (leftWeaponEquip != null) {
            addSomethingToBag(leftWeaponEquip!!)
            leftWeaponEquip = null
        }
        if (rightWeaponEquip != null) {
            addSomethingToBag(rightWeaponEquip!!)
            rightWeaponEquip = null
        }
    }

    fun loadEquip(equip:GameEquip,location:Int,addrInBag:Int){
        when(location){
            GameEquip.EQUIPCLASS_HAND->{  //左手
                if (leftHandEquip!=null) {
                    addSomethingToBag(leftHandEquip!!)
                }
                leftHandEquip=equip
            }
            GameEquip.EQUIPCLASS_RIGHT_HAND->{  //右手
                if (rightHandEquip!=null) {
                    addSomethingToBag(rightHandEquip!!)
                }
                rightHandEquip=equip
            }
            GameEquip.EQUIPCLASS_SHOE->{  //左腿
                if (leftShoeEquip!=null) {
                    addSomethingToBag(leftShoeEquip!!)
                }
                leftShoeEquip=equip
            }
            GameEquip.EQUIPCLASS_RIGHT_SHOE->{  //右腿
                if (rightShoeEquip!=null) {
                    addSomethingToBag(rightShoeEquip!!)
                }
                rightShoeEquip=equip
            }
            GameEquip.EQUIPCLASS_HEAD->{  //头
                if (headEquip!=null) {
                    addSomethingToBag(headEquip!!)
                }
                headEquip=equip
            }
            GameEquip.EQUIPCLASS_PANTS->{  //裤衩
                if (pantsEquip!=null) {
                    addSomethingToBag(pantsEquip!!)
                }
                pantsEquip=equip
            }
            GameEquip.EQUIPCLASS_LEFT_WEAPON->{  //左武器
                if (leftWeaponEquip!=null) {
                    addSomethingToBag(leftWeaponEquip!!)
                }
                leftWeaponEquip=equip
            }
            GameEquip.EQUIPCLASS_RIGHT_WEAPON->{  //右武器
                if (rightWeaponEquip!=null) {
                    addSomethingToBag(rightWeaponEquip!!)
                }
                rightWeaponEquip=equip
            }
        }
        loseSomethingFromBag(addrInBag,1)
    }

    fun attack():Int{
        var attackAdd:Int=0
        if (headEquip!=null) {
            attackAdd+=headEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_ATTACK)
        }
        if (leftHandEquip!=null) {
            attackAdd+=leftHandEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_ATTACK)
        }
        if (rightHandEquip!=null) {
            attackAdd+=rightHandEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_ATTACK)
        }
        if (leftWeaponEquip!=null) {
            attackAdd+=leftWeaponEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_ATTACK)
        }
        if (rightWeaponEquip!=null) {
            attackAdd+=rightWeaponEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_ATTACK)
        }
        if (leftShoeEquip!=null) {
            attackAdd+=leftShoeEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_ATTACK)
        }
        if (rightShoeEquip!=null) {
            attackAdd+=rightShoeEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_ATTACK)
        }
        if (pantsEquip!=null) {
            attackAdd+=pantsEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_ATTACK)
        }
        return personAttrAttack*(1+(attackAdd.toDouble())/(1000.toDouble())).toInt()
    }

    fun defense(attack:Int):Int{
        var defenseReduce:Int=0
        if (headEquip!=null) {
            defenseReduce+=headEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_DEFENSE)
        }
        if (leftHandEquip!=null) {
            defenseReduce+=leftHandEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_DEFENSE)
        }
        if (rightHandEquip!=null) {
            defenseReduce+=rightHandEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_DEFENSE)
        }
        if (leftWeaponEquip!=null) {
            defenseReduce+=leftWeaponEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_DEFENSE)
        }
        if (rightWeaponEquip!=null) {
            defenseReduce+=rightWeaponEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_DEFENSE)
        }
        if (leftShoeEquip!=null) {
            defenseReduce+=leftShoeEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_DEFENSE)
        }
        if (rightShoeEquip!=null) {
            defenseReduce+=rightShoeEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_DEFENSE)
        }
        if (pantsEquip!=null) {
            defenseReduce+=pantsEquip!!.getFinalAttr(GameEquip.ATTRIBUTE_DEFENSE)
        }
        var damageReduce:Int=((personAttrDefense+defenseReduce).toDouble()*attack/((personAttrDefense+defenseReduce).toDouble()+50)).toInt()
        return attack-(if(damageReduce>50)damageReduce else 50)
    }
}