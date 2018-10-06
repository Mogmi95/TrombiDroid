package apps.mogmi.fr.trombidroid.request

import apps.mogmi.fr.trombidroid.data.Person
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface TrombiService {

    @GET("api/persons")
    fun listPersons(): Call<List<Person>>

}