package br.ufmg.coltec.tp.moreaqui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Adapter responsável por carregar os imóveis na lista
 */
public class ImoveisAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Imovel> imoveis;

    public ImoveisAdapter(Context context, ArrayList<Imovel> imoveis) {
        this.context = context;

        this.imoveis = imoveis;
    }

    @Override
    public int getCount() {
        return imoveis.size();
    }

    @Override
    public Object getItem(int i) {
        return imoveis.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Imovel imovel = (Imovel) this.getItem(i);

        // recupera a view do adapter que será customizada
        View newView = LayoutInflater.from(this.context).inflate(R.layout.adapter_imoveis,
                viewGroup, false);


        TextView lblName = newView.findViewById(R.id.identifier_tv);
        TextView lblAddress = newView.findViewById(R.id.address_tv);
        TextView lblCity = newView.findViewById(R.id.city_tv);
        TextView lblRentPrice = newView.findViewById(R.id.rent_price_tv);
        TextView lblTelephone = newView.findViewById(R.id.telephone_tv);

        lblName.setText(imovel.getNome());
        lblAddress.setText(imovel.getEndereco());
        lblCity.setText(imovel.getCidade());

        lblRentPrice.setText(String.valueOf(imovel.getValor()));
        lblTelephone.setText(imovel.getTelefone());

        return newView;
    }
}
