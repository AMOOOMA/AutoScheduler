import biweekly.ICalendar;
import biweekly.component.VEvent;
import biweekly.io.text.ICalReader;
import biweekly.property.DateEnd;
import biweekly.property.DateStart;
import biweekly.property.Summary;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class Parser {
    ArrayList<Event> set;

    /**
     * default constructor that take a String as an input value
     * and parse all the events in the file to an ArrayList instance.
     * @param path
     */
    public Parser(String path) {
        //TO DO
        set = new ArrayList<Event>();
        File f = new File(path);
        try {
            ICalReader reader = new ICalReader(f);
            ICalendar ical;
            DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm");
            while ((ical = reader.readNext()) != null) {
                for (VEvent event : ical.getEvents()) {
                    DateStart dateStart = event.getDateStart();
                    String dateStartStr = (dateStart == null) ? null : df.format(dateStart.getValue());
                    Summary summary = event.getSummary();
                    String summaryStr = (summary == null) ? null : summary.getValue();
                    DateEnd dateEnd = event.getDateEnd();
                    String dateEndStr = (dateEnd == null) ? null : df.format(dateEnd.getValue());

                    Event e = new Event(summaryStr, dateStartStr, dateEndStr);
                    set.add(e);
                }
            }
        } catch (Exception e) {
            //Do nothing
        }
    }

    public ArrayList<Event> getSet() {
        return set;
    }
}
