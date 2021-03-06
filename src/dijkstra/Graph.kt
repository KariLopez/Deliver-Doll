package dijkstra


class Graph(edges:List<Edge>) {
    internal lateinit var edges: List<Edge>
    internal var directed: Boolean = true
    var showAllPaths: Boolean = false
    // With directed set to true will print directed path, set to false prints undirected
    //showAllPath set to false so it won't print out all paths from source to vertex
    internal var graph = HashMap<String, Vertex>(edges.size)

    init {
        // one pass to find all vertices
        for (e in edges) {
            if (!graph.containsKey(e.startLocation)) graph.put(e.startLocation, Vertex(e.startLocation))
            if (!graph.containsKey(e.endLocation)) graph.put(e.endLocation, Vertex(e.endLocation))
        }

        // another pass to set neighbouring vertices
        for (e in edges) {
            graph[e.startLocation]!!.neighbours.put(graph[e.endLocation]!!, e.distance)

            // also do this for an undirected graph if applicable
            if (!directed) graph[e.endLocation]!!.neighbours.put(graph[e.startLocation]!!, e.distance)
        }
    }
}




