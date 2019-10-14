package contest.w158;

import java.util.ArrayList;
import java.util.List;

/**
 * @auther ikaruga
 * 上午10:42 - 2019/10/13
 */
public class QueensThatCanAttackTheKing {
    class Solution {
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            int[][] map = new int[8][8];
            for (int i = 0; i < queens.length; i++) {
                map[queens[i][0]][queens[i][1]] = 1;
            }
            List<List<Integer>> r = new ArrayList<>();
            search(r, king, map, 0, 1);
            search(r, king, map, 0, -1);
            search(r, king, map, 1, 0);
            search(r, king, map, -1, 0);
            search(r, king, map, 1, 1);
            search(r, king, map, 1, -1);
            search(r, king, map, -1, 1);
            search(r, king, map, -1, -1);
            return r;
        }

        private void search(List<List<Integer>> r, int[] king, int[][] map, int xStep, int yStep){
            List<Integer> l = search(king, map, xStep, yStep);
            if(l != null){
                r.add(l);
            }
        }

        private List<Integer> search(int[] king, int[][] map, int xStep, int yStep) {
            int x = king[0] + xStep;
            int y = king[1] + yStep;
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (map[x][y] == 1) {
                    List<Integer> result = new ArrayList<>();
                    result.add(x);
                    result.add(y);
                    return result;
                }
                x += xStep;
                y += yStep;
            }
            return null;
        }
    }
}
