package com.talentreef.interviewquestions.takehome.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.text.DecimalFormat;
import javax.persistence.Column;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Length;

@Data
@Table
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Builder(toBuilder=true)
public class Widget{
    private static final DecimalFormat df = new DecimalFormat("0.00");


  @Id
  @Column(unique=true)
  @Size(min=3, max=100)
  private String name;

  @Column(name="description")
  @Size(min=5, max=1000)
  private String description;

  @Column(name="price")
  @Size(min=1, max=20000)
  private Double price;

  public String getName(){
    return name;
  }

  public void setName(String name){
    this.name = name;
  }

  public String getDescription(){
    return description;
  }

  public void setDescription(String description){
    this.description = description;
  }

  public Double getPrice(){
    return price;
  }

  public void setPrice(Double price){
    this.price = Double.parseDouble(df.format(price));
  }
}
