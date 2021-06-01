package com.example.jrxspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ZhaoYongfeng
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInformation {

  private long custId;
  private String surname;
  private long gender;
  private String educaDes;
  private String marDes;
  private long birthday;
  private String address;
  private Long id;

  @Id
  public long getCustId() {
    return custId;
  }

  public void setCustId(long custId) {
    this.custId = custId;
  }


  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }


  public long getGender() {
    return gender;
  }

  public void setGender(long gender) {
    this.gender = gender;
  }


  public String getEducaDes() {
    return educaDes;
  }

  public void setEducaDes(String educaDes) {
    this.educaDes = educaDes;
  }


  public String getMarDes() {
    return marDes;
  }

  public void setMarDes(String marDes) {
    this.marDes = marDes;
  }


  public long getBirthday() {
    return birthday;
  }

  public void setBirthday(long birthday) {
    this.birthday = birthday;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public void setId(Long id) {
    this.id = id;
  }

  @Id
  public Long getId() {
    return id;
  }
}
