/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.*;
/**
 *
 * @author Nur Arini
 */
public class BreadthFirstSearch {

    static Map<String, List<String>> graph = new HashMap<>();
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) {

        graph.put("a1", List.of("a2", "a3"));
        graph.put("a2", List.of("a1", "a4", "a5"));
        graph.put("a3", List.of("a1", "a6", "a7"));
        graph.put("a4", List.of("a2"));
        graph.put("a5", List.of("a2"));
        graph.put("a6", List.of("a3"));
        graph.put("a7", List.of("a3", "a8"));
        graph.put("a8", List.of("a7"));

        String start = "a1";
        String target = "a8";

        System.out.println("Hasil pencarian BFS dari " + start + " ke " + target + ":");
        bfs(start, target);
    }

    public static void bfs(String start, String target) {
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println("Mengunjungi: " + current);

            if (current.equals(target)) {
                System.out.println("Node " + target + " ditemukan!");
                return;
            }

            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("Node " + target + " tidak ditemukan.");
    }
}
