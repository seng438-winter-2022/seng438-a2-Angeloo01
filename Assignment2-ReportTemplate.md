**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report \#2 – Requirements-Based Test Generation**

| Group \#:       | 22  |
|-----------------|---|
| Student Names:  |  Angelo Gonzales |
|                 |  Dave Sharma |
|                 |  Jaron Baldazo |
|                 |  Manjot Singh |

# 1 Introduction

The purpose of this lab is to intorduce us to the concepts of automated unit testing. In this lab we will be tasked with creating unit test using the primary testing tool in Java, being the JUnit framework. We will be using the JUnit framework, to test the system JFreeChart. In order to test the system, units tests will be created based in requirements found in the Javadocs for the JFreeChart software. Certain aspects of the JFreeChart system that we will be testing, will require the development and use of mock objects in order to simulate features of objects that are hard to reproduce in our unit tests.

# 2 Detailed description of unit test strategy

Our strategy for this assignment is to use Black-box testing, weak equivalence class testing, boundary value testing, and weak robustness testing. We are undergoing black-box testing because we do not know the internal structure and the implementation of the functions and classes we are testing. Additionally, we chose to undego weak ECT because of the limited time frame and strong ECT introduces some redundancy. We chose to do BVT and weak robustness testing so that we can test the behaviour at the boundary values and out of bound values in addition to correctness of output.

To apply these testing methods, we are going to implement unit tests using JUnit 4. Additionally, to test functions that rely on DOC's we will use Jmock to create stubs and/or mocks to act as fakes. In addition, these stubs and mocks will allow us to verify the state of the SUT, and its behaviour and interactions during the test.

The functions we chose to test from the Range class are and their equvalence classes:
 - getLength()
   - Range object with valid doubles as bounds.
  
 - getLowerBound()
   - Range object with valid doubles as bounds.
  
 - getUpperBound()
   - Range object with valid doubles as bounds.
  
 - intersects(double a, double b)
   - Range object with valid doubles as bounds.
   - a < lower bound, lower bound <= a <= upper bound, a > upper bound
   - b < lower bound, lower bound <= b <= upper bound, b > upper bound
  
 - Range(double a, double b)
   - a < b
   - a >= b

The functions we are testing from the DataUtilities class are:
 - calculateColumnTotal()
   - non-null and null Values2D argument
 - calculateRowTotal()
   - non-null and null Values2D argument
 - createNumberArray()
   - non-null and null double array argument
 - createNumberArray2D()
   - non-null and null double 2d array argument
 - getCumulativePercentages()
   - non-null and null KeyedValues argument

# 3 Test cases developed

Range: 
| Method to be Tested | Testing Method Name | Type of Test |
|-------------------- | --- | --- |
| getLength() | getLengthShouldBeTwo() | weak ECT
| getLowerBound() | getLowerBoundShouldBeNegOne() | weak ECT
| getUpperBound() | getUpperBoundShouldBeOne() | weak ECT
| intersects(double a, double b) | intersectsShouldBeTrueALessThanLower() | BVT
| intersects(double a, double b) | intersectsShouldBeFalseAGreaterThanUpper() | BVT
| intersects(double a, double b) | intersectsShouldBeTrueABetweenBounds() | weak ECT
| intersects(double a, double b) | intersectsShouldBeTrueAEqualLower() | BVT
| intersects(double a, double b) | intersectsShouldBeTrueAEqualUpper() | BVT
| intersects(double a, double b) | intersectsShouldBeTrueABLB() | Robust
| intersects(double a, double b) | intersectsShouldBeFalseAAUB() | Robust
| Range(double a, double b) | rangeCtorLowerGreaterThanUpper() | BVT
| Range(double a, double b) | rangeCtorInvalidArgument() | weak ECT
| Range(double a, double b) | rangeCtorValidArgument() | weak ECT
| Range(double a, double b) | rangeCtorAEqualB() | BVT
| Range(double a, double b) | rangeCtorABLB() | Robust
| Range(double a, double b) | rangeCtorAAUB() | Robust

DataUtilities: 
| Method to be Tested | Testing Method Name | Type of Test |
|-------------------- | --- | --- |
| calculateColumnTotal(Values2D data, int column) | calculateColumnTotalForTwoValues() | weak ECT
| calculateColumnTotal(Values2D data, int column) | calculateColumnTotalForTwoRowsTwoColumns() | weak ECT
| calculateColumnTotal(Values2D data, int column) | calculateColumnTotalNullArgument() | BVT
| calculateRowTotal(Values2D data, int row) | calculateRowTotalForTwoValues() | weak ECT
| calculateRowTotal(Values2D data, int row) | calculateRowTotalForTwoRowsTwoColumns() | weak ECT
| calculateRowTotal(Values2D data, int row) | calculateRowTotalNullArgument() | BVT
| createNumberArray(double[] data) | createNumberArrayTwoDoubleElements() | weak ECT
| createNumberArray(double[] data) | createNumberArrayNullArgument() | BVT
| createNumberArray2D(double[][] data) | createNumberArray2DTwoArrayOfTwoDoubleElements() | weak ECT
| createNumberArray2D(double[][] data) | createNumberArray2DNullArgument() | BVT
| equal(double[][] a, double[][] b) | equalTwoEqualArrays() | weak ECT
| equal(double[][] a, double[][] b) | equalTwoUnequalArrays() | weak ECT
| equal(double[][] a, double[][] b) |  public void equalOneWithInts() | weak ECT
| getCumulativePercentages(KeyedValues data) | getCumulativePercentagesNullArgument() | BVT
| getCumulativePercentages(KeyedValues data) | getCumulativePercentagesValidKeyedValues() | weak ECT
| getCumulativePercentages(KeyedValues data) | getCumulativePercentagesEmptyList() | weak ECT

# 4 How the team work/effort was divided and managed

Team work was divided equally, as all team members worked together one each part of the lab. Each member of the team went through the familirization of creating unit tests, and were responsiblle of creating and then following through with the test plan. As a team we went through the Javadocs of the JFreeChart system, and determined which methods and requirements we were gonna test for the test plan. Once the plan was created, members worked on creating unit tests, with an equal workload distributed to each. Finally, the lab report writeup, was split equally between members. Throughout the lab, each member was responsible for keeping each other accountable, and make sure that the work was done in time.

# 5 Difficulties encountered, challenges overcome, and lessons learned

The main difficulty that we found during the assignment was during the Mock testings of DataUtilities. Issues with the hamcrest package not being recognized prevented us from initially doing the Mock testings of DataUtilities.We were able to overcome this difficulty with the aid of our teaching assistant, by adding the hamcrest-library-1.1.jar to our external jars, allowing us to complete the mocking tests for DataUtilities.

The main lessons that our group learned throughout this assignment was the key differences between the Black Box Testing types. Without having complete knowledge of the function implementations tested (Black Box), we were still able to write useful unit tests to determine whether the functionality of the RangeTests and DataUtilities was working properly.

# 6 Comments/feedback on the lab itself

The assignment handout was very easy to follow as it tells us step by step on how to familiarize ourselves with JUnit and JFreeChart. This assignment was also useful in enforcing our understanding with the different types of Black Box testings. We were able to understand the usefulness of writing Black Box testing, through the use of JMock and JUnit 4. Minor inconveniences that we found during the assignment includes downloading the Assignment 2 Artifacts from D2L rather than the github and the hamcrest package not being recognized.
