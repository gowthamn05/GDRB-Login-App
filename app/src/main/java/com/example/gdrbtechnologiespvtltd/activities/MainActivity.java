package com.example.gdrbtechnologiespvtltd.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gdrbtechnologiespvtltd.R;
import com.example.gdrbtechnologiespvtltd.adapters.ItemListAdapter;
import com.example.gdrbtechnologiespvtltd.model.UserItemModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ImageView image_logout;
    private RecyclerView item_list_recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        toolbar = findViewById(R.id.app_bar);
        image_logout = findViewById(R.id.image_logout);
        item_list_recycler_view = findViewById(R.id.item_list_recycler_view);
        setRecyclerAdapter();
        image_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoginActivity();
            }
        });

    }

    private void setRecyclerAdapter() {
        List<UserItemModel> userItemModels = new ArrayList<>();
        userItemModels.add(new UserItemModel("671-812-785", "Turner Inc", "TI Logistics NVWH-01", "Logistics", "Approved", "OUT-EGAIS-001216-11-2023", "Handling", "Sczone Project", "Handling Between Two Projects within the SCZone", "November 6, 2023"));
        userItemModels.add(new UserItemModel("924-739-211", "Horpx Inc", "IT Logistics ABC-05", "IT Tech", "Pending", "NOT-AJDGI-836650-43-2024", "Warming", "ITZone Project", "Warming Between Two Apps within the Dual Zone", "October 10, 2023"));
        userItemModels.add(new UserItemModel("504-225-211", "GDRB Inc", "IT GDRB Logistics RDR-10", "IT GDRB Tech", "Rejected", "HTS-GDRB-908946-19-2024", "Processing", "Gaming Project", "Processing Between Five Modules with the NormalZone", "December 12, 2023"));
        userItemModels.add(new UserItemModel("111-010-109", "DOTO Inc", "CT Mobile CTA-09", "IT Tech Solutions", "Approved", "VAT-UIYEU-090374-66-2027", "Routing", "App Level Project", "Routing Behalf of One App with the Others", "January 15, 2024"));
        userItemModels.add(new UserItemModel("808-000-121", "BOTT Inc", "BT APP PVT-05", "MEMBER TECH", "Rejected", "GOT-SVHF-283886-00-2056", "Testing", "Computer Project", "Testing the Projects within the use of MainZone", "February 26, 2024"));

        ItemListAdapter imdQRCodeAdapter = new ItemListAdapter(userItemModels,MainActivity.this);
        item_list_recycler_view.setAdapter(imdQRCodeAdapter);

    }

    private void openLoginActivity() {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(MainActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
