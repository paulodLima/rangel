package com.braz.rangel.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "SALARY")
public class SalaryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SALARY_ID")
    private Long id;
    @Column(name = "SALARY")
    private BigDecimal salary;
    @Column(name = "PAYMENT_DATE")
    private Date paymentDate;
    @Column(name = "MES_ANO")
    private String monthYear;

    @ManyToOne
    @JoinColumn(name = "SALARY_ID_PERSON")
    private PersonEntity personEntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getMonthYear() {
        return monthYear;
    }

    public void setMonthYear(String mesAno) {
        this.monthYear = mesAno;
    }

    public PersonEntity getPersonEntity() {
        return personEntity;
    }

    public void setPersonEntity(PersonEntity personEntity) {
        this.personEntity = personEntity;
    }
}
