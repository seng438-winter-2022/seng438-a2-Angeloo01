package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

public class DataUtilitiesTest{
	private Mockery mockingContext;
	private Values2D values;
	private KeyedValues keyValues;
	@Before
    public void setUp() throws Exception { 
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
		keyValues = mockingContext.mock(KeyedValues.class);
    }
	
	 @Test
	 public void calculateColumnTotalForTwoValues() {
	     // setup
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getRowCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	         }
	     });
	     
	     // exercise	
	     double result = DataUtilities.calculateColumnTotal(values, 0);
	     // verify
	     //mockingContext.assertIsSatisfied();
	     assertEquals(10.0, result, .000000001d);
	     // tear-down: NONE in this test method
	 }
	 
	 @Test
	 public void calculateColumnTotalForTwoRowsTwoColumns() {
	     // setup
	     mockingContext.checking(new Expectations() {
	         {
	             exactly(2).of(values).getRowCount();
	             will(returnValue(2));
	            
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	             
	             one(values).getValue(0, 1);
	             will(returnValue(1));
	             one(values).getValue(1, 1);
	             will(returnValue(1));
	         }
	     });
	     
	     // exercise	
	     DataUtilities.calculateColumnTotal(values, 0);
	     double result = DataUtilities.calculateColumnTotal(values, 1);
	     // verify
	     assertEquals(2, result, .000000001d);
	 }
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void calculateColumnTotalNullArgument() throws Exception{
		 DataUtilities.calculateColumnTotal(null, 0);
	 }
	 
	 @Test
	 public void calculateRowTotalForTwoValues() {
	     // setup
	     mockingContext.checking(new Expectations() {
	         {
	             one(values).getColumnCount();
	             will(returnValue(2));
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(0, 1);
	             will(returnValue(2.5));
	         }
	     });
	     
	     // exercise	
	     double result = DataUtilities.calculateRowTotal(values, 0);
	     // verify
	     //mockingContext.assertIsSatisfied();
	     assertEquals(10.0, result, .000000001d);
	     // tear-down: NONE in this test method
	 }
	 
	 @Test
	 public void calculateRowTotalForTwoRowsTwoColumns() {
	     // setup
	     mockingContext.checking(new Expectations() {
	         {
	             exactly(2).of(values).getColumnCount();
	             will(returnValue(2));
	            
	             one(values).getValue(0, 0);
	             will(returnValue(7.5));
	             one(values).getValue(1, 0);
	             will(returnValue(2.5));
	             
	             one(values).getValue(0, 1);
	             will(returnValue(1));
	             one(values).getValue(1, 1);
	             will(returnValue(1));
	         }
	     });
	     
	     // exercise	
	     DataUtilities.calculateRowTotal(values, 0);
	     double result = DataUtilities.calculateRowTotal(values, 1);
	     // verify
	     assertEquals(3.5, result, .000000001d);
	 }
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void calculateRowTotalNullArgument() throws Exception{
		 DataUtilities.calculateRowTotal(null, 0);
	 }
	 
	 @Test
	 public void createNumberArrayTwoDoubleElements() {
		 Number[] numberArr = DataUtilities.createNumberArray(new double[]{1.0, 2.0});
		 assertArrayEquals("Error at two double elements for createNumberArray()", new Number[] {1.0, 2.0}, numberArr);
	 }
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void createNumberArrayNullArgument() throws Exception{
		 DataUtilities.createNumberArray(null);
	 }
	 
	 @Test
	 public void createNumberArray2DTwoArrayOfTwoDoubleElements() {
		 Number[][] numberArr = DataUtilities.createNumberArray2D(new double[][]{{1.0, 3.0}, {2.0, 4.0}});
		 assertArrayEquals("Error at two double elements for createNumberArray()", new Number[][] {{1.0, 3.0}, {2.0, 4.0}}, numberArr);
	 }
	 
	 @Test(expected = IllegalArgumentException.class)
	 public void createNumberArray2DNullArgument() throws Exception{
		 DataUtilities.createNumberArray2D(null);
	 }
	 
	 @Test
	 public void equalTwoEqualArrays() {
		 assertTrue("Error at equal() with 2 equal arrays", DataUtilities.equal(new double[][]{{1.0, 3.0}, {2.0, 4.0}}, new double[][]{{1.0, 3.0}, {2.0, 4.0}}));
	 }
	 
	 @Test
	 public void equalTwoUnequalArrays() {
		 assertFalse("Error at equal() with 2 equal arrays", DataUtilities.equal(new double[][]{{1.0, 3.0}, {2.0, 1.0}}, new double[][]{{1.0, 3.0}, {2.0, 4.0}}));
	 }
	 
	 @Test
	 public void equalOneWithInts() {
		 assertTrue("Error at equal() with 2 equal arrays", DataUtilities.equal(new double[][]{{1, 3}, {2, 4}}, new double[][]{{1.0, 3.0}, {2.0, 4.0}}));
	 }
	 
	 @Test (expected = IllegalArgumentException.class)
	 public void getCumulativePercentagesNullArgument() throws Exception{
		 DataUtilities.getCumulativePercentages(null);
	 }
	 
	 @Test
	 public void getCumulativePercentagesValidKeyedValues(){
		 mockingContext.checking(new Expectations() {
			{
				atLeast(1).of(keyValues).getItemCount();
				will(returnValue(3));
	        	
				atLeast(1).of(keyValues).getValue(0);
				will(returnValue(1));
				
				atLeast(1).of(keyValues).getValue(1);
				will(returnValue(2));
				
				atLeast(1).of(keyValues).getValue(2);
				will(returnValue(3));
				
				atLeast(1).of(keyValues).getKey(0);
				will(returnValue("key0"));
				
				atLeast(1).of(keyValues).getKey(1);
				will(returnValue("key1"));
				
				atLeast(1).of(keyValues).getKey(2);
				will(returnValue("key2"));
	     	}
		 });
		 
		 KeyedValues result = DataUtilities.getCumulativePercentages(keyValues);
		 assertEquals(0.16666666666666666, result.getValue(0).doubleValue(), .000000001d);
		 assertEquals(0.5, result.getValue(1).doubleValue(), .000000001d);
		 assertEquals(1.0, result.getValue(2).doubleValue(), .000000001d);
	 }
	 
	 @Test
	 public void getCumulativePercentagesEmptyList() {
		 mockingContext.checking(new Expectations() {
				{
					atLeast(1).of(keyValues).getItemCount();
					will(returnValue(0));
		        	
		     	}
			 });
			 
			 DataUtilities.getCumulativePercentages(keyValues);
	 }
	 
	 
	 
	 

}
