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
	
	/**Setup the mock objects and mocking context
	 * @throws Exception
	 */
	@Before
    public void setUp() throws Exception { 
		mockingContext = new Mockery();
		values = mockingContext.mock(Values2D.class);
		keyValues = mockingContext.mock(KeyedValues.class);
    }
	
	 /**
	 * test calculateColumnTotal() with one row of two valid values
	 */
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
	 
	/**
	 * test calculateColumnTotal() with two rows of two valid values
	 */
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
	 
	 /**
	  * Test calculateColumnTotal() with a null argument Expected: IllegalArgumentException
	 * @throws Exception
	 */
	@Test(expected = IllegalArgumentException.class)
	 public void calculateColumnTotalNullArgument() throws Exception{
		 DataUtilities.calculateColumnTotal(null, 0);
	 }
	 
	/**
	  * test calculateColumnTotal() with one row and two columns
	  */
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
	 
	 /**
	  * test calculateColumnTotal() with two rows and two columns
	  */
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
	 
	 /**
	  * Test calculateRowTotal() with a null argument Expected: IllegalArgumentException
	 * @throws Exception
	 */
	 @Test(expected = IllegalArgumentException.class)
	 public void calculateRowTotalNullArgument() throws Exception{
		 DataUtilities.calculateRowTotal(null, 0);
	 }
	 
	 /**
	 * Test createNumberArray() with a valid double array
	 */
	@Test
	 public void createNumberArrayTwoDoubleElements() {
		 Number[] numberArr = DataUtilities.createNumberArray(new double[]{1.0, 2.0});
		 assertArrayEquals("Error at two double elements for createNumberArray()", new Number[] {1.0, 2.0}, numberArr);
	 }
	 
	/**
	  * Test createNumberArray() with a null argument Expected: IllegalArgumentException
	 * @throws Exception
	 */
	 @Test(expected = IllegalArgumentException.class)
	 public void createNumberArrayNullArgument() throws Exception{
		 DataUtilities.createNumberArray(null);
	 }
	 
	 /**
		 * Test createNumberArray2D() with a valid 2d double array
		 */
	 @Test
	 public void createNumberArray2DTwoArrayOfTwoDoubleElements() {
		 Number[][] numberArr = DataUtilities.createNumberArray2D(new double[][]{{1.0, 3.0}, {2.0, 4.0}});
		 assertArrayEquals("Error at two double elements for createNumberArray()", new Number[][] {{1.0, 3.0}, {2.0, 4.0}}, numberArr);
	 }
	 
	 /**
	  * Test createNumberArray2D() with a null argument Expected: IllegalArgumentException
	 * @throws Exception
	 */
	 @Test(expected = IllegalArgumentException.class)
	 public void createNumberArray2DNullArgument() throws Exception{
		 DataUtilities.createNumberArray2D(null);
	 }
	 
	 /**
	 * test equal() with two equal arrays of doubles
	 */
	@Test
	 public void equalTwoEqualArrays() {
		 assertTrue("Error at equal() with 2 equal arrays", DataUtilities.equal(new double[][]{{1.0, 3.0}, {2.0, 4.0}}, new double[][]{{1.0, 3.0}, {2.0, 4.0}}));
	 }
	 
	/**
	 * test equal() with two unequal arrays of doubles
	 */
	 @Test
	 public void equalTwoUnequalArrays() {
		 assertFalse("Error at equal() with 2 equal arrays", DataUtilities.equal(new double[][]{{1.0, 3.0}, {2.0, 1.0}}, new double[][]{{1.0, 3.0}, {2.0, 4.0}}));
	 }
	 
	 /**
	  * test equal() with one int array and one double array with equal values
	  */
	 @Test
	 public void equalOneWithInts() {
		 assertTrue("Error at equal() with 2 equal arrays", DataUtilities.equal(new double[][]{{1, 3}, {2, 4}}, new double[][]{{1.0, 3.0}, {2.0, 4.0}}));
	 }
	 
	 /**
	  * Test getCumulativePercentages() with a null argument Expected: IllegalArgumentException
	 * @throws Exception
	 */
	 @Test (expected = IllegalArgumentException.class)
	 public void getCumulativePercentagesNullArgument() throws Exception{
		 DataUtilities.getCumulativePercentages(null);
	 }
	 
	 
	 /**
	 * test getCumulativePercentages() with a mock KeyedValue object. Check value of element 0
	 */
	@Test
	 public void getCumulativePercentagesValidKeyedValuesElement0(){
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
		 //assertEquals(0.5, result.getValue(1).doubleValue(), .000000001d);
		 //assertEquals(1.0, result.getValue(2).doubleValue(), .000000001d);
	 }
	
	/**
	 * test getCumulativePercentages() with a mock KeyedValue object. Check value of element 1
	 */
	 @Test
	 public void getCumulativePercentagesValidKeyedValuesElement1(){
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
		 //assertEquals(0.16666666666666666, result.getValue(0).doubleValue(), .000000001d);
		 assertEquals(0.5, result.getValue(1).doubleValue(), .000000001d);
		 //assertEquals(1.0, result.getValue(2).doubleValue(), .000000001d);
	 }
	 
	 /**
		 * test getCumulativePercentages() with a mock KeyedValue object. Check value of element 2
		 */
	 @Test
	 public void getCumulativePercentagesValidKeyedValuesElement2(){
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
		 //assertEquals(0.16666666666666666, result.getValue(0).doubleValue(), .000000001d);
		 //assertEquals(0.5, result.getValue(1).doubleValue(), .000000001d);
		 assertEquals(1.0, result.getValue(2).doubleValue(), .000000001d);
	 }
	 
	 /**
	  * Test getCumulativePercentages() with a an empty KeyedValue object
	 * @throws Exception
	 */
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
