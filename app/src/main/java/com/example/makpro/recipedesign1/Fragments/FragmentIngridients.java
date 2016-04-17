package com.example.makpro.recipedesign1.Fragments;

import android.app.FragmentTransaction;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
//import android.support.v4.app.Fragment;
import  android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.makpro.recipedesign1.R;
import com.example.makpro.recipedesign1.staticString;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

//import android.support.v7.app.AppCompatActivity;
//import android.support.v4.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentIngridients.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentIngridients#newInstance} factory method to
 * create an instance of this fragment.
 */

public class FragmentIngridients extends Fragment implements View.OnClickListener{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    Button meatB, veganB;
    View view;
    MeatFragment mF;
    vegetableFragment vF;
    TextView txt;
    FragmentTransaction fTrans;
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentIngridients() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentIngridients.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentIngridients newInstance(String param1, String param2) {
        FragmentIngridients fragment = new FragmentIngridients();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mF = new MeatFragment();
        vF = new vegetableFragment();
        staticString.str = new ArrayList<String>();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        String tmp = "";
        view = inflater.inflate(R.layout.fragment_fragment_ingridients, container, false);
        meatB = (Button) view.findViewById(R.id.meatButton);
        veganB = (Button) view.findViewById(R.id.vegetableButton);
        meatB.setOnClickListener(this);
        veganB.setOnClickListener(this);
        txt = (TextView) view.findViewById(R.id.textView2);
        txt.setText(tmp);
        for (int i=0; i<staticString.str.size(); i++) {
            if (i!=staticString.str.size()-1)
            tmp+=staticString.str.get(i)+" & ";
            else
                tmp+=staticString.str.get(i);
        }
        txt.setText(tmp);
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
        fTrans = getFragmentManager().beginTransaction();
        switch(v.getId()) {
            case R.id.meatButton:
                fTrans.replace(R.id.conteiner, mF);
                break;
            case R.id.vegetableButton:
                fTrans.replace(R.id.conteiner, vF);
                break;
        }
        fTrans.addToBackStack(null);
        fTrans.commit();
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
}
