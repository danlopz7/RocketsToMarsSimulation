import com.dlopez.homework.Simulation
import java.io.FileNotFoundException

fun main() {

    println("Welcome to the simulation on a mission to Mars!")
    println("---------------------------------------------------")
    val PHASE_1_FILE_NAME = "src/main/phase-1.txt"
    val PHASE_2_FILE_NAME = "src/main/phase-2.txt"
    val sim = Simulation()

    try {
        val phase1 = sim.loadItems(PHASE_1_FILE_NAME)
        val phase2 = sim.loadItems(PHASE_2_FILE_NAME)

        val fleetU1Phase1 = sim.loadU1(phase1)
        println("Running Phase 1 on U1 Rocket units: ")
        val run1 = sim.runSimulation(fleetU1Phase1)

        val fleetU1Phase2 = sim.loadU1(phase2)
        println("Running Phase 2 on U1 Rocket units: ")
        val run2 = sim.runSimulation(fleetU1Phase2)
        println("Total budget required for phase 1 and phase 2 on Rockets U1: ${run1 + run2} millions \n ")

    } catch (e: FileNotFoundException) {
        println("Error: File not found: ${e.message}")
    }

    try {
        val phase1 = sim.loadItems(PHASE_1_FILE_NAME)
        val phase2 = sim.loadItems(PHASE_2_FILE_NAME)

        val fleetU2Phase1 = sim.loadU2(phase1)
        println("Running Phase 1 on U2 Rocket units: ")
        val run1 = sim.runSimulation(fleetU2Phase1)

        val fleetU2Phase2 = sim.loadU2(phase2)
        println("Running Phase 2 on U2 Rocket units: ")
        val run2 = sim.runSimulation(fleetU2Phase2)
        println("Total budget required for phase 1 and phase 2 on Rockets U2: ${run1 + run2} millions \n ")

    } catch (e: FileNotFoundException) {
        println("Error: File not found: ${e.message}")
    }
}

