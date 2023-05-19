package com.dlopez.homework.Rocket

import com.dlopez.homework.Item
import com.dlopez.homework.SpaceShip

abstract class Rocket : SpaceShip {

    abstract var rocketCost: Int
    abstract var rocketWeight: Int
    abstract var maxWeight: Int
    abstract var currentWeight: Int

    abstract override fun launch(): Boolean

    abstract override fun land(): Boolean

    override fun canCarry(item: Item): Boolean = currentWeight + item.weight <= maxWeight


    override fun carry(item: Item): Int {
        currentWeight += item.weight
        return currentWeight
    }
}