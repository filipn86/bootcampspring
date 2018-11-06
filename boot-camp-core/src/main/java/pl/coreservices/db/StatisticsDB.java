package pl.coreservices.db;

import com.google.common.collect.Maps;
import pl.coreservices.model.Statistic;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsDB {

    private Map<String, Integer> statistics;

    public StatisticsDB() {
        statistics = Maps.newHashMap();
    }

    public void addStatistics(Statistic statistic) {
        statistics.putIfAbsent(statistic.getName(), 0);
        statistics.put(statistic.getName(), statistics.get(statistic.getName())+statistic.getCount());
    }

    public List<Statistic> getAllStatistics() {
        return statistics.entrySet().stream().map( st-> new Statistic(st.getKey(), st.getValue())).collect(Collectors.toList());
    }

    public Statistic getStatisticByName(String name) {
        return new Statistic(name, statistics.getOrDefault(name, 0));
    }

}
