package com.dsalgo.stacks;

import java.util.*;

public class ChangingDirectories {

    public static void changeDirectory(String[] commands) {

        Deque<String> queue = new ArrayDeque<>();
        for (String eachCommand : commands) {
            if (eachCommand.startsWith("cd")) {
                String[] tokens = eachCommand.split(" ");
                String[] path = tokens[1].split("/");
                for (String dir : path) {
                    if (dir.equals("..")) {
                        if (!queue.isEmpty()) {
                            queue.pop();
                        }
                    } else {
                        queue.push(dir);
                    }

                }
            } else if (eachCommand.startsWith("pwd")) {
                StringBuilder pwd = new StringBuilder();
                queue.descendingIterator().forEachRemaining(s -> pwd.append(s).append("/"));
                System.out.println(pwd.length() == 0 ? "/" : pwd.toString());
            }

        }

    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            String[] commands = new String[N];
            for (int i = 0; i < N; i++) {
                commands[i] = scanner.nextLine().trim();
            }
            changeDirectory(commands);
            System.out.println(); // Print newline between test cases
        }
        scanner.close();

    }

}
