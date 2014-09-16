package org.scalalabs.basic.lab02
import sys._
/**
 * The goal of this exercise is to get familiar with the basic collections API of Scala. Implement all methods so that the unit test passes.
 * Using collections will be a different experience than the way you're familiar with in Java.
 * In Scala the way to deal with collections is to use higher order functions instead of a for-loop.
 *
 * An overview of some functional programming techniques can be found here in the O'reilly book:
 * http://programming-scala.labs.oreilly.com/ch08.html#FunctionalDataStructures 
 */
object ListManipulationExercise01 {

  /**
   * Get the first element in the list. Hint: there is a built-in function for this you can use.
   * 
   */
  def firstElementInList[T](l: List[T]): T = {
    l(0);
  }

  /**
   * Get the sum of all the elements in the list, e.g. sumOfList(List(1,2,3)) = 6.
   */
  def sumOfList(l: List[Int]): Int = {
    l.sum;
  }

  /**
   * Get the last element in the list, e.g. lastElementInList(List(1,2,3)) = 3.
   * Hint: this can be achieved in multiple ways:
   *  - built in
   *  - via a pattern match
   *  - by using a foldLeft function
   *  - ... etc
   */
  def lastElementInList[T](l: List[T]): T = {
    l(l.length -1)
  }

   /**
   * Get the nth element in the list, e.g. nthElementInList(3, List(1,2,3,4)) = 3.
   * Hint: this can be achieved in multiple ways:
   *  - built in
   *  - via a pattern match
   *  - custom made (for instance, it can be done in a fun way by using the zipWithIndex function, that is available on a List)
   *  - ... etc
   */
  def nthElementInList[T](n: Int, l: List[T]): T = {
    l(n)
  }

  /**
   * Concatenate two lists into one, e.g. concatLists(List(1,2,3), List(4,5,6)) = List(1,2,3,4,5,6)
   * Hint: this can be achieved in multiple ways:
   *  - built in
   *  - via a pattern match
   *  - custom made
   *  - ... etc 
   */
  def concatLists[T](l1: List[T], l2: List[T]): List[T] = {
    l1 ++ l2;
  }

  /**
   * Sort a list on the natural ordering, so sortList(3,1,2) = List(1,2,3).
   * Hint: this can be achieved in multiple ways:
   * - built in using the sort method
   * - via a foldLeft method (a bit complex, but fun)
   * - ... whichever way you like 
   * 
   */
  def sortList[T <% Ordered[T]](list: List[T]): List[T] = {
    list.sorted
  }

  /**
   * Check whether a given element in a list exists, i.e. elementExists(List("a", "b", "c"), "b") = true
   * Again, easy to implement using built-in functionality, but also possible to implement in your own free-style way.
   */
  def elementExists[T](l: List[T], e: T): Boolean = {
    l.contains(e)
  }

  /**
   * Get all odd elements in the list, i.e. oddElements(List(1,2,3,4,5)) = List(1,3,5)
   * As always, use either build-in functions (for instance the filter method), or roll your own way via a
   * pattern match or some other method.
   */
  def oddElements(iList: List[Int]): List[Int] = {
    iList.filter( _ % 2 != 0)
  }

  /**
   * Inspired by Haskell's tails function: http://www.zvon.org/other/haskell/Outputlist/tails_f.html
   * This method should return a list of lists, containing all final segments of the argument list, longest first.
   * For example: tails(List(1,2,3,4)) = List(List(1,2,3,4), List(2,3,4), List(3,4), List(4), List())
   *
   * Implement it whatever way suites you best. Hint: it can be done in a neat way using recursion. 
   */
  def tails[T](l: List[T]): List[List[T]] = {
    recursiveTails[T](l, List())      
  }
  
  def recursiveTails[T](l: List[T], soFar: List[List[T]]): List[List[T]] = {
    if(l.length == 0){
      soFar :+ l
    }
    else {
      recursiveTails[T](l.takeRight(l.length-1), soFar :+ l)
    }
  }
  
}


