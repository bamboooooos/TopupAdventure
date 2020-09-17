package com.example.topupadventurer.GameElement

open class GameItem {

    companion object{
        const val GAMEITEMQUALITY_LOW:Int=21
    }

    var canUsed:Boolean=true

    var itemId:Int
    var itemImage:Int
    var itemName:String
    var itemTimes:Int=0
    var itemQuality:Int=
        GAMEITEMQUALITY_LOW
    var isShowTimes:Boolean=true

    var detail:String=""

    constructor(itemId:Int,itemImage:Int,itemName:String,itemTimes:Int){
        this.itemId=itemId
        this.itemImage=itemImage
        this.itemName=itemName
        if(itemTimes>0) {
            this.itemTimes = itemTimes
        }else if(itemTimes==-10){
            this.itemTimes=1
            isShowTimes=false
        }
    }




}