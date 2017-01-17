package com.windhike.kotlinlearn;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * author: gzzyj on 2017/1/17.
 * email:zhyongjun@windhike.cn
 */

public class MainAty extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextListAdapter list = new TextListAdapter(new ArrayList<String>());
    }
}
