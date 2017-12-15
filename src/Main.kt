import dijkstra.Dijkstra
import dijkstra.Edge
import dijkstra.Graph


fun main(args: Array<String>) {
    var START = "Kruthika's abode"
    var END = "Craig's haunt"


    //creating list of edges
    val GRAPH = listOf(
            Edge("Kruthika's abode", "Mark's crib", 9),
            Edge("Kruthika's abode", "Greg's casa", 4),
            Edge("Kruthika's abode", "Matt's pad", 18),
            Edge("Kruthika's abode", "Brian's apartment", 8),
            Edge("Brian's apartment", "Wesley's condo", 7),
            Edge("Brian's apartment", "Cam's dwelling", 17),
            Edge("Greg's casa", "Cam's dwelling", 13),
            Edge("Greg's casa", "Mike's digs", 19),
            Edge("Greg's casa", "Matt's pad", 14),
            Edge("Wesley's condo", "Kirk's farm", 10),
            Edge("Wesley's condo", "Nathan's flat", 11),
            Edge("Wesley's condo", "Bryce's den", 6),
            Edge("Matt's pad", "Mark's crib", 19),
            Edge("Matt's pad", "Nathan's flat", 15),
            Edge("Matt's pad", "Craig's haunt", 14),
            Edge("Mark's crib", "Kirk's farm", 9),
            Edge("Mark's crib", "Nathan's flat", 12),
            Edge("Bryce's den", "Craig's haunt", 10),
            Edge("Bryce's den", "Mike's digs", 9),
            Edge("Mike's digs", "Cam's dwelling", 20),
            Edge("Mike's digs", "Nathan's flat", 12),
            Edge("Cam's dwelling", "Craig's haunt", 18),
            Edge("Nathan's flat", "Kirk's farm", 3)
    )
    var edges = Graph(GRAPH)
    var method = Dijkstra(graphD = edges)
    

    method.dijkstra(START)
    method.printPath(END)
    //method.printDist()

}