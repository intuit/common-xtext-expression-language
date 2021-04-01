package com.intuit.dsl.expression.runtime.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.regex.Pattern;

public class NumberValue {

  public static final BigDecimal ZERO = BigDecimal.ZERO;
  private static final Pattern INTPATTERN = Pattern.compile("^(-)?\\d+.0*$");
  private BigDecimal number;
  private boolean numberPragma;

  public NumberValue(int value, boolean numberPragma) {
    this.number = new BigDecimal(value);
    this.numberPragma = numberPragma;
  }

  public NumberValue(String value, boolean numberPragma) {
    this.number = new BigDecimal(value);
    this.numberPragma = numberPragma;
  }

  public NumberValue(long value, boolean numberPragma) {
    this.number = new BigDecimal(value);
    this.numberPragma = numberPragma;
  }

  public NumberValue(double value, boolean numberPragma) {
    this.number = BigDecimal.valueOf(value);
    this.numberPragma = numberPragma;
  }

  public NumberValue(BigDecimal number, boolean numberPragma) {
    this.number = number;
    this.numberPragma = numberPragma;
  }

  public String toString() {
    if (numberPragma) {
      cleanDecimal();
    }
    return (INTPATTERN.matcher(number.toString()).matches())
        ? number.toString().split("\\.")[0]
        : number.toString();
  }

  public NumberValue add(NumberValue value) {
    return new NumberValue(number.add(value.get()), this.numberPragma);
  }

  public Boolean less(NumberValue value) {
    return (number.compareTo(value.get()) < 0);
  }

  public Boolean greater(NumberValue value) {
    return (number.compareTo(value.get()) > 0);
  }

  public Boolean greaterEqual(NumberValue value) {
    return (number.compareTo(value.get()) >= 0);
  }

  public Boolean lessEqual(NumberValue value) {
    return (number.compareTo(value.get()) <= 0);
  }

  public NumberValue subtract(NumberValue value) {
    return new NumberValue(number.subtract(value.get()), this.numberPragma);
  }

  public NumberValue multiply(NumberValue value) {
    return new NumberValue(number.multiply(value.get()), this.numberPragma);
  }

  public NumberValue remainder(NumberValue value) {
    return new NumberValue(number.remainder(value.get()), this.numberPragma);
  }

  public NumberValue divide(NumberValue value) {
    return new NumberValue(number.divide(value.get(), 2, RoundingMode.HALF_EVEN), this.numberPragma);
  }

  public BigDecimal get() {
    return number;
  }

  public boolean equals(Object obj) {
    if (!(obj instanceof NumberValue)) {
      return false;
    }
    return this.number.compareTo(((NumberValue) (obj)).get()) == 0;
  }

  public int hashCode() {
    return this.number.hashCode();
  }

  private void cleanDecimal() {
    number = number.setScale(2, BigDecimal.ROUND_HALF_UP);
  }
}
