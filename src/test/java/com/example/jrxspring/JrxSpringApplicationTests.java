package com.example.jrxspring;

import com.example.jrxspring.model.DetailTransaction;
import com.example.jrxspring.model.Statistic;
import com.example.jrxspring.model.UserInformation;
import com.example.jrxspring.model.all;
import com.example.jrxspring.repository.DetailTransactionRepo;
import com.example.jrxspring.repository.StatisticRepo;
import com.example.jrxspring.repository.UserInformationRepo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.List;

@SpringBootTest
class JrxSpringApplicationTests {

    @Autowired
    private UserInformationRepo userInformationRepo;

    @Autowired
    private StatisticRepo statisticRepo;

    @Autowired
    private DetailTransactionRepo detailTransactionRepo;

    @Test
    void contextLoads() {
        List<UserInformation> user = userInformationRepo.queryAllUser();
        System.out.println(user.toString());
    }

    @Test
    void contextLoads1() {
        List<UserInformation> user = userInformationRepo.queryFindByName("user1");
        user.forEach(System.out::println);
        List<Statistic> statistic = statisticRepo.quertAllStatistic();
        statistic.forEach(System.out::println);
    }

    @Test
    void contextLoads2(){
        String surname="user";
        int gender;
        String educa_des;
        String mar_des;
        long birthday;
        String address;
        String[] str1={"本科","高中","中专","大专","硕士"};
        String[] str2={"已婚","未婚"};
        String[] str3={"北京市海淀区","湖南省湘潭市","湖南省长沙市",
                "北京市朝阳区","北京市东城区","北京市西城区","湖南省株洲市"};
        for(int i=4;i<200;i++){
            surname = "user";
            surname = surname + String.valueOf(i);
            gender = (int) (Math.random()*1000)%2;
            educa_des = str1[(int)(Math.random()*1000%5)];
            mar_des = str2[(int)(Math.random()*1000%2)];
            birthday = ((int)(Math.random()*1000%12)+1)*100 + (int)(Math.random()*1000%28+1);
            address = str3[(int)(Math.random()*1000%7)];
            System.out.println("surname:"+surname+" gender:"+gender+" educa_des:"+educa_des+" mar_des:"+mar_des
            +" birthday:"+birthday+" address:"+address);
            userInformationRepo.insertUserInformation(surname,gender,educa_des,mar_des,birthday,address);
        }


    }
    @Test
    void contextLoad3() throws ParseException {
        DetailTransaction detailTransaction = new DetailTransaction();
        List<UserInformation> userInformations = userInformationRepo.queryAllUser();
        int sum=0;
        String[] str1 = {"消费","还款"};
        for(UserInformation i : userInformations){
            long date = (((int)(Math.random()*1000%12))%5+1)*100 + (int)(Math.random()*1000%28+1);
            SimpleDateFormat dateformat = new SimpleDateFormat ("yyyy-MM-dd");
            for(int j = 0 ; j<10+(int)(Math.random()*100)%10;j++){
                long time = (dateformat.parse("2021-5-"+(int)(Math.random()*1000%31+1))).getTime();
                long cust_id=i.getCustId();
                detailTransaction.setAccount(String.valueOf(i.getCustId())+String.valueOf(i.getBirthday()));
                detailTransaction.setCardNbr("62227878"+String.valueOf(i.getCustId())+String.valueOf((int)Math.random()*1000%9));
                detailTransaction.setTranno(date*100000+sum++);
                detailTransaction.setMonthNbr(date/100);
                detailTransaction.setBill(Math.random()*10000);
                detailTransaction.setTransType(str1[(int)(Math.random()*1000%2)]);
                detailTransaction.setTxnDatetime(new Date(time));
                detailTransaction.setCustId(cust_id);
                detailTransactionRepo.insertDetailTransaction(detailTransaction.getCustId(),detailTransaction.getAccount(),
                        detailTransaction.getCardNbr(),detailTransaction.getTranno(), (int) detailTransaction.getMonthNbr(),
                        detailTransaction.getBill(), detailTransaction.getTransType(),detailTransaction.getTxnDatetime());
                System.out.println(detailTransaction.toString());
            }

        }
    }

    @Test
    void contextLoad4(){
        final List<UserInformation> userInformations = userInformationRepo.queryAllUser();
        for(UserInformation i : userInformations){
            Statistic statistic = new Statistic();
            List<DetailTransaction> detailTransactions = detailTransactionRepo.queryFindByCustId(i.getCustId());
            statistic.setCustId(i.getCustId());
            statistic.setSurname(i.getSurname());
            java.util.Date date=new java.util.Date();
            DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time=format.format(date);//time就是当前时间
            for(int sum=1;sum<=31;sum++){
                long trans_date = (((int)(Math.random()*1000%12))%5+1)*100 + sum;
                SimpleDateFormat dateformat = new SimpleDateFormat ("yyyy-MM-dd");
                System.out.println(statistic.toString());
            }

        }

    }

    @Test
    void contextLoad5() throws ParseException {
        int countIn,countOut;
        double sumIn,sumOut;
        double max;
        SimpleDateFormat dateformat = new SimpleDateFormat ("yyyy-MM-dd");
        final List<UserInformation> userInformations = userInformationRepo.queryAllUser();
        for(UserInformation u : userInformations){
            for(int i=1;i<=31;i++) {
                countIn = 0;
                countOut=0;
                sumOut=0;
                sumIn = 0;
                max = 0;
                long time = (dateformat.parse("2021-5-" + String.valueOf(i))).getTime();
                final List<DetailTransaction> detailTransactions = detailTransactionRepo.queryStatistic(u.getCustId(), new Date(time));
                for (DetailTransaction d : detailTransactions) {
                    if (d.getBill() > max) max = d.getBill();
                    if("消费".equals(d.getTransType())){
                        countOut++;
                        sumOut = sumOut+d.getBill();
                    }
                    else {
                        countIn++;
                        sumIn = sumIn+d.getBill();
                    }
                }
                Statistic statistic = new Statistic();
                statistic.setSurname(u.getSurname());
                statistic.setCustId(u.getCustId());
                statistic.setTransDate(new Date(time));
                statistic.setTranAmt(sumOut);
                statistic.setTranCnt(countOut);
                statistic.setPayAmt(sumIn);
                statistic.setPayCnt(countIn);
                statistic.setTranMaxAmt(max);
//                java.util.Date date = new java.util.Date();
//                DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//                String detailtime = format.format(date);//time就是当前时间
//                statistic.setUpdateTime(new Date(format.parse(detailtime).getTime()));
//                OffsetDateTime offsetDateTime=OffsetDateTime.parse(detailtime);
                statistic.setUpdateTime(new Date(time));
                if(countOut!=0 || countIn!=0){
                    System.out.println(statistic.toString());
                    statisticRepo.insertStatistic(statistic.getCustId(),statistic.getUpdateTime(),
                            statistic.getTransDate(),statistic.getSurname(),statistic.getTranMaxAmt(),
                            statistic.getPayAmt(),statistic.getTranCnt(),
                            statistic.getPayCnt(),statistic.getTranAmt());
                }

            }


        }

    }
    @Test
    void contextLoad6() throws ParseException {
        SimpleDateFormat dateformat = new SimpleDateFormat ("yyyy-MM-dd");
        for(int i=1;i<=31;i++){
            long time = (dateformat.parse("2021-5-" + String.valueOf(i))).getTime();
            System.out.println(new Date(time));
        }
    }

}
