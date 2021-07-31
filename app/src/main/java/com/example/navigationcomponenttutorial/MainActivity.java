package com.example.navigationcomponenttutorial;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    NavController navController;
    BottomNavigationView bottomNavigationView;
    AppBarConfiguration appBarConfiguration;
    NavigationView navView;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        bottomNavigationView = findViewById(R.id.bottom_nav);
        navView = findViewById(R.id.navView);
        drawerLayout = findViewById(R.id.drawer_layout);
    }

    @Override
    protected void onStart() {
        super.onStart();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        setSupportActionBar(toolbar);

        appBarConfiguration = new AppBarConfiguration
                .Builder(R.id.homeFragment, R.id.searchFragment, R.id.userFragment)
                .setOpenableLayout(drawerLayout)
                .build();
        NavigationUI.setupWithNavController(bottomNavigationView, navController);
        NavigationUI.setupWithNavController(navView, navController);
        NavigationUI.setupWithNavController(toolbar, navController, appBarConfiguration);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp() || super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.termsAndConditions) {
            NavDirections action = NavGraphDirections.actionGlobalTermsFragment();
            navController.navigate(action);
            return true;
        }

        return NavigationUI.onNavDestinationSelected(item, navController)
                || super.onOptionsItemSelected(item);
    }

}