package com.intuit.dsl.expression.runtime;

public interface ConfigManager {
	
	default String getProperty(String property) {
		return "";
	}
}
