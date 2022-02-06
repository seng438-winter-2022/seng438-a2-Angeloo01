package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;

public class RangeTest {
    private Range exampleRange;
    @BeforeClass public static void setUpBeforeClass() throws Exception {
    }


    @Before
    public void setUp() throws Exception { exampleRange = new Range(-1, 1);
    }


    @Test
    public void centralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
        0, exampleRange.getCentralValue(), .000000001d);
    }
    
    @Test
    public void getLengthShouldBeTwo() {
       // fail("Not yet implemented");
    	assertEquals("The length should be 2",
    	        2, exampleRange.getLength(), .000000001d);
    }
    
    @Test
    public void getLowerBoundShouldBeNegOne() {
        //fail("Not yet implemented");
    	assertEquals("The lower bound should be -1",-1,exampleRange.getLowerBound(), .000000001d);
    }
    
    @Test
    public void getUpperBoundShouldBeOne() {
        //fail("Not yet implemented");
    	assertEquals("The length should be 2",
    	        1, exampleRange.getUpperBound(), .000000001d);
    }
    
    @Test
    public void intersectsShouldBeTrue() {
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range(-2, 2);
    	
    	assertTrue(exampleRange.intersects(exampleRange2));
    }
    
    @Test
    public void intersectsShouldBeFalse() {
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range(3, 4);
    	
    	assertFalse(exampleRange.intersects(exampleRange2));
    }
//    
    @Test(expected = IllegalArgumentException.class)
    public void isNaNRangeShouldBeFalseBothValidBounds() throws Exception {
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range(4, 2);
    }
 
    @Test(expected = IllegalArgumentException.class)
    public void isNaNRangeShouldBeFalseOneNaNBound() throws Exception{
        //fail("Not yet implemented");
    	Range exampleRange2 = new Range('L',3);
    }
    
//    @Test
//    public void isNaNRangeShouldBeTrue(){
//        //fail("Not yet implemented");
//    	
//    	
//    }

    @After
    public void tearDown() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
}