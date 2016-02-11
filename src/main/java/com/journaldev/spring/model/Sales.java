package com.journaldev.spring.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "Sales")
public class Sales implements Serializable {

    // private static DateFormatter dateFormat = DateFormat.forPattern("yyyy-MM-dd");
    /**
     * 
     */
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 10002020L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String saleNo;
    private String invoiceNo;
    private String customerNo;
    private double cost;
    private double netPay;
    private double advance;
    private double amoutDue;
    private String saleDate;

    private String dueDate;
    @Transient
    private List<Inventory> inventoryList;

    // private String convertDate(String strDate) {
    // return String.parse(strDate, dateFormat);
    //
    // }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaleNo() {
        return saleNo;
    }

    public void setSaleNo(String saleNo) {
        this.saleNo = saleNo;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(String customerNo) {
        this.customerNo = customerNo;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    public double getAdvance() {
        return advance;
    }

    public void setAdvance(double advance) {
        this.advance = advance;
    }

    public double getAmoutDue() {
        return amoutDue;
    }

    public void setAmoutDue(double amoutDue) {
        this.amoutDue = amoutDue;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    // @JsonProperty
    // public void setSaleDate(String saleDate) {
    // this.saleDate = convertDate(saleDate);
    // }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    @Transient
    public List<Inventory> getInventoryList() {
        if (inventoryList == null) {
            inventoryList = new ArrayList<Inventory>();
        }
        return inventoryList;
    }

    public void setInventoryList(List<Inventory> inventoryList) {
        this.inventoryList = inventoryList;
    }

    // @JsonProperty
    // public void setDueDate(String dueDate) {
    // this.dueDate = convertDate(dueDate);
    // }
}
