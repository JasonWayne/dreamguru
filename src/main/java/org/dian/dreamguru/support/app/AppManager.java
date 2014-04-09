package org.dian.dreamguru.support.app;

import android.app.Activity;
import android.content.Context;

import java.util.Stack;

/**
 * the class to manage activities and application exits
 * Created by Jason on 14-4-9.
 */
public class AppManager {

    private static Stack<Activity> activityStack;
    private static AppManager instance;

    private AppManager() {
    }

    /**
     * singleton
     * @return
     */
    public static AppManager getInstance() {
        if(instance == null) {
            instance = new AppManager();
        }
        return instance;
    }

    public void finishAllActivity() {
        for (int i = 0, size = activityStack.size(); i < size; i++) {
            if (null != activityStack.get(i)) {
                activityStack.get(i).finish();
            }
        }
        activityStack.clear();
    }
    public void AppExit(Context context) {
        try {
            finishAllActivity();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void finishActivity(Activity activity) {
        if (null != activity) {
            activityStack.remove(activity);
            activity.finish();
            activity = null;
        }
    }
    public void finishActivity(Class<?> cls) {
        for (Activity activity : activityStack) {
            if(activity.getClass().equals(cls)) {
                finishActivity(activity);
            }
        }
    }
    public Activity currentActivity() {
        Activity activity = activityStack.lastElement();
        return activity;
    }

    public void addActivity(Activity activity) {
        if(activityStack == null) {
            activityStack = new Stack<Activity>();
        }
        activityStack.add(activity);
    }


}
