package com.example.jrxspring.repository;

import com.example.jrxspring.model.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author ZhaoYongfeng
 */
@Mapper
@Repository
public interface UserInformationRepo {
    List<UserInformation> queryAllUser();
    List<UserInformation> queryFindByName(String name);
    List<UserInformation> queryFindByCustId(long cust_id);
    void insertUserInformation(String surname,int gender,String educa_des,String mar_des,long birthday,String address);
    void updateUserInformation();
    void deleteUserInformation();
}
