package pl.coreservices.service;

import com.google.common.collect.Lists;
import pl.coreservices.model.web.Statistic;
import pl.coreservices.model.web.StatisticsList;

import java.util.List;

public class StatisticsService {

    public StatisticsList getStatisticList(String name) {
        List<Statistic> statistics;
        if("ALL".equals(name)){
            statistics = Lists.newArrayList(new Statistic("ala", 2), new Statistic("becia", 3));
        } else {
            statistics = Lists.newArrayList(new Statistic(name, 3));
        }
        return new StatisticsList(statistics);
    }

}
