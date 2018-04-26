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

//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//        Imovel imovel = (Imovel) this.getItem(i);
//
//
//
//
//
//        //TODO implementar mecanismo para estilizar elemento da lista
//        TextView lblNomeImovel = new TextView(this.context);
//        lblNomeImovel.setText(imovel.getNome() + " -- " + imovel.getValor());
//
//        return lblNomeImovel;
//    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Imovel imovel = (Imovel) this.getItem(i);

        // recupera a view do adapter que será customizada
        View newView = LayoutInflater.from(this.context).inflate(R.layout.adapter_imoveis, viewGroup, false);

        // recupera cada um dos campos do item
        TextView Nome = newView.findViewById(R.id.Nome);
        TextView Endereco = newView.findViewById(R.id.Endereco);
        TextView Cidade = newView.findViewById(R.id.Cidade);
        TextView Valor = newView.findViewById(R.id.Valor);
        TextView Telefone = newView.findViewById(R.id.Telefone);

        // define o valor de cada um dos campos
        Nome.setText(imovel.getNome() + imovel.getValor());
        Endereco.setText(imovel.getEndereco() );
        Valor.setText(imovel.getValor().toString() + imovel.getValor());
        Telefone.setText(imovel.getTelefone().toString());
        Cidade.setText(imovel.getCidade().toString() + imovel.getValor());

        return newView;
    }

}
