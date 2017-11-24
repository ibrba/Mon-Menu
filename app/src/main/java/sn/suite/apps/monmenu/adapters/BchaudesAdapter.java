package sn.suite.apps.monmenu.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import sn.suite.apps.monmenu.R;
import sn.suite.apps.monmenu.datas.Produit;

/**
 * Created by Ninja barbu on 23/11/2017.
 */

public class BchaudesAdapter extends ArrayAdapter<Produit> {

    public BchaudesAdapter(Context ctx, List<Produit> produit){
        super(ctx,0,produit);
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.produit,parent, false);
        }
        ProduitViewHolder viewHolder = (ProduitViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new ProduitViewHolder();
            viewHolder.nom = (TextView) convertView.findViewById(R.id.nom_prod);
            viewHolder.prix = (TextView) convertView.findViewById(R.id.prix_prod);
            convertView.setTag(viewHolder);
        }

        Produit n=getItem(position);
        viewHolder.nom.setText(""+n.getNom());
        viewHolder.prix.setText(""+n.getPrix());

        return convertView;
    }


    private class ProduitViewHolder{
        TextView nom;
        TextView prix;
    }
}
