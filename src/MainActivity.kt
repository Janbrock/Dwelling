import kotlin.math.PI

fun main() {
    val squareCabin = SquareCabin(6, 50.0)
    val roundHut = RoundHut(3, 10.0)
    val roundTower = RoundTower(4, 15.5)

    with(squareCabin) {
        println("\nSquare Cabin\n============")
        println("Material: ${buildingMaterial}")
        println("Floor area: ${floorArea()}")
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")

    }
    with(roundHut) {
        println("\nRound Hut\n=========")
        println("Material: ${buildingMaterial}")
        println("Floor area: %.2f".format(floorArea()))
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
    }
    with(roundTower) {
        println("\nRound Tower\n===========")
        println("Material: ${buildingMaterial}")
        println("Floors: ${floors}")
        println("Floor area: %.2f".format(floorArea()))
        println("Capacity: ${capacity}")
        println("Has room? ${hasRoom()}")
    }
}

abstract class Dwelling(private val residents: Int) {
    abstract val buildingMaterial: String
    abstract val capacity: Int

    fun hasRoom(): Boolean {
        return residents < capacity
    }

    abstract fun floorArea(): Double
}

class SquareCabin(residents: Int, private val length: Double) : Dwelling(residents) {
    override val buildingMaterial: String = "Wood"
    override val capacity: Int = 6
    override fun floorArea(): Double {
        return length * length
    }
}

open class RoundHut(residents: Int, val radius: Double) : Dwelling(residents) {
    override val buildingMaterial: String = "Straw"
    override val capacity: Int = 4
    override fun floorArea(): Double {
        return PI * radius * radius
    }
}

class RoundTower(residents: Int, radius: Double, val floors: Int = 2) : RoundHut(residents, radius) {
    override val buildingMaterial: String = "Stone"
    override val capacity: Int = 4 * floors
    override fun floorArea(): Double {
        return super.floorArea()*floors
    }
}
