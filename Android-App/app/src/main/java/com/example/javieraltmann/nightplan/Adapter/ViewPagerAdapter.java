package com.example.javieraltmann.nightplan.Adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.javieraltmann.nightplan.Models.Recomendados;
import com.example.javieraltmann.nightplan.R;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

/**
 * Created by javier.altmann on 29/11/2017.
 */

public class ViewPagerAdapter extends PagerAdapter {

    private Context context;
    private List<Recomendados> recomendadosList;

    // private Integer [] images = {R.drawable.antares,R.drawable.heisenburguer,R.drawable.jobs};

    public ViewPagerAdapter(Context context, List<Recomendados> recomendadosList) {
        this.context = context;
        this.recomendadosList = recomendadosList;
    }

    @Override
    public int getCount() {
        return recomendadosList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

     //   layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
     //   View view = layoutInflater.inflate(R.layout.custom_layout,container,false);
        View view = LayoutInflater.from(context).inflate(R.layout.custom_layout, container, false);


        SimpleDraweeView draweeView = (SimpleDraweeView) view.findViewById(R.id.imageView);
        Recomendados recomendados = recomendadosList.get(position);
        Uri uri = Uri.parse(recomendados.getImagen());
        draweeView.setImageURI(uri);



        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(position == 0){
                    Toast.makeText(context, "Slide 1 Clicked", Toast.LENGTH_SHORT).show();
                    //Hacer logica para que guarde el voto
                } else if(position == 1){
                    Toast.makeText(context, "Slide 2 Clicked", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(context, "Slide 3 Clicked", Toast.LENGTH_SHORT).show();
                }

            }
        });

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }


}

