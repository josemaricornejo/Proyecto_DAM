package com.example.fooderful.ui.list.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.fooderful.R;
import com.example.fooderful.adapters.AdapterAlimentos;
import com.example.fooderful.ui.list.ListMvpPresenter;
import com.example.fooderful.ui.list.ListMvpView;
import com.example.fooderful.ui.list.ListPresenter;
import com.example.fooderful.ui.login.LoginMvpPresenter;
import com.example.fooderful.utils.Alimento;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TodosFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TodosFragment extends Fragment implements ListMvpView {

    RecyclerView recyclerAlimentos;
    ArrayList<Alimento> listaAlimentos;
    private ListMvpPresenter presenter;
    Context context;

    RequestQueue requestQueue;



    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TodosFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TodosFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TodosFragment newInstance(String param1, String param2) {
        TodosFragment fragment = new TodosFragment();
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
        View vista = inflater.inflate(R.layout.fragment_todos, container, false);

        presenter = new ListPresenter(this);
        context=getContext();
        presenter.buscarTodosAlimentos(context);

        recyclerAlimentos = vista.findViewById(R.id.recyclerTodos);
        recyclerAlimentos.setLayoutManager(new LinearLayoutManager(getContext()));

        return vista;
    }


    @Override
    public void llenarListaAlimentos(ArrayList<Alimento> listaAlimentos) {

        this.listaAlimentos=listaAlimentos;

        AdapterAlimentos adapter = new AdapterAlimentos(listaAlimentos);
        recyclerAlimentos.setAdapter(adapter);

    }

}