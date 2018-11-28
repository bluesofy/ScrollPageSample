package cn.byk.pandora.sample.scrollpage;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Created by Byk on 2018/11/10.
 */
public class ContentFragment extends Fragment {

    private RecyclerView mRvContent;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_content, container, false);
        setView(view);
        setValue();
        return view;
    }

    private void setView(View view) {
        mRvContent = view.findViewById(R.id.rv_content);
    }

    private void setValue() {
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(i);
        }

        mRvContent.setLayoutManager(new GridLayoutManager(getActivity(), 4));
        mRvContent.setAdapter(new ContentAdapter(getActivity(), datas));
    }
}
