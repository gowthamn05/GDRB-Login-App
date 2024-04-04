package com.example.gdrbtechnologiespvtltd.adapters;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.gdrbtechnologiespvtltd.R;
import com.example.gdrbtechnologiespvtltd.model.UserItemModel;
import java.util.List;

public class ItemListAdapter extends RecyclerView.Adapter {

    List<UserItemModel> userItemModels;
    Activity activity;

    public ItemListAdapter(List<UserItemModel> userItemModels, Activity activity) {
        this.userItemModels = userItemModels;
        this.activity = activity;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((MyViewHolder) holder).bind(userItemModels.get(position));
    }

    @Override
    public int getItemCount() {
        return userItemModels.size();
    }

    private static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView item_text_reg_number, item_text_investor, item_text_sczone, item_text_nature, item_text_status, item_text_form_no,
                item_text_form_procedure, item_text_process, item_text_declaration_procedure, item_text_created_date;
        public MyViewHolder(View view) {
            super(view);
            item_text_reg_number = view.findViewById(R.id.item_text_reg_number);
            item_text_investor = view.findViewById(R.id.item_text_investor);
            item_text_sczone = view.findViewById(R.id.item_text_sczone);
            item_text_nature = view.findViewById(R.id.item_text_nature);
            item_text_status = view.findViewById(R.id.item_text_status);
            item_text_form_no = view.findViewById(R.id.item_text_form_no);
            item_text_form_procedure = view.findViewById(R.id.item_text_form_procedure);
            item_text_process = view.findViewById(R.id.item_text_process);
            item_text_declaration_procedure = view.findViewById(R.id.item_text_declaration_procedure);
            item_text_created_date = view.findViewById(R.id.item_text_created_date);
        }

        @SuppressLint({"SetTextI18n", "ResourceAsColor"})
        public void bind(UserItemModel userItemModel) {
                item_text_reg_number.setText(userItemModel.getTaxRegistrationNumber());
                item_text_investor.setText(userItemModel.getInvestor());
                item_text_sczone.setText(userItemModel.getScZoneLicenseNo());
                item_text_nature.setText(userItemModel.getNatureOfBusiness());
                item_text_status.setText(userItemModel.getStatus());
                item_text_form_no.setText(userItemModel.getFormNumber());
                item_text_form_procedure.setText(userItemModel.getFormProcedure());
                item_text_process.setText(userItemModel.getProcess());
                item_text_declaration_procedure.setText(userItemModel.getDeclarationProcedure());
                item_text_created_date.setText(userItemModel.getCreatedDate());
                if (userItemModel.getStatus().equalsIgnoreCase("Approved")) {
                    item_text_status.setTextColor(Color.GREEN);
                } else if (userItemModel.getStatus().equalsIgnoreCase("Rejected")) {
                    item_text_status.setTextColor(Color.RED);
                } else if (userItemModel.getStatus().equalsIgnoreCase("Pending")) {
                    item_text_status.setTextColor(Color.MAGENTA);
                }
            }
        }
    }
