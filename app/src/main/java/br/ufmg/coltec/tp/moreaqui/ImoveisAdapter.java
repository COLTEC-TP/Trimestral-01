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

        TextView identificação = newView.findViewById(R.id.adapter_identificacao);
        TextView endereco = newView.findViewById(R.id.adapter_endereco);
        TextView cidade = newView.findViewById(R.id.adapter_cidade);
        TextView aluguel = newView.findViewById(R.id.adapter_aluguel);
        TextView telefone = newView.findViewById(R.id.adapter_telefone);

        identificação.setText(imovel.getNome());
        endereco.setText(imovel.getEndereco());
        cidade.setText(imovel.getCidade());
        aluguel.setText(imovel.getValor().toString());
        telefone.setText(imovel.getTelefone());


        return newView;
    }
}
