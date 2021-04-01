package com.intuit.dsl.expression.runtime.model;

public class RuntimeOptions {

	public boolean getNumberPragma() {
		return numberPragma;
	}

	public RuntimeOptions(){
		numberPragma = false;
	}
	final boolean numberPragma;
}