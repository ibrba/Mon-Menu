package sn.suite.apps.monmenu.adapters;

import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import sn.suite.apps.monmenu.R;
import sn.suite.apps.monmenu.datas.Evenement;
import sn.suite.apps.monmenu.datas.Resto;

/**
 * Created by Ninja barbu on 22/11/2017.
 */

public class AnnuaireAdapter extends  RecyclerView.Adapter<AnnuaireAdapter.ViewHolder>{
    private ArrayList<Resto> annuaireList;
    private Context context;

    public AnnuaireAdapter(Context context, ArrayList<Resto> annuaireList) {
        this.annuaireList = annuaireList;
        this.context = context;
    }

    @Override
    public AnnuaireAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.contact_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(AnnuaireAdapter.ViewHolder viewHolder, int i) {

        viewHolder.nomTextView.setText(annuaireList.get(i).getNom());
        viewHolder.adresseTextView.setText(annuaireList.get(i).getAdresse());
        viewHolder.logoImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        viewHolder.logoImageView.setImageResource((annuaireList.get(i).getImageID()));
        //Pour les corners de imageview
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            viewHolder.logoImageView.setClipToOutline(true);
        }

    }

    @Override
    public int getItemCount() {
        return annuaireList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView nomTextView;
        private TextView adresseTextView;
        private ImageView logoImageView;
        private ImageButton appelButton;
        public ViewHolder(View view) {
            super(view);

            nomTextView = (TextView)view.findViewById(R.id.nom);
            adresseTextView = (TextView)view.findViewById(R.id.adresse);
            logoImageView = (ImageView) view.findViewById(R.id.logo);
            appelButton = (ImageButton) view.findViewById(R.id.appeler);

        }
    }

}
