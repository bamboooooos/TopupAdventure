package com.example.topupadventurer.GameElement

class GamePerson {
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