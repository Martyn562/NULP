package DML.Lab2;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        int matrixAdjacency[][] = {{0, 3, 0, 0, 0, 34, 0, 80},
                {3, 0, 0, 1, 0, 0, 0, 68},
                {0, 0, 0, 0, 23, 0, 12, 0},
                {0, 1, 0, 0, 53, 0, 0, 39},
                {0, 0, 23, 53, 0, 0, 68, 14},
                {34, 0, 0, 0, 0, 0, 0, 25},
                {0, 0, 12, 0, 68, 0, 0, 99},
                {80, 68, 0, 39, 14, 25, 99, 0}};

        eilerPath(matrixAdjacency);
    }
    private static List<Integer> eilerPath(int[][] matrixAdjacency) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        int v = 0;
        int u;
        int edge;
        stack.push(v);
        while (!stack.empty()) {
            edge = findAdjacencyVertex(matrixAdjacency, stack.peek());
            if (edge == -1) {
                list.add(stack.pop());
            } else {
                u = edge;
                matrixAdjacency[stack.peek()][u]--;
                matrixAdjacency[u][stack.peek()]--;
                stack.push(u);
            }
        }
        System.out.println(list);
        int length = list.stream().mapToInt(x -> x).sum();
        System.out.println(length);

        return list;
    }

    private static int findAdjacencyVertex(int[][] matrixAdjacency, int edge) {
        for (int i = 0; i < matrixAdjacency.length; i++) {
            if (matrixAdjacency[edge][i] > 0) {
                return i;
            }
        }
        return -1;
    }
}