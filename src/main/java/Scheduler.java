import java.util.ArrayList;
import java.util.PriorityQueue;

public class Scheduler {
    boolean[] status;
    PriorityQueue<Event> other;
    ArrayList<Event> ans;

    /**
     * This class takes an ArrayList of events and merge it with tbe new events.
     * Implemented through PriorityQueue and topological sort.
     * @param set
     * @param other
     */
    public Scheduler(ArrayList<Event> set, PriorityQueue<Event> other) {
        status = new boolean[31 * 24 * 60 + 23 * 60 + 59 + 1];
        ans = set;
        this.other = other;

        //default no work for off hours and lunch time
        for (int i = 0; i < status.length; i++) {
            int currHour = i / 60 % 24;
            if (currHour < 9 || currHour > 17
                    || currHour == 12) {
                status[i] = true;
            }
        }

        //fill all existing events
        for (Event e : set) {
            for (int i = e.timeStart; i <= e.timeEnd; i++) {
                status[i] = true;
            }
        }
    }

    public void merge() {
        //TO DO
        while (!other.isEmpty()) {
            Event curr = other.poll();
            //TO DO
        }
    }

    public ArrayList<Event> getAns() {
        return ans;
    }

}

