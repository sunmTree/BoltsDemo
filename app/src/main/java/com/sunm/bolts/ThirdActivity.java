package com.sunm.bolts;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.sunm.AppConfig;
import com.sunm.model.adapter.QuickSort;
import com.sunm.model.bridge.Image;
import com.sunm.model.bridge.ImageImpl;
import com.sunm.model.bridge.PNGImage;
import com.sunm.model.bridge.WindowImpl;
import com.sunm.model.builder.Builder;
import com.sunm.model.builder.ConstructBuilder;
import com.sunm.model.builder.Director;
import com.sunm.model.builder.Notify;
import com.sunm.model.builder.Product;
import com.sunm.model.compose.AbstractFile;
import com.sunm.model.compose.Folder;
import com.sunm.model.compose.ImageFile;
import com.sunm.model.compose.TextFile;
import com.sunm.model.compose.VideoFile;
import com.sunm.model.decorate.Component;
import com.sunm.model.decorate.ScrollBarDecorator;
import com.sunm.model.decorate.Window;
import com.sunm.model.factory.ILoggerFactory;
import com.sunm.model.factory.Logger;
import com.sunm.model.factory.LoggerFactory;
import com.sunm.model.flyweight.Coordinates;
import com.sunm.model.flyweight.IgoChessman;
import com.sunm.model.flyweight.IgoChessmanFactory;
import com.sunm.model.proxy.ProxySearcher;
import com.sunm.model.proxy.Searcher;
import com.sunm.model.simplefactory.ChartFactory;
import com.sunm.model.singleton.Singleton;
import com.sunm.prop.ModelProp;
import com.sunm.utils.FileUtils;
import com.sunm.utils.SortUtils;

import java.lang.ref.WeakReference;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "ThirdActivity";
    private static final boolean DEBUG = AppConfig.DEBUG;

    private static final int CREATE_CHART_MESSAGE = 1;
    private ChartFactory.Chart mChart;
    private MyHandler myHandler = new MyHandler(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        myHandler.sendEmptyMessageDelayed(CREATE_CHART_MESSAGE, 400);
    }

    class MyHandler extends Handler {

        private WeakReference<Activity> mWeak;

        public MyHandler(Activity activity) {
            mWeak = new WeakReference<>(activity);
        }

        @Override
        public void handleMessage(Message msg) {
            ThirdActivity activity = (ThirdActivity) mWeak.get();
            if (DEBUG) {
                Log.d(TAG, "receive message and the activity state " + activity.isFinishing());
            }
            if (CREATE_CHART_MESSAGE == msg.what) {
                if (activity != null && !activity.isFinishing()) {
                    activity.showChart();
                    activity.logCreate();
                    activity.single();
                    activity.builder();
                    activity.bridge();
                    activity.compose();
                    activity.decorate();
                    activity.flyweight();
                    activity.proxy();
                }
            }
        }
    }

    // 简单工厂模式
    private void showChart() {
        if (DEBUG) {
            Log.d(TAG, "showChart " + FileUtils.getChartType(this));
        }
        mChart = ChartFactory.getChart(ModelProp.getInstance(this).getChartType());
        if (DEBUG) {
            Log.d(TAG, mChart.toString());
        }
        mChart = ChartFactory.getChart(ModelProp.getInstance(this).getChartType());
        if (DEBUG) {
            Log.d(TAG, mChart.toString());
        }
        mChart.display();
    }

    // 工厂模式
    private void logCreate() {
        if (DEBUG) {
            String logFactoryType = ModelProp.getInstance(this).getLogFactoryType();
            try {
                LoggerFactory loggerFactory =
                        (LoggerFactory) Class.forName(logFactoryType).newInstance();
                Log.e(TAG, "loggerFactory " + loggerFactory);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        ILoggerFactory iLoggerFactory = LoggerFactory.createFileFactory();
        Logger logger = iLoggerFactory.createLog();
        logger.writeLog("Hello world");
    }

    // 单例模式
    private void single() {
        Singleton instance = Singleton.getInstance();
    }

    // 创建者模式
    private void builder() {
        Builder builder = new ConstructBuilder();
        Director director = new Director();
        director.setBuilder(builder);
        Product product = director.construct();
        if (DEBUG) {
            Log.d(TAG, "builder " + product.toString());
        }

        Notify.NotifyBuilder notifyBuilder = new Notify.NotifyBuilder();
        notifyBuilder.setSmallIcon(0).setContent("I need a success")
                .setTitle("Make It").setWhen(10L);
        Notify build = notifyBuilder.build();
        build.showNotify(this);
    }

    // 桥接模式
    private void bridge() {
        Image image = new PNGImage();
        ImageImpl impl = new WindowImpl();
        image.setImpl(impl);
        image.parseFile("小龙女");
    }

    // 组合模式
    private void compose() {
        AbstractFile file1,file2,file3,file4,file5,file6,folder1,folder2,folder3,folder4;

        folder1 = new Folder("Sunny的资料");
        folder2 = new Folder("图像文件");
        folder3 = new Folder("文本文件");
        folder4 = new Folder("视频文件");

        file1 = new ImageFile("小龙女.jpg");
        file2 = new ImageFile("张无忌.gif");
        file3 = new TextFile("九阴真经.txt");
        file4 = new TextFile("葵花宝典.doc");
        file5 = new VideoFile("真界.mp4");
        file6 = new TextFile("README.txt");

        folder2.add(file1);
        folder2.add(file2);
        folder3.add(file3);
        folder3.add(file4);
        folder4.add(file5);

        folder1.add(folder2);
        folder1.add(folder3);
        folder1.add(folder4);
        folder1.add(file6);

        folder1.killVirus();
    }

    // 装饰模式
    private void decorate() {
        Component component, componentScroll;
        component = new Window();
        componentScroll = new ScrollBarDecorator(component);
        componentScroll.display();
    }

    // 享元模式
    private void flyweight() {
        IgoChessman black1, black2, black3;
        IgoChessman white1, white2;
        String BLACK_CHESSMAN = "black";
        String WHITE_CHESSMAN = "white";
        // 获取享元工厂对象
        IgoChessmanFactory factory = IgoChessmanFactory.getInstance();

        // 通过工厂获取三个黑子
        black1 = factory.getIgoChessman(BLACK_CHESSMAN);
        black2 = factory.getIgoChessman(BLACK_CHESSMAN);
        black3 = factory.getIgoChessman(BLACK_CHESSMAN);
        if (DEBUG) {
            Log.i(TAG, " is equal black " + (black1 == black2));
        }

        // 通过工厂获取两个白子
        white1 = factory.getIgoChessman(WHITE_CHESSMAN);
        white2 = factory.getIgoChessman(WHITE_CHESSMAN);
        if (DEBUG) {
            Log.i(TAG, " is equal white " + (white1 == white2));
        }

        black1. display(new Coordinates(1, 4));
        black2.display(new Coordinates(3,1));
        black3.display(new Coordinates(12, 17));
        white1.display(new Coordinates(2, 0));
        white2.display(new Coordinates(10, 3));
    }

    // 代理模式
    private void proxy() {
        Searcher searcher = new ProxySearcher();
        searcher.doSearch("Sunny", "Money");
    }
}
