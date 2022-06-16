package com.inventario.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.inventario.model.Inventario
import com.inventario.repository.InventarioRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class InventarioViewModel(application: Application) : AndroidViewModel(application){

    val getAllData: LiveData<List<Inventario>>

    //Esta es la manera de acceder al repositorio desde el viewModel
    private val repository: InventarioRepository

    //Procede a inicializar los atributos anteriores de esta clase LugarViewModel
    init
    {
        val inventarioDao = InventarioDatabase.getDatabase(application).inventarioDao()
        repository = InventarioRepository(inventarioDao)
        getAllData = repository.getAllData
    }
    //Esta funcion de alto nivel llama al subproceso de I/O para grabar un registro Lugar
    fun addInventario(inventario: Inventario)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.addInventario(inventario)
        }
    }

    //Esta funcion de alto nivel llama al subproceso de I/O para Actualizar un registro Lugar
    fun updateInventario(inventario: Inventario)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.updateInventario(inventario)
        }
    }

    //Esta funcion de alto nivel llama al subproceso de I/O para Eliminar un registro Lugar
    fun deleteInventario(inventario: Inventario)
    {
        viewModelScope.launch(Dispatchers.IO)
        {
            repository.deleteInventario(inventario)
        }
    }
}