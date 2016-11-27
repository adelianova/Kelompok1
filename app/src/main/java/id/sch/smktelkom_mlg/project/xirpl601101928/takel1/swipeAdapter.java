package id.sch.smktelkom_mlg.project.xirpl601101928.takel1;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by intel on 27/11/2016.
 */
public class swipeAdapter extends PagerAdapter {

    private int[] image_resourcer = {R.drawable.makanand, R.drawable.g2, R.drawable.g3};

    private Context ct;
    private LayoutInflater layoutInflater;


    public swipeAdapter(Context ct) {
        this.ct = ct;
    }

    @Override
    public int getCount() {
        return image_resourcer.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        layoutInflater = (LayoutInflater) ct.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.swipe, container, false);
        ImageView iv = (ImageView) item_view.findViewById(R.id.imageView);
        TextView tv = (TextView) item_view.findViewById(R.id.imagecount);
        iv.setImageResource(image_resourcer[position]);
        tv.setText("Image : " + position);
        container.addView(item_view);

        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
