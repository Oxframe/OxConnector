package cn.oxframe.connector;

import java.io.File;
import java.util.HashMap;

import cn.oxframe.connector.scheduler.SchedulerUtils;
import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

/**
 * cn.adair.client
 * Created by Administrator on 2018/12/6/006.
 * slight negligence may lead to great disaster~
 */
public class OxConnector {

    public static Observable<String> _Get(OxService iService, String iUri) {
        return iService._Get(iUri, new HashMap<String, Object>()).compose(new SchedulerUtils<String>().ioToMain());
    }

    public static Observable<String> _Get(OxService iService, String iUri, HashMap<String, Object> iParams) {
        return iService._Get(iUri, iParams).compose(new SchedulerUtils<String>().ioToMain());
    }

    public static Observable<String> _Post(OxService iService, String iUri, HashMap<String, Object> iParams) {
        return iService._Post(iUri, iParams).compose(new SchedulerUtils<String>().ioToMain());
    }

    public static Observable<String> _Upload(OxService iService, String iUri, HashMap<String, Object> iParams, File iFile) {
        RequestBody requestFile = RequestBody.create(MediaType.parse("image/jpg"), iFile);
        MultipartBody.Part iPart = MultipartBody.Part.createFormData("file", iFile.getName(), requestFile);
        return iService._Upload(iUri, iParams, iPart).compose(new SchedulerUtils<String>().ioToMain());
    }

}
