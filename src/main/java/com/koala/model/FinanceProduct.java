package com.koala.model;

public class FinanceProduct {
    private Integer id;

    private String name;

    private String source;

    private String rawUrl;

    private Integer investCycle;

    private Integer riskScore;

    private Integer lowestAmount;

    private String financeProductcol1;

    private Float expectedProfitRate;

    private String expectedProfitName;

    private String investField;

    private String productTypeLabel;

    private String channelNameShort;

    private String channelName;

    private String channelUrl;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source == null ? null : source.trim();
    }

    public String getRawUrl() {
        return rawUrl;
    }

    public void setRawUrl(String rawUrl) {
        this.rawUrl = rawUrl == null ? null : rawUrl.trim();
    }

    public Integer getInvestCycle() {
        return investCycle;
    }

    public void setInvestCycle(Integer investCycle) {
        this.investCycle = investCycle;
    }

    public Integer getRiskScore() {
        return riskScore;
    }

    public void setRiskScore(Integer riskScore) {
        this.riskScore = riskScore;
    }

    public Integer getLowestAmount() {
        return lowestAmount;
    }

    public void setLowestAmount(Integer lowestAmount) {
        this.lowestAmount = lowestAmount;
    }

    public String getFinanceProductcol1() {
        return financeProductcol1;
    }

    public void setFinanceProductcol1(String financeProductcol1) {
        this.financeProductcol1 = financeProductcol1 == null ? null : financeProductcol1.trim();
    }

    public Float getExpectedProfitRate() {
        return expectedProfitRate;
    }

    public void setExpectedProfitRate(Float expectedProfitRate) {
        this.expectedProfitRate = expectedProfitRate;
    }

    public String getExpectedProfitName() {
        return expectedProfitName;
    }

    public void setExpectedProfitName(String expectedProfitName) {
        this.expectedProfitName = expectedProfitName == null ? null : expectedProfitName.trim();
    }

    public String getInvestField() {
        return investField;
    }

    public void setInvestField(String investField) {
        this.investField = investField == null ? null : investField.trim();
    }

    public String getProductTypeLabel() {
        return productTypeLabel;
    }

    public void setProductTypeLabel(String productTypeLabel) {
        this.productTypeLabel = productTypeLabel == null ? null : productTypeLabel.trim();
    }

    public String getChannelNameShort() {
        return channelNameShort;
    }

    public void setChannelNameShort(String channelNameShort) {
        this.channelNameShort = channelNameShort == null ? null : channelNameShort.trim();
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName == null ? null : channelName.trim();
    }

    public String getChannelUrl() {
        return channelUrl;
    }

    public void setChannelUrl(String channelUrl) {
        this.channelUrl = channelUrl == null ? null : channelUrl.trim();
    }
}