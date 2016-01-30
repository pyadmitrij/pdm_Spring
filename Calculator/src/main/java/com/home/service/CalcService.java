package com.home.service;

import org.springframework.stereotype.Service;

/**
 * @author Dmitriy
 */
@Service
public class CalcService 
{
	public double sum(Double a, Double b)
	{
		return a + b;
	}
	
	public double minus(double a, double b)
	{
		return a - b;
	}
	
	public double mult(double a, double b)
	{
		return a * b;
	}
	
	public double div(double a, double b) throws Exception
	{
		if(b == 0)
		{
			throw new Exception("Делить на ноль нельзя!!!");
		}
		else { return a / b; }
	}
	
	public double sqrtRot(double a)
	{
		return Math.sqrt(a);
	}
}
