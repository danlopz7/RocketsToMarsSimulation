package com.dlopez.homework.Rocket

import kotlin.random.Random

class U2() : Rocket() {

    override var rocketCost = 120000000
    override var rocketWeight = 18000
    override var maxWeight = 29000
    override var currentWeight = rocketWeight

    override fun launch(): Boolean {
        /**
         * chance of launching fail = 4% * (cargo carried/cargo limit)
         */
        val randomValue = (Random.nextDouble(from = 0.0, until = 0.2)).toFloat()
        val chanceOfExplosion = 0.04f * (currentWeight.toFloat() / maxWeight.toFloat())
        return chanceOfExplosion <= randomValue
    }

    override fun land(): Boolean {
        /**
         * chance of landing crash = 8% * (cargo carried/cargo limit)
         */
        val randomValue = (Random.nextDouble(from = 0.0, until = 0.2)).toFloat()
        val chanceOfCrash = 0.08f * (currentWeight.toFloat() / maxWeight.toFloat())
        return chanceOfCrash <= randomValue
    }
}