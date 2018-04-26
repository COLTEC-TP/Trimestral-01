package br.ufmg.coltec.tp.moreaqui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
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

        //TODO implementar mecanismo para estilizar elemento da lista

        // recupera a view do adapter que será customizada
        View newView = LayoutInflater.from(this.context).inflate(R.layout.adapter_imoveis, viewGroup, false);

        TextView lblNomeImovel = newView.findViewById(R.id.lblNomeImovel);
        lblNomeImovel.setText(imovel.getNome() + " -- ");

        TextView lblEndereco = newView.findViewById(R.id.lblEndereco);
        lblEndereco.setText(imovel.getEndereco() + " -- ");

        TextView lblPreco = newView.findViewById(R.id.lblPreco);
        lblPreco.setText(imovel.getValor() + " -- " );

        TextView lblCidade = newView.findViewById(R.id.lblCidade);
        lblCidade.setText(imovel.getCidade() + " -- ");

        TextView lblTelefone = newView.findViewById(R.id.lblTelefone);
        lblTelefone.setText(imovel.getTelefone() + " -- ");

        return newView;
    }
}
