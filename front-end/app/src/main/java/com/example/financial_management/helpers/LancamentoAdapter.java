package com.example.financial_management.helpers;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financial_management.R;
import com.example.financial_management.dto.Lancamento;

import java.util.List;

public class LancamentoAdapter extends RecyclerView.Adapter<LancamentoAdapter.LancamentoHolder> {
    private LayoutInflater mInflater;
    private Context context;
    private List<Lancamento> lista;

    public LancamentoAdapter(Context context, List<Lancamento> lista) {
        this.context = context;
        this.lista = lista;
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public LancamentoAdapter.LancamentoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.item_historico_layout, parent, false);
        return new LancamentoHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull LancamentoAdapter.LancamentoHolder holder, int position) {
        holder.contador.setText(String.valueOf(position + 1));
        holder.descricao.setText(lista.get(position).getDescricao());
        holder.data.setText(lista.get(position).getData().toString());
        holder.valor.setText(lista.get(position).getValor().toString());
        //Double val = Double.parseDouble(holder.valor.getText().toString());
        int cor = lista.get(position).getTipo().toString().equals("C") ? Color.parseColor("#F8F5F5") : Color.parseColor("#F8E2A1");
        holder.itemView.setBackgroundColor(cor);
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class LancamentoHolder extends RecyclerView.ViewHolder {
        final LancamentoAdapter lancamentoAdapter;
        public final TextView contador;
        public final TextView descricao;
        public final TextView data;
        public final TextView valor;
        public final TextView tipo;

        public LancamentoHolder(@NonNull View itemView, LancamentoAdapter lancamentoAdapter) {
            super(itemView);
            this.lancamentoAdapter = lancamentoAdapter;

            contador = itemView.findViewById(R.id.tv_codigo);
            descricao = itemView.findViewById(R.id.tv_descricao);
            data = itemView.findViewById(R.id.tv_data);
            valor = itemView.findViewById(R.id.tv_valor);
            tipo = itemView.findViewById(R.id.tv_creddebi);
            //itemView.setBackgroundResource(Double.parseDouble(valor.getText().toString()) > 0 ? R.color.lentrada : R.color.lsaida);
        }
    }

}
