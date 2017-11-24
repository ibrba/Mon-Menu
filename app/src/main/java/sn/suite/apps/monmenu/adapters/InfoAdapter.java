package sn.suite.apps.monmenu.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;

import sn.suite.apps.monmenu.R;
import sn.suite.apps.monmenu.activities.MapsActivity;
import sn.suite.apps.monmenu.datas.SiteResto;

/**
 * Created by Ninja barbu on 23/11/2017.
 */

public class InfoAdapter extends  RecyclerView.Adapter<InfoAdapter.ViewHolder>{
    private ArrayList<SiteResto> sitesList;
    private Context context;

    public InfoAdapter(Context context, ArrayList<SiteResto> sitesList) {
        this.sitesList = sitesList;
        this.context = context;
    }

    @Override
    public InfoAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.info_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(InfoAdapter.ViewHolder viewHolder, int i) {

        viewHolder.nomSiteTextView.setText(sitesList.get(i).getNom());
        viewHolder.adresseTextView.setText(sitesList.get(i).getAdress());
        viewHolder.telTextView.setText(sitesList.get(i).getTel());
        viewHolder.horaireTextView.setText(sitesList.get(i).getHoraire());

         viewHolder.mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, MapsActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return sitesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nomSiteTextView ;
        private TextView telTextView ;
        private TextView adresseTextView ;
        private ImageButton mapButton ;
        private ImageButton callButton ;
        private TextView horaireTextView ;
        public ViewHolder(View view) {
            super(view);

            nomSiteTextView = (TextView)view.findViewById(R.id.nomSite);
            telTextView = (TextView)view.findViewById(R.id.tel);
            adresseTextView = (TextView)view.findViewById(R.id.adresse);
            horaireTextView = (TextView)view.findViewById(R.id.horaire);
            mapButton= (ImageButton)view.findViewById(R.id.buttonMap);
            callButton = (ImageButton)view.findViewById(R.id.buttonCall);

        }
    }

}
