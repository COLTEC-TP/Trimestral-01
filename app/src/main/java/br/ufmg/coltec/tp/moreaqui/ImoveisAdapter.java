package br.ufmg.coltec.tp.moreaqui;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

class Adapter extends ArrayAdapter<Imovel> {

    public Adapter(Context context, ArrayList<Imovel> imoveis) {
        super(context, 0, imoveis);
    }



    @Override
    public View getView(final int position, View convertView, final ViewGroup parent) {
        final Imovel imovel = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.adapter_imoveis, parent, false);
        }

        TextView name = convertView.findViewById(R.id.lblNomeImovel);
        name.setText(imovel.getNome());

        TextView cidade = convertView.findViewById(R.id.lblCidade);
        cidade.setText(imovel.getCidade());

        TextView director = convertView.findViewById(R.id.lblEndereco);
        director.setText(imovel.getEndereco());

        TextView telefone = convertView.findViewById(R.id.lblTelefone);
        telefone.setText(imovel.getTelefone());

        TextView valor = convertView.findViewById(R.id.lblValor);
        valor.setText(String.valueOf( imovel.getValor() ));


        return convertView;
    }

}
