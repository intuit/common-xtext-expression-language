package com.intuit.dsl.expression.runtime.model;

import java.util.List;
import java.util.Map;

public interface DataModel {
	boolean has(String string);

	DataModel get(String string);

	Object get();

	DataValue getValue();

	void replace(String string, DataModel model);

	String asText();

	void set(String string, DataModel model);

	boolean isArray();

	boolean isTextual();

	boolean isAtomic();

	void add(DataModel data);

	void addAll(List<DataModel> data);

	int length();

	List<DataModel> toList();

	Map<String, DataModel> fields();

	void delete(String path);

	String toJson();

	String toXml();

	byte[] toBinary();

	default DataModel copy() {
		return this;
	}
}
