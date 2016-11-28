package id.sch.smktelkom_mlg.project.xirpl601101928.takel1.Wisata;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.project.xirpl601101928.takel1.R;

/**
 * Created by Smktelkom on 11/28/2016.
 */
public class WisataAdapter extends RecyclerView.Adapter<WisataAdapter.ViewHolder> {
    IHotelAdapter mIHotelAdapter;
    ArrayList<WisataModel> hotelList;

    public WisataAdapter(Context context, ArrayList<WisataModel> hotelList) {
        this.hotelList = hotelList;
        mIHotelAdapter = (IHotelAdapter) context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_wisata, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        WisataModel hotel = hotelList.get(position);
        holder.tvJudul.setText(hotel.judul);
        holder.tvDescripsi.setText(hotel.descripsi);
        holder.ivFoto.setImageURI(Uri.parse(hotel.foto));
    }

    @Override
    public int getItemCount() {
        if (hotelList != null) return hotelList.size();
        return 0;
    }

    public interface IHotelAdapter {
        void doClick(int pos);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDescripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageView);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJudul);
            tvDescripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mIHotelAdapter.doClick(getAdapterPosition());
                }
            });
        }
    }
}