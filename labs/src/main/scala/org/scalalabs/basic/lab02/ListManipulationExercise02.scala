package org.scalalabs.basic.lab02

import scala.collection.mutable.ListBuffer
 import sys._


object ListManipulationExercise02 {

  /**
   * Find the maximum element in a list, e.g. maxElementInList(List(1,9,3,5)) == 9
   * As usual, various ways exist: pattern matching, folding, ...
   */
  def maxElementInList(l: List[Int]): Int = {
    l.max;
  }

  /**
   * Calculate the sum of the equally position elements
   * of the two list
   */
  def sumOfTwo(l1: List[Int], l2: List[Int]): List[Int] = {
    var x = 0;
    val newList = new ListBuffer[Int]();
    val max = math.max(l1.length -1, l2.length-1)
    for( x <- 0 to max ){
    	if(l1.length - 1 < x) {
    	  newList += l2(x)
    	}
    	else if(l2.length -1 < x) {
    	  newList += l1(x)
    	}
    	else {
    	  newList += l1(x) + l2(x)
    	} 
    }
    
    newList.toList
  }

  /**
   *  For this exercise preferably make use of the sumOfTwo
   * method above
   */
  def sumOfMany(l: List[Int]*): List[Int] = {
    
    
    val starter = List.fill(l(0).length)(0)
    l.foldLeft(starter)(sumOfTwo(_,_))   
  }

  case class Person(age: Int, firstName: String, lastName: String)

  /**
   * The following method is implemented in the most in-elegant way we could think of.
   * The idea is to re-write the method into more functional style. In the end, you
   * may be able to achieve the same functionality as implemented below
   * in a one-liner.
   */
  def separateTheYoungFromTheOld(persons: List[Person]): List[List[String]] = {
    
    List(persons.filter(_.age < 18).map(_.firstName).sorted, persons.filter(_.age >= 18).map(_.firstName).sorted)
    /*
    var youngins: ListBuffer[Person] = new ListBuffer[Person]()
    var elders: ListBuffer[Person] = new ListBuffer[Person]()
    var validYoungNames: ListBuffer[String] = new ListBuffer[String]()
    var validOldNames: ListBuffer[String] = new ListBuffer[String]()

    for (person <- persons) {
        if (person.age < 18) {
          youngins += person
        } else {
          elders += person
        }
    }

    var sortedYoung = youngins.toList.sortBy(_.age)
    var sortedOld = elders.toList.sortBy(_.age)

    for (young <- sortedYoung) {
      validYoungNames += young.firstName
    }
    for (old <- sortedOld) {
      validOldNames += old.firstName
    }
    List(validYoungNames.toList, validOldNames.toList)
  }
  */
  }
}