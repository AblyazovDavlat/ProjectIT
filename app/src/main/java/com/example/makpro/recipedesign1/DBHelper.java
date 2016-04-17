package com.example.makpro.recipedesign1;

/**
 * Created by Давлат on 17.04.2016.
 */
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Давлат on 16.04.2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    //для работы с ресурсами
    private final Context fContext;
    ContentValues contentValues;
    Resources res;

    public DBHelper(Context context) {
        super(context, "CookDB", null, 1);
        fContext = context;
    }

    public void onCreate(SQLiteDatabase db) {

        contentValues = new ContentValues();
        res = fContext.getResources();

        //СОЗДАНИЕ ТАБЛИЦ БАЗЫ ДАННЫХ----------------------------------------------------------

        //создаем таблицу !РЕЦЕПТЫ!---------------
        db.execSQL("create table Recipe ("
                +"Recipe_ID integer primary key,"
                +"Rec_Cuisine_ID integer,"
                +"Rec_Category_ID integer,"
                +"Rec_Cooking_method_ID integer,"
                +"Description_cooking_method text,"
                +"Recipe_name text,"
                +"Caloric_content text,"
                +"Rec_Author_ID integer" + ");");

        //создаем таблицу !КУХНЯ!------------------
        db.execSQL("create table Cuisine("
                + "Cuisine_ID integer primary key,"
                + "Cuisine_name text" + ");");


        //создаем таблицу !ВИД БЛЮДА!---------------
        db.execSQL("create table Category("
                + "Category_ID integer primary key,"
                + "Category_name text" + ");");

        //создаем таблицу !СПОСОБ ПРИГТОВЛЕНИЯ!-----------
        db.execSQL("create table Cooking_method ("
                + "Cooking_method_ID integer primary key,"
                + "Method_name text" + ");");

        //создаем таблицу !СОСТАВ БЛЮДА!--------
        db.execSQL("create table Composition ("
                + "Comp_ID integer primary key,"
                + "Comp_Ingredient_ID integer,"
                + "Comp_recipe_ID integer,"
                + "Comp_Unit_measure_ID integer,"
                + "Quantity integer" + ");");

        //создаем таблицу !ВРЕМЯ!---------------
        db.execSQL("create table Time ("
                +"Time_ID integer primary key,"
                +"Time_name text" + ");");


        //создаем таблицу !ЕДИНИЦЫ ИЗМЕРЕНИЯ!----------
        db.execSQL("create table Unit_measure ("
                +"Unit_measure_ID integer primary key,"
                +"Unit_measure_name text" + ");");

        //создаем таблицу !ИНГРЕДИЕНТ!---------------
        db.execSQL("create table Ingredient ("
                +"Ingredient_ID integer primary key,"
                +"Ingredient_name text" + ");");

        //создаем таблицу !ОТЗЫВ!-------------------
        db.execSQL("create table Reference ("
                +"Reference_ID integer primary key,"
                +"Ref_Recipe_ID integer,"
                +"Message text,"
                +"Date datetime" + ");");

        //ЗАПОЛНЕНИЕ ТАБЛИЦ ИЗ РЕСУРСОВ------------------------------------------------------------

        //заполнение таблицы !КУХНЯ!

        String[] cuisine_name = res.getStringArray(R.array.Cuisine_name);
        int[] cuisine_id = res.getIntArray(R.array.Cuisine_id);

        for (int i=0; i<cuisine_id.length;i++){
            contentValues.clear();
            contentValues.put("Cuisine_ID",cuisine_id[i]);
            contentValues.put("Cuisine_name",cuisine_name[i]);
            db.insert("Cuisine",null,contentValues);
        }

        //заполнение таблицы !ВИД БЛЮДА!

        String[] category_name = res.getStringArray(R.array.Category_name);
        int[] category_id = res.getIntArray(R.array.Category_id);

        for (int i=0; i<category_id.length;i++){
            contentValues.clear();
            contentValues.put("Category_ID",category_id[i]);
            contentValues.put("Category_name",category_name[i]);
            db.insert("Category",null,contentValues);
        }

        //заполнение таблицы !СПОСОБ ПРИГТОВЛЕНИ!

        String[] method_name = res.getStringArray(R.array.Method_name);
        int[]  cooking_method_id = res.getIntArray(R.array.Cooking_method_ID);

        for (int i=0; i<cooking_method_id.length;i++){
            contentValues.clear();
            contentValues.put("Cooking_method_ID",cooking_method_id[i]);
            contentValues.put("Method_name",method_name[i]);
            db.insert("Cooking_method",null,contentValues);
        }








    }

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
