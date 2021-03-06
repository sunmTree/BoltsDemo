package com.sunm.bolts;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.sunm.AppConfig;
import com.sunm.data.MapDemo;
import com.sunm.model.bridge.Image;
import com.sunm.model.bridge.ImageImpl;
import com.sunm.model.bridge.PNGImage;
import com.sunm.model.bridge.WindowImpl;
import com.sunm.model.builder.Builder;
import com.sunm.model.builder.ConstructBuilder;
import com.sunm.model.builder.Director;
import com.sunm.model.builder.Notify;
import com.sunm.model.builder.Product;
import com.sunm.model.chain.Approver;
import com.sunm.model.chain.Congress;
import com.sunm.model.chain.President;
import com.sunm.model.chain.PurchaseRequest;
import com.sunm.model.chain.VicePresident;
import com.sunm.model.command.Command;
import com.sunm.model.command.FBSettingWindow;
import com.sunm.model.command.FunctionButton;
import com.sunm.model.command.HelperCommand;
import com.sunm.model.command.WindowCommand;
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
import com.sunm.model.interpreter.InstructionHandler;
import com.sunm.model.iteration.AbstractIteration;
import com.sunm.model.iteration.AbstractObjectList;
import com.sunm.model.iteration.ProductList;
import com.sunm.model.mediator.Buton;
import com.sunm.model.mediator.ComboBox;
import com.sunm.model.mediator.ConcreteMediator;
import com.sunm.model.mediator.ListCom;
import com.sunm.model.mediator.TextBox;
import com.sunm.model.observer.AllyControllerCenter;
import com.sunm.model.observer.ConcreteAllyControllerCenter;
import com.sunm.model.observer.Observer;
import com.sunm.model.observer.Player;
import com.sunm.model.proxy.ProxySearcher;
import com.sunm.model.proxy.Searcher;
import com.sunm.model.simplefactory.ChartFactory;
import com.sunm.model.singleton.Singleton;
import com.sunm.model.state.Account;
import com.sunm.model.strategy.Discount;
import com.sunm.model.strategy.MovieTicket;
import com.sunm.model.strategy.StudentDiscount;
import com.sunm.operation.OperationDemo;
import com.sunm.prop.ModelProp;
import com.sunm.utils.FileUtils;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class ThirdActivity extends AppCompatActivity {

    private static final String TAG = "ThirdActivity";
    private static final boolean DEBUG = AppConfig.DEBUG;

    private static final int CREATE_CHART_MESSAGE = 1;
    private static final int OPERATION_MESSAGE = 2;

    private ChartFactory.Chart mChart;
    private MyHandler myHandler = new MyHandler(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        myHandler.sendEmptyMessageDelayed(OPERATION_MESSAGE, 400);
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

            if (OPERATION_MESSAGE == msg.what) {
                OperationDemo.operation();
                MapDemo mapDemo = new MapDemo();
                mapDemo.put("Key", "Value");
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
                    activity.chain();
                    activity.command();
                    activity.interpreter();
                    activity.iteration();
                    activity.mediator();
                    activity.observer();
                    activity.state();
                    activity.strategy();
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

    // 责任链模式
    private void chain() {
        Approver approver1,approver2,approver3,approver4;

        approver1 = new com.sunm.model.chain.Director("张无忌");
        approver2 = new VicePresident("杨过");
        approver3 = new President("郭靖");
        approver4 = new Congress("董事会");

        approver1.setSuccessor(approver2);
        approver2.setSuccessor(approver3);
        approver3.setSuccessor(approver4);

        PurchaseRequest request = new PurchaseRequest(3000, 2, "买东西");
        approver1.processRequest(request);

        PurchaseRequest request1 = new PurchaseRequest(600000, 2, "并购");
        approver1.processRequest(request1);

        PurchaseRequest request2 = new PurchaseRequest(34100, 2, "扩张");
        approver1.processRequest(request2);
    }

    // 命令模式
    private void command() {
        FBSettingWindow fbWindow = new FBSettingWindow("快捷键设置");
        FunctionButton f1, f2;
        f1 = new FunctionButton("按钮");
        f2 = new FunctionButton("快捷键");

        Command command1, command2;
        command1 = new HelperCommand();
        command2 = new WindowCommand();

        f1.setCommand(command2);
        f2.setCommand(command1);
        fbWindow.addFunctionButton(f1);
        fbWindow.addFunctionButton(f2);

        fbWindow.display();
        f1.onClick();
        f2.onClick();
    }

    // 解释器模式
    private void interpreter() {
        String instruction = "up move 5 and down run 10 and left move 5";
        InstructionHandler handler = new InstructionHandler();
        handler.handle(instruction);
        String output = handler.output();
        if (DEBUG) {
            Log.d(TAG, "output " + output);
        }
    }

    // 迭代模式
    private void iteration() {
        List products = new ArrayList();
        products.add("Item1");
        products.add("Item2");
        products.add("Item3");
        products.add("Item4");
        products.add("Item5");

        AbstractObjectList abList = new ProductList(products);
        AbstractIteration iteration = abList.createIteration();

        if (DEBUG) {
            Log.d(TAG, "----------------->>>> 正向遍历");
        }
        while (!iteration.isLast()) {
            Log.d(TAG, "item " + iteration.getNext().toString());
            iteration.next();
        }
        if (DEBUG) {
            Log.d(TAG, "------------------->>>> 反向遍历");
        }
        while (! iteration.isFirst()) {
            Log.d(TAG, "item " + iteration.getPreviousItem().toString());
            iteration.previous();
        }
    }

    // 中介模式
    private void mediator() {
        ConcreteMediator mediator = new ConcreteMediator();

        Buton buton = new Buton();
        ListCom listCom = new ListCom();
        ComboBox comboBox = new ComboBox();
        TextBox textBox = new TextBox();

        buton.setMediator(mediator);
        listCom.setMediator(mediator);
        comboBox.setMediator(mediator);
        textBox.setMediator(mediator);

        mediator.userName = textBox;
        mediator.comboBox = comboBox;
        mediator.listCom = listCom;
        mediator.buton = buton;

        buton.changed();
        if (DEBUG) {
            Log.d(TAG, " -----------------分割线----------------");
        }
        listCom.changed();
    }

    // 观察者模式
    private void observer() {
        AllyControllerCenter center = new ConcreteAllyControllerCenter();
        center.setAllyName("刑天");
        Observer player1, player2, player3, player4;

        player1 = new Player("战神1");
        player2 = new Player("神2");
        player3 = new Player("战神----3");
        player4 = new Player("4");
        center.join(player1);
        center.join(player2);
        center.join(player3);
        center.join(player4);

        player1.beAttacked(center);
    }

    // 状态模式
    private void state() {
        Account acc = new Account("段誉",0.0);
        acc.deposit(1000);
        acc.withDraw(2000);
        acc.deposit(3000);
        acc.withDraw(4000);
        acc.withDraw(1000);
        acc.computeInterest();
    }

    // 策略模式
    private void strategy() {
        MovieTicket movieTicket = new MovieTicket();
        double originalPrice = 60.0;
        double currentPrice;

        movieTicket.setPrice(originalPrice);
        if (DEBUG) {
            Log.d(TAG, "原始价为 " + originalPrice);
            Log.d(TAG, "-----------------------------------------");
        }

        Discount discount = new StudentDiscount();
        movieTicket.setDiscount(discount);

        currentPrice = movieTicket.getPrice();
        if (DEBUG) {
            Log.d(TAG, " currentPrice " + currentPrice);
            Log.d(TAG, "-----------------------------------");
        }
    }
}
