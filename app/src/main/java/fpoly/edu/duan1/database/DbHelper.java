package fpoly.edu.duan1.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public DbHelper(Context context){
        super(context,"QUANLYBANHANG",null,1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String tSanPham="CREATE TABLE SANPHAM(masanpham integer primary key autoincrement,tensanpham text, giasanpham integer, soluong integer)";
        db.execSQL(tSanPham);
        String tNguoiDung="CREATE TABLE NGUOIDUNG(username text primary key, password text)";
        db.execSQL(tNguoiDung);
        String tHoaDon="CREATE TABLE HOADON(mahoadon integer primary key autoincrement, giatien integer,username text references NGUOIDUNG(username), dongia integer)";
        db.execSQL(tHoaDon);
        String tHoaDonChiTiet = "CREATE TABLE HOADONCHITIET(mahoadonchitiet integer primary key autoincrement, mahoadon integer references HOADON(mahoadon), masanpham integer references SANPHAM(masanpham),soluongmua integer, tongtien integer)";
        db.execSQL(tHoaDonChiTiet);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion != newVersion){
            db.execSQL("DROP TABLE IF EXISTS SANPHAM");
            db.execSQL("DROP TABLE IF EXISTS NGUOIDUNG");
            db.execSQL("DROP TABLE IF EXISTS HOADON");
            db.execSQL("DROP TABLE IF EXISTS HOADONCHITIET");

        }

    }
}