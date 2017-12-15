package dijkstra

class Vertex (val name: String) : Comparable<Vertex> {
    var dist = Int.MAX_VALUE  // "infinity" declaration
    var previous: Vertex? = null
    var neighbours = HashMap<Vertex, Int>()

    fun printPath() {
        when (previous) {
            this -> print(name)
            null -> print("$name(unreached)")
            else -> {
                previous!!.printPath()
                print(" => $name ($dist)")
            }
        }
    }

    override fun compareTo(other: Vertex): Int {
        if (dist == other.dist) return name.compareTo(other.name)
        return dist.compareTo(other.dist)
    }

    override fun toString() = "($dist,$name)"
}