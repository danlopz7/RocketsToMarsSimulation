package com.dlopez.homework.Rocket

import com.dlopez.homework.Item
import kotlin.random.Random

class U1 : Rocket() {

    override var rocketCost = 100000000
    override var rocketWeight = 10000
    override var maxWeight = 18000
    override var currentWeight = rocketWeight

    /**
     * chance of launching fail = 5 % * (cargo carried/cargo limit)
     */
    override fun launch(): Boolean {
        val randomValue = (Random.nextDouble(from = 0.0, until = 0.2)).toFloat()
        val chanceOfExplosion = 0.05f * (currentWeight.toFloat().div(maxWeight.toFloat()))
        return chanceOfExplosion <= randomValue
    }

    /**
     * chance of landing crash = 1% * (cargo carried/cargo limit)
     */
    override fun land(): Boolean {
        val randomValue = (Random.nextDouble(from = 0.0, until = 0.2)).toFloat()
        val chanceOfCrash = 0.01f * (currentWeight.toFloat() / maxWeight.toFloat())
        return chanceOfCrash <= randomValue
    }
}



