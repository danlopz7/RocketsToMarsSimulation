package com.dlopez.homework

import com.dlopez.homework.Rocket.Rocket
import com.dlopez.homework.Rocket.U1
import com.dlopez.homework.Rocket.U2
import java.io.File
import java.util.*
import kotlin.collections.ArrayList

class Simulation {

    /**
     * Class responsible for reading data and filling up the rockets
     */

    companion object {
        private const val SPLIT_VALUE = "="
        var itemNameArray = mutableListOf<String>()
    }

    fun runSimulation(rockets: ArrayList<Rocket>): Long {
        var totalBudget = 0L
        var failedTrial = false
        var attempts = 0
        for (rocket in rockets) {
            if (rocket.land() && rocket.launch()) {
                print("Rocket landed successfully\n")
                //println("")
                totalBudget += rocket.rocketCost
                attempts++
            } else {
                print("Rocket Failed to land \n")
                totalBudget += rocket.rocketCost
                failedTrial = true
                attempts++
                while (failedTrial) {
                    if (rocket.land() && rocket.launch()) {
                        print("Rocket landed successfully\n")
                        totalBudget += rocket.rocketCost
                        failedTrial = false
                        attempts++
                    } else {
                        print("Rocket Failed to land \n")
                        totalBudget += rocket.rocketCost
                        attempts++
                    }
                }
            }
        }
        println("")
        println("Total rockets required for this operation: ${rockets.size}")
        println("Total of attempts for mission to success: $attempts")
        println("Budget required for this operation: $totalBudget Millions")
        println("---------------------------------------------------")
        return totalBudget
    }



    fun loadItems(fileName: String): ArrayList<Item> {
        val items: ArrayList<Item> = ArrayList()
        Scanner(File(fileName)).apply {
            while (hasNextLine()) {
                val lineArray = nextLine().split(SPLIT_VALUE)
                items.add(
                    Item(lineArray[0], lineArray[1].toInt())   //Integer.parseInt(lineArray[1]))
                )
            }
        }
        return items
    }

    fun loadU1(items: ArrayList<Item>): ArrayList<Rocket> {
        val rocketsU1: ArrayList<Rocket> = ArrayList()
        var count = 0
        var rocketU1 = U1()
        itemNameArray.clear()
        for (item in items) {
            if (rocketU1.canCarry(item)) {
                rocketU1.carry(item)
                count++
                itemNameArray.add(item.name)
                //var itemName = rocketU1.currentItem
                if (count == items.size) {
                    rocketsU1.add(rocketU1)
                }
            } else {
                itemNameArray.add(item.name)
                rocketsU1.add(rocketU1)
                itemNameArray.clear()
                rocketU1 = U1()
                rocketU1.carry(item)
                count++
            }
        }
        return rocketsU1
    }

    fun loadU2(items: ArrayList<Item>): ArrayList<Rocket> {
        itemNameArray.clear()
        val rocketsU2: ArrayList<Rocket> = ArrayList()
        var count = 0
        var rocketU2 = U2()
        for (item in items) {
            if (rocketU2.canCarry(item)) {
                rocketU2.carry(item)
                count++
                if (count == items.size) {
                    rocketsU2.add(rocketU2)
                }
            } else {
                rocketsU2.add(rocketU2)
                rocketU2 = U2()
                rocketU2.carry(item)
                count++
                if (count == items.size) {
                    rocketsU2.add(rocketU2)
                }
            }
        }
        return rocketsU2
    }
}