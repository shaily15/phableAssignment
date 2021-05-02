package google.com.phable.shaily.database

import android.os.Parcel
import android.os.Parcelable
import android.view.View
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userDetails")
class UserEntity(): Parcelable {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    var userId: Long? = null

    @ColumnInfo(name = "user_name")
    var userName: String? = null

    @ColumnInfo(name = "user_email_id")
    var userEmailId: String? = null

    constructor(userId: Long?, userName: String?, userEmail: String?) : this() {
        this.userId = userId
        this.userName = userName
        this.userEmailId = userEmailId
    }

    constructor(parcel: Parcel) : this() {
        userId = parcel.readValue(Long::class.java.classLoader) as? Long
        userName = parcel.readString()
        userEmailId = parcel.readString()
    }

    // for DiffUtil class
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UserEntity) return false
        val user = other as? UserEntity
        return userId == user?.userId
                && userName == user?.userName
                && userEmailId == user?.userEmailId
    }

    // dataBinding onClick
    fun onUserItemClicked(view: View, user: UserEntity) {
//        val intent = Intent(view.context, BookActivity::class.java)
//        intent.putExtra("selected_category_id", book.bookCategoryID)
//        intent.putExtra("selected_book", book)
//        intent.putExtra("is_update_book", true)
//        view.context.startActivity(intent)
        //TODO
    }

    // parcelable stuff
    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(userId)
        parcel.writeString(userName)
        parcel.writeString(userEmailId)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserEntity> {
        override fun createFromParcel(parcel: Parcel): UserEntity {
            return UserEntity(parcel)
        }

        override fun newArray(size: Int): Array<UserEntity?> {
            return arrayOfNulls(size)
        }
    }
}
