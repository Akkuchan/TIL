import java.util.*;

public class tree {
    public static int[][] createMatrix(int[][] edges) {
            // TODO:

            List<Integer> testList = new ArrayList<Integer>();
            for (int j = 0; j < edges.length; j++) {
                for (int k = 0; k < 2; k++) {
                    testList.add(edges[j][k]);
                }
            }
            int maxnum = testList.stream().mapToInt(a -> a).max().getAsInt();

            int[][] output = new int[maxnum+1][maxnum+1];
            for (int i = 0; i < edges.length; i++) {

                output[edges[i][0]][edges[i][1]] = 1;

                if (edges[i][2] == 1) {
                    output[edges[i][1]][edges[i][0]] = 1;
                } else output[edges[i][1]][edges[i][0]] = 0;
            }

            return output;

        }
    }

