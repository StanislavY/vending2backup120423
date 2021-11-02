package com.example.order.Repository

import com.example.order.Data.Keys

import com.example.order.Data.MainList
import com.example.order.ViewModel.Database1CViewModel
import java.math.RoundingMode
import java.text.DecimalFormat

class MainRepositoryFrom1CImpl:MainRepisitoryFrom1C {
    private val dataBase1CViewModel: Database1CViewModel = Database1CViewModel()
    private val amountOfWorkList=makeListOfWork(Keys.NUMBERS_OF_VALUES_FOR_WORK_LIST,Keys.STEP_FOR_WORK_LIST,"Фактически отработано в натуре")
    private val hoursWorked=makeListOfWork(Keys.NUMBERS_OF_VALUES_FOR_WORKED_HOURS,Keys.STEP_FOR_WORKED_HOURS,"Отработано часов")
    // саделать маски для имен в главном списке
    override fun getListForChoice(): List<MainList> {
           val dataFrom1C: List<MainList> = dataBase1CViewModel.getAllDataFromDB1C()
           return makeStartList(dataFrom1C+amountOfWorkList+hoursWorked+ testListBrigadir)+dataFrom1C+amountOfWorkList+hoursWorked+ testListBrigadir

    }

    private fun makeStartList(mainList: List<MainList>): List<MainList> {
        val startList: List<MainList> = mainList.distinctBy { it.id1 }
        val convertList:MutableList<MainList> = mutableListOf()
         for (startList1 in startList) {
           convertList.add(changeValues(startList1.id1,startList1.id2,startList1.name,startList1.value))

        }
        return convertList
    }

    private fun changeValues (id1:String, id2:String, name: String, value:String):MainList{
        val objectForChange = MainList(id1,id2,name,value)

        objectForChange.name=objectForChange.id1
        objectForChange.id2=objectForChange.id1
        objectForChange.id1="0"
        return objectForChange
    }
    private fun makeListOfWork(numberOfValues:Int, step:Double, nameOfField:String):MutableList<MainList>{
        val workList: MutableList<MainList> = mutableListOf()
        var valueForWork=0.0
        for (i in 1..numberOfValues){
            valueForWork += step
            val roundedNumber = DecimalFormat("#.#")
            roundedNumber.roundingMode = RoundingMode.CEILING

            workList.add(MainList(nameOfField,nameOfField+i,roundedNumber.format(valueForWork).toString(),"0"))
        }
        return workList

    }

}





val testListBrigadir= listOf(
MainList("Бригадир", "1", "Иванов", "0"),
    MainList("Бригадир", "2", "Петров", "0"))



