package sn.suite.apps.monmenu.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.github.ivbaranov.mfb.MaterialFavoriteButton;

import java.util.ArrayList;

import sn.suite.apps.monmenu.R;
import sn.suite.apps.monmenu.activities.DetailsRestoActivity;
import sn.suite.apps.monmenu.datas.Resto;

/**
 * Created by Ninja barbu on 22/11/2017.
 */

public class RestoAdapter extends  RecyclerView.Adapter<RestoAdapter.ViewHolder>{
    private ArrayList<Resto> restosList;
    private Context context;

    public RestoAdapter(Context context, ArrayList<Resto> restosList) {
        this.restosList = restosList;
        this.context = context;
    }

    @Override
    public RestoAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.resto_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final RestoAdapter.ViewHolder viewHolder, int i) {

        viewHolder.nomRestoTextView.setText(restosList.get(i).getNom());
        viewHolder.idResto =restosList.get(i).getID();
        viewHolder.restoImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.restoImageView.setImageResource((restosList.get(i).getImageID()));
        viewHolder.favoriteButton.setFavorite(restosList.get(i).isFavori());
        //Pour les corners de imageview
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            viewHolder.restoImageView.setClipToOutline(true);
        }

        viewHolder.restoImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,DetailsRestoActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                i.putExtra("idResto",viewHolder.idResto );

                context.startActivity(i);

            }
        });

    }

    @Override
    public int getItemCount() {
        return restosList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nomRestoTextView;
        private ImageView restoImageView;
        private MaterialFavoriteButton favoriteButton;
        private Integer idResto;
        public ViewHolder(View view) {
            super(view);

            nomRestoTextView = (TextView)view.findViewById(R.id.nom_resto);
            restoImageView = (ImageView) view.findViewById(R.id.img_resto);
            favoriteButton = (MaterialFavoriteButton) view.findViewById(R.id.favorite_button);

        }
    }

}
