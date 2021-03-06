package org.md2k.mcerebrum.core.access.appinfo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import org.md2k.mcerebrum.core.access.SampleProviderSQLiteOpenHelper;
import org.md2k.mcerebrum.core.access.appinfo.AppInfoBean;
import org.md2k.mcerebrum.core.access.appinfo.AppInfoColumns;
import org.md2k.mcerebrum.core.access.appinfo.AppInfoContentValues;
import org.md2k.mcerebrum.core.access.appinfo.AppInfoCursor;
import org.md2k.mcerebrum.core.access.appinfo.AppInfoSelection;

import java.util.ArrayList;

/**
 * App ContentProvider ContentProvider class.
 * This class is auto-generated by Android ContentProvider Generator.
 * For more information see <a href="https://github.com/BoD/android-contentprovider-generator">GitHub</a>.
 */
public class AppCP {

    public static void deleteTable(Context context) {
        try {
            SampleProviderSQLiteOpenHelper s = SampleProviderSQLiteOpenHelper.getInstance(context);
            SQLiteDatabase db = s.getWritableDatabase();
            db.execSQL("DROP TABLE IF EXISTS " + AppInfoColumns.TABLE_NAME);
            db.execSQL(SampleProviderSQLiteOpenHelper.SQL_CREATE_TABLE_APP_INFO);
        }catch (Exception e){}
    }

    private static void insertOrUpdate(Context context, AppInfoBean appInfoBean) {
        try {
            AppInfoContentValues values = prepare(appInfoBean);
            if (isEmpty(context, appInfoBean))
                values.insert(context);
            else
                values.update(context, new AppInfoSelection().packageName(appInfoBean.getPackageName()));
        }catch (Exception e){
            deleteTable(context);
            AppInfoContentValues values = prepare(appInfoBean);
            values.insert(context);
        }
    }

    public static AppInfoBean read(Context context, String packageName) {
        AppInfoBean appInfoBean = null;
        try {
            AppInfoSelection appInfoSelection = new AppInfoSelection();
            AppInfoCursor c = appInfoSelection.query(context);
            while (c.moveToNext()) {
                if(c.getPackageName() != null && c.getPackageName().equals(packageName)) {
                    appInfoBean = AppInfoBean.newInstance(c.getId(),c.getPackageName(),c.getType(),
                            c.getTitle(),c.getSummary(),c.getDescription(),c.getUseInStudy(),
                            c.getUseAs(),c.getInstalled(),c.getDownloadLink(),c.getUpdates(),
                            c.getCurrentVersion(),c.getLatestVersion(),c.getExpectedVersion(),
                            c.getIcon(),c.getMcerebrumSupported(),c.getFuncInitialize(),
                            c.getInitialized(),c.getFuncUpdateInfo(),c.getFuncConfigure(),
                            c.getConfigured(),c.getConfigureMatch(),c.getFuncPermission(),
                            c.getPermissionOk(),c.getFuncBackground(),c.getBackgroundRunningTime(),
                            c.getIsBackgroundRunning(),c.getFuncReport(),c.getFuncClear(),c.getDatakitConnected());
                    c.close();
                    return appInfoBean;
                }
            }
            c.close();
        }catch (Exception ignored){
        }
        return appInfoBean;
    }

    public static ArrayList<String> read(Context context) {
        ArrayList<String> packageName = new ArrayList<>();
        try {
            AppInfoSelection appInfoSelection = new AppInfoSelection();
            AppInfoCursor c = appInfoSelection.query(context);
            while (c.moveToNext()) {
                if(c.getPackageName() != null) {
                    packageName.add(c.getPackageName());
                }
            }
            c.close();
        }catch (Exception ignored){
        }
        return packageName;
    }

    private static boolean isEmpty(Context context, AppInfoBean appInfoBean) {
        int count = 0;
        AppInfoSelection appInfoSelection = new AppInfoSelection().packageName(appInfoBean.getPackageName());
        AppInfoCursor c = appInfoSelection.query(context);
        while (c.moveToNext()) {
            count++;
        }
        c.close();
        return count == 0;
    }

    private static AppInfoContentValues prepare(AppInfoBean appInfoBean) {
        AppInfoContentValues values = new AppInfoContentValues();
        values.putPackageName(appInfoBean.getPackageName());
        values.putType(appInfoBean.getType());
        values.putTitle(appInfoBean.getTitle());
        values.putSummary(appInfoBean.getSummary());
        values.putDescription(appInfoBean.getDescription());
        values.putUseInStudy(appInfoBean.getUseInStudy());
        values.putUseAs(appInfoBean.getUseAs());
        values.putInstalled(appInfoBean.getInstalled());
        values.putDownloadLink(appInfoBean.getDownloadLink());
        values.putUpdates(appInfoBean.getUpdates());
        values.putCurrentVersion(appInfoBean.getCurrentVersion());
        values.putLatestVersion(appInfoBean.getLatestVersion());
        values.putExpectedVersion(appInfoBean.getExpectedVersion());
        values.putIcon(appInfoBean.getIcon());
        values.putMcerebrumSupported(appInfoBean.getMcerebrumSupported());
        values.putFuncInitialize(appInfoBean.getFuncInitialize());
        values.putInitialized(appInfoBean.getInitialized());
        values.putFuncUpdateInfo(appInfoBean.getFuncUpdateInfo());
        values.putFuncConfigure(appInfoBean.getFuncConfigure());
        values.putConfigured(appInfoBean.getConfigured());
        values.putConfigureMatch(appInfoBean.getConfigureMatch());
        values.putFuncPermission(appInfoBean.getFuncPermission());
        values.putPermissionOk(appInfoBean.getPermissionOk());
        values.putFuncBackground(appInfoBean.getFuncBackground());
        values.putBackgroundRunningTime(appInfoBean.getBackgroundRunningTime());
        values.putIsBackgroundRunning(appInfoBean.getIsBackgroundRunning());
        values.putFuncReport(appInfoBean.getFuncReport());
        values.putFuncClear(appInfoBean.getFuncClear());
        values.putDatakitConnected(appInfoBean.getDatakitConnected());
        return values;
    }

    public boolean isEqual(AppInfoBean appInfoBean, String packageName) {
        return appInfoBean.getPackageName().equals(packageName);
    }

    public static void set(Context context, String packageName, String type, String title,
                           String summary, String description, String use_as, String downloadLink,
                           String update, String expectedVersion, String icon, boolean useInStudy) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            appInfoBean = new AppInfoBean();
        appInfoBean.setPackageName(packageName);
        appInfoBean.setType(type);
        appInfoBean.setTitle(title);
        appInfoBean.setSummary(summary);
        appInfoBean.setDescription(description);
        appInfoBean.setUseAs(use_as);
        appInfoBean.setDownloadLink(downloadLink);
        appInfoBean.setUpdates(update);
        appInfoBean.setExpectedVersion(expectedVersion);
        appInfoBean.setIcon(icon);
        appInfoBean.setUseInStudy(useInStudy);
        insertOrUpdate(context, appInfoBean);
    }

    public static String getType(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getType();
    }

    public static String getTitle(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        else return appInfoBean.getTitle();
    }

    public static String getSummary(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getSummary();
    }

    public static String getDescription(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getDescription();
    }

    public static Boolean getUseInStudy(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        if(appInfoBean.getUseInStudy() == null)
            return false;
        return appInfoBean.getUseInStudy();
    }

    public static String getUseAs(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getUseAs();
    }

    public static String getIcon(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getIcon();
    }

    public static void setInstalled(Context context, String packageName, boolean isInstalled, String currentVersion) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null) return;
        if(appInfoBean.getInstalled() == null
                || appInfoBean.getInstalled() != isInstalled
                || appInfoBean.getCurrentVersion() == null
                || !appInfoBean.getCurrentVersion().equals(currentVersion)) {
            appInfoBean.setInstalled(isInstalled);
            appInfoBean.setCurrentVersion(currentVersion);
            insertOrUpdate(context, appInfoBean);
            if(!isInstalled) clearAccess(context, packageName);
        }
    }

    public static boolean getInstalled(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return false;
        if(appInfoBean.getInstalled() == null)
            return false;
        return appInfoBean.getInstalled();
    }

    public static String getCurrentVersion(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getCurrentVersion();
    }

    public static String getDownloadLink(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getDownloadLink();
    }

    public static String getExpectedVersion(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getExpectedVersion();
    }

    public static void setLatestVersion(Context context, String packageName, String s) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return;
        if(appInfoBean.getLatestVersion() == null || !appInfoBean.getLatestVersion().equals(s)) {
            appInfoBean.setLatestVersion(s);
            insertOrUpdate(context, appInfoBean);
        }
    }

    public static String getUpdate(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getUpdates();
    }

    public static String getLatestVersion(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getLatestVersion();
    }

    public static boolean getMCerebrumSupported(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return false;
        if(appInfoBean.getMcerebrumSupported() == null)
            return false;
        return appInfoBean.getMcerebrumSupported();
    }

    public static void setMCerebrumSupported(Context context, String packageName, boolean isSupported) {
        AppInfoBean appInfoBean=read(context, packageName);
        if(appInfoBean == null) return;
        if(appInfoBean.getMcerebrumSupported() == null || appInfoBean.getMcerebrumSupported() != isSupported) {
            appInfoBean.setMcerebrumSupported(isSupported);
            insertOrUpdate(context, appInfoBean);
        }
    }

    public static void setUseInStudy(Context context, String packageName, boolean b) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return;
        if(appInfoBean.getUseInStudy() == null || appInfoBean.getUseInStudy() != b) {
            appInfoBean.setUseInStudy(b);
            insertOrUpdate(context, appInfoBean);
        }
    }

    public static String getFuncInitialize(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getFuncInitialize();
    }

    public static void setFuncInitialize(Context context, String packageName, String s) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return;
        if(appInfoBean.getFuncInitialize() == null || !appInfoBean.getFuncInitialize().equals(s)) {
            appInfoBean.setFuncInitialize(s);
            insertOrUpdate(context, appInfoBean);
        }
    }

    public static boolean getInitialized(Context context, String packageName, boolean initialized) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return false;
        if(appInfoBean.getInitialized() == null)
            return false;
        return appInfoBean.getInitialized();
    }

    public static void setInitialized(Context context, String packageName, boolean initialized) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return;
        if(appInfoBean.getInitialized() == null || appInfoBean.getInitialized() !=initialized) {
            appInfoBean.setInitialized(initialized);
            insertOrUpdate(context, appInfoBean);
        }
    }

    public static String getFuncUpdateInfo(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getFuncUpdateInfo();
    }

    public static void setFuncUpdateInfo(Context context, String packageName, String s) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return;
        if(appInfoBean.getFuncUpdateInfo() == null || !appInfoBean.getFuncUpdateInfo().equals(s)) {
            appInfoBean.setFuncUpdateInfo(s);
            insertOrUpdate(context, appInfoBean);
        }
    }

    public static void setFuncConfigure(Context context, String packageName, String s) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return;
        if(appInfoBean.getFuncConfigure() == null || !appInfoBean.getFuncConfigure().equals(s)) {
            appInfoBean.setFuncConfigure(s);
            insertOrUpdate(context, appInfoBean);
        }
    }

    public static String getFuncConfigure(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getFuncConfigure();
    }

    public static void setConfigured(Context context, String packageName, boolean isConfigured) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return;
        if(appInfoBean.getConfigured() == null || appInfoBean.getConfigured() != isConfigured) {
            appInfoBean.setConfigured(isConfigured);
            insertOrUpdate(context, appInfoBean);
        }
    }

    public static boolean getConfigured(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return true;
        Boolean b = appInfoBean.getConfigured();
        if(b == null)
            return true;
        return appInfoBean.getConfigured();
    }

    public static boolean getConfigureMatch(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return true;
        Boolean isConfigMatch = appInfoBean.getConfigureMatch();
        if(isConfigMatch == null)
            return true;
        return appInfoBean.getConfigureMatch();
    }

    public static void setConfigureMatch(Context context, String packageName, boolean b) {
        AppInfoBean appInfoBean=read(context, packageName);
        if(appInfoBean == null)
            return;
        if(appInfoBean.getConfigureMatch() == null || appInfoBean.getConfigureMatch() != b) {
            appInfoBean.setConfigureMatch(b);
            insertOrUpdate(context, appInfoBean);
        }
    }

    public static void setFuncPermission(Context context, String packageName, String s) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return;
        if(appInfoBean.getFuncPermission() == null || !appInfoBean.getFuncPermission().equals(s)) {
            appInfoBean.setFuncPermission(s);
            insertOrUpdate(context, appInfoBean);
        }
    }

    public static String getFuncPermission(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getFuncPermission();
    }

    public static void setPermissionOk(Context context, String packageName, boolean b) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return;
        if(appInfoBean.getPermissionOk() == null || appInfoBean.getPermissionOk() != b) {
            appInfoBean.setPermissionOk(b);
            insertOrUpdate(context, appInfoBean);
        }
    }

    public static boolean getPermissionOk(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return false;
        if(appInfoBean.getPermissionOk() == null)
            return false;
        return appInfoBean.getPermissionOk();
    }

    public static String getFuncBackground(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getFuncBackground();
    }

    public static void setFuncBackground(Context context, String packageName, String s) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return;
        if(appInfoBean.getFuncBackground() == null || !appInfoBean.getFuncBackground().equals(s)) {
            appInfoBean.setFuncBackground(s);
            insertOrUpdate(context, appInfoBean);
        }
    }

    public static boolean getBackgroundRunning(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return false;
        if(appInfoBean.getIsBackgroundRunning() == null)
            return false;
        return appInfoBean.getIsBackgroundRunning();
    }

    public static void setBackgroundRunning(Context context, String packageName, boolean b) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return;
        appInfoBean.setIsBackgroundRunning(b);
        insertOrUpdate(context, appInfoBean);
    }

    public static String getFuncReport(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getFuncReport();
    }

    public static void setFuncReport(Context context, String packageName, String s) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return ;
        if(appInfoBean.getFuncReport() == null || !appInfoBean.getFuncReport().equals(s)) {
            appInfoBean.setFuncReport(s);
            insertOrUpdate(context, appInfoBean);
        }
    }

    public static String getFuncClear(Context context, String packageName) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return null;
        return appInfoBean.getFuncClear();
    }

    public static void setFuncClear(Context context, String packageName, String s) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null) appInfoBean = new AppInfoBean();
        if(appInfoBean.getFuncClear() == null || !appInfoBean.getFuncClear().equals(s)) {
            appInfoBean.setFuncClear(s);
            insertOrUpdate(context, appInfoBean);
        }
    }

    public static boolean getDataKitConnected(Context context, String packageName, boolean b) {
        AppInfoBean appInfoBean = read(context, packageName);
        if(appInfoBean == null)
            return false;
        if(appInfoBean.getDatakitConnected() == null)
            return false;
        return appInfoBean.getDatakitConnected();
    }

    public static void setDataKitConnected(Context context, String packageName, boolean b) {}

    public static void clearAccess(Context context, String packageName) {
        boolean flag = false;
        AppInfoBean a = read(context, packageName);
        if(a == null)
            return;
        if(a.getMcerebrumSupported() == null || a.getMcerebrumSupported()){
            a.setMcerebrumSupported(false);
            flag = true;
        }
        if(a.getFuncInitialize() != null){
            a.setFuncInitialize(null);
            flag = true;
        }
        a.setInitialized(false);
        if(a.getFuncUpdateInfo() != null){
            a.setFuncUpdateInfo(null);
            flag = true;
        }
        if(a.getFuncConfigure() != null){
            a.setFuncConfigure(null);
            flag = true;
        }
        if(a.getConfigured() == null || a.getConfigured()){
            a.setConfigured(false);
            flag = true;
        }
        if(a.getConfigureMatch() == null || a.getConfigureMatch()){
            a.setConfigureMatch(false);
            flag = true;
        }
        if(a.getFuncPermission() != null){
            a.setFuncPermission(null);
            flag = true;
        }
        if(a.getPermissionOk() == null || a.getPermissionOk()){
            a.setPermissionOk(false);
            flag = true;
        }
        if(a.getFuncBackground() != null){
            a.setFuncBackground(null);
            flag = true;
        }
        if(a.getBackgroundRunningTime() == null || a.getBackgroundRunningTime()){
            a.setBackgroundRunningTime(false);
            flag = true;
        }
        if(a.getIsBackgroundRunning() == null || a.getIsBackgroundRunning()){
            a.setIsBackgroundRunning(false);
            flag = true;
        }
        if(a.getFuncReport() != null){
            a.setFuncReport(null);
            flag = true;
        }
        if(a.getFuncClear() != null){
            a.setFuncClear(null);
            flag = true;
        }
        if(a.getDatakitConnected() == null || a.getDatakitConnected()){
            a.setDatakitConnected(false);
            flag = true;
        }
        if(flag)
            insertOrUpdate(context, a);
    }

    public static void deleteRow(Context context, String packageName) {
        try {
            SampleProviderSQLiteOpenHelper s = SampleProviderSQLiteOpenHelper.getInstance(context);
            SQLiteDatabase db = s.getWritableDatabase();
            String whereClause = AppInfoColumns.PACKAGE_NAME + "=?";
            String[] whereArgs = new String[]{packageName};
            int d = db.delete(AppInfoColumns.TABLE_NAME, whereClause, whereArgs);
            Log.d("abc","d=" + d);
        }catch (Exception ignored){
            Log.d("abc","abc");
        }
    }
}
