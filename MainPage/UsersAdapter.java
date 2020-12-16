package com.cookandroid.teamproject;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.CustomViewHolder> implements Filterable {

    private ArrayList<ProductData> mList = null;
    private Activity context = null;

    ArrayList<ProductData> filteredList = null;

    public UsersAdapter(Activity context, ArrayList<ProductData> list) {
        this.context = context;
        this.mList = list;

        this.filteredList = list;
    }


    class CustomViewHolder extends RecyclerView.ViewHolder {
        protected TextView name;
        protected TextView price;
        protected TextView store_loc;

        public CustomViewHolder(View view) {
            super(view);
            this.name = (TextView) view.findViewById(R.id.textView_list_name);
            this.price = (TextView) view.findViewById(R.id.textView_list_price);
            this.store_loc = (TextView) view.findViewById(R.id.textView_list_store_loc);
        }
    }


    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, null);
        CustomViewHolder viewHolder = new CustomViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder viewholder, int position) {
        viewholder.name.setText(filteredList.get(position).getMember_name());
        viewholder.price.setText(filteredList.get(position).getMember_price());
        viewholder.store_loc.setText(filteredList.get(position).getMember_store_loc());
    }

    @Override
    public int getItemCount() {
        return filteredList.size();
    }


    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if(charString.isEmpty()) {
                    filteredList = mList;
                } else {
                    ArrayList<ProductData> filteringList = new ArrayList<>();
                    for(ProductData product : mList) {
                        String name = product.getMember_name();
                        if(name.toLowerCase().contains(charString.toLowerCase())) {
                            filteringList.add(product);
                        }
                    }
                    filteredList = filteringList;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = filteredList;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                // RecyclerView Update
                filteredList = (ArrayList<ProductData>)results.values;
                notifyDataSetChanged();
            }
        };
    }
}
