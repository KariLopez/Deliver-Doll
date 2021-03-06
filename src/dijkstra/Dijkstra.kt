package dijkstra

import java.util.TreeSet


class Dijkstra(val graphD:Graph) {

     fun dijkstra(startName: String) {
        if(!graphD.graph.containsKey(startName)){
            println("Graph doesn't contain start vertex '$startName'")
            return
        }

        val source = graphD.graph[startName]
        val q = TreeSet<Vertex>()

        // set-up vertices
        for (v in graphD.graph.values) {
            v.previous = if (v == source) source else null
            v.dist = if (v == source) 0 else Int.MAX_VALUE
            q.add(v)

        }


        dijkstra(q)
    }

    private fun dijkstra(q: TreeSet<Vertex>) {
        while (!q.isEmpty()) {
            // vertex with shortest distance (first iteration will return source)
            val u: Vertex = q.pollFirst()
            // if distance is infinite we can ignore 'u' (and any other remaining vertices)


            if (u.dist == Int.MAX_VALUE) break

            //look at distances to each neighbour
            for(a:MutableMap.MutableEntry<Vertex,Int> in u.neighbours) {
                val v = a.key // the neighbour in this iteration

                val alternateDist = u.dist + a.value
                if (alternateDist < v.dist) { // shorter path to neighbour found
                    q.remove(v)
                    v.dist = alternateDist
                    v.previous = u
                    q.add(v)

                }
            }
        }
    }


    fun printPath(endName: String) {
        if (!graphD.graph.containsKey(endName)) {
            println("Graph doesn't contain end vertex '$endName'")
            return
        }
        print(message = if (graphD.directed) "Path: " else "Undirected : ")

        graphD.graph[endName]!!.printPath()
        println()
        if (graphD.showAllPaths) printAllPaths() else println()

    }

    /** Prints all paths from  beginning  source to every vertex  */
    private fun printAllPaths() {

        for (v in graphD.graph.values) {
            v.printPath()
            println()
        }
        println()}
}


