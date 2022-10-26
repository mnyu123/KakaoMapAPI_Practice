package com.example.map_api_test_1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ListAdapter;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import net.daum.mf.map.api.MapPOIItem;
import net.daum.mf.map.api.MapPoint;
import net.daum.mf.map.api.MapView;

public class MainActivity extends AppCompatActivity {

    static final String[] List_Menu = {"리스트1","리스트2","리스트2","리스트2","리스트2","리스트2","리스트2","리스트2","리스트2","리스트2"};
    static final double[] point1 = {35.9646389,35.9609,35.9617,35.9669,35.9587,35.9593};
    static final double[] point2 = {126.9595793,126.9666,126.9666,126.9594,126.9685,126.9819};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MapView mapView = new MapView(this);

        ViewGroup mapViewContainer = (ViewGroup) findViewById(R.id.map_view);
        mapViewContainer.addView(mapView);

        mapView.setMapCenterPoint(MapPoint.mapPointWithGeoCoord(35.9646389,126.9595793),true); // 원대병원을 중심으로 나오게

        //좌표를 리스트에 넣고
        //리스트 불러와서 반복문 집어넣음


        for(int i =0; i<6 ;i++)
        {
            MapPoint mapPoint = MapPoint.mapPointWithGeoCoord(point1[i],point2[i]);
            for(int j =0; j<10; j++){
                MapPOIItem marker = new MapPOIItem();
                marker.setItemName("선별진료소"+i);
                marker.setTag(0);
                marker.setMapPoint(mapPoint);
                marker.setMarkerType(MapPOIItem.MarkerType.BluePin);
                marker.setSelectedMarkerType(MapPOIItem.MarkerType.YellowPin);

                mapView.addPOIItem(marker);
//

                List_Menu[j] = "션별진료소" + j;
            }


        }


        //----------------------------------------------------------------------
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,List_Menu);

        ListView listview = (ListView) findViewById(R.id.list_view);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                String strText = (String) parent.getItemAtPosition(position);

                if(List_Menu[0]==strText)
                {
                    mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(point1[0], point2[0]), 1, true);
                }
                else if(List_Menu[1]==strText)
                {
                    mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(point1[1], point2[1]), 1, true);
                }
                else if(List_Menu[2]==strText)
                {
                    mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(point1[2], point2[2]), 1, true);
                }
                else if(List_Menu[3]==strText)
                {
                    mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(point1[3], point2[3]), 1, true);
                }
                else if(List_Menu[4]==strText)
                {
                    mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(point1[4], point2[4]), 1, true);
                }
                else if(List_Menu[5]==strText)
                {
                    mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(point1[5], point2[5]), 1, true);
                }
                //mapView.setMapCenterPointAndZoomLevel(MapPoint.mapPointWithGeoCoord(35.9646389, 126.9595793), 1, true);


            }

        });








    }


}