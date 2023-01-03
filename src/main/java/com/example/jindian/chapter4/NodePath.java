package com.example.jindian.chapter4;

import java.util.LinkedList;

//4.1 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
public class NodePath {
    enum State {
        Unvisited,
        Visited,
        Visiting
    }

    boolean search(Graph graph, Node start, Node end) {
        if (start == end) {
            return true;
        }
        for (Node n : graph.nodes) {
            n.state = State.Unvisited;
        }
        start.state = State.Visiting;
        LinkedList<Node> q = new LinkedList();
        q.add(start);
        Node u;
        while (!q.isEmpty()) {
            u = q.removeFirst(); // 例如出列
           /* if (u != null) {
              for (Node v : u.getAdjacent()) {
                   if (v.state == State.Unvisited) {
                        if (v == end) {
                           return true;
                           } else {
                            v.state = State.Visiting;
                            q.add(v);
                           }
                        }
                    }
              u.state = State.Visited;
                 }
            }*/


        }
        return false;
    }
}
