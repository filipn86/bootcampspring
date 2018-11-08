package pl.coreservices.db;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import pl.coreservices.model.Statistic;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StatisticsDB {

    private IMap<String, Statistic> statistics;

    public StatisticsDB(HazelcastInstance hazelcastInstance) {
        statistics = hazelcastInstance.getMap("statistics");
    }

    public void addStatistics(Statistic statistic) {
        statistics.putIfAbsent(statistic.getName(), new Statistic(statistic.getName(), 0));
        statistics.get(statistic.getName()).increaseCountBy(statistic.getCount());
    }

    public List<Statistic> getAllStatistics() {
        return Lists.newArrayList(statistics.values());
    }

    public Statistic getStatisticByName(String name) {
        return statistics.getOrDefault(name, new Statistic(name, 0));
    }

}
