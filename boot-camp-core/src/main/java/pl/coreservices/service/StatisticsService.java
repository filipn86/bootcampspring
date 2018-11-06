package pl.coreservices.service;

import com.google.common.collect.Lists;
import pl.coreservices.db.StatisticsDB;
import pl.coreservices.model.Statistic;
import pl.coreservices.model.StatisticsList;

import java.util.List;

public class StatisticsService {

    private StatisticsDB statisticsDB;


    public StatisticsService(StatisticsDB statisticsDB) {
        this.statisticsDB = statisticsDB;
    }

    public StatisticsList getStatisticList(String name) {
        List<Statistic> statistics;
        if("ALL".equals(name)){
            statistics = statisticsDB.getAllStatistics();
        } else {
            statistics = Lists.newArrayList(statisticsDB.getStatisticByName(name));
        }
        return new StatisticsList(statistics);
    }

}
