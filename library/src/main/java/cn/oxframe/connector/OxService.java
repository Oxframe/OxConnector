package cn.oxframe.connector;


import java.util.HashMap;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * com.yidao.media.request
 * Created by Administrator on 2018/5/25/025.
 * slight negligence may lead to great disaster~
 */
public interface OxService {

    @GET
    Observable<String> _Get(@Url String _Uri, @QueryMap HashMap<String, Object> _Params);

    @POST
    Observable<String> _Post(@Url String _Uri, @QueryMap HashMap<String, Object> _Params);

    /**
     * Upload 图片上传使用
     *
     * @Body @Part 不能同时使用
     * @Body parameters cannot be used with form or multi-part encoding.
     */
    @POST
    @Multipart
    Observable<String> _Upload(@Url String _Uri, @QueryMap HashMap<String, Object> _Params, @Part MultipartBody.Part _Part);

}
