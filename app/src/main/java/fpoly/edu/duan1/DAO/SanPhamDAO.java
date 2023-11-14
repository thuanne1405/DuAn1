package fpoly.edu.duan1.DAO;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;



import java.util.ArrayList;

import fpoly.edu.duan1.database.DbHelper;
import fpoly.edu.duan1.model.sanpham;

public class SanPhamDAO {
    private DbHelper dbhelper;
    public SanPhamDAO(Context context){
        dbhelper = new DbHelper(context);
    }
    public ArrayList<sanpham>getDSSanpham(){
        ArrayList<sanpham>list=new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = dbhelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM SANPHAM", null);


        return list;
    }
}
