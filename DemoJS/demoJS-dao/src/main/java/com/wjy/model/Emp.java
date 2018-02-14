package com.wjy.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Table(name = "tbl_emp")
public class Emp {
    @Id
    @Column(name = "emp_id")
    private Integer empId;

    @Column(name = "emp_name")
    private String empName;

    private String gender;

    private String email;

    @Column(name = "d_id")
    private Integer dId;

    @ApiModelProperty(example = "2017-12-12 12:12:12")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    @Column(name = "create_time")
    private Date createTime;

    public Integer getEmpId() {
        return empId;
    }

    public Emp setEmpId(Integer empId) {
        this.empId = empId;
        return this;
    }

    public String getEmpName() {
        return empName;
    }

    public Emp setEmpName(String empName) {
        this.empName = empName;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Emp setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Emp setEmail(String email) {
        this.email = email;
        return this;
    }

    public Integer getdId() {
        return dId;
    }

    public Emp setdId(Integer dId) {
        this.dId = dId;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Emp setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", dId=" + dId +
                ", createTime=" + createTime +
                '}';
    }
}