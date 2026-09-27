package com.calculation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculation.dto.CalculatorRequest;
import com.calculation.dto.CalculatorResponse;
import com.calculation.service.CalculatorService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/calculator")
@CrossOrigin(origins = "*")
public class CalculatorController {

	@Autowired
	private CalculatorService service;

	@PostMapping("/add")
	public CalculatorResponse add(@Valid @RequestBody CalculatorRequest request) {

		return service.calculatorResponseAdd(request);
	}

	@PostMapping("/subtract")
	public CalculatorResponse subtract(@Valid @RequestBody CalculatorRequest request) {

		return service.calculatorResponseSubtract(request);
	}

	@PostMapping("/multiply")
	public CalculatorResponse multiply(@Valid @RequestBody CalculatorRequest request) {

		return service.calculatorResponseMultiply(request);
	}

	@PostMapping("/division")
	public CalculatorResponse division(@Valid @RequestBody CalculatorRequest request) {

		return service.calculatorResponseDivision(request);
	}

	@PostMapping("/square")
	public CalculatorResponse sqaure(@Valid @RequestBody CalculatorRequest request) {

		return service.calculatorResponseSquare(request);
	}

	@PostMapping("/power")
	public CalculatorResponse power(@Valid @RequestBody CalculatorRequest request) {

		return service.calculatorResponsePower(request);
	}

	@PostMapping("/modulus")
	public CalculatorResponse modulus(@Valid @RequestBody CalculatorRequest request) {

		return service.calculatorResponseModulus(request);
	}

	@PostMapping("/squareRoot")
	public CalculatorResponse squareRoot(@Valid @RequestBody CalculatorRequest request) {

		return service.calculatorResponseSqaureRoot(request);
	}

	@PostMapping("/max")
	public CalculatorResponse max(@Valid @RequestBody CalculatorRequest request) {

		return service.calculatorResponseMaximum(request);
	}

	@PostMapping("/min")
	public CalculatorResponse min(@Valid @RequestBody CalculatorRequest request) {

		return service.calculatorResponseMinimun(request);
	}

	@PostMapping("/absolute")
	public CalculatorResponse absolute(@Valid @RequestBody CalculatorRequest request) {

		return service.calculatorResponseAbsolute(request);
	}

	@PostMapping("/factorial")
	public CalculatorResponse factorial(@Valid @RequestBody CalculatorRequest request) {

		return service.calculatorResponseFactorial(request);
	}

	@GetMapping("/history")
	public List<CalculatorResponse> calculationHistory() {

		return service.calcultionHistoryFetch();
	}

	@DeleteMapping("/history")
	public String calculationHistoryDelete() {

		return service.clearAllCalculationHistory();
	}
}
