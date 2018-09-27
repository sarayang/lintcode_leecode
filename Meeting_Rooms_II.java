package lintcode.lintcode_leecode;

import java.util.Arrays;

/**
 * Created by YANGSONG on 2018-09-25.
 *
 *
 */

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}
public class Meeting_Rooms_II {
    // using two list to contain start time and end time
    // if start < end => meeting does not finish, need a new room
    //    start > end => meeting finishes, do not need a new room
    public int minMeetingRooms(Interval[] intervals) {
        int[] startTime = new int[intervals.length];
        int[] endTime = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            startTime[i] = intervals[i].start;
            endTime[i] = intervals[i].end;
        }

        Arrays.sort(startTime);
        Arrays.sort(endTime);

        int room = 0;
        int end = 0;
        for (int i = 0; i< startTime.length; i++) {
            if (startTime[i] < endTime[end]) {
                room++;
            } else {
                end++;
            }
        }

        return room;



    }
}
