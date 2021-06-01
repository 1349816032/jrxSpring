package com.example.jrxspring.controller;

import com.example.jrxspring.model.Statistic;
import com.example.jrxspring.repository.DetailTransactionRepo;
import com.example.jrxspring.repository.StatisticRepo;
import com.example.jrxspring.repository.UserInformationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ZhaoYongfeng
 */
@Controller
@RequestMapping(path = "/statistic")
public class StatisticController {
    @Autowired
    private UserInformationRepo userInformationRepo;

    @Autowired
    private DetailTransactionRepo detailTransactionRepo;

    @Autowired
    private StatisticRepo statisticRepo;

    @GetMapping(path = "statistic")
    public String statistic(){
        return "statistic";
    }


    @ResponseBody
    @GetMapping(path = "column")
    @CrossOrigin
    public Column column(){
        Column bar = new Column();

        final List<Statistic> statistics = statisticRepo.quertAllStatistic();
        long countIn=0;
        long countOut=0;
        for(Statistic s :statistics){
            countOut=countOut+s.getTranCnt();
            countIn=countIn+s.getPayCnt();
        }
        bar.countIn=countIn;
        bar.countOut=countOut;
        bar.xAxis= new String[]{"当月还款总笔数", "当月消费总笔数"};
        bar.title="近一个月消费总笔数和还款总笔数";
        return bar;
    }

    @ResponseBody
    @GetMapping(path = "pie")
    @CrossOrigin
    public List<pie> pie() throws ParseException {
        double sum=0;
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
        long time = dateformat.parse("2021-5-31").getTime();
        final List<Statistic> statistics = statisticRepo.queryFindByDate(new Date(time));
        final List<Statistic> statistics1 = statisticRepo.queryFindDate(new Date(time));
        Map<String,Double> map = new HashMap<>();
        int i=0;
        for(Statistic s:statistics1){
            sum=sum+s.getTranAmt();
        }
        List<pie> list = new ArrayList<>();
        for(Statistic s:statistics){
            pie pie = new pie();
            sum=sum-s.getTranAmt();
            pie.value =s.getTranAmt();
            pie.name=s.getSurname();
            list.add(pie);
            i++;
        }
        pie pie = new pie();
        pie.name="其他";
        pie.value =sum;
        list.add(pie);

        return list;
    }
}
class pie{
    public String name;
    public double value;
}
class Column {
    public String title;
    public String[] xAxis;
    public long countIn;
    public long countOut;
}