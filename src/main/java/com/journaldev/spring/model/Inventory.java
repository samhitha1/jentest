package com.journaldev.spring.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "Inventory")
public class Inventory implements Serializable {

    // private static StringFormatter dateFormat = StringFormat.forPattern("yyyy-MM-dd");
    /**
     * 
     */
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 10002020L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String serialNo;
    private String category;
    private String productName;
    private String certificate;
    private String productNumber;
    private String productType;
    private String batchId;
    private String manufactureDate;
    private String expirationDate;
    private String shipmenteDate;
    private String receivedDate;
    private String transitDuration;
    // Pallet Details
    private String palletNo;
    private String noOfCases;
    private String noOfPacks;
    private String packCost;
    private String caseCost;
    private String palletCost;

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonProperty
    public void setCertificate(List<String> certificate) {
        this.certificate = "";
        for (String certs : certificate) {
            this.certificate = this.certificate + certs;
        }

    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;

    }

    public String getProductNumber() {
        return productNumber;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getBatchId() {
        return batchId;
    }

    public void setBatchId(String batchId) {
        this.batchId = batchId;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    // @JsonProperty
    // public void setManufactureDate(String manufactureDate) {
    // this.manufactureDate = convertDate(manufactureDate);
    // }

    // private String convertDate(String strDate) {
    // return String.parse(strDate, dateFormat);
    //
    // }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public String getCertificate() {
        return certificate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getShipmenteDate() {
        return shipmenteDate;
    }

    public void setShipmenteDate(String shipmenteDate) {
        this.shipmenteDate = shipmenteDate;
    }

    // @JsonProperty
    // public void setShipmenteDate(String shipmenteDate) {
    // this.shipmenteDate = convertDate(shipmenteDate);
    // }

    public String getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(String receivedDate) {
        this.receivedDate = receivedDate;
    }

    // @JsonProperty
    // public void setReceivedDate(String receivedDate) {
    // this.receivedDate = convertDate(receivedDate);
    // }

    public String getTransitDuration() {
        return transitDuration;
    }

    public void setTransitDuration(String transitDuration) {
        this.transitDuration = transitDuration;
    }

    public String getPalletNo() {
        return palletNo;
    }

    public void setPalletNo(String palletNo) {
        this.palletNo = palletNo;
    }

    public String getNoOfCases() {
        return noOfCases;
    }

    public void setNoOfCases(String noOfCases) {
        this.noOfCases = noOfCases;
    }

    public String getNoOfPacks() {
        return noOfPacks;
    }

    public void setNoOfPacks(String noOfPacks) {
        this.noOfPacks = noOfPacks;
    }

    public String getPackCost() {
        return packCost;
    }

    public void setPackCost(String packCost) {
        this.packCost = packCost;
    }

    public String getCaseCost() {
        return caseCost;
    }

    public void setCaseCost(String caseCost) {
        this.caseCost = caseCost;
    }

    public String getPalletCost() {
        return palletCost;
    }

    public void setPalletCost(String palletCost) {
        this.palletCost = palletCost;
    }

}
