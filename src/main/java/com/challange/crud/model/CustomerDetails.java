package com.challange.crud.model;

import java.util.Date;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EqualsAndHashCode
@Entity
@Table(name = "customer_details")
public class CustomerDetails {

  @Id
  @Column(name = "id", nullable = false)
  @Builder.Default
  private String id = UUID.randomUUID().toString();

  @ManyToOne
  @JoinColumn(name = "customer_id", nullable = false)
  private Customer customer;

  @Enumerated(EnumType.STRING)
  @NotNull(message = "Sex is mandatory (M or F)")
  @Column(name = "sex")
  private Sex sex;

  @Past(message = "Date of birth cannot be in the future")
  @NotNull(message = "Date of birth is mandatory")
  @Column(name = "dob")
  private Date dob;

  @NotNull(message = "Native place is mandatory")
  @Column(name = "native_place")
  private String nativePlace;
}

