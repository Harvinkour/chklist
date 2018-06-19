package com.example.dell.checklist_app.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.dell.checklist_app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import fragment.Checklist_Fragment;
import fragment.Dashboard;
import fragment.List_Fragment;
import fragment.User_Details;
import fragment.View_Checklist;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

 @BindView(R.id.menu_icon)
    ImageView menu_icon;
    @BindView(R.id.drawer_layout)
    DrawerLayout drawer;
  /*  @BindView(R.id.wlcm_text)
    AppCompatTextView wlcm_text;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
           toolbar.setOverflowIcon(ContextCompat.getDrawable(getApplicationContext(),R.drawable.overflow));
        setSupportActionBar(toolbar);
        setActionBar();
        Dashboard dash = new Dashboard();
        changeFragment(dash);
        ButterKnife.bind(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(false);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

      //  wlcm_text.setSelected(true);
    }
    private void setActionBar() {
        //  getSupportActionBar().hide();
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue));
        }
    }

  /*  @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
            finish();
        } else
            super.onBackPressed();
    }

*/
    private void changeFragment(android.support.v4.app.Fragment fragment) {
        if (fragment instanceof Dashboard) {
            getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            android.support.v4.app.FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.content_frame, fragment, "HELLO");
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
    }



   @OnClick(R.id.menu_icon)
    public void onButtonClick(View view) {
        Click(view);
    }
    private void Click(View view){
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                drawer.openDrawer(GravityCompat.START);
            }
    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
*/
    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        displaySelectedScreen(item.getItemId());
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void displaySelectedScreen(int itemId) {
        View v;
        switch (itemId) {
            case R.id.nav_dashboard:
                Dashboard homeDashboard_fragment = new Dashboard();
                changeFragment(homeDashboard_fragment);
                break;
            case R.id.nav_daily:
                List_Fragment checklist = new List_Fragment();
                changeFragment(checklist);
                break;
            case R.id.nav_weekly:
                List_Fragment view_checklist = new List_Fragment();
                changeFragment(view_checklist);
                break;
            case R.id.nav_monhtly:
                List_Fragment user_details = new List_Fragment();
                changeFragment(user_details);
                break;

            case R.id.nav_pending:
                List_Fragment view_checklist1 = new List_Fragment();
                changeFragment(view_checklist1);
                break;
            case R.id.nav_missed:
                List_Fragment user_details1 = new List_Fragment();
                changeFragment(user_details1);
                break;
              /*case R.id.nav_user:
                User_Details ur_details = new User_Details();
                changeFragment(ur_details);
                break;*/



            case R.id.nav_logout:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Are you sure you want to logout?");

                builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        Intent logoutIntent = new Intent(MainActivity.this, Login_Activity.class);
                        logoutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(logoutIntent);
                        finish();
                    }
                });
                builder.setNegativeButton("NO",new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                builder.setCancelable(false);
                builder.create().show();


                break;

            default:

                break;
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    @Override
    public void onBackPressed() {
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure you want to exit?");

        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Intent logoutIntent = new Intent( MainActivity.this,Login_Activity.class);
                logoutIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(logoutIntent);
                finish();
            }
        });
        builder.setNegativeButton("NO",new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.setCancelable(false);
        builder.create().show();
    }

}
