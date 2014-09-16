package org.scalalabs.basic.lab03
import sys._
/**
 * This exercise introduces you to pattern matching in combination with recursion.
 *
 * Recursion is a key concept for the functional style programming.
 * In the exercises below you learn how to apply recursion in combination with Scala's pattern matching facilities.
 *
 * For this exercise exclusively use pattern matching constructs in order to make the corresponding unittest work.
 *
 * Reference material to solve these exercises can be found here:
 * Pattern matching in general: http://programming-scala.labs.oreilly.com/ch03.html#PatternMatching
 * Pattern matching and recursion: http://programming-scala.labs.oreilly.com/ch08.html#Recursion
 */

object RecursionPatternMatchingExercise {

  /**
   * ***********************************************************************
   * Recursive algorithms with pattern matching
   * For expected solution see unittest @RecursionPatternMatchingExerciseTest
   * ***********************************************************************
   */
  /**
   * Create a method that checks that each subsequent value is greater than
   * the previous one.
   * E.g.:
   * checkValuesIncrease(Seq(1,2,3)) == true
   * checkValuesIncrease(Seq(1,2,2)) == false
   */
  def checkValuesIncrease(seq: Seq[Int]): Boolean = {
    if(seq.length <= 1)
      true
    
    else if(seq(0) < seq(1)) 
      checkValuesIncrease(seq.takeRight(seq.length-1))
    
    else
      false
      
  }
  
  /**
   * Group Consecutive values
   * List(1,1,2,3,1,1) -> List(1,1), List(2), List(3), List(1,1)
   */
  def groupConsecutive[T](in: List[T]): List[List[T]] = {
    groupConsecutiveRecursive[T](in.takeRight(in.length-1), List.empty, List(in(0)))
  }
  
  def groupConsecutiveRecursive[T](in: List[T], soFar: List[List[T]], current: List[T]): List[List[T]] = {
    if(in.length == 0) {
      soFar :+ current
    }
    else if(in(0) == current(0)) {
      groupConsecutiveRecursive[T](in.takeRight(in.length-1), soFar, current :+ in(0))
    }
    else {
      groupConsecutiveRecursive[T](in.takeRight(in.length-1), soFar :+ current, List(in(0)))
    }
  }

  /**
   * Group Equal values
   * List(1,1,2,3,1,1) -> List(1,1,1,1), List(2), List(3)
   */
  def groupEquals[T](in: List[T]): List[List[T]] = {
	groupEqualsRecursive[T](List.empty, in)
  }
  
  def groupEqualsRecursive[T](finalResult: List[List[T]], in: List[T]): List[List[T]] = {
    if(in.length == 0)
      finalResult
      
    else {
    	val partitionList = in.partition(_ == in(0))
        groupEqualsRecursive[T](finalResult :+ partitionList._1, partitionList._2)
      }
     
  }

  /**
   * Compress values
   * List(1,1,2,3,1,1) -> List(1,2,3)
   */
  def compress[T](in: List[T]): List[T] = {
    compressRecursive[T](List.empty, in)
  }
  
  def compressRecursive[T](finalResult: List[T], in: List[T]): List[T] = {
    if(in.length == 0)
      finalResult
      
    else {
    	val partitionList = in.partition(_ == in(0))
        compressRecursive[T](finalResult :+ partitionList._1(0), partitionList._2)
      }
     
  }
  
  /**
   * Define the amount of all equal members
   * List(1,1,2,3,1,1) -> List((4,1),(1,2),(1,3))
   */
  def amountEqualMembers[T](in: List[T]): List[(Int, T)] = {
    val listOfLists = groupEquals(in)
    listOfLists.map(x => (x.length, x(0)))
    
  }
  
  /**
   * Zip multiple lists
   * List(List(1,2,3), List('A, 'B, 'C), List('a, 'b, 'c)) -> List(List(1, 'A, 'a), List(2, 'B, 'b), List(3, 'C, 'c))
   */
  def zipMultiple(in: List[List[_]]): List[List[_]] = {
    zipMultipleRecursive(in, List.empty)
  }
  
  def zipMultipleRecursive(in: List[List[_]], finalList: List[List[_]]): List[List[_]] = {
    if(in(0).length == 0) {
      finalList
    }
    else {
    	val listOfBeginnings = in.map(x => x(0))
    	zipMultipleRecursive(in.map(x => x.takeRight(x.length-1)), finalList :+ listOfBeginnings)
    }
  }

  /**
   * Zip multiple lists with different sizes
   * List(List(1), List('A, 'B, 'C), List('a, 'b)) -> List(List(1, 'A, 'a))
   */
  def zipMultipleWithDifferentSize(in: List[List[_]]): List[List[_]] = {
    zipMultipleWithDifferentSizeRecursive(in, List.empty)
  }
  
  def zipMultipleWithDifferentSizeRecursive(in: List[List[_]], finalList: List[List[_]]): List[List[_]] = {
    if(in.map(_.length).contains(0)) {
      finalList
    }
    else {
      val listOfBeginnings = in.map(x => x(0))
      zipMultipleWithDifferentSizeRecursive(in.map(x => x.takeRight(x.length-1)), finalList :+ listOfBeginnings)
    }
  }

}
