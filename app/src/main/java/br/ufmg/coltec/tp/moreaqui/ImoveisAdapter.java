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

        View newView = LayoutInflater.from(this.context).inflate(R.layout.adapter_imoveis,viewGroup, false);

        //TODO implementar mecanismo para estilizar elemento da lista
        TextView lblNomeImovel = new TextView(this.context);
        TextView lblNome = newView.findViewById(R.id.lbl_imovel_name);
        TextView lblEndereço = newView.findViewById(R.id.lbl_imovel_endereço);
        TextView lblCidade = newView.findViewById(R.id.lbl_imovel_cidade);
        TextView lblValor = newView.findViewById(R.id.lbl_imovel_valor);
        TextView lblTelefone = newView.findViewById(R.id.lbl_imovel_telefone);

        lblNomeImovel.setText(imovel.getNome() + " -- " + imovel.getValor());
        lblNome.setText(imovel.getNome());
        lblEndereço.setText(imovel.getEndereco());
        lblCidade.setText(imovel.getCidade());
        lblValor.setText(imovel.getValor().toString());
        lblTelefone.setText(imovel.getTelefone().toString());
        return newView;
    }
}
