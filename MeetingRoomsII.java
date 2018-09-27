package lintcode.lintcode_leecode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by YANGSONG on 2018-09-26.
 */

class Interval_919 {
    int start, end;
    Interval_919(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

// use sweep line algorithm, sort each end points (start and end) if end and start have same value, deal with end first.
class Pair_919 implements Comparable<Pair> {
    int time;
    int startOrEnd;
    Pair_919(int t, int st) {
        this.time = t;
        this.startOrEnd = st;
    }

    @Override
    public int compareTo(Pair p) {
        if ((this.time - p.time) == 0) {
            if (this.startOrEnd == -1) {
                return 1;
            } else if (p.startOrEnd == -1) {
                return -1;
            } else {
                return 0;
            }
        }
        return this.time - p.time;
    }

}

public class MeetingRoomsII {
    public int minMeetingRooms(List<Interval_919> intervals) {
        if (intervals == null) {
            return 0;
        }
        if (intervals.size() < 2) {
            return 1;
        }

        List<Pair_919> list = new ArrayList<>();
        for (Interval_919 i : intervals) {
            Pair_919 start = new Pair_919(i.start, 1);
            Pair_919 end = new Pair_919(i.end, -1);
            list.add(start);
            list.add(end);
        }

//        Collections.sort(list);
        int max = 0;
        int amount = 0;
        for (Pair_919 p : list) {
            amount += p.startOrEnd;
            max = Math.max(max, amount);
        }

        return max;
    }

}
