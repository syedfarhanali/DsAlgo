package algoexpert.graphs;

import java.util.ArrayList;

public class DFS {

    public static void main(String[] args) {

        Node ni = new Node("I");
        Node nj = new Node("J");
        Node nk = new Node("K");
        Node ne = new Node("E");
        Node nh = new Node("H");
        Node nc = new Node("C");


        ArrayList<Node> childrenG = new ArrayList<>();
        childrenG.add(nk);
        Node ng = new Node("G",childrenG);

        ArrayList<Node> childrenF = new ArrayList<>();
        childrenF.add(ni);
        childrenF.add(nj);
        Node nf = new Node("F",childrenF);

        ArrayList<Node> childrenB = new ArrayList<>();
        childrenB.add(ne);
        childrenB.add(nf);
        Node nb = new Node("B",childrenB);

        ArrayList<Node> childrenD = new ArrayList<>();
        childrenD.add(ng);
        childrenD.add(nh);
        Node nd = new Node("D",childrenD);

        ArrayList<Node> childrenA = new ArrayList<>();
        childrenA.add(nb);
        childrenA.add(nc);
        childrenA.add(nd);
        Node na = new Node("A",childrenA);

        ArrayList<String> array = new ArrayList<>();
        na.depthFirstSearch(array);

    }

    static class Node {
        String name;
        ArrayList<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public Node(String name,ArrayList<Node> children) {
            this.name = name;
            this.children = children;
        }

        public ArrayList<String> depthFirstSearch(ArrayList<String> array) {

            array.add(this.name);
            for(int i = 0 ; i< this.children.size() ; i++){
                this.children.get(i).depthFirstSearch(array);
            }
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }
}
