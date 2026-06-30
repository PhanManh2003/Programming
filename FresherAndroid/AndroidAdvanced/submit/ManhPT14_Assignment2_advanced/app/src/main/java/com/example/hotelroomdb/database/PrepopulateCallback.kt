package com.example.hotelroomdb.database

import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

class PrepopulateCallback : RoomDatabase.Callback() {

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)

        // Room types
        db.execSQL("INSERT INTO room_type VALUES (1, 'Single', 50.0)")
        db.execSQL("INSERT INTO room_type VALUES (2, 'Double', 80.0)")
        db.execSQL("INSERT INTO room_type VALUES (3, 'Suite', 150.0)")

        // Facilities
        db.execSQL("INSERT INTO facility VALUES (1, 'TV')")
        db.execSQL("INSERT INTO facility VALUES (2, 'Bar')")
        db.execSQL("INSERT INTO facility VALUES (3, 'Vault')")
        db.execSQL("INSERT INTO facility VALUES (4, 'Jacuzzi')")

        // Room type facilities
        db.execSQL("INSERT INTO room_type_facility VALUES (1, 1)")        // Single: TV
        db.execSQL("INSERT INTO room_type_facility VALUES (2, 1)")        // Double: TV
        db.execSQL("INSERT INTO room_type_facility VALUES (2, 2)")        // Double: Bar
        db.execSQL("INSERT INTO room_type_facility VALUES (3, 1)")        // Suite: TV
        db.execSQL("INSERT INTO room_type_facility VALUES (3, 2)")        // Suite: Bar
        db.execSQL("INSERT INTO room_type_facility VALUES (3, 3)")        // Suite: Vault
        db.execSQL("INSERT INTO room_type_facility VALUES (3, 4)")        // Suite: Jacuzzi

        // Rooms
        db.execSQL("INSERT INTO room VALUES (101, 1)")
        db.execSQL("INSERT INTO room VALUES (102, 1)")
        db.execSQL("INSERT INTO room VALUES (201, 2)")
        db.execSQL("INSERT INTO room VALUES (202, 2)")
        db.execSQL("INSERT INTO room VALUES (203, 2)")
        db.execSQL("INSERT INTO room VALUES (301, 3)")
        db.execSQL("INSERT INTO room VALUES (302, 3)")

        // Clients
        db.execSQL("INSERT INTO client VALUES (1, 'Nguyen Van A', 'Male', 'Vietnam', '0901234567')")
        db.execSQL("INSERT INTO client VALUES (2, 'Tran Thi B', 'Female', 'Vietnam', '0912345678')")
        db.execSQL("INSERT INTO client VALUES (3, 'John Smith', 'Male', 'USA', '0923456789')")
        db.execSQL("INSERT INTO client VALUES (4, 'Emma Johnson', 'Female', 'UK', '0934567890')")
        db.execSQL("INSERT INTO client VALUES (5, 'Le Van C', 'Male', 'Vietnam', '0945678901')")
        db.execSQL("INSERT INTO client VALUES (6, 'Park Ji Young', 'Female', 'Korea', '0956789012')")
        db.execSQL("INSERT INTO client VALUES (7, 'Wang Wei', 'Male', 'China', '0967890123')")
        db.execSQL("INSERT INTO client VALUES (8, 'Pham Thi D', 'Female', 'Vietnam', '0978901234')")

        // Occupations (mix năm 2023 và 2024 để test cả 2 query)
        db.execSQL("INSERT INTO occupation VALUES (1, 101, 1, '2023-01-10', '2023-01-15', 30.0)")
        db.execSQL("INSERT INTO occupation VALUES (2, 201, 2, '2023-02-05', '2023-02-10', 50.0)")
        db.execSQL("INSERT INTO occupation VALUES (3, 301, 3, '2023-03-20', '2023-03-25', 100.0)")
        db.execSQL("INSERT INTO occupation VALUES (4, 102, 4, '2023-06-01', '2023-06-07', 20.0)")
        db.execSQL("INSERT INTO occupation VALUES (5, 202, 5, '2023-08-15', '2023-08-20', 60.0)")
        db.execSQL("INSERT INTO occupation VALUES (6, 302, 6, '2023-11-10', '2023-11-14', 80.0)")
        db.execSQL("INSERT INTO occupation VALUES (7, 203, 7, '2024-01-05', '2024-01-10', 40.0)")
        db.execSQL("INSERT INTO occupation VALUES (8, 301, 8, '2024-03-15', '2024-03-20', 90.0)")
        db.execSQL("INSERT INTO occupation VALUES (9, 101, 1, '2024-07-01', '2024-07-05', 25.0)")
        db.execSQL("INSERT INTO occupation VALUES (10, 201, 3, '2024-09-10', '2024-09-15', 70.0)")
    }
}