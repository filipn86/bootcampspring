package pl.coreservices.model;

import java.io.Serializable;
import java.util.List;

public class StatisticsList implements Serializable{

    private List<Statistic> statistics;

    public StatisticsList(List<Statistic> statistics) {
        this.statistics = statistics;
    }

    public List<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(List<Statistic> statistics) {
        this.statistics = statistics;
    }
}
