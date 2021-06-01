package com.example.jrxspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DetailTransaction {

  private long transId;
  private long custId;
  private String account;
  private String cardNbr;
  private long tranno;
  private long monthNbr;
  private double bill;
  private String transType;
  private Date txnDatetime;


  public long getTransId() {
    return transId;
  }

  public void setTransId(long transId) {
    this.transId = transId;
  }


  public long getCustId() {
    return custId;
  }

  public void setCustId(long custId) {
    this.custId = custId;
  }


  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }


  public String getCardNbr() {
    return cardNbr;
  }

  public void setCardNbr(String cardNbr) {
    this.cardNbr = cardNbr;
  }


  public long getTranno() {
    return tranno;
  }

  public void setTranno(long tranno) {
    this.tranno = tranno;
  }


  public long getMonthNbr() {
    return monthNbr;
  }

  public void setMonthNbr(long monthNbr) {
    this.monthNbr = monthNbr;
  }


  public double getBill() {
    return bill;
  }

  public void setBill(double bill) {
    this.bill = bill;
  }


  public String getTransType() {
    return transType;
  }

  public void setTransType(String transType) {
    this.transType = transType;
  }


  public java.sql.Date getTxnDatetime() {
    return txnDatetime;
  }

  public void setTxnDatetime(java.sql.Date txnDatetime) {
    this.txnDatetime = txnDatetime;
  }

}
