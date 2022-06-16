import androidx.lifecycle.LiveData
import androidx.room.*
import com.inventario.model.Inventario

@Dao
interface InventarioDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun addInventario(inventario: Inventario)

    @Update(onConflict = OnConflictStrategy.IGNORE)
     fun updateInventario(inventario: Inventario)

    @Delete
     fun deleteInventario(inventario: Inventario)

    @Query("SELECT * FROM INVENTARIO")
    fun getAllData() : LiveData<List<Inventario>>
}