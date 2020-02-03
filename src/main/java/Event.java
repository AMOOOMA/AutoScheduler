public class Event {
    String summary;
    String date;
    String dateEnd;
    int duration;
    int timeStart;
    int timeEnd;

    /**
     * Default constructor for existing events.
     * @param summary
     * @param date
     * @param dateEnd
     */
    public Event(String summary, String date, String dateEnd) {
        this.summary = summary;
        this.date = date;
        this.dateEnd = dateEnd;
        timeStart = parseDate(date);
        timeEnd = parseDate(dateEnd);
    }

    /**
     * Constructor for new events.
     * @param summary
     * @param duration
     */
    public Event(String summary, int duration) {
        this.summary = summary;
        this.duration = duration;
    }

    public int parseDate(String date) {
        int day = Integer.parseInt(date.substring(3, 5));
        int hour = Integer.parseInt(date.substring(11, 13));
        int minute = Integer.parseInt(date.substring(14, 16));
        return day * 24 * 60 + hour * 60 + minute;
    }

}
