package models

import android.os.Parcel
import android.os.Parcelable

data class Member(val name: String?, val age: Int) : Parcelable {

    constructor(parcel: Parcel) : this(
        name = parcel.readString(),
        age = parcel.readInt()
    )

    override fun describeContents(): Int {
        return 0
    }

    override fun writeToParcel(parcel: Parcel?, p1: Int) {
        parcel?.writeString(name)
        parcel?.writeInt(age)
    }

    companion object CREATOR : Parcelable.Creator<Member> {
        override fun createFromParcel(parcel: Parcel): Member {
            return Member(parcel)
        }

        override fun newArray(size: Int): Array<Member?> {
            return arrayOfNulls(size)
        }
    }
}
