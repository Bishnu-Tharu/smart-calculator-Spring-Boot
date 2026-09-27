package com.calculation.dto;

import java.math.BigDecimal;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CalculatorResponse {

	private BigDecimal num1;
	private BigDecimal num2;
	private String operation;
	private BigDecimal result;

	public CalculatorResponse(BigDecimal num1, BigDecimal num2, String operation, BigDecimal result) {
		this.num1 = num1;
		this.num2 = num2;
		this.operation = operation;
		this.result = result;
	}

	public BigDecimal getNum1() {
		return num1;
	}

	public void setNum1(BigDecimal num1) {
		this.num1 = num1;
	}

	public BigDecimal getNum2() {
		return num2;
	}

	public void setNum2(BigDecimal num2) {
		this.num2 = num2;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public BigDecimal getResult() {
		return result;
	}

	public void setResult(BigDecimal result) {
		this.result = result;
	}

}
