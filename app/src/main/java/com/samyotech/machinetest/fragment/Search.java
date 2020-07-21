package com.samyotech.machinetest.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.samyotech.machinetest.R;
import com.samyotech.machinetest.adapter.Homeadaper;
import com.samyotech.machinetest.apicalling.APIClient;
import com.samyotech.machinetest.apicalling.APIInterface;
import com.samyotech.machinetest.model.Homemodel;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Search extends Fragment {
    RecyclerView recycle_search;
    ProgressBar progress_circularhome;
    Homeadaper homeadaper;
    String userid;
    List<Homemodel.RecentlyAddedProperty> dataList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        recycle_search = view.findViewById(R.id.recycle_search);
        progress_circularhome = view.findViewById(R.id.progress_circularhome);
        recycle_search.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycle_search.setLayoutManager(layoutManager);
        Intent intent = getActivity().getIntent();
        userid = intent.getStringExtra("userId");

        homedata();
        return view;
    }

    private void homedata()
    {
        //String Token = et_loginemail.getText().toString().trim();
        progress_circularhome.setVisibility(View.VISIBLE);
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);
        Call<Homemodel> callback = apiInterface.getHomedata(userid);
        callback.enqueue(new Callback<Homemodel>() {
            @Override
            public void onResponse(Call<Homemodel> call, Response<Homemodel> response) {
                progress_circularhome.setVisibility(View.GONE);
                if(response.code() == 200)
                {
                    Homemodel data = response.body();
                    int status = data.getStatus();
                    Log.d("status","---------"+status);
                    if(status == 1)
                    {
                        Homemodel.Data getdata = data.getData();
                        List<Homemodel.RecentlyAddedProperty> recentlyAddedProperty = getdata.getRecentlyAddedProperty();
                        for(Homemodel.RecentlyAddedProperty recent : recentlyAddedProperty)
                        {
                            String title = recent.getTitle();
                            String description = recent.getDescription();
                            String amount = recent.getAmount();
                            String type = recent.getType();
                            Log.d("ammount","----------"+type);
                            dataList.add(new Homemodel.RecentlyAddedProperty(title,description,amount,type));
                            List<Homemodel.RecentlyAddedProperty.ProImg> proImg = recent.getProImgs();
                            for(Homemodel.RecentlyAddedProperty.ProImg promdata : proImg )
                            {
                                String image = promdata.getImage();
                               // Toast.makeText(getContext(), ""+image, Toast.LENGTH_SHORT).show();


                            }


                        }
                        homeadaper = new Homeadaper(dataList);
                        recycle_search.setAdapter(homeadaper);

                    }
                    if(status == 0)
                    {
                        Toast.makeText(getContext(), ""+data.getMessage(), Toast.LENGTH_SHORT).show();
                    }


                }
                else
                {
                    progress_circularhome.setVisibility(View.GONE);
                    Toast.makeText(getContext(), "Something Went Wrong or Check Your Internet Connection", Toast.LENGTH_SHORT).show();


                }
            }

            @Override
            public void onFailure(Call<Homemodel> call, Throwable t) {
                progress_circularhome.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Something Went Wrong or Check Your Internet Connection", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
