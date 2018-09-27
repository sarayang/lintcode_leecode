package lintcode.lintcode_leecode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by YANGSONG on 2018-09-27.
 */
public class MeetingRoom {
    public boolean canAttendMeetings(Interval[] intervals) {

        System.out.println(intervals.length);
        if (intervals == null||intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });

        int end = intervals[0].end;
        for (int j = 1;j < intervals.length; j++) {
            if (intervals[j].start < end) {
                return false;
            }

            end = Math.max(end, intervals[j].end);
        }
        return true;
    }
}
