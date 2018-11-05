package pl.coreservices.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coreservices.model.web.StatisticsList;
import pl.coreservices.service.StatisticsService;

@RestController()
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @RequestMapping(method = RequestMethod.GET, value = "/getStatistics")
    public StatisticsList getStatistics(@RequestParam(value = "name", defaultValue = "ALL")String name) {
        return statisticsService.getStatisticList(name);
    }
}
