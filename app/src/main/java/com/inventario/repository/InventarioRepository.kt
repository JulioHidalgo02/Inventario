package com.inventario.repository

import InventarioDao
import androidx.lifecycle.LiveData

import com.inventario.model.Inventario

class InventarioRepository(private val inventarioDao: InventarioDao) {

    // Se implementan las funciones de la interface

    //Se crea un objeto que contiene el arrayList de los registros de la tabla lugar ... cubiertos por LiveData
    val getAllData: LiveData<List<Inventario>> = inventarioDao.getAllData()

    //Define la funcion para insertar un lugar en la tabla LUGAR
     fun addInventario(inventario: Inventario)
    {
        inventarioDao.addInventario(inventario)
    }

    //Define la funcion para actualizar un lugar en la tabla LUGAR
     fun updateInventario(inventario: Inventario)
    {
        inventarioDao.updateInventario(inventario)
    }

    //Define la funcion para eliminar un lugar en la tabla LUGAR
     fun deleteInventario(inventario: Inventario)
    {
        inventarioDao.deleteInventario(inventario)
    }

}