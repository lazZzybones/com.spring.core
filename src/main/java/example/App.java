package example;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

public class App {

    private Client client;
    private EventLogger eventLogger;
    private Event event;
    private Map<EventType , EventLogger> loggers;

    App(Client client,EventLogger logger, Map<EventType , EventLogger> loggres, Event event){
        this.client = client;
        this.eventLogger = logger;
        this.event = event;
        this.loggers = loggres;
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
        App app = (App) ctx.getBean("app");
        System.out.println(app.client.getGreeting());
        app.logEvent(EventType.ERROR, app.event);
        ctx.close();
    }

    void logEvent(EventType type, Event event){
        EventLogger logger = loggers.get(type);
        if(logger == null){
            logger = eventLogger;
        }

        logger.logEvent(event);
    }
}
