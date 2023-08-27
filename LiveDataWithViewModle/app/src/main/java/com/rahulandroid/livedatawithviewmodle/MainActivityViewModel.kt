package com.rahulandroid.livedatawithviewmodle

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlin.random.Random

class MainActivityViewModel :ViewModel(){
    val factsDataO = MutableLiveData<String>("This is a fact")

    val factsData:LiveData<String>
        get()= factsDataO


    data class Employee(var name:String, var age:Int, var salary:Double)

    val employeeList = MutableLiveData<Employee>()

    val e1 = Employee("Rahul",29,242345.9123)
    val e2 = Employee("Raja",28,342345.9123)
    val e3 = Employee("Ram",22,142345.9123)
    val e4 = Employee("Ramesh",23,222345.9123)
    val e5 = Employee("Manjit",22,2440345.9123)
    val e6 = Employee("Harsha",21,242045.9123)
    val e7 = Employee("Harsh",31,4342045.9123)
    val e8 = Employee("Naveen",39,2445.9123)
    val e9 = Employee("Meenakshi",29,345.9123)
    val e10 = Employee("Abhinav",19,245.9123)
    val e11 = Employee("Bhawna",39,2445.9123)
    val e12 = Employee("Aayush",49,12345.9123)

   var list = listOf(e1,e2,e3,e4,e5,e6,e7,e8,e9,e10,e11,e12)




    fun updateLiveData(){
        factsDataO.value = "New Live Data "+Math.random();
    }

    fun updateEmployeeLiveData(){
        val employee = list.get(Random.nextInt(0, 11))
        employeeList.value= employee
    }
}
