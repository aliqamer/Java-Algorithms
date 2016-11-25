package com.datastructure;

import java.util.*;

/**
 * Created by Ali on 11/15/2016.
 * https://www.youtube.com/watch?v=zaBhtODEL0w
 *
 */

class Graph {
    Map<Integer, Node> lookup = new HashMap<>();

    class Node {
        int id;
        List<Node> adjacentList = new LinkedList<>();

        private Node(int id) {
            this.id = id;
        }
    }

    private Node getNode(int id){
        return lookup.get(id);
    }

    public void addEdge(int s, int d){
        Node source = getNode(s);
        Node dest = getNode(d);
        source.adjacentList.add(dest);
    }

    public boolean hasPathDFS(int s , int d){
        Node source = getNode(s);
        Node dest = getNode(d);

        Set<Integer> visited = new HashSet<>();
        return hasPathDFS(source, dest, visited);

    }

    private boolean hasPathDFS(Node source, Node dest, Set<Integer> visited) {

        if(visited.contains(source.id)){
            return false;
        }
        visited.add(source.id);
        if(source.id == dest.id){
            return true;
        }

        for (Node child : source.adjacentList) {
            if(hasPathDFS(child, dest, visited)){
                return true;
            }
        }
        return false;
    }

    public boolean hasBFSPath(int s, int d){
        Node source = getNode(s);
        Node dest = getNode(d);

        LinkedList<Node> nextToVisit = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        nextToVisit.add(source);

        while (!nextToVisit.isEmpty()){
            Node node = nextToVisit.remove();
            if(node == null){
                return false;
            }
            if(node.id == dest.id){
                return true;
            }
            if(visited.contains(node.id)){
                continue;
            }
            visited.add(node.id);
            for (Node child : nextToVisit) {
                nextToVisit.add(child);
            }
        }
        return false;
    }
}

public class GraphTest {

    public static void main(String args[]) {

        GraphTest object = new GraphTest();

        LinkedList<Graph.Node>[] items = new LinkedList[10];
        System.out.println(items[0]);

    }
}
