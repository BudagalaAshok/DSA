package com.dsalgo.stacks;

import java.util.*;

public class CurrentWorkingDirectory {
    public static void printCurrentDirectory(List<String> commands) {
        String currentPath = "/"; // Initialize current path as root
        for (String command : commands) {
            if (command.startsWith("cd")) {
                String[] tokens = command.split(" ");
                String path = tokens[1];
                if (path.equals("..")) {
                    int lastSlashIndex = currentPath.lastIndexOf('/');
                    if (lastSlashIndex != -1) {
                        currentPath = currentPath.substring(0, lastSlashIndex);
                    }
                } else {
                    if (!path.startsWith("/")) {
                        path = currentPath + "/" + path; // Convert to absolute path
                    }
                    currentPath = simplifyPath(path);
                }
            } else if (command.equals("pwd")) {
                System.out.println(currentPath);
            }
        }
    }

    private static String simplifyPath(String path) {
        Deque<String> stack = new ArrayDeque<>();
        String[] dirs = path.split("/");
        for (String dir : dirs) {
            if (dir.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (!dir.isEmpty() && !dir.equals(".")) {
                stack.push(dir);
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/").append(stack.pollLast());
        }
        return result.length() == 0 ? "/" : result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            List<String> commands = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                commands.add(scanner.nextLine().trim());
            }
            printCurrentDirectory(commands);
            System.out.println(); // Print newline between test cases
        }
        scanner.close();
    }
}
