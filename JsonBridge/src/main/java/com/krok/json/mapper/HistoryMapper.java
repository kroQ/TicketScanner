package com.krok.json.mapper;

import com.krok.data.HistoryData;
import com.krok.json.HistoryJson;
import com.krok.json.mapper.service.HistoryMapperService;

/**
 * Created by Mateusz Krok on 2018-05-04
 */

public class HistoryMapper implements HistoryMapperService {

    public HistoryJson toHistoryJson(HistoryData historyData) {
        HistoryJson json = new HistoryJson();
        json.setId(historyData.getId());
        json.setDate(historyData.getDate());
        json.setEventId(historyData.getEventId());
        json.setInside(historyData.isInside());
        json.setTicketId(historyData.getTicketId());
        json.setTime(historyData.getTime());
        json.setUserId(historyData.getUserId());
        return json;
    }

    public HistoryData toHistoryData(HistoryJson json) {
        HistoryData historyData = new HistoryData();
        historyData.setId(json.getId());
        historyData.setDate(json.getDate());
        historyData.setEventId(json.getEventId());
        historyData.setInside(json.isInside());
        historyData.setTicketId(json.getTicketId());
        historyData.setTime(json.getTime());
        historyData.setUserId(json.getUserId());
        return historyData;
    }
}
