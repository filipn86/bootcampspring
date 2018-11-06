package pl.coreservices.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.coreservices.model.Statistic;
import pl.coreservices.model.StatisticsList;
import pl.coreservices.service.MessageService;
import pl.coreservices.service.StatisticsService;

@RestController()
@RequestMapping("/statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private MessageService messageService;


    @RequestMapping(method = RequestMethod.GET, value = "/getStatistics")
    public StatisticsList getStatistics(@RequestParam(value = "name", defaultValue = "ALL") String name) {
        return statisticsService.getStatisticList(name);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/sendStatistic")
    public void sendStatistic(@RequestParam(value = "name") String name) {
        messageService.sendMessage(new Statistic(name, 1));
    }

}
