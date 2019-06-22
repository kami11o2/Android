package com.cs442.dsuraj.quantumc;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Suraj Didwania on 04-11-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Movie.db";
    public static final String TABLE_NAME1 = "Movies";
    public static final String TABLE_NAME3 = "Movies_Booked";
    public static final String TABLE_NAME4 = "User_Info";
    public static final String T1_COL_1 = "MovieName";
    public static final String T1_COL_2 = "Movie_Id";
    public static final String T1_COL_3 = "Information";
    public static final String T1_COL_4 = "Ratings";
    public static final String T1_COL_5 = "User_Reviews";
    public static final String T1_COL_6 = "ComingSoon";
    public static final String T1_COL_7 = "Seats_Available";
    public static final String T2_COL_1 = "Theatres";
    public static final String T2_COL_2 = "Timings";
    public static final String T2_COL_3 = "Price";
    public static final String T2_COL_4 = "Movie_ID";
    public static final String T3_COL_1 = "Movie_Id";
    public static final String T3_COL_2 = "Timings";
    public static final String T3_COL_3 = "Theatres";
    public static final String T3_COL_4 = "Email";
    public static final String T3_COL_5 = "Phone";
    public static final String T3_COL_6 = "Booking_ID";
    public static final String T3_COL_7 = "Quantity";

    public DatabaseHelper(Context context) {
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME1 +" (NAME VARCHAR, MOVIE_ID INTEGER PRIMARY KEY AUTOINCREMENT,INFORMATION VARCHAR, RATINGS INTEGER)");
        db.execSQL("create table " + TABLE_NAME3 +" (BOOKINGID INTEGER PRIMARY KEY AUTOINCREMENT,MOVIE_ID INTEGER,TIMINGS TIME,THEATRES VARCHAR,EMAIL VARCHAR,PRICE INTEGER,SHOW_DATE DATE, PHONE  VARCHAR,SEATS_NO  VARCHAR,FOREIGN KEY(MOVIE_ID) REFERENCES Movies(MOVIE_ID))");
        db.execSQL("create table " + TABLE_NAME4 +" (USER_ID VARCHAR, NAME VARCHAR,EMAIL VARCHAR )");
        ContentValues content = new ContentValues();
        db.execSQL("insert into " + TABLE_NAME1 +" (NAME,INFORMATION, RATINGS)" + "VALUES" + "('Vụ cướp kỳ quái','Phim nói về một chàng trai bị kẹt giữa hai vụ cướp đồng thời tại một ngân hàng. Trong tình huống bất đắc dĩ anh phải làm người hùng ra tay bảo vệ các nhân viên của ngân hàng với người mà anh thầm yêu, và những tình huống hài hước bắt đầu....','5')");
        db.execSQL("insert into " + TABLE_NAME1 + " (NAME,INFORMATION,RATINGS)"+ "VALUES" + "('Mission: Impossible - Quốc gia bí ẩn','Mission Impossible 5: Rogue Nation - Nhiệm vụ bất khả thi 5: Quốc gia dối trá: là phần thứ 5 trong loạt phim hành động bom tấn về điệp viên nổi tiếng. Tài tử điển trai Tom Cruise quay lại với nhân vật biểu tượng Ethan Hunt, lần này sẽ phải thực hiện một nhiệm vụ siêu khó khăn: tiêu diệt cả một tổ chức lừa đảo xuyên quốc gia Syndicate – nơi tập hợp những sát thủ thông minh và nguy hiểm nhất. Mission Impossible 5 sẽ do đạo diễn Christopher McQuarrie, người từng hợp tác với Cruise trong Jack Reakcer, chỉ đạo. ','4')");
        db.execSQL("insert into " + TABLE_NAME1 + " (NAME,INFORMATION,RATINGS)"+ "VALUES"+ "('Avengers: Age of Ultron','Trong phần 2 này, khán giả chắc chắn sẽ bất ngờ khi chứng kiến Iron Man - Tony Stark (Robert Downey Jr.) sẽ trở thành “kẻ xấu”. Thực ra, vai phản diện thực sự của phim chính là một con robot mang tên Ultron do Tony chế tạo. Mệt mỏi vì công việc của một nhà sáng chế, doanh nhân và cả trách nhiệm của một siêu anh hùng, anh đã quyết định tạo ra Ultron để thay mình bảo vệ thế giới. Nhưng ý tưởng đã thất bại, Ultron trở nên mất kiểm soát và biến thành một cỗ máy sát nhân máu lạnh. Khi hòa bình lại bị đe dọa, đó cũng là lúc biệt đội Avengers phải trở lại và ra tay.... ','3')");
        db.execSQL("insert into " + TABLE_NAME1 + " (NAME,INFORMATION,RATINGS)"+ "VALUES"+ "('Người nhện siêu đẳng 2','Phần hai của Người Nhện là bom tấn dành riêng cho kỳ nghỉ lễ 30/4 và 1/5. Nối tiếp nội dung phần trước, Người Nhện phải cân bằng giữa trách nhiệm to lớn của siêu anh hùng bảo vệ New York và cuộc sống bình thường của một học sinh trung học. Sở hữu thân phận kép thú vị, với Peter Parker, không gì sánh bằng việc đu mình qua những toàn nhà chọc trời, được người dân ca ngợi, tin tưởng và dành thời gian bên bạn gái xinh đẹp: Gwen Stacy. \n" +
                "Với sự giúp đỡ của người bạn thân Harry Osborn, những bí ẩn về mối liên hệ giữa cha của Peter và tập đoàn Oscorp dần được hé lộ. Oscorp chính là nơi đã mang lại cho Peter sức mạnh siêu nhiên nhưng cũng khiến anh phải đối mặt với những thế lực vô cùng nguy hiểm: Electro, Rhino và Green Goblin. Đứng trước trận chiến lớn nhất từ trước tới nay, Peter nhận ra bài học sâu sắc khi trở thành một siêu anh hùng… ','4')");
       // db.execSQL("insert into " + TABLE_NAME4 + " (SEAT,THEATRE,TIMINGS,DATE_CURRENT, MOVIE_ID)" + "VALUES" + "('A1','AMC RIVER EAST 21',''11:55',)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME3);
        onCreate(db);
    }
    //Sushma Database part
    public boolean insertmoviebooked(int id, String Seats, String theatre, String time, String date, int price, String Email, String phone)
    {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("Movie_ID",id);
        content.put("TIMINGS",time);
        content.put("THEATRES",theatre);
        content.put("SHOW_DATE", date);
        content.put("PRICE", price);
        content.put("EMAIL",Email);
        content.put("PHONE",phone);
        content.put("SEATS_NO",Seats);
        long result = db.insert(TABLE_NAME3,null,content);
        if(result == -1) return false; else return true;
    }
    public boolean insertuser(String id,String name, String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("USER_ID",id);
        content.put("NAME", name);
        content.put("EMAIL", email);
        long result = db.insert(TABLE_NAME4, null, content);
        if (result == -1) return false;
        else return true;
    }
    //Seat Selection
    /*
    public boolean insertseatbooked(int id, String Seats, String theatre, String time, String date)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("Movie_ID",id);
        content.put("TIMINGS",time);
        content.put("THEATRES",theatre);
        content.put("DATE_CURRENT", date);
        content.put("SEATS", Seats);
        long result = db.insert(TABLE_NAME4,null,content);
        if(result == -1) return false; else return true;
    }*/
    /*
    public boolean insertdatamovie(String movie_name, String Details, String ratings, String User_review, boolean comingsoon, int seats_available )
    {
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NAME3);
        onCreate(db);

        ContentValues content = new ContentValues();
        content.put("NAME",movie_name);
        content.put("INFORMATION",Details);
        content.put("RATINGS",ratings);
        long result = db.insert(TABLE_NAME1,null,content);
        if(result == -1) return false; else return true;
    }
    */
    /*
    public boolean insertdatatimimgs(int MOVIE_ID,String Theatres, String Timings, int price)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("MOVIE_ID",MOVIE_ID);
        content.put("THEATRES",Theatres);
        content.put("TIMINGS",Timings);
        content.put("PRICE",price);
        long result = db.insert(TABLE_NAME2,null,content);
        if(result == -1) return false; else return true;
    }
*/
    //Max Booking ID
    public Cursor getmaxbooking(SQLiteDatabase db)
    {
        Cursor cursor;
        String sql = "Select max(BOOKINGID) from "  + TABLE_NAME3;
        cursor = db.rawQuery(sql,null);
        return cursor;
    }
    public Cursor getData(SQLiteDatabase db,String  Booking_ID)
    {
        Cursor cursor;
        String sql="SELECT t1.NAME,t2.THEATRES,t2.PRICE,t2.SHOW_DATE,t2.TIMINGS,t2.EMAIL,t2.PHONE,t2.SEATS_NO FROM Movies_Booked t2,Movies t1 WHERE  t1.MOVIE_ID=t2.MOVIE_ID AND t2.BOOKINGID=? ";

        cursor = db.rawQuery(sql,new String[]{Booking_ID});
        System.out.println(Booking_ID);

        return cursor;
    }
    //Suraj Part
    public Cursor getseats( SQLiteDatabase db, String Theatre, String date, String time, int movie_id)
    {
        Cursor cursor=null;
        System.out.print(Theatre + date + time + movie_id);
        String sql = "select SEATS_NO from " + TABLE_NAME3 + " where MOVIE_ID = ? and THEATRES = ? and TIMINGS = ? AND SHOW_DATE = ?";
            cursor = db.rawQuery(sql, new String[]{Integer.toString(movie_id), Theatre, time, date});
            Cursor md = getAllDataMovies();
            while(md.moveToNext())
            {
                System.out.print(md);
            }
            System.out.print(cursor);
            System.out.print(cursor.getCount());

        return cursor;

    }
    public Cursor getAllDataMovies()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String sql = "select * from " +TABLE_NAME1;
        Cursor res = db.rawQuery(sql,null);
        return res;

    }
    /*
    public Cursor getAllDataTimings()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select MovieName,Information,Rating from " + TABLE_NAME2,null);
        return res;

    }*/
    public Cursor getMoviename(SQLiteDatabase db, String movie_id)
    {
        Cursor cursor;
       String sql = "select NAME FROM "+ TABLE_NAME1+ " where MOVIE_ID = ?";
        cursor = db.rawQuery(sql, new String[]{movie_id});
        System.out.print(movie_id);
        return cursor ;
    }
    /*
    public Cursor getAllDataBooked()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select MovieName,Theatre,Timing from " + TABLE_NAME2,null);
        return res;

    }
*/
}

