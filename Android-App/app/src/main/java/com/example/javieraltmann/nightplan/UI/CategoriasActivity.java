package com.example.javieraltmann.nightplan.UI;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.SparseArray;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.javieraltmann.nightplan.Adapter.ParticipantesAdapter;
import com.example.javieraltmann.nightplan.Models.Usuario;
import com.example.javieraltmann.nightplan.R;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by javier.altmann on 28/11/2017.
 */

public class CategoriasActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
 {

     private SectionsPagerAdapter viewPagerAdapter;
     private ViewPager viewPager;
     private AppBarLayout appBarLayout;
     private TabLayout tabLayout;

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_categorias);
         Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
         setSupportActionBar(toolbar);

         DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
         ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                 this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
         drawer.addDrawerListener(toggle);
         toggle.syncState();

         NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
         navigationView.setNavigationItemSelectedListener(this);

         appBarLayout = (AppBarLayout) findViewById(R.id.appbar);
         tabLayout = (TabLayout) findViewById(R.id.tabs);
         viewPager = (ViewPager) findViewById(R.id.viewPager);

         setupViewPager();

     }

     @Override
     public boolean onNavigationItemSelected(MenuItem item) {
         // Handle navigation view item clicks here.
         int id = item.getItemId();

         if (id == R.id.nav_inicio) {
             Intent intent = new Intent(getBaseContext(), DestacadosActivity.class);
             this.startActivity(intent);
         } else if (id == R.id.nav_mis_grupos) {
             Intent intent = new Intent(getBaseContext(), GrupoActivity.class);
             this.startActivity(intent);
         } else if (id == R.id.nav_cuenta) {

         } else if (id == R.id.nav_cerrar_sesion) {
             Intent intent = new Intent(getBaseContext(), LoginActivity.class);
             this.startActivity(intent);
         }

         DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
         drawer.closeDrawer(GravityCompat.START);
         return true;
     }

     private void setupViewPager() {
         tabLayout.setupWithViewPager(viewPager);
         viewPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
         viewPagerAdapter.addFragment(new BarriosFragment(), "barrios");
         viewPagerAdapter.addFragment(new CaracteristicasFragment(), "caracteristicas");
         viewPagerAdapter.addFragment(new GastronomiaFragment(), "gastronomia");
         viewPager.setOffscreenPageLimit(3);
         viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
             @Override
             public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                 appBarLayout.setExpanded(true, true);
             }

             @Override
             public void onPageSelected(int position) {

             }

             @Override
             public void onPageScrollStateChanged(int state) {

             }
         });
         viewPager.setAdapter(viewPagerAdapter);
     }

     public class SectionsPagerAdapter extends FragmentPagerAdapter {
         private final List<Fragment> mFragments = new ArrayList<>();
         private final List<String> mFragmentTitles = new ArrayList<>();

         SparseArray<Fragment> registeredFragments = new SparseArray<>();

         public SectionsPagerAdapter(FragmentManager fm) {
             super(fm);
         }

         @Override
         public Fragment getItem(int position) {
             return mFragments.get(position);
//            }
         }

         @Override
         public int getCount() {
             return mFragments.size();
         }

         public void addFragment(Fragment fragment, String title) {
             mFragments.add(fragment);
             mFragmentTitles.add(title);
         }

         public String getTitle(int position) {
             return mFragmentTitles.get(position);
         }

         @Override
         public CharSequence getPageTitle(int position) {
             return mFragmentTitles.get(position);
         }

         @Override
         public Object instantiateItem(ViewGroup container, int position) {
             Fragment fragment = (Fragment) super.instantiateItem(container, position);
             registeredFragments.put(position, fragment);
             return fragment;
         }

         @Override
         public void destroyItem(ViewGroup container, int position, Object object) {
             super.destroyItem(container, position, object);
             registeredFragments.remove(position);
         }
     }
}
