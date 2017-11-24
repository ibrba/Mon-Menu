package sn.suite.apps.monmenu.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import sn.suite.apps.monmenu.R;
import sn.suite.apps.monmenu.adapters.BchaudesAdapter;
import sn.suite.apps.monmenu.datas.DatasUtils;
import sn.suite.apps.monmenu.datas.Produit;

/**
 * A simple {@link Fragment} subclass.
 */
public class BChaudesFragment extends Fragment {

    private ListView chaudeslisteview;

    public BChaudesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v =  inflater.inflate(R.layout.fragment_bchaudes, container, false);

        //Initializing listviews
        chaudeslisteview =(ListView) v.findViewById(R.id.bchaudeslistview);

        List<Produit> boissonsChaudes = DatasUtils.loadBoissonsChaudes();
        chaudeslisteview.setAdapter(new BchaudesAdapter(getActivity().getBaseContext(),boissonsChaudes));

        return v;
    }

}
