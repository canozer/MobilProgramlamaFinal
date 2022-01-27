fun insertData(user:User){
        val sqliteDB = this.writableDatabase
        contentValues.put(COL_NAME , yemekadi)

        val result = sqliteDB.insert(TABLE_NAME,null,contentValues)

        Toast.makeText(context,if(result != -1L) "Kayıt Başarılı" else "Kayıt yapılamadı.", Toast.LENGTH_SHORT).show()
    }

    fun readData():MutableList<User>{
        val userList = mutableListOf<User>()
        val sqliteDB = this.readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val result = sqliteDB.rawQuery(query,null)
        if(result.moveToFirst()){
            do {
                val user = User()
                yemekadi = result.getString(result.getColumnIndex(COL_ID)).toInt()
            }while (result.moveToNext())
        }
        result.close()
        sqliteDB.close()
        return userList
    }
