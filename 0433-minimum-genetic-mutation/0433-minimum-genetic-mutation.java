class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        return bfs(startGene, endGene, bank);
    }

    private static class Node {
        String gene;
        int check;

        public Node(String gene, int check) {
            this.gene = gene;
            this.check = check;
        }
    }

    private static int bfs(String startGene, String endGene, String[] bank) {
        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(startGene, 0));
        int depth = 0;

        while (!que.isEmpty()) {
            int size = que.size();

            while (size-- > 0) {
                Node cur = que.poll();
                String curGene = cur.gene;
                int bitCheck = cur.check;

                if (curGene.equals(endGene)) {
                    return depth;
                }

                for (int idx = 0; idx < bank.length; idx++) {
                    if ((bitCheck & (1 << idx)) != 0) {
                        continue;
                    }

                    String bankGene = bank[idx];
                    int diffCnt = 0;

                    for (int i = 0; i < 8; i++) {
                        if (curGene.charAt(i) != bankGene.charAt(i)) {
                            diffCnt++;
                        }
                    }

                    if (diffCnt == 1) {
                        que.offer(new Node(bankGene, bitCheck | (1 << idx)));
                    }
                }
            }

            depth++;
        }

        return -1;
    }
}