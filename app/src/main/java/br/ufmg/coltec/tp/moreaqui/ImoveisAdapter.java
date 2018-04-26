package br.ufmg.coltec.tp.moreaqui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

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

        // Recuperando os TextViews
        TextView nomeImovel = newView.findViewById(R.id.nome);
        TextView valorImovel = newView.findViewById(R.id.valor);
        TextView enderecoImovel = newView.findViewById(R.id.endereco);
        TextView cidadeImovel = newView.findViewById(R.id.cidade);
        TextView telefoneImovel = newView.findViewById(R.id.telefone);


        //TODO implementar mecanismo para estilizar elemento da lista
        nomeImovel.setText(imovel.getNome());
        valorImovel.setText("R$ " + imovel.getValor().toString());
        enderecoImovel.setText(imovel.getEndereco());
        cidadeImovel.setText(imovel.getCidade());
        telefoneImovel.setText(imovel.getTelefone());

        return newView;
    }
}
