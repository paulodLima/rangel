package com.braz.rangel.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ACCOUNT")
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ACCOUNT_ID")
    private Long idAccount;
    @Column(name = "DOCUMENT")
    private String document;
    @Column(name = "ACCOUNT")
    private Integer account;
    @Column(name = "DIGIT")
    private Integer Digit;
    @Column(name = "BANK")
    private String Bank;
    @Column(name = "COD_BANK")
    private Integer codBank;
    public Long getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(Long idAccount) {
        this.idAccount = idAccount;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public Integer getDigit() {
        return Digit;
    }

    public void setDigit(Integer digit) {
        Digit = digit;
    }

    public String getBank() {
        return Bank;
    }

    public void setBank(String bank) {
        Bank = bank;
    }

    public Integer getCodBank() {
        return codBank;
    }

    public void setCodBank(Integer codBank) {
        this.codBank = codBank;
    }

}
