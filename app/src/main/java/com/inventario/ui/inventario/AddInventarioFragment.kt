package com.inventario.ui.inventario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.inventario.R
import com.inventario.databinding.FragmentAddInventarioBinding
import com.inventario.model.Inventario
import com.inventario.viewmodel.InventarioViewModel


class AddInventarioFragment : Fragment() {


    private lateinit var inventarioViewModel: InventarioViewModel

    private var _binding: FragmentAddInventarioBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inventarioViewModel = ViewModelProvider(this)[InventarioViewModel::class.java]
        _binding = FragmentAddInventarioBinding.inflate(inflater,container,false)


        binding.btAdd.setOnClickListener{
            addInventario()
        }

        return binding.root
    }

    private fun addInventario() {
        val nombre=binding.etNombre.text.toString()
        val cantidad=binding.etCantidad.text.toString().toInt()
        val estado=binding.etEstado.text.toString()

        if(nombre.isNotEmpty()){
            val inventario = Inventario(0,nombre,cantidad,estado)
            inventarioViewModel.addInventario(inventario)
            Toast.makeText(requireContext(),getString(R.string.lugarAdded),Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_addInventarioFragment_to_nav_inventario)
        }else{
            Toast.makeText(requireContext(),getString(R.string.noData),Toast.LENGTH_SHORT).show()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}