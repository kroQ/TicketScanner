package com.krok.springboot.dto.service;

import com.krok.springboot.data.HistoryData;

import java.util.List;

/**
 * Created by Mateusz Krok on 2018-04-13
 */

public interface HistoryService {

    void createOrUpdate(HistoryData historyData);

    List<HistoryData> getHistoryListByUserId(int id);

    List<HistoryData> getHistoryListByTicketId(int id);

    List<HistoryData> getHistoryListByEventId(int id);

}
