package example;

import java.util.Collection;
import java.util.List;

public class CombinedEventLogger implements EventLogger{
    Collection<? extends EventLogger> loggers;

    CombinedEventLogger( List<EventLogger> loggers){
        this.loggers = loggers;
    }

    @Override
    public void logEvent(Event event) {
        for(EventLogger logger : loggers){
            logger.logEvent(event);
        }
    }
}
