package com.jmarcosag.wizardworldapi.ui.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.jmarcosag.wizardworldapi.R;
import com.jmarcosag.wizardworldapi.controller.StaffActivity;
import com.jmarcosag.wizardworldapi.controller.adapters.StaffAdapter;
import com.jmarcosag.wizardworldapi.databinding.FragmentDashboardBinding;
import com.jmarcosag.wizardworldapi.model.dao.StaffDao;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        StaffDao staffDao = new StaffDao();

        binding = FragmentDashboardBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        ListView listView = (ListView) root.findViewById(R.id.staffListView);
        listView.setAdapter(new StaffAdapter(staffDao.getStaffList()));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity().getApplicationContext(), StaffActivity.class);

                intent.putExtra("staff_id", staffDao.getStaffList().get(i).getId());
                startActivity(intent);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}