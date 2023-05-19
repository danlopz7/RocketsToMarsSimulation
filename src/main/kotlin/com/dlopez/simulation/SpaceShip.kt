package com.dlopez.homework

import com.dlopez.homework.Item

interface SpaceShip {

    /**
     *returns true or false if launch was successful or the rocket has crashed
     */
    fun launch(): Boolean

    /**
     * returns true or false based on the success of the landing
     */
    fun land(): Boolean

    /**
     * takes an item as argument. returns true if the rocket can carry such item and false if exceed weight limit
     */
    fun canCarry(item: Item): Boolean

    /**
     * takes and item object and updates the current weight of the rocket
     */
    fun carry(item: Item): Int

}