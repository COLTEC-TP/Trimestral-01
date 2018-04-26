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
        View newView = LayoutInflater.from(this.context).inflate(R.layout.adapter_imoveis, viewGroup, false);

        TextView lblNome = newView.findViewById(R.id.lbl_name);
        TextView lblEndereco = newView.findViewById(R.id.lbl_address);
        TextView lblCidade = newView.findViewById(R.id.lbl_city);
        TextView lblValor = newView.findViewById(R.id.lbl_value);
        TextView lblTelefone = newView.findViewById(R.id.lbl_phone);

        lblNome.setText(imovel.getNome());
        lblEndereco.setText(imovel.getEndereco());
        lblCidade.setText(imovel.getCidade());
        lblValor.setText(imovel.getValor().toString());
        lblTelefone.setText(imovel.getTelefone());

        return newView;
    }
}
