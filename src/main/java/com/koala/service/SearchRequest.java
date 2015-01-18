package com.koala.service;

public class SearchRequest {
  private Integer id;

  // rate
  private Float rateBegin;
  private Float rateEnd;
  private Integer orderByRate;

  private Integer investCycleBegin;
  private Integer investCycleEnd;
  private Integer orderByInvestCycle;

  private Integer riskScoreBegin;
  private Integer riskScoreEnd;
  private Integer orderByRiskScore;

  private String investField;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getInvestCycleBegin() {
    return investCycleBegin;
  }

  public void setInvestCycleBegin(Integer investCycleBegin) {
    this.investCycleBegin = investCycleBegin;
  }

  public Integer getInvestCycleEnd() {
    return investCycleEnd;
  }

  public void setInvestCycleEnd(Integer investCycleEnd) {
    this.investCycleEnd = investCycleEnd;
  }

  public Integer getRiskScoreBegin() {
    return riskScoreBegin;
  }

  public void setRiskScoreBegin(Integer riskScoreBegin) {
    this.riskScoreBegin = riskScoreBegin;
  }

  public Integer getRiskScoreEnd() {
    return riskScoreEnd;
  }

  public void setRiskScoreEnd(Integer riskScoreEnd) {
    this.riskScoreEnd = riskScoreEnd;
  }

  public String getInvestField() {
    return investField;
  }

  public void setInvestField(String investField) {
    this.investField = investField;
  }

  public Float getRateBegin() {
    return rateBegin;
  }

  public void setRateBegin(Float rateBegin) {
    this.rateBegin = rateBegin;
  }

  public Float getRateEnd() {
    return rateEnd;
  }

  public void setRateEnd(Float rateEnd) {
    this.rateEnd = rateEnd;
  }
}
