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

    public ImoveisAdapter() {
        this(null,null);
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

        View newView = LayoutInflater.from(this.context).inflate(R.layout.adapter_imoveis, viewGroup, false);
        Imovel imovel = (Imovel) this.getItem(i);

        TextView txt_nome = newView.findViewById(R.id.txt_nome);
        TextView txt_endereco = newView.findViewById(R.id.txt_endereco);
        TextView txt_cidade = newView.findViewById(R.id.txt_cidade);
        TextView txt_telefone = newView.findViewById(R.id.txt_telefone);
        TextView txt_valor = newView.findViewById(R.id.txt_valor);

        txt_nome.setText(imovel.getNome());
        txt_endereco.setText(imovel.getEndereco());
        txt_cidade.setText(imovel.getCidade());
        txt_telefone.setText(imovel.getTelefone());
        txt_valor.setText(String.valueOf(imovel.getValor()));

        return newView;
    }
}
