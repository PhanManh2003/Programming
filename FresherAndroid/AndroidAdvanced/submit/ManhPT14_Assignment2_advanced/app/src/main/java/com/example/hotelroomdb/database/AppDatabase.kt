package com.example.hotelroomdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.Room as RoomLib
import com.example.hotelroomdb.dao.ClientDao
import com.example.hotelroomdb.dao.FacilityDao
import com.example.hotelroomdb.dao.OccupationDao
import com.example.hotelroomdb.dao.RoomDao
import com.example.hotelroomdb.dao.RoomTypeDao
import com.example.hotelroomdb.model.Client
import com.example.hotelroomdb.model.Facility
import com.example.hotelroomdb.model.Occupation
import com.example.hotelroomdb.model.Room
import com.example.hotelroomdb.model.RoomType
import com.example.hotelroomdb.model.RoomTypeFacility
import com.example.hotelroomdb.model.RoomTypePhoto

@Database(
    entities = [
        RoomType::class,
        Room::class,
        Facility::class,
        RoomTypeFacility::class,
        RoomTypePhoto::class,
        Client::class,
        Occupation::class
    ],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun roomTypeDao(): RoomTypeDao
    abstract fun roomDao(): RoomDao
    abstract fun facilityDao(): FacilityDao
    abstract fun clientDao(): ClientDao
    abstract fun occupationDao(): OccupationDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = RoomLib.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "hotel_database"
                )
                    .addCallback(PrepopulateCallback())
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}