package com.inventario.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="inventario")
data class Inventario(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="nombre")
    val nombre: String,
    @ColumnInfo(name="cantidad")
    val cantidad: Int?,
    @ColumnInfo(name="estado")
    val estado: String?
) : Parcelable