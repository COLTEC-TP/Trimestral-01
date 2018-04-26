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
        TextView nome = newView.findViewById(R.id.lbl_imovel_nome);
        TextView end = newView.findViewById(R.id.lbl_imovel_end);
        TextView valor = newView.findViewById(R.id.lbl_imovel_valor);
        TextView cidade = newView.findViewById(R.id.lbl_imovel_cidade);
        TextView tel = newView.findViewById(R.id.lbl_imovel_tel);


        nome.setText(imovel.getNome());
        end.setText(imovel.getEndereco());
        valor.setText(imovel.getValor().toString());
        cidade.setText(imovel.getCidade());
        tel.setText(imovel.getTelefone());


        return newView;
    }
}
