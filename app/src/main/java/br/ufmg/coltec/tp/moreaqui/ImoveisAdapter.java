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
        Imovel currentImovel = this.imoveis.get(i);

        // recupera a view do adapter que será customizada
        View newView = LayoutInflater.from(this.context).inflate(R.layout.adapter_imoveis, viewGroup, false);

        // recupera cada um dos campos do item
        TextView lblNome = newView.findViewById(R.id.nome);
        TextView lblEndereco = newView.findViewById(R.id.endereco);
        TextView lblCidade = newView.findViewById(R.id.cidade);
        TextView lblValor = newView.findViewById(R.id.valor);
        TextView lblTelefone = newView.findViewById(R.id.telefone);

        // define o valor de cada um dos campos
        lblNome.setText(currentImovel.getNome());
        lblEndereco.setText(currentImovel.getEndereco());
        lblCidade.setText(currentImovel.getCidade());
        lblValor.setText(currentImovel.getValor().toString());
        lblTelefone.setText(currentImovel.getTelefone());

        return newView;
    }
}
