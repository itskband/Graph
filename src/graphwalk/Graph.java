package graphwalk;

/**
 *
 * @author kband
 */
import java.util.Arrays;
import java.util.ArrayList;

public class Graph {

    ArrayList<GNode> allNodes = new ArrayList<>();

    public Graph(Node n) {
        Node startNode = n;
        System.out.println("Creating other nodes~~");
        Node B = new Node("B");
        Node C = new Node("C");
        Node D = new Node("D");
        startNode.addChildren(new Node[]{B, C, D}, startNode);
        Node E = new Node("E");
        Node F = new Node("F");
        B.addChildren(new Node[]{E, F}, B);
        Node G = new Node("G");
        Node H = new Node("H");
        Node I = new Node("I");
        C.addChildren(new Node[]{G, H, I}, C);
        Node J = new Node("J");
        //Node K = new Node("K");
        D.addChildren(new Node[]{J}, D);
    }

    public ArrayList walkGraph(GNode node) {
        System.out
                .println("----------------------------Walk Graph------------------------------");
        ArrayList<GNode> nodes = recBFS(node);
        for (GNode n : nodes) {
            System.out.println(n.getName());
        }
        return nodes;
    }

    public ArrayList<GNode> recBFS(GNode node) {
        allNodes.add(node);
        GNode[] children = node.getChildren();
        for (GNode n : children) {
            ArrayList<GNode> childrenNode = recBFS(n);
        }
        return allNodes;
    }

    public ArrayList paths(GNode startNode) {
        ArrayList<ArrayList<GNode>> possiblepaths = new ArrayList<>();
        possiblepaths = dfsPaths(startNode);
        return possiblepaths;
    }

    public ArrayList<ArrayList<GNode>> dfsPaths(GNode node) {
        ArrayList<ArrayList<GNode>> paths = new ArrayList<ArrayList<GNode>>();
        ArrayList<GNode> children = new ArrayList<GNode>(Arrays.asList(node.getChildren()));
        System.out.println("---------------------Printing all possible paths --------------------");
        if (children.size() > 0) {
            for (int i = 0; i < children.size(); i++) {
                ArrayList<GNode> dfs = new ArrayList<GNode>();
                ArrayList<GNode> childrenL2 = new ArrayList<GNode>(Arrays.asList(children.get(i).getChildren()));
                if (childrenL2.size() > 0) {
                    for (int j = 0; j < childrenL2.size(); j++) {
                        dfs.add(node);
                        dfs.add(children.get(i));
                        dfs.add(childrenL2.get(j));
                    }
                }
                paths.add(dfs);
            }
        }
        return paths;
    }

    public static void printPaths(ArrayList<ArrayList<GNode>> possiblepaths) {
        for (ArrayList<GNode> path : possiblepaths) {
            for (int i = 0; i < path.size(); i++) {
                System.out.print(path.get(i).getName());
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node startNode = new Node("A");
        Graph g = new Graph(startNode);
        ArrayList walk = g.walkGraph(startNode);
        printPaths(g.paths(startNode));
    }
}
