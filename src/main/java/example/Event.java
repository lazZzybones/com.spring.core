package example;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

public class Event {
    int id;
    String msg;
    Date date;
    DateFormat df;

    Event(Date date, DateFormat df){
        this.date = date;
        this.id = new Random().nextInt();
        this.df = df;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
               "id=" + id +
               ", msg='" + msg + '\'' +
               ", date=" + df.format(date) +
               '}';
    }
}
