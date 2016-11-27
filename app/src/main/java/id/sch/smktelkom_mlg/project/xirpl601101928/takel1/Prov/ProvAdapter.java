package id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Prov;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.R;

/**
 * Created by Mochammad Al_97 on 11/24/2016.
 */
public class ProvAdapter extends RecyclerView.Adapter<ProvAdapter.ViewHolder> {
    ArrayList<ProvinsiModel> provList;

    public ProvAdapter(ArrayList<ProvinsiModel> provList) {
        this.provList = provList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_provinsi, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ProvinsiModel provinsi = provList.get(position);
        holder.tvJudul.setText(provinsi.judul);
        holder.tvDescripsi.setText(provinsi.descripsi);
        holder.ivFoto.setImageDrawable(provinsi.foto);
    }

    @Override
    public int getItemCount() {
        if (provList != null)
            return provList.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDescripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDescripsi = (TextView) itemView.findViewById(R.id.textViewDescripsi);
        }
    }
}
