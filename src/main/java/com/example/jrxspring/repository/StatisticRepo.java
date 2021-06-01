package com.example.jrxspring.repository;

import com.example.jrxspring.model.Statistic;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

/**
 * @author ZhaoYongfeng
 */
@Mapper
@Repository
public interface StatisticRepo {
    List<Statistic> quertAllStatistic();
    List<Statistic> queryFindByName(String name);
    List<Statistic> queryFindByDate(Date date);
    List<Statistic> queryFindDate(Date date);
    void insertStatistic(long cust_id,Date update_time,Date trans_date,String surname,
                         double tran_max_amt,double pay_amt,long tran_cnt,long pay_cnt,
                         double tran_amt);
    void updateStatistic();
    void deleteStatistic();
}
