package com.race.house.houseracelamp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * 参考资料： http://blog.csdn.net/xiaoyu490697/article/details/7317396
 */
public class MainActivity extends AppCompatActivity {

    private Button scroll_by_btn;
    private Button scroll_to_btn;
    private TextView scroll_to_txt;
    private TextView scroll_by_txt;
    private MyScrollTextView scroll_self_txt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        scroll_by_btn = (Button) findViewById(R.id.scroll_by_btn);
        scroll_to_btn = (Button) findViewById(R.id.scroll_to_btn);

        scroll_to_txt = (TextView) findViewById(R.id.scroll_to_txt);
        scroll_by_txt = (TextView) findViewById(R.id.scroll_by_txt);
        scroll_self_txt = (MyScrollTextView) findViewById(R.id.scroll_self_txt);


    }

    /**
     * 滚动  到指定位置
     *
     * @param view
     */
    public void scrollTo(View view) {

        scroll_to_txt.scrollTo(100, 0);

    }

    /**
     * 滚动  指定的位置
     *
     * @param view
     */
    public void scrollBy(View view) {
        scroll_by_txt.scrollBy(100, 0);

    }

    /**
     * 开始跑马
     * 思路，是设计一个定时器，每隔一定的时间更新一次；
     * 等向左移动了的距离 超过了文字的长度之后，将其设置在右面，
     * 重新开始。
     *
     * @param view
     */
    public void startHouseRace(View view) {

        scroll_self_txt.startPlay();

    }

    /**
     * 停止播放定时器
     *
     * @param view
     */
    public void stopHouseRace(View view) {
        scroll_self_txt.stopPlay();

    }


}
