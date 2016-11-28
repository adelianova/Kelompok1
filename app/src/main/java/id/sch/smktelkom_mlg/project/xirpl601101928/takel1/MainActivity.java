package id.sch.smktelkom_mlg.project.xirpl601101928.takel1;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Makann.Makanan;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Pakain.Pakaian;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Prov.Provinsi;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Wisata.Wisata;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.rumh.Rumah;

public class MainActivity extends AppCompatActivity {
    public static final int REQUEST_CODE = 123;
    ViewPager viewPager;
    swipeAdapter adapter;
    //Mendefinisikan variabel
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        adapter = new swipeAdapter(this);

        viewPager.setAdapter(adapter);

        findViewById(R.id.imageBaju).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, Pakaian.class), REQUEST_CODE);
            }
        });
        findViewById(R.id.imageMakan).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, Makanan.class), REQUEST_CODE);
            }
        });
        findViewById(R.id.imageLagu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, Lagu.class), REQUEST_CODE);
            }
        });
        findViewById(R.id.imageWisata).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, Wisata.class), REQUEST_CODE);
            }
        });
        findViewById(R.id.imageRumah).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, Rumah.class), REQUEST_CODE);
            }
        });
        // Menginisiasi Toolbar dan mensetting sebagai actionbar
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Menginisiasi  NavigationView
        navigationView = (NavigationView) findViewById(R.id.navigation_view);
        //Mengatur Navigasi View Item yang akan dipanggil untuk menangani item klik menu navigasi
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            // This method will trigger on item Click of navigation menu
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                //Memeriksa apakah item tersebut dalam keadaan dicek  atau tidak,
                if (menuItem.isChecked()) menuItem.setChecked(false);
                else menuItem.setChecked(true);
                //Menutup  drawer item klik
                drawerLayout.closeDrawers();
                //Memeriksa untuk melihat item yang akan dilklik dan melalukan aksi
                switch (menuItem.getItemId()) {
                    // pilihan menu item navigasi akan menampilkan pesan toast klik kalian bisa menggantinya
                    //dengan intent activity
                    case R.id.navigation1:
                        return true;
                    case R.id.navigation8:
                        Intent h = new Intent(getApplicationContext(), Provinsi.class);
                        startActivity(h);
                        return true;
                    case R.id.navigation2:
                        Intent b = new Intent(getApplicationContext(), Pakaian.class);
                        startActivity(b);
                        return true;
                    case R.id.navigation3:
                        Intent c = new Intent(getApplicationContext(), Lagu.class);
                        startActivity(c);
                        return true;
                    case R.id.navigation4:
                        Intent d = new Intent(getApplicationContext(), Rumah.class);
                        startActivity(d);
                        return true;
                    case R.id.navigation5:
                        Intent e = new Intent(getApplicationContext(), Makanan.class);
                        startActivity(e);
                        return true;
                    case R.id.navigation6:
                        Intent f = new Intent(getApplicationContext(), Wisata.class);
                        startActivity(f);
                        return true;
                    case R.id.navigation7:
                        Intent g = new Intent(getApplicationContext(), Tentangkami.class);
                        startActivity(g);
                        return true;
                    default:
                        Toast.makeText(getApplicationContext(), "Kesalahan Terjadi ", Toast.LENGTH_SHORT).show();
                        return true;
                }
            }
        });
        // Menginisasi Drawer Layout dan ActionBarToggle
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                // Kode di sini akan merespons setelah drawer menutup disini kita biarkan kosong
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                //  Kode di sini akan merespons setelah drawer terbuka disini kita biarkan kosong
                super.onDrawerOpened(drawerView);
            }
        };
        //Mensetting actionbarToggle untuk drawer layout
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        //memanggil synstate
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {


        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //pesan keluar
        finish();
        moveTaskToBack(true);
        System.exit(0);
    }

}
