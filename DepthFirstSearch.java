/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
import java.util.*;
/**
 *
 * @author Nur Arini
 */
public class DepthFirstSearch {
    static Map<String, List<String>> graph = new HashMap<>();
    static Set<String> visited = new HashSet<>();

    public static void main(String[] args) {
        // Membuat graf dengan relasi baru
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

        System.out.println("Hasil pencarian DFS dari " + start + " ke " + target + ":");
        dfs(start, target);
    }

    public static void dfs(String current, String target) {
        System.out.println("Mengunjungi: " + current);
        visited.add(current);

        if (current.equals(target)) {
            System.out.println("Node " + target + " ditemukan!");
            return;
        }

        for (String neighbor : graph.get(current)) {
            if (!visited.contains(neighbor)) {
                dfs(neighbor, target);
            }
        }
    }
}
