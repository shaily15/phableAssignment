package google.com.phable.shaily.database

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

interface UserDAO {
    @Insert
    fun addUser(book: UserEntity) : Long

    @Update
    fun updateUser(book: UserEntity)

    @Delete
    fun deleteUser(book: UserEntity?)

    @Query("SELECT * FROM userDetails")
    fun getAllUsers() : LiveData<List<UserEntity>>
}