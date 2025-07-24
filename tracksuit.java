import java.util.*;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        Arrays.sort(lost);
        Arrays.sort(reserve);

        boolean[] lostFlag = new boolean[lost.length];  // 도난
        boolean[] reserveFlag = new boolean[reserve.length];    // 여벌

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j]) {
                    lostFlag[i] = true;
                    reserveFlag[j] = true;
                    break;
                }
            }
        }

        // 빌려주기
        for (int i = 0; i < lost.length; i++) {
            if (lostFlag[i]) continue; // 여벌 가진 사람은 skip

            for (int j = 0; j < reserve.length; j++) {
                if (reserveFlag[j]) continue; // 이미 사용했으면 skip

                if (reserve[j] == lost[i] - 1 || reserve[j] == lost[i] + 1) {
                    reserveFlag[j] = true;
                    lostFlag[i] = true;
                    break;
                }
            }
        }

        // 체육복을 못 빌린 학생 수
        int lostCnt = 0;
        for (int i = 0; i < lostFlag.length; i++) {
            if (!lostFlag[i]) lostCnt++;
        }

        return n - lostCnt;
    }
}
