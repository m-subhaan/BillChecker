package com.nopalyer.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         FragmentManager fragmentManager= getSupportFragmentManager();
         FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
         Fragment fragment1=new MainFragment();
        fragmentTransaction.add(R.id.fragment_container,fragment1);
        fragmentTransaction.commit();

        drawerLayout = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.drawerOpen,R.string.drawerClose);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id =menuItem.getItemId();
Bundle bundle= new Bundle();
if(id==R.id.LESCO)
{
    bundle.putString("url","http://www.lesco.gov.pk/");
}
else
    if (id==R.id.FESCO)
    {
        bundle.putString("url","http://www.fesco.com.pk/");
    }
    else
    if (id==R.id.IESCO)
    {
        bundle.putString("url","http://210.56.23.106:888/iescobill");
    }
    else
    if (id==R.id.WASAl)
    {
        bundle.putString("url","https://wasa.punjab.gov.pk/billing");
    }
    else
    if (id==R.id.WASAf)
    {
        bundle.putString("url","http://wasafaisalabad.gop.pk/Home/Bill");
    }
    else
    if (id==R.id.GASl)
    {
        bundle.putString("url","https://www.sngpl.com.pk/web/");
    }
    else
    if (id==R.id.GASf)
    {
        bundle.putString("url","https://www.sngpl.com.pk/web/");
    }
else
{
    Toast.makeText(this,"No Internet Connection", Toast.LENGTH_LONG).show();
}
        Fragment fragment2= new WebViewFragment();
        Fragment fragment1=new MainFragment();
        FragmentManager fragmentManager= getSupportFragmentManager();
        fragment2.setArguments(bundle);
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment2,"tag").addToBackStack(null).commit();
DrawerLayout drawerLayout=(DrawerLayout) findViewById(R.id.drawer);
drawerLayout.closeDrawer(GravityCompat.START);
        return true;}

    @Override
    public void onBackPressed() {

        DrawerLayout drawer=findViewById(R.id.drawer);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else
            super.onBackPressed();

    }


}
