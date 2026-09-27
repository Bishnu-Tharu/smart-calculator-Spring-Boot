package com.calculation.service;

import java.util.List;

import com.calculation.dto.CalculatorRequest;
import com.calculation.dto.CalculatorResponse;

public interface CalculatorService {

	CalculatorResponse calculatorResponseAdd(CalculatorRequest request);
	
	CalculatorResponse calculatorResponseSubtract(CalculatorRequest request);
	
	CalculatorResponse calculatorResponseMultiply(CalculatorRequest request);
	
	CalculatorResponse calculatorResponseDivision(CalculatorRequest request);
	
	CalculatorResponse calculatorResponseSquare(CalculatorRequest request);
	
	CalculatorResponse calculatorResponsePower(CalculatorRequest request);
	
	CalculatorResponse calculatorResponseModulus(CalculatorRequest request);
	
	CalculatorResponse calculatorResponseSqaureRoot(CalculatorRequest request);
	
	CalculatorResponse calculatorResponseMaximum(CalculatorRequest request);
	
	CalculatorResponse calculatorResponseMinimun(CalculatorRequest request);
	
	CalculatorResponse calculatorResponseAbsolute(CalculatorRequest request);
	
	CalculatorResponse calculatorResponseFactorial(CalculatorRequest request);
	
	List<CalculatorResponse> calcultionHistoryFetch();
	
	String clearAllCalculationHistory();
	
}
