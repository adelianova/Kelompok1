package id.sch.smktelkom_mlg.project.xirpl601101928.takel1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Lagu.Lagu;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Makann.Makanan;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Pakain.Pakaian;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Prov.Provinsi;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Wisata.Wisata;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.rumh.Rumah;

/**
 * Created by Mochammad Al_97 on 11/26/2016.
 */
public class Tentangkami extends AppCompatActivity {
    //Mendefinisikan variabel
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tentangkami);
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
                        Intent g = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(g);
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

        Intent a = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(a);
    }


}