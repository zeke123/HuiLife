package com.minghuilianmeng.huilife.activity;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.minghuilianmeng.huilife.R;
import com.minghuilianmeng.huilife.adapter.CityAdapter;
import com.minghuilianmeng.huilife.bean.CityItem;
import com.minghuilianmeng.huilife.data.CityData;
import com.minghuilianmeng.huilife.widget.ContactItemInterface;
import com.minghuilianmeng.huilife.widget.ContactListViewImpl;
import java.util.ArrayList;
import java.util.List;
import butterknife.ButterKnife;
import butterknife.InjectView;


/**
 * 选择城市的界面
 * Created by zhoujian on 16/8/30.
 */
public class ChoiceCityActivity extends Activity implements TextWatcher
{

    private final static String TAG = "ChoiceCityActivity";
    @InjectView(R.id.iv_title_back)
    ImageView mIvTitleBack;
    @InjectView(R.id.tv_title_name)
    TextView mTvTitleName;
    @InjectView(R.id.iv_title_menu_right)
    ImageView mIvTitleMenuRight;
    @InjectView(R.id.tv_title_menu_right)
    TextView mTvTitleMenuRight;
    private Context context_ = ChoiceCityActivity.this;
    private ContactListViewImpl listview;
    private EditText searchBox;
    private String searchString;
    private Object searchLock = new Object();
    boolean inSearchMode = false;
    List<ContactItemInterface> contactList;
    List<ContactItemInterface> filterList;
    private SearchListTask curSearchTask = null;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chiose_city);
        ButterKnife.inject(this);
        initTitle();
        filterList = new ArrayList<ContactItemInterface>();
        contactList = CityData.getSampleContactList();
        CityAdapter adapter = new CityAdapter(this, R.layout.city_item, contactList);
        listview = (ContactListViewImpl) this.findViewById(R.id.listview);
        listview.setFastScrollEnabled(true);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position,
                                    long id) {
                List<ContactItemInterface> searchList = inSearchMode ? filterList : contactList;
                Toast.makeText(context_, searchList.get(position).getDisplayInfo(),Toast.LENGTH_SHORT).show();
            }
        });
        searchBox = (EditText) findViewById(R.id.input_search_query);
        searchBox.addTextChangedListener(this);
    }

    private void initTitle()
    {
        mTvTitleName.setText("选择城市");
        mIvTitleMenuRight.setVisibility(View.GONE);
        mTvTitleMenuRight.setVisibility(View.GONE);
        mIvTitleBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    public void afterTextChanged(Editable s)
    {
        searchString = searchBox.getText().toString().trim().toUpperCase();

        if (curSearchTask != null && curSearchTask.getStatus() != AsyncTask.Status.FINISHED) {
            try {
                curSearchTask.cancel(true);
            } catch (Exception e) {
                Log.i(TAG, "Fail to cancel running search task");
            }

        }
        curSearchTask = new SearchListTask();
        curSearchTask.execute(searchString);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,int after)
    {

    }
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count)
    {

    }
    private class SearchListTask extends AsyncTask<String, Void, String>
    {

        @Override
        protected String doInBackground(String... params)
        {
            filterList.clear();
            String keyword = params[0];
            inSearchMode = (keyword.length() > 0);
            if (inSearchMode)
            {
                for (ContactItemInterface item : contactList) {
                    CityItem contact = (CityItem) item;
                    boolean isPinyin = contact.getFullName().toUpperCase().indexOf(keyword) > -1;
                    boolean isChinese = contact.getNickName().indexOf(keyword) > -1;
                    if (isPinyin || isChinese) {
                        filterList.add(item);
                    }
                }
            }
            return null;
        }

        protected void onPostExecute(String result)
        {
            synchronized (searchLock) {
                if (inSearchMode) {
                    CityAdapter adapter = new CityAdapter(context_,R.layout.city_item, filterList);
                    adapter.setInSearchMode(true);
                    listview.setInSearchMode(true);
                    listview.setAdapter(adapter);
                } else {
                    CityAdapter adapter = new CityAdapter(context_,R.layout.city_item, contactList);
                    adapter.setInSearchMode(false);
                    listview.setInSearchMode(false);
                    listview.setAdapter(adapter);
                }
            }
        }
    }
}
