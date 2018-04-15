package com.sboot.sbootmod.api;

import com.sboot.sbootmod.data.EventData;
import com.sboot.sbootmod.dto.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Mateusz Krok on 2018-04-15
 */

@RestController
public class EventController {

    @Autowired
    EventService eventService;

    // ******************** EVENT API ******************* //

    @RequestMapping("/event/{id}")
    public String findEvent(@PathVariable("id") int id) {
        try {
            EventData event = eventService.getEventById(id);
            return event.toString();
        } catch (NoResultException e) {
            return "No user find";
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

    @RequestMapping("/event/code/{code}")
    public String findEvent(@PathVariable("code") String code) {
        try {
            EventData event = eventService.getEventByCode(code);
            return event.toString();
        } catch (NoResultException e) {
            return "No user find";
        }
    }

    @RequestMapping("/event/generate")
    public String newEvent() {
        // TODO RequestBody and ResponseBody
        Calendar today = Calendar.getInstance();
        Calendar tomorrow = Calendar.getInstance();
        today.set(Calendar.MILLISECOND, 0);
        tomorrow.add(Calendar.DATE, 1);
        tomorrow.set(Calendar.MILLISECOND, 0);
        EventData event;
        event = new EventData("C", today.getTime(), tomorrow.getTime(), 1, 20);
        eventService.createOrUpdate(event);
        return event.toString();
    }

    @RequestMapping("/event/delete/{id}")
    public String deleteEvent(@PathVariable("id") int id) {
        boolean isDeleted = eventService.deleteEventById(id);
        return isDeleted ? "Deleted: " + id : "User not exist";
    }
}
