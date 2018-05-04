package com.krok.json.mapper.service;

import com.krok.data.HistoryData;
import com.krok.json.HistoryJson;

/**
 * Created by Mateusz Krok on 2018-05-04
 */

public interface HistoryMapperService {

    HistoryJson toHistoryJson(HistoryData historyData);

    HistoryData toHistoryData(HistoryJson json);
}
