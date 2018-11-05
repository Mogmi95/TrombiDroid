package apps.mogmi.fr.trombidroid.data

import com.google.gson.annotations.SerializedName

data class Person(val arrival : Long = 0,
                  val surname : String = "",
                  val name : String = "",
                  @SerializedName("team_id") var teamId : Int?,
                  val email : String = "",
                  val job : String = "",
                  val birthday : Long = 0,
                  val login : String = "",
                  val id : Int = 0,
                  val picture : String = "")  {

    companion object {
        const val BASE_URL = "https://trombi.mogmi.fr"
    }

    val pictureUrl: String
        get() = BASE_URL.plus(picture)

}