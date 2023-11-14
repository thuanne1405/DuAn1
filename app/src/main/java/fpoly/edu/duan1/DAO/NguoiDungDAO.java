package fpoly.edu.duan1.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;


import fpoly.edu.duan1.database.DbHelper;

public class NguoiDungDAO {
    private DbHelper dbhelper;
    public NguoiDungDAO(Context context){
        dbhelper = new DbHelper(context);

    }
    public boolean KiemTraDangNhap(String username, String password){
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM NGUOIDUNG WHERE username = ? AND password = ?",new String []{username,password});
            return cursor.getCount()>0;

    }
}
