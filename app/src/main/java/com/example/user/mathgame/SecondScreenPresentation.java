package com.example.user.mathgame;



import android.app.Presentation;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.EventBus;

  /*      import com.yanghaoyi.presentation.R;
        import com.yanghaoyi.presentation.presenter.event.MapEvent;
        import com.yanghaoyi.presentation.presenter.event.SearchEvent;
        import com.yanghaoyi.presentation.view.page.MapFrameLayout;
        import com.yanghaoyi.presentation.view.page.SearchFrameLayout;

        import org.greenrobot.eventbus.EventBus;
        import org.greenrobot.eventbus.Subscribe;*/

/**
 * @author : YangHaoYi on 2019/1/2.
 *         Email  :  yang.haoyi@qq.com
 *         Description :双屏异显辅助屏幕
 *         Change : YangHaoYi on 2019/1/2.
 *         Version : V 1.0
 */
public class SecondScreenPresentation extends Presentation     {

    /** TAG **/
    private static final String TAG = "Presentation";
    /** 根布局 **/
//    private FrameLayout fmContent;

    private TextView tvSearch;


    public SecondScreenPresentation(Context outerContext, Display display) {
        super(outerContext, display);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.presentation_search);
        init();
    }

    private void init(){
        initView();
        initEvent();
    }

    private void initView(){
        tvSearch= findViewById(R.id.tvSearch);
//        fmContent = findViewById(R.id.fmContent);
//        initPage();
    }

 /*   private void initPage(){
        mapFrameLayout = new MapFrameLayout(getContext());
        mapFrameLayout.setMapCallBackListener(this);
        fmContent.addView(mapFrameLayout);
        searchFrameLayout = new SearchFrameLayout(getContext());
    }*/


    private void initEvent(){
        windowWidthAndHeightTest();
    }

    private void windowWidthAndHeightTest(){
        int height = getContext().getResources().getDisplayMetrics().heightPixels;
        int width = getContext().getResources().getDisplayMetrics().widthPixels;
        Log.d(TAG,"height_is"+height+"  width_is:"+width);
        System.out.println("SearchPresentation________height_is"+height+"  width_is:"+width);
    }

    /**  EventBus模拟点击  */

    /**  EventBus注册  */
    @Override
    public void show() {
        super.show();
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }

    /**  EventBus解注册  */
    @Override
    public void dismiss() {
        EventBus.getDefault().unregister(this);
        super.dismiss();
    }


    /**  地图Event事件  */
    @Subscribe
    public void onMapEvent(MapEvent mapEvent){
        tvSearch.setText("onMapEvent:"+mapEvent.getCode());
     /*   switch (mapEvent.getCode()){
            case MapEvent.ZOOM_IN:
                mapFrameLayout.performZoomIn();
                break;
            case MapEvent.TO_SEARCH:
                mapFrameLayout.performToSearch();
                break;
            default:
                break;
        }*/
    }



/*    @Override
    public void mapCallBackContent(MapFrameLayout.MapEvent event, Object data) {
        switch (event){
            case Search:
                if(null == searchFrameLayout){
                    searchFrameLayout = new SearchFrameLayout(getContext());
                    searchFrameLayout.setSearchBackListener(this);
                    fmContent.addView(searchFrameLayout);
                }else {
                    searchFrameLayout.setSearchBackListener(this);
                    fmContent.addView(searchFrameLayout);
                }
                break;
            default:
                break;
        }
    }*/

    /** 搜索页面回调 **/
/*
    @Override
    public void searchCallBackContent(SearchFrameLayout.SearchEvent event, Object data) {
        switch (event){
            case Back:
                fmContent.removeView(searchFrameLayout);
                searchFrameLayout = null;
                break;
            case Other:
                break;
            default:
                break;
        }
    }
*/


    /**  EventBus模拟点击  */

    /**  EventBus注册  */
  /*  @Override
    public void show() {
        super.show();
        if(!EventBus.getDefault().isRegistered(this)){
            EventBus.getDefault().register(this);
        }
    }*/

    /**  EventBus解注册  */
  /*  @Override
    public void dismiss() {
        EventBus.getDefault().unregister(this);
        super.dismiss();
    }*/

    /**  地图Event事件  */
/*    @Subscribe
    public void onMapEvent(MapEvent mapEvent){
        switch (mapEvent.getCode()){
            case MapEvent.ZOOM_IN:
                mapFrameLayout.performZoomIn();
                break;
            case MapEvent.TO_SEARCH:
                mapFrameLayout.performToSearch();
                break;
            default:
                break;
        }
    }*/

    /**  搜索Event事件  */
 /*   @Subscribe
    public void onSearchEvent(SearchEvent searchEvent){
        switch (searchEvent.getCode()){
            case SearchEvent.DO_SEARCH:
                searchFrameLayout.performDoSearch();
                break;
            case SearchEvent.BACK:
                searchFrameLayout.performBack();
                break;
            default:
                break;
        }
    }
*/


}
