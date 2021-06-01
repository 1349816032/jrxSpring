package com.example.jrxspring.repository;
import com.example.jrxspring.model.DetailTransaction;
import com.example.jrxspring.model.all;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;
/**
 * @author ZhaoYongfeng
 */
@Mapper
@Repository
public interface DetailTransactionRepo {
    List<DetailTransaction> queryAllDetailTransaction();
    List<DetailTransaction> queryFindByCustId(long custId);
    List<DetailTransaction> queryFindByDate(Date txnDateTime);
    List<DetailTransaction> queryStatistic(long custId,Date txnDatetime);
    List<DetailTransaction> queryFindByTransType(String transType);
    List<DetailTransaction> queryFindByTranno(long tranno);
    List<DetailTransaction> querySortByDate();
    void insertDetailTransaction(long cust_id,String account,String card_nbr,
                                 long tranno,int month_nbr,Double bill,String trans_type,
                                 Date txn_datetime);
    void updateDetailTransaction();
    void deleteDetailTransaction();
}
