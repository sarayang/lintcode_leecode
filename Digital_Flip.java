package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-23.
 */
public class Digital_Flip {
    public int flipDigit(int[] A) {
        int n = A.length;
        if (n <= 1) {
            return 0;
        }

        int[][] f = new int[n + 1][2];

        // initialization
        f[0][0] = f[0][1] = 0;

        int i, j, k, t;
        // first i digits
        for (i = 1; i <= n; i++) {
            // change a[i - 1] to j
            for (j = 0; j < 2; j++) {
                f[i][j] = Integer.MAX_VALUE;
                t = 0;
                if (A[i - 1] != j) {
                    t = 1;
                }

                // t = I_{A[i-1]!=j}
                for (k = 0; k < 2; ++k) {
                    // we do not deal with this
                    if (k == 0 && j == 1) {
                        continue;
                    }
                    f[i][j] = Math.min(f[i][j], f[i - 1][k] + t);
                }
            }
        }

        return Math.min(f[n][0], f[n][1]);
    }

    public static void main(String[] args) {
        int[] A = {0,1,0,1};
        Digital_Flip d = new Digital_Flip();
        System.out.println(d.flipDigit(A));

        String s = "";
        System.out.println(s.length());

    }
}
