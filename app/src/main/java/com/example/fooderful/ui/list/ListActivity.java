package com.example.fooderful.ui.list;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.fooderful.R;
import com.example.fooderful.utils.Alimento;
import com.example.fooderful.utils.PagerController;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity implements ListMvpView{
    TabLayout tabLayout;
    ViewPager viewPager;
    TabItem tabTodos, tabFrigo, tabDespensa;

    PagerController pagerAdapter;

    //--------------------
    ListMvpPresenter presenter;
    Context context;
    RecyclerView recyclerAlimentos;
    ArrayList<Alimento> listaAlimentos;

    FragmentTransaction transaction;
    Fragment fragmentBusqueda;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        tabLayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        tabTodos = findViewById(R.id.tabTodos);
        tabFrigo = findViewById(R.id.tabFrigo);
        tabDespensa = findViewById(R.id.tabDespensa);

        pagerAdapter = new PagerController(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
                if(tab.getPosition()==0){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==1){
                    pagerAdapter.notifyDataSetChanged();
                }
                if(tab.getPosition()==2){
                    pagerAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        //----------------------------
        presenter = new ListPresenter(this);
        context=this;

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu,menu);

        MenuItem menuItem = menu.findItem(R.id.busqueda);
        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setQueryHint("Buscar alimento");

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {

                presenter.buscarAlimento(context, query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {



                return false;
            }
        });


        return super.onCreateOptionsMenu(menu);
    }




    @Override
    public void llenarListaAlimentos(ArrayList<Alimento> listaAlimentos) {

    }


}