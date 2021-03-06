package com.example.bc_campus_deliver.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.bc_campus_deliver.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private LinearLayout helpget1;
    private LinearLayout helpget2;
    private LinearLayout helpbuy1;
    private LinearLayout helpbuy2;
    private ImageView img1;
    private HelpbuyFragment helpbuyFragment = new HelpbuyFragment();
    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment homeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();

        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        helpbuy1 = view.findViewById(R.id.helpBuy1);
        helpbuy2 = view.findViewById(R.id.helpBuy2);
        helpget1 = view.findViewById(R.id.helpGet1);
        helpget2 = view.findViewById(R.id.helpGet2);
        img1 = view.findViewById(R.id.pic1);
        FragmentManager fragmentManager = getParentFragmentManager();

        helpbuy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            fragmentManager.beginTransaction()
                    .replace(R.id.fvc,helpbuyFragment,null)
                    .addToBackStack(null).commit();
            }
        });

        helpbuy2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fvc,helpbuyFragment,null)
                        .addToBackStack(null).commit();
            }
        });

        helpget1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fvc,helpbuyFragment,null)
                        .addToBackStack(null).commit();
            }
        });

        helpget2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.beginTransaction()
                        .replace(R.id.fvc,helpbuyFragment,null)
                        .addToBackStack(null).commit();
            }
        });

    }
}