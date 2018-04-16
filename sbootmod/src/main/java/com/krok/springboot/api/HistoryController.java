package com.krok.springboot.api;

import com.krok.springboot.data.HistoryData;
import com.krok.springboot.dto.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.NoResultException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

@RestController
public class HistoryController {

    @Autowired
    HistoryService historyService;

    // ******************** HISTORY API ******************* //

    @RequestMapping("/history/{id}")
    public String findHistoryListByUserId(@PathVariable("id") int id) {
        try {
            List<HistoryData> historyList = historyService.getHistoryListByUserId(id);
            for (HistoryData h : historyList) {
                h.toString();
            }
            return historyList.size() > 0 ? historyList.toString() : "No history found";
        } catch (NoResultException e) {
            return "No history find exception";
        }
    }

    @RequestMapping("/history/ticket/{id}")
    public String findHistoryListByTicketId(@PathVariable("id") int id) {
        try {
            List<HistoryData> historyList = historyService.getHistoryListByTicketId(id);
            for (HistoryData h : historyList) {
                h.toString();
            }
            return historyList.size() > 0 ? historyList.toString() : "No history found";
        } catch (NoResultException e) {
            return "No history find exception";
        }
    }

    @RequestMapping("/history/event/{id}")
    public String findHistoryListByEventtId(@PathVariable("id") int id) {
        try {
            List<HistoryData> historyList = historyService.getHistoryListByEventId(id);
            for (HistoryData h : historyList) {
                h.toString();
            }
            return historyList.size() > 0 ? historyList.toString() : "No history found";
        } catch (NoResultException e) {
            return "No history find exception";
        }
    }

    @RequestMapping("/history/generate")
    public String newHistory() {
        // TODO RequestBody and ResponseBody
        Calendar today = Calendar.getInstance();
        today.set(Calendar.HOUR_OF_DAY, 0);
        HistoryData history;
        history = new HistoryData(1, 1, true, 1, today.getTime(), LocalTime.now());
        historyService.createOrUpdate(history);
        return history.toString();
    }


}
