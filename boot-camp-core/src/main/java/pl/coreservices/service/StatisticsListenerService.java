package pl.coreservices.service;

import pl.coreservices.db.StatisticsDB;
import pl.coreservices.model.Statistic;

public class StatisticsListenerService implements ServiceListener<Statistic>{

    private StatisticsDB statisticsDB;

    public StatisticsListenerService(StatisticsDB statisticsDB) {
        this.statisticsDB = statisticsDB;
    }

    @Override
    public void service(Statistic object) {
        statisticsDB.addStatistics(object);
    }
}
