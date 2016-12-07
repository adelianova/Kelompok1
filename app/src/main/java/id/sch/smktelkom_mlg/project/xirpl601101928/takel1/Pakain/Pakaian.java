package id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Pakain;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Lagu.Lagu;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.MainActivity;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Makann.Makanan;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Prov.Provinsi;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.R;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Tentangkami;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Wisata.Wisata;
import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.rumh.Rumah;

/**
 * Created by Mochammad Al_97 on 11/26/2016.
 */
public class Pakaian extends AppCompatActivity implements PakaianAdapter.IHotelAdapter {
    public static final String HOTEL = "hotel";
    public static final int REQUEST_CODE_ADD = 88;
    public static final int REQUEST_CODE_EDIT = 99;
    ArrayList<PakaianModel> mList = new ArrayList<>();
    PakaianAdapter mAdapter;
    int itemPos;
    ArrayList<PakaianModel> mListALL = new ArrayList<>();
    boolean isfiltered;
    ArrayList<Integer> mListMapFilter = new ArrayList<>();
    String mQuery;

    //Mendefinisikan variabel
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTitle("Pakaian Adat");
        setContentView(R.layout.pakaian);
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
                        Intent b = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(b);
                        return true;
                    case R.id.navigation8:
                        Intent h = new Intent(getApplicationContext(), Provinsi.class);
                        startActivity(h);
                        return true;
                    case R.id.navigation2:
                        Intent p = new Intent(getApplicationContext(), Pakaian.class);
                        startActivity(p);
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

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new PakaianAdapter(this, mList);
        recyclerView.setAdapter(mAdapter);

        fillData();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADD && resultCode == RESULT_OK) {
            PakaianModel hotel = (PakaianModel) data.getSerializableExtra(HOTEL);
            mList.add(hotel);
            mAdapter.notifyDataSetChanged();
            //mAdapter.notifyDataSetChanged();
        } else if (requestCode == REQUEST_CODE_EDIT && resultCode == RESULT_OK) {
            PakaianModel hotel = (PakaianModel) data.getSerializableExtra(HOTEL);
            mList.remove(itemPos);
            if (isfiltered) mListALL.remove(mListMapFilter.get(itemPos).intValue());
            mList.add(itemPos, hotel);
            if (isfiltered) mListALL.add(mListMapFilter.get(itemPos), hotel);
            mAdapter.notifyDataSetChanged();
        }
    }


    private void fillData() {
        Resources resources = getResources();
        String[] arJudul = resources.getStringArray(R.array.pakaian_judul);
        String[] arDescripsi = resources.getStringArray(R.array.pakaian_desk);
        String[] arDetail = resources.getStringArray(R.array.pakaian_detail);
        TypedArray a = resources.obtainTypedArray(R.array.pakaian_picture);
        String[] arFoto = new String[a.length()];
        for (int i = 0; i < arFoto.length; i++) {
            int id = a.getResourceId(i, 0);
            arFoto[i] = ContentResolver.SCHEME_ANDROID_RESOURCE + "://"
                    + resources.getResourcePackageName(id) + '/'
                    + resources.getResourceTypeName(id) + '/'
                    + resources.getResourceEntryName(id);
        }
        a.recycle();

        for (int i = 0; i < arJudul.length; i++) {
            mList.add(new PakaianModel(arJudul[i], arDescripsi[i],
                    arFoto[i], arDetail[i]));
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView)
                MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(
                new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String query) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String newText) {
                        mQuery = newText.toLowerCase();
                        doFilter(mQuery);
                        return true;
                    }
                }
        );
        return true;
    }

    private void doFilter(String mQuery) {
        if (!isfiltered) {
            mListALL.clear();
            mListALL.addAll(mList);
            isfiltered = true;
        }

        mList.clear();
        if (mQuery == null || mQuery.isEmpty()) {
            mList.addAll(mListALL);
            isfiltered = false;
        } else {
            mListMapFilter.clear();
            for (int i = 0; i < mListALL.size(); i++) {
                PakaianModel hotel = mListALL.get(i);
                if (hotel.judul.toLowerCase().contains(mQuery) ||
                        hotel.descripsi.toLowerCase().contains(mQuery)) {
                    mList.add(hotel);
                    mListMapFilter.add(i);
                }
            }
        }
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void doClick(int pos) {
        Intent intent = new Intent(this, id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Pakain.DetailActivity.class);
        intent.putExtra(HOTEL, mList.get(pos));
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        Intent a = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(a);

    }


}