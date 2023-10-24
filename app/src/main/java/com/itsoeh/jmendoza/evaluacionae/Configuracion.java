package com.itsoeh.jmendoza.evaluacionae;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Configuracion#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Configuracion extends Fragment {

    private NavController navcontrol;
    private Button changeName, changePass, changeEmail, about, logout;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Configuracion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Configuracion.
     */
    // TODO: Rename and change types and number of parameters
    public static Configuracion newInstance(String param1, String param2) {
        Configuracion fragment = new Configuracion();
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
        return inflater.inflate(R.layout.fragment_configuracion, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        changeName = view.findViewById(R.id.config_name);
        changeName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicName();
            }
        });
        changeEmail =  view.findViewById(R.id.config_email);
        changeEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicEmail();
            }
        });
        changePass= view.findViewById(R.id.config_pass);
        changePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicPass();
            }
        });
        about = view.findViewById(R.id.config_about);
        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicAbout();
            }
        });
        logout = view.findViewById(R.id.config_logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clicLogout();
            }
        });
    }

    private void clicAbout() {
        Intent intent = new Intent(getActivity(), About.class);
        startActivity(intent);
    }

    private void clicPass() {
        Intent intent = new Intent(getActivity(), CambiarPassword.class);
        startActivity(intent);
    }

    private void clicName() {
        Intent intent = new Intent(getActivity(), CambiarNombre.class);
        startActivity(intent);
    }

    private void clicEmail() {
        Intent intent = new Intent(getActivity(), CambiarCorreo.class);
        startActivity(intent);
    }
    private void clicLogout() {
        Intent intent = new Intent(getActivity(), Login.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
        getActivity().finishAffinity(); // Cierra todas las otras actividades
    }

}
