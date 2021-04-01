/**
 * Generic value class that encapsulates te actual value with the dataType associated with that
 */
package com.intuit.dsl.expression.runtime.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.lang3.StringUtils;

public class DataValue {

  public enum Type {
    NULL,
    BOOLEAN,
    NUMBER,
    STRING,
    ARRAY,
    OBJECT,
    TSI,
    FRF,
    XML,
    BINARY;
  }

  private static Map<String, DataValue.Type> types = new HashMap<>();

  static {
    DataValue.types.put("string", DataValue.Type.STRING);
    DataValue.types.put("number", DataValue.Type.NUMBER);
    DataValue.types.put("boolean", DataValue.Type.BOOLEAN);
    DataValue.types.put("long", DataValue.Type.NUMBER);
    DataValue.types.put("amount", DataValue.Type.NUMBER);
    DataValue.types.put("int", DataValue.Type.NUMBER);
    DataValue.types.put("float", DataValue.Type.NUMBER);
    DataValue.types.put("decimal", DataValue.Type.NUMBER);
  }

  private Object object;
  private DataValue.Type type;
  private boolean numberPragma;

  public DataValue(final Object object, final DataValue.Type type, final boolean numberPragma) {
    this.object = object;
    this.type = type;
    this.numberPragma = numberPragma;
  }

  public DataValue(final Object object, final DataValue.Type type) {
     this(object, type, false);
  }

  @Override
  public boolean equals(final Object obj) {
    if ((!(obj instanceof DataValue))) {
      return false;
    }
    DataValue rightVal = ((DataValue) obj);
    if ((rightVal.type != this.type)) {
      return false;
    }
    if ((this.type == DataValue.Type.NULL)) {
      return true;
    }
    return this.object.equals(rightVal.object);
  }

  @Override
  public int hashCode() {
    return (object == null) ? 0 : object.hashCode() + 31 * type.hashCode();
  }

  @Override
  public String toString() {
    if ((this.object == null)) {
      return null;
    }
    return this.object.toString();
  }

  public Object getValue() {
    return this.object;
  }

  public DataValue.Type getType() {
    return this.type;
  }

  public boolean isComplex() {
    return this.type == DataValue.Type.ARRAY || this.type == DataValue.Type.OBJECT
        || this.type == DataValue.Type.TSI || this.type == DataValue.Type.FRF
        || this.type == DataValue.Type.BINARY || this.type == DataValue.Type.XML;
  }

  public boolean isTsi() {
    return (this.type == DataValue.Type.TSI);
  }

  public NumberValue length() {
    if (this.type == Type.NULL) {
      return new NumberValue(-1, numberPragma);
//		} else if (this.type === Type::TSI) {
//			return new NumberValue(new TSIModel(new TsiMapVal(object), numberPragma).length(), numberPragma)
    } else if (this.type == Type.ARRAY) {
      return new NumberValue(new JsonModel(this, numberPragma).length(), numberPragma);
    } else if (this.type == Type.STRING || this.type == Type.NUMBER) {
      return new NumberValue(toString().length(), numberPragma);
    } else {
      return new NumberValue(NumberValue.ZERO, numberPragma);
    }
  }

  public boolean toBoolean() {
    if (this.type == DataValue.Type.NULL || this.object == null) {
      return false;
    }
    return Boolean.valueOf(this.object.toString());
  }

  public boolean fuzzyEquals(final DataValue obj) {
    if ((!(obj instanceof DataValue))) {
      return false;
    }
    DataValue rightVal = obj;
    if ((rightVal.type != this.type)) {
      return false;
    }
    if ((this.type == DataValue.Type.NULL)) {
      return true;
    }
    if ((this.type == DataValue.Type.STRING)) {
      return this.object.toString().equalsIgnoreCase(rightVal.toString());
    }
    return this.object.equals(rightVal.object);
  }

  public static DataValue.Type getType(final String type) {
    Type dataType = types.get(StringUtils.lowerCase(type));
    if (Objects.nonNull(dataType)) {
      return dataType;
    }
    return Type.valueOf(type.toUpperCase());
  }
}
