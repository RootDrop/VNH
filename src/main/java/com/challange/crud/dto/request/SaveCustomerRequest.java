package com.challange.crud.dto.request;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SaveCustomerRequest {

  @JsonProperty("name")
  private String name;

  @JsonProperty("details")
  private Details details;

  @JsonProperty("account_type")
  private String accountType;

  @JsonProperty("business_requirements")
  private List<String> businessRequirements;

  @JsonProperty("contract_type")
  private String contractType;

  @Getter
  @Setter
  @NoArgsConstructor
  public static class Details {

    @JsonProperty("sex")
    private String sex;

    @JsonProperty("dob")
    private String dob;

    @JsonProperty("native_place")
    private String nativePlace;
  }

  public boolean checkSex() {
    return !this.details.sex.equals("M") && !this.details.sex.equals("F");
  }

  public boolean checkDob() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    LocalDate localDate = LocalDate.parse(this.details.dob, formatter);
    return localDate.isAfter(LocalDate.of(2002, 1, 1));
  }

  public boolean checkContractType() {
    return !this.contractType.equals("fulltime") && !this.contractType.equals("parttime");
  }
}
