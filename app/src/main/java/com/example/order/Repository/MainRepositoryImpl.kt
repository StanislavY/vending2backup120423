package com.example.order.Repository

import com.example.order.Data.MainList

class MainRepositoryImpl:MainRepisitory {
    override fun getListFrom1C(): List<MainList> {
        return listOf(
            MainList(0,1,"Работа","0"),
            MainList(0,2,"Трактор","0"),
            MainList(0,3,"Тракторист","0"),
            MainList(0,4,"Участок","0"),
            MainList(0,5,"Объем в га","0"),
            MainList(0,6,"Человеко-часы","0"),
            MainList(0,7,"Дата","0"),
            MainList(0,8,"Вид работ","0"),
            MainList(1,9,"Обрезка","0"),
            MainList(1,10,"Чизелевание","0"),
            MainList(1,11,"Посадка","0"),
            MainList(1,12,"Культивация","0"),
            MainList(2,13,"МТЗ 921","0"),
            MainList(2,14,"Джон дир","0"),
            MainList(2,15,"Фентд","0"),
            MainList(2,16,"Валтра","0")
        )
    }

}