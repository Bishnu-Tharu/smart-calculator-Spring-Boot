package com.calculation.service;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
//import java.util.ArrayList;
import java.util.List;

//import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calculation.dto.CalculatorRequest;
import com.calculation.dto.CalculatorResponse;
import com.calculation.entity.CalculatorEntity;
import com.calculation.respository.CalculationRepository;

@Service
public class CalculatorServiceImp implements CalculatorService {

	@Autowired
	private CalculationRepository repository;

	@Override
	public CalculatorResponse calculatorResponseAdd(CalculatorRequest request) {

		BigDecimal result = request.getNum1().add(request.getNum2());

		saveHistory(request.getNum1(),
				request.getNum2(),
				"ADD",
				result);

		return new CalculatorResponse(request.getNum1(),
				request.getNum2(),
				"ADD",
				result);
	}

	@Override
	public CalculatorResponse calculatorResponseSubtract(CalculatorRequest request) {

		BigDecimal result = request.getNum1().subtract(request.getNum2());

		saveHistory(request.getNum1(),
				request.getNum2(),
				"SUBTRACT",
				result);

		return new CalculatorResponse(request.getNum1(),
				request.getNum2(),
				"SUBTRACT",
				result);

	}

	@Override
	public CalculatorResponse calculatorResponseMultiply(CalculatorRequest request) {

		BigDecimal result = request.getNum1().multiply(request.getNum2());

		saveHistory(request.getNum1(),
				request.getNum2(),
				"MULTIPLY", 
				result);

		return new CalculatorResponse(request.getNum1(),
				request.getNum2(),
				"MULTIPLY",
				result);

	}

	@Override
	public CalculatorResponse calculatorResponseDivision(CalculatorRequest request) {

		if (request.getNum2().compareTo(BigDecimal.ZERO) == 0) {
			throw new IllegalArgumentException("Division by Zero is impossible");
		}

		BigDecimal result = request.getNum1().divide(request.getNum2(), 8, RoundingMode.HALF_UP);

		saveHistory(request.getNum1(),
				request.getNum2(),
				"DIVIDE",
				result);

		return new CalculatorResponse(request.getNum1(),
				request.getNum2(),
				"DIVIDE",
				result);

	}

	
	@Override
	public List<CalculatorResponse> calcultionHistoryFetch() {

		/*
		Using BeanUtils
		
		List<CalculatorResponse> entities = new ArrayList<>();
		List<CalculatorEntity> repoEntities = repository.findAll();
		
		for (CalculatorEntity calculatorEntity : repoEntities) {
			CalculatorResponse response = new CalculatorResponse();
			BeanUtils.copyProperties(calculatorEntity, response);
			entities.add(response);
		}
		
		return entities;
		*/
		
		
		/*
		 Using Constructor Reference
		 
		List<CalculatorResponse> entities = new ArrayList<>();
		List<CalculatorEntity> repoEntities = repository.findAll();
		 
		for (CalculatorEntity calculatorEntity : repoEntities) {
			CalculatorResponse response = new CalculatorResponse(calculatorEntity.getNum1(), 
					calculatorEntity.getNum2(),
					calculatorEntity.getOperation(), 
					calculatorEntity.getResult());
			
			entities.add(response);

		return entities;
		}
		*/
		
		
		//Using Streams (Java 8+)
		
		
		return repository.findAll()
				.stream()
				.map(entity -> 
						new CalculatorResponse(
								entity.getNum1(),
								entity.getNum2(),
								entity.getOperation(),
								entity.getResult()))
				.toList();
		
				
	}
	

	@Override
	public String clearAllCalculationHistory() {
		
		if (repository.count() == 0) {
			throw new RuntimeException("No calculation history found");
		}
		
		repository.truncateTable();
		return "All calculation history deleted successfully";
	}


	@Override
	public CalculatorResponse calculatorResponseSquare(CalculatorRequest request) {
		
		BigDecimal result = request.getNum1().multiply(request.getNum1());
		
		saveHistory(request.getNum1(), BigDecimal.ZERO, "SQUARE", result);
		
		return new CalculatorResponse(request.getNum1(), 
				new BigDecimal(0), 
				"SQUARE", 
				result);
	}

	@Override
	public CalculatorResponse calculatorResponsePower(CalculatorRequest request) {

		if (request.getNum2().compareTo(BigDecimal.ZERO) < 0) {
		    throw new IllegalArgumentException("Power must be non-negative");
		}
		
		if (request.getNum2().stripTrailingZeros().scale() > 0) {
		    throw new IllegalArgumentException("Power must be a whole number");
		}
		
		BigDecimal result = request.getNum1().pow(request.getNum2().intValue());
		
		saveHistory(request.getNum1(), request.getNum2(), "POWER", result);
		
		return new CalculatorResponse(request.getNum1(), 
				request.getNum2(), 
				"POWER", 
				result);
	}

	@Override
	public CalculatorResponse calculatorResponseModulus(CalculatorRequest request) {
		
		if (request.getNum2().compareTo(BigDecimal.ZERO) == 0) {
			throw new ArithmeticException("Modulus by Zero is impossible");
		}
		
		BigDecimal result = request.getNum1().remainder(request.getNum2());
		
		saveHistory(request.getNum1(), request.getNum2(), "MODULUS", result);
		
		return new CalculatorResponse(request.getNum1(), 
				request.getNum2(), 
				"MODULUS", 
				result);
	}

	@Override
	public CalculatorResponse calculatorResponseSqaureRoot(CalculatorRequest request) {

		if (request.getNum1().compareTo(BigDecimal.ZERO) < 0) {
		    throw new ArithmeticException("Square root of a negative number is impossible");
		}
		
		BigDecimal result = request.getNum1().sqrt(new MathContext(8));
		
		saveHistory(request.getNum1(), BigDecimal.ZERO, "SQUARE ROOT", result);
		
		return new CalculatorResponse(request.getNum1(), 
				BigDecimal.ZERO, 
				"SQUARE ROOT", 
				result);
	}

	@Override
	public CalculatorResponse calculatorResponseMaximum(CalculatorRequest request) {

		BigDecimal result = request.getNum1().max(request.getNum2());
		
		saveHistory(request.getNum1(), request.getNum2(), "MAX", result);
		
		return new CalculatorResponse(request.getNum1(), 
				request.getNum2(),
				"MAX", 
				result);
	}

	@Override
	public CalculatorResponse calculatorResponseMinimun(CalculatorRequest request) {

		BigDecimal result = request.getNum1().min(request.getNum2());
		
		saveHistory(request.getNum1(), request.getNum2(), "MIN", result);
		
		return new CalculatorResponse(request.getNum1(), 
				request.getNum2(),
				"MIN", 
				result);
	}
	

	@Override
	public CalculatorResponse calculatorResponseAbsolute(CalculatorRequest request) {

		BigDecimal result = request.getNum1().abs(new MathContext(8));
		
		saveHistory(request.getNum1(), BigDecimal.ZERO, "ABSOLUTE", result);
		
		return new CalculatorResponse(request.getNum1(), 
				BigDecimal.ZERO,
				"ABSOLUTE", 
				result);
	}

	@Override
	public CalculatorResponse calculatorResponseFactorial(CalculatorRequest request) {
		
		if (request.getNum1().compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("Number must be non-negative");
		}
		
		if (request.getNum1().compareTo(BigDecimal.valueOf(32)) > 0) {
	        throw new IllegalArgumentException(
	                "Factorial is allowed only up to 32"
	        );
	    }
		
		if (request.getNum1().stripTrailingZeros().scale() > 0) {
	        throw new IllegalArgumentException(
	                "Factorial requires a whole number"
	        );
	    }
		
		BigDecimal result = BigDecimal.ONE;
		
		for (int i = 2; i <= request.getNum1().intValue(); i++) {
			result = result.multiply(BigDecimal.valueOf(i), new MathContext(8));
		}
		
		saveHistory(request.getNum1(), BigDecimal.ZERO, "FACTORIAL", result);
			
		return new CalculatorResponse(request.getNum1(), 
					BigDecimal.ZERO,
					"FACTORIAL", 
					result);
		
	}
	
	void saveHistory(BigDecimal num1, BigDecimal num2, String operation, BigDecimal result) {
		CalculatorEntity entity = new CalculatorEntity(num1,
													num2,
													operation, 
													result);
		repository.save(entity);
	}

}
