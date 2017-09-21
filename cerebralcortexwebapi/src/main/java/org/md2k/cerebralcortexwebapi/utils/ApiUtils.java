package org.md2k.cerebralcortexwebapi.utils;

import android.os.Environment;

import org.md2k.cerebralcortexwebapi.interfaces.CerebralCortexWebApi;
import org.md2k.utilities.Report.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public class ApiUtils {

    public static final String BASE_URL = "http://141.225.42.72:8088";

    public static CerebralCortexWebApi getCCService() {
        return RetrofitClient.getClient(BASE_URL).create(CerebralCortexWebApi.class);
    }



    public static final String writeResponseToDisk(ResponseBody body, String fileName){

        try{
            File minioObject = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), fileName);
            InputStream inputStream = null;
            OutputStream outputStream = null;
            try{
                byte[] fileReader = new byte[4096];
                long fileSize = body.contentLength();
                long fileSizeDownloaded = 0;

                inputStream = body.byteStream();
                outputStream = new FileOutputStream(minioObject);

                while (true){
                    int read = inputStream.read(fileReader);
                    if(read==-1){
                        break;
                    }

                    outputStream.write(fileReader, 0, read);
                    fileSizeDownloaded += read;
                    Log.d("CC Web API", "File Download: "+ fileSizeDownloaded+ " of "+fileSize);
                }
                outputStream.flush();

                return "Download Successful";
            }catch (IOException e){
                return e.getMessage();
            }finally {
                if(inputStream !=null){
                    inputStream.close();
                }
                if(outputStream!=null){
                    outputStream.close();
                }
            }
        }catch (IOException e){
            Log.d("abc","error...");
            return e.getMessage();
        }
    }

    public static MultipartBody.Part getUploadFileMultipart(String filePath){
        File file = new File(filePath);
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        MultipartBody.Part fileMultiBodyPart = MultipartBody.Part.createFormData("file", file.getName(), requestFile);
        return fileMultiBodyPart;
    }
}