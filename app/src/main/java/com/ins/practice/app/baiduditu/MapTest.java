package com.ins.practice.app.baiduditu;

import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.search.core.PoiInfo;
import com.baidu.mapapi.search.core.RouteNode;
import com.baidu.mapapi.search.poi.*;
import com.baidu.mapapi.search.route.*;
import com.ins.practice.app.R;

import java.util.List;

public class MapTest extends FragmentActivity {
    private MapView mMapView = null;
    private TextView textView;
    private RoutePlanSearch routePlanSearch;
    private OnGetRoutePlanResultListener listener;
    private PoiSearch poiSearch;
    private OnGetPoiSearchResultListener onGetPoiSearchResultListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_map_test);
        initview();
        initdata();
    }

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
        }
    };
    private void initdata() {
        routePlanSearch = RoutePlanSearch.newInstance();
        listener = new OnGetRoutePlanResultListener() {

            @Override
            public void onGetWalkingRouteResult(WalkingRouteResult walkingRouteResult) {

            }

            @Override
            public void onGetTransitRouteResult(TransitRouteResult transitRouteResult) {
//

            }

            @Override
            public void onGetMassTransitRouteResult(MassTransitRouteResult massTransitRouteResult) {

            }

            @Override
            public void onGetDrivingRouteResult(DrivingRouteResult drivingRouteResult) {


            }

            @Override
            public void onGetIndoorRouteResult(IndoorRouteResult indoorRouteResult) {

            }

            @Override
            public void onGetBikingRouteResult(BikingRouteResult bikingRouteResult) {

            }
        };
        routePlanSearch.setOnGetRoutePlanResultListener(listener);
        //Poi 检索
        poiSearch = PoiSearch.newInstance();
        onGetPoiSearchResultListener = new OnGetPoiSearchResultListener() {
            @Override
            public void onGetPoiResult(PoiResult poiResult) {
                if (poiResult != null) {
                    List<PoiInfo> allPoi = poiResult.getAllPoi();
                    if (allPoi != null) {
                        for (int i = 0; i < allPoi.size(); i++) {
                            Log.d("dddddddddddddddddddd",allPoi.get(i).name);
                        }
                    }
                }
            }

            @Override
            public void onGetPoiDetailResult(PoiDetailResult poiDetailResult) {

            }

            @Override
            public void onGetPoiIndoorResult(PoiIndoorResult poiIndoorResult) {

            }
        };
        poiSearch.setOnGetPoiSearchResultListener(onGetPoiSearchResultListener);
    }
    public void start_go(View view) {
        poiSearch.searchInCity(new PoiCitySearchOption().city("北京").keyword("美食").pageNum(10));
    }

    private void initview() {
        mMapView = (MapView) findViewById(R.id.bmapView);
        textView = (TextView) findViewById(R.id.map_text);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //在activity执行onDestroy时执行mMapView.onDestroy()，实现地图生命周期管理
        mMapView.onDestroy();
    }
    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView. onResume ()，实现地图生命周期管理
        mMapView.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView. onPause ()，实现地图生命周期管理
        mMapView.onPause();
    }


}
