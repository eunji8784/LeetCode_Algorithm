class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        int[] arr = new int[n * n + 1];

        int num = 1;
        boolean flag = true;

        for (int i = n - 1; i >= 0; i--) {
            if (flag) {
                for (int j = 0; j < n; j++) {
                    arr[num++] = board[i][j];
                }
            } else {
                for (int j = n - 1; j >= 0; j--) {
                    arr[num++] = board[i][j];
                }
            }
            flag = !flag;
        }

        return bfs(board, arr, n);
    }

    private static int bfs(int[][] board, int[] arr, int n) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] vst = new boolean[n * n + 1];
        que.offer(1);
        vst[1] = true;
        int count = 0;

        while (!que.isEmpty()) {
            int size = que.size();

            while (size-- > 0) {
                int num = que.poll();

                if (num == n * n) {
                    return count;
                }

                for (int i = num + 1; i <= Math.min(num + 6, n * n); i++) {
                    int next = (arr[i] == -1 ? i : arr[i]);
                    if (!vst[next]) {
                        vst[next] = true;
                        que.offer(next);
                    }
                }
            }

            count++;
        }

        return -1;
    }
}