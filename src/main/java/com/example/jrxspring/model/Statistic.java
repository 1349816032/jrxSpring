package com.example.jrxspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.time.OffsetDateTime;

/**
 * @author ZhaoYongfeng
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Statistic {

  private long sId;
  private long custId;
  private Date updateTime;
  private java.sql.Date transDate;
  private String surname;
  private double tranMaxAmt;
  private double payAmt;
  private long tranCnt;
  private long payCnt;
  private double tranAmt;


  public long getSId() {
    return sId;
  }

  public void setSId(long sId) {
    this.sId = sId;
  }


  public long getCustId() {
    return custId;
  }

  public void setCustId(long custId) {
    this.custId = custId;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }


  public java.sql.Date getTransDate() {
    return transDate;
  }

  public void setTransDate(java.sql.Date transDate) {
    this.transDate = transDate;
  }


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }


  public double getTranMaxAmt() {
    return tranMaxAmt;
  }

  public void setTranMaxAmt(double tranMaxAmt) {
    this.tranMaxAmt = tranMaxAmt;
  }


  public double getPayAmt() {
    return payAmt;
  }

  public void setPayAmt(double payAmt) {
    this.payAmt = payAmt;
  }


  public long getTranCnt() {
    return tranCnt;
  }

  public void setTranCnt(long tranCnt) {
    this.tranCnt = tranCnt;
  }


  public long getPayCnt() {
    return payCnt;
  }

  public void setPayCnt(long payCnt) {
    this.payCnt = payCnt;
  }


  public double getTranAmt() {
    return tranAmt;
  }

  public void setTranAmt(double tranAmt) {
    this.tranAmt = tranAmt;
  }

}
