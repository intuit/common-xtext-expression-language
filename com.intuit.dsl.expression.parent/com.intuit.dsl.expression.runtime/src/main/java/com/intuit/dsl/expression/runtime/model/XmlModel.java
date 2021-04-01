package com.intuit.dsl.expression.runtime.model;

import com.intuit.dsl.expression.runtime.util.JSONUtils;
import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public class XmlModel implements DataModel {
  public String xml;
  
  private RuntimeOptions pragmas;
  
  private DataModel jsonModel;
  
  public XmlModel(final String xml, final RuntimeOptions pragmas) {
    this.xml = xml;
    this.pragmas = pragmas;
    boolean numberPragma = pragmas.getNumberPragma();
    DataValue _dataValue = new DataValue(JSONUtils.xmlToJSon(xml), DataValue.Type.OBJECT, numberPragma);
    this.jsonModel = new JsonModel(_dataValue, numberPragma);
  }
  
  @Override
  public boolean has(final String string) {
    return this.jsonModel.has(string);
  }
  
  @Override
  public DataModel get(final String string) {
    return this.jsonModel.get(string);
  }
  
  @Override
  public Object get() {
    return this.getValue();
  }
  
  @Override
  public DataValue getValue() {
    boolean _numberPragma = this.pragmas.getNumberPragma();
    return new DataValue(this.xml, DataValue.Type.XML, _numberPragma);
  }
  
  @Override
  public void replace(final String string, final DataModel model) {
    throw new UnsupportedOperationException("replace not supported on xml");
  }
  
  @Override
  public String asText() {
    return this.xml;
  }
  
  @Override
  public String toString() {
    return this.xml;
  }
  
  @Override
  public void set(final String string, final DataModel model) {
    throw new UnsupportedOperationException("set not supported on xml");
  }
  
  @Override
  public boolean isArray() {
    return false;
  }
  
  @Override
  public boolean isTextual() {
    return false;
  }
  
  @Override
  public boolean isAtomic() {
    return false;
  }
  
  @Override
  public void add(final DataModel data) {
    throw new UnsupportedOperationException("add not supported on xml");
  }
  
  @Override
  public void addAll(final List<DataModel> data) {
    throw new UnsupportedOperationException("addAll not supported on xml");
  }
  
  @Override
  public int length() {
    return this.xml.length();
  }
  
  @Override
  public List<DataModel> toList() {
    throw new UnsupportedOperationException("toList not supported on xml");
  }
  
  @Override
  public Map<String, DataModel> fields() {
    return this.jsonModel.fields();
  }
  
  @Override
  public void delete(final String path) {
    throw new UnsupportedOperationException("delete not supported on xml");
  }
  
  @Override
  public String toJson() {
    return this.jsonModel.toJson();
  }
  
  @Override
  public String toXml() {
    return this.toString();
  }
  
  @Override
  public byte[] toBinary() {
    throw new UnsupportedOperationException("XmlModel does not support toBinary method");
  }
}
