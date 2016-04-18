package com.example.makpro.recipedesign1.Fragments;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
//import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.makpro.recipedesign1.R;
import com.example.makpro.recipedesign1.staticString;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MeatFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link MeatFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MeatFragment extends Fragment implements View.OnClickListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    View view;
    CheckBox chicken;
    CheckBox Pig;
    CheckBox turkey;
    CheckBox cow;
    CheckBox rabbit;
    CheckBox bear;
    Button apply;
    Button choose_all;
    Fragment fr;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public MeatFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MeatFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MeatFragment newInstance(String param1, String param2) {
        MeatFragment fragment = new MeatFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fr = this;
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_meat2,container, false);
        apply = (Button) view.findViewById(R.id.apply);
        chicken = (CheckBox) view.findViewById(R.id.CBchicken);
        Pig =(CheckBox) view.findViewById(R.id.CBpig);
        turkey =(CheckBox) view.findViewById(R.id.CBturkey);
        cow =(CheckBox) view.findViewById(R.id.CBcow);
        rabbit =(CheckBox) view.findViewById(R.id.CBrabbit);
        bear =(CheckBox) view.findViewById(R.id.CBbear);
        apply.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v)
           {
               if (chicken.isChecked()) {
                   staticString.str.remove("chicken");
                   staticString.str.add("chicken");
               }
               else
                   staticString.str.remove("chicken");

               if (Pig.isChecked()) {
                   staticString.str.remove("pig");
                   staticString.str.add("pig");
               }
               else
                   staticString.str.remove("pig");

               if (turkey.isChecked()) {
                   staticString.str.remove("turkey");
                   staticString.str.add("turkey");
               }
               else
                   staticString.str.remove("turkey");

               if (cow.isChecked()) {
                   staticString.str.remove("cow");
                   staticString.str.add("cow");
               }
               else
                   staticString.str.remove("cow");

               if (rabbit.isChecked()) {
                   staticString.str.remove("rabbit");
                   staticString.str.add("rabbit");
               }
               else
                   staticString.str.remove("rabbit");

               if (bear.isChecked()) {
                   staticString.str.remove("bear");
                   staticString.str.add("bear");
               }
               else
                   staticString.str.remove("bear");

               FragmentManager fm = getFragmentManager();
               fm.popBackStack();
               FragmentTransaction ft = fm.beginTransaction();
               ft.commit();
           }
        });
        choose_all = (Button) view.findViewById(R.id.choose_all);
        choose_all.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                
            }
        });
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    /**
     * Created by Давлат on 16.04.2016.
     */
    public static class DBHelper extends SQLiteOpenHelper {

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
                    +"Rec_Author_ID integer," + ");");

            //создаем таблицу !КУХНЯ!------------------
            db.execSQL("create table Cuisine("
                    + "Cuisine_ID integer primary key,"
                    + "Cuisine_name text," + ");");


            //создаем таблицу !ВИД БЛЮДА!---------------
            db.execSQL("create table Category("
                    + "Category_ID integer primary key,"
                    + "Category_name text," + ");");

            //создаем таблицу !СПОСОБ ПРИГТОВЛЕНИЯ!-----------
            db.execSQL("create table Cooking_method ("
                    + "Cooking_method_ID integer primary key,"
                    + "Method_name text," + ");");

            //создаем таблицу !СОСТАВ БЛЮДА!--------
            db.execSQL("create table Category ("
                    + "Comp_ID integer primary key,"
                    + "Comp_Ingredient_ID integer,"
                    + "Comp_recipe_ID integer,"
                    + "Comp_Unit_measure_ID integer,"
                    + "Quantity integer," + ");");

            //создаем таблицу !ВРЕМЯ!---------------
            db.execSQL("create table Time ("
                    +"Time_ID integer primary key,"
                    +"Time_name text," + ");");


            //создаем таблицу !ЕДИНИЦЫ ИЗМЕРЕНИЯ!----------
            db.execSQL("create table Unit_measure ("
                    +"Unit_measure_ID integer primary key,"
                    +"Unit_measure_name text," + ");");

            //создаем таблицу !ИНГРЕДИЕНТ!---------------
            db.execSQL("create table Ingredient ("
                    +"Ingredient_ID integer primary key,"
                    +"Ingredient_name text," + ");");

            //создаем таблицу !ОТЗЫВ!-------------------
            db.execSQL("create table Reference ("
                    +"Reference_ID integer primary key,"
                    +"Ref_Recipe_ID integer,"
                    +"Message text,"
                    +"Date datetime,"
                    + ");");

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
}
