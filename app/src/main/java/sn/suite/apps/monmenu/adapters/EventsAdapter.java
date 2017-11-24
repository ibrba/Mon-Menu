package sn.suite.apps.monmenu.adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.ivbaranov.mfb.MaterialFavoriteButton;

import java.util.ArrayList;

import sn.suite.apps.monmenu.R;
import sn.suite.apps.monmenu.activities.DetailsRestoActivity;
import sn.suite.apps.monmenu.datas.Evenement;
import sn.suite.apps.monmenu.datas.Resto;

/**
 * Created by Ninja barbu on 22/11/2017.
 */

public class EventsAdapter extends  RecyclerView.Adapter<EventsAdapter.ViewHolder>{
    private ArrayList<Evenement> eventsList;
    private Context context;

    public EventsAdapter(Context context, ArrayList<Evenement> eventsList) {
        this.eventsList = eventsList;
        this.context = context;
    }

    @Override
    public EventsAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.event_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventsAdapter.ViewHolder viewHolder, int i) {

        viewHolder.dateTextView.setText(eventsList.get(i).getDate());
        viewHolder.descriptTextView.setText(eventsList.get(i).getDescript());
        viewHolder.restoImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.restoImageView.setImageResource((eventsList.get(i).getImageID()));
        //Pour les corners de imageview
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            viewHolder.restoImageView.setClipToOutline(true);
        }

    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView dateTextView;
        private TextView descriptTextView;
        private ImageView restoImageView;
        private Button reserverButton;
        public ViewHolder(View view) {
            super(view);

            dateTextView = (TextView)view.findViewById(R.id.dateEvent);
            descriptTextView = (TextView)view.findViewById(R.id.descEvent);
            restoImageView = (ImageView) view.findViewById(R.id.img_event);
            reserverButton = (Button) view.findViewById(R.id.reserver);

        }
    }

}
