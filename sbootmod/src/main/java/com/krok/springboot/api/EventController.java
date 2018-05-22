package com.krok.springboot.api;

import com.krok.data.EventData;
import com.krok.error.AppException;
import com.krok.error.DAOError;
import com.krok.json.EventJson;
import com.krok.json.mapper.EventMapper;
import com.krok.springboot.dto.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.NoResultException;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Mateusz Krok on 2018-04-15
 */

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    private static Logger logger = Logger.getLogger(
            Thread.currentThread().getStackTrace()[0].getClassName());

    // ******************** EVENT API ******************* //

    @RequestMapping("/event/id/{id}")
    public String findEvent(@PathVariable("id") int id) {
        try {
            EventData event = eventService.getEventById(id);
            return event.toString();
        } catch (NoResultException e) {
            return "No event find";
        }
    }

    @RequestMapping("/event/all")
    public String getAllEvents() {
        try {
            List<EventData> eventList = eventService.getAllEvents();
            for (EventData e : eventList) {
                e.toString();
            }
            return eventList.size() > 0 ? eventList.toString() : "No events found";
        } catch (NoResultException e) {
            return "No events found";
        }
    }

    @RequestMapping(value = "/event/{name}", method = RequestMethod.GET)
    public ResponseEntity<EventJson> findEventByName(@PathVariable String name) {
        logger.info("Event/code: " + name);
        EventMapper eventMapper = new EventMapper();
        try {
            EventData event = eventService.getEventByName(name);
            return new ResponseEntity<>(eventMapper.toEventJson(event), HttpStatus.OK);
        } catch (AppException e) {
            logger.info(e.getCodeMessage());
            if (e.getErrorCode().equals(DAOError.EVENT_NOT_FOUND)) {
                return new ResponseEntity<>(new EventJson(), HttpStatus.NO_CONTENT);
            }
            logger.info(e.getCodeMessage());
            return new ResponseEntity<>(new EventJson(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @RequestMapping(value = "/event/", method = RequestMethod.POST)
    public ResponseEntity<EventJson> newEvent(@RequestBody EventJson eventJson) {
        logger.info("Event/: " + eventJson.getName());
        EventMapper eventMapper = new EventMapper();

        try {
            EventData eventData = eventMapper.toEventData(eventJson);
            eventService.create(eventData);
            eventJson = eventMapper.toEventJson(eventData);
        } catch (AppException e) {
            logger.info(e.getCodeMessage());
            return new ResponseEntity<>(eventJson, HttpStatus.IM_USED);
        }
        logger.info("Event/: and ID is: " + eventJson.getId());
        return new ResponseEntity<>(eventJson, HttpStatus.OK);
//        Calendar today = Calendar.getInstance();
//        Calendar tomorrow = Calendar.getInstance();
//        today.set(Calendar.MILLISECOND, 0);
//        tomorrow.add(Calendar.DATE, 1);
//        tomorrow.set(Calendar.MILLISECOND, 0);
//        EventData event;
//        event = new EventData("C", today.getTime(), tomorrow.getTime(), 1, 20);

//        eventService.create(event);
//        return event.toString();
    }

    @RequestMapping("/event/delete/{id}")
    public String deleteEvent(@PathVariable("id") int id) {
        boolean isDeleted = eventService.deleteEventById(id);
        return isDeleted ? "Deleted: " + id : "Event not exist";
    }
}
