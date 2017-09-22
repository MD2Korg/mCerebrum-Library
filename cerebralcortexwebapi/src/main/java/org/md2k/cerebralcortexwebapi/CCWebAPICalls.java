package org.md2k.cerebralcortexwebapi;

import android.widget.TextView;

import org.md2k.cerebralcortexwebapi.interfaces.CerebralCortexWebApi;
import org.md2k.cerebralcortexwebapi.models.AuthRequest;
import org.md2k.cerebralcortexwebapi.models.AuthResponse;
import org.md2k.cerebralcortexwebapi.models.MinioBucket;
import org.md2k.cerebralcortexwebapi.models.MinioBucketsList;
import org.md2k.cerebralcortexwebapi.models.MinioObjectStats;
import org.md2k.cerebralcortexwebapi.models.MinioObjectsListInBucket;
import org.md2k.cerebralcortexwebapi.models.stream.DataStream;
import org.md2k.cerebralcortexwebapi.utils.ApiUtils;

import java.io.IOException;
import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Call;

/**
 * Created by ali on 9/21/17.
 */

public class CCWebAPICalls {

    private TextView output;
    private CerebralCortexWebApi ccService;

    public CCWebAPICalls(CerebralCortexWebApi ccService) {
        this.output = null;
        this.ccService = ccService;
    }

    public AuthResponse authenticateUser(String userName, String userPassword) {

        AuthRequest authRequest = new AuthRequest(userName, userPassword);
        Call<AuthResponse> call = ccService.authenticateUser(authRequest);

        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new AuthResponse("Authorization exception occurred");

//        ccService.authenticateUser(authRequest).enqueue(new Callback<AuthResponse>() {
//            @Override
//            public void onResponse(Call<AuthResponse> call, Response<AuthResponse> response) {
//                if(response.isSuccessful()) {
//                    output.append(response.body().getAccessToken().toString());
//                    output.append("\n\n\n");
//                    Log.d("UserAuthentication", "User authenticated ("+authRequest.getEmailId()+")");
//                }else {
//                    Gson gson = new Gson();
//                    CCApiErrorMessage errorBody =gson.fromJson(response.errorBody().charStream(),CCApiErrorMessage.class);
//                    output.append("Not successful "+errorBody.getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<AuthResponse> call, Throwable t) {
//                output.append("Failed "+t.getMessage());
//                Log.d("Failed", "On Failure "+t.getMessage());
//
//            }
//        });
    }


    public List<MinioBucket> getMinioBuckets(String accessToken) {

        Call<MinioBucketsList> call = ccService.bucketsList(accessToken);

        try {
            return call.execute().body().getMinioBuckets();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

//        ccService.bucketsList(accessToken).enqueue(new Callback<MinioBucketsList>() {
//            @Override
//            public void onResponse(Call<MinioBucketsList> call, Response<MinioBucketsList> response) {
//                if(response.isSuccessful()) {
//                    List<MinioBucket> minioBuckets = response.body().getMinioBuckets();
//                    for (MinioBucket b: minioBuckets){
//                        output.append("MinioBucket Name -> "+b.getBucketName().toString()+"  ---  ");
//                        output.append("Last Modified -> "+b.getLastModified().toString()+"\n");
//                    }
//                }else {
//                    Gson gson = new Gson();
//                    CCApiErrorMessage errorBody =gson.fromJson(response.errorBody().charStream(),CCApiErrorMessage.class);
//                    output.append("Not successful "+errorBody.getMessage());
//                    // handle request errors depending on status code
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MinioBucketsList> call, Throwable t) {
//                output.append("Failed "+t.getMessage());
//                Log.d("Failed", "On Failure "+t.getMessage());
//
//            }
//        });
    }

    public List<MinioObjectStats> getObjectsInBucket(String accessToken, String bucketName) {


        Call<MinioObjectsListInBucket> call = ccService.objectsListInBucket(accessToken, bucketName);

        try {
            return call.execute().body().getBucketObjects();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

//        ccService.objectsListInBucket(accessToken, bucketName).enqueue(new Callback<MinioObjectsListInBucket>() {
//            @Override
//            public void onResponse(Call<MinioObjectsListInBucket> call, Response<MinioObjectsListInBucket> response) {
//                if (response.isSuccessful()) {
//                    List<MinioObjectStats> objectz = response.body().getBucketObjects();
//                    for (MinioObjectStats b : objectz) {
//                        output.append("Object Name -> " + b.getObjectName() + "  ---  ");
//                        output.append("Content Type -> " + b.getContentType() + "\n");
//                    }
//                } else {
//                    Gson gson = new Gson();
//                    CCApiErrorMessage errorBody = gson.fromJson(response.errorBody().charStream(), CCApiErrorMessage.class);
//                    output.append("Not successful " + errorBody.getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MinioObjectsListInBucket> call, Throwable t) {
//                output.append("Failed " + t.getMessage());
//                Log.d("Failed", "On Failure " + t.getMessage());
//
//            }
//        });
    }

    public MinioObjectStats getObjectStats(String accessToken, String bucketName, String objectName) {


        Call<MinioObjectStats> call = ccService.getMinioObjectStats(accessToken, bucketName, objectName);

        try {
            return call.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
//
//        ccService.getMinioObjectStats(accessToken, bucketName, objectName).enqueue(new Callback<MinioObjectStats>() {
//            @Override
//            public void onResponse(Call<MinioObjectStats> call, Response<MinioObjectStats> response) {
//                if (response.isSuccessful()) {
//                    output.append("Object Name -> " + response.body().getObjectName() + "  ---  ");
//                    output.append("Content Type -> " + response.body().getContentType() + "  --- ");
//                    output.append("Etag -> " + response.body().getEtag() + "  --- ");
//                    output.append("Size -> " + response.body().getSize() + "  \n\n ");
//                } else {
//                    Gson gson = new Gson();
//                    CCApiErrorMessage errorBody = gson.fromJson(response.errorBody().charStream(), CCApiErrorMessage.class);
//                    output.append("Not successful " + errorBody.getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<MinioObjectStats> call, Throwable t) {
//                output.append("Failed " + t.getMessage());
//                Log.d("Failed", "On Failure " + t.getMessage());
//
//            }
//        });
    }

    public Boolean downloadMinioObject(String accessToken, String bucketName, String objectName, String outputFileName) {


        Call<ResponseBody> call = ccService.downloadMinioObject(accessToken, bucketName, objectName);

        try {
            return ApiUtils.writeResponseToDisk(call.execute().body(), outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }


//        ccService.downloadMinioObject(accessToken, bucketName, objectName).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.isSuccessful()) {
//                    output.append("Download Started -> " + response.body());
//                    String fileName = objectName;
//                    String downloadStatus = ApiUtils.writeResponseToDisk(response.body(), fileName);
//                    Log.d("abc", "\n\nDownload Status -> " + downloadStatus + "\n\n\n");
//                    output.append("\n\nDownload Status -> " + downloadStatus + "\n\n\n");
//                } else {
//                    Gson gson = new Gson();
//                    CCApiErrorMessage errorBody = gson.fromJson(response.errorBody().charStream(), CCApiErrorMessage.class);
//                    output.append("Not successful " + errorBody.getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                output.append("Failed " + t.getMessage());
//                Log.d("Failed", "On Failure " + t.getMessage());
//
//            }
//        });
    }


    public Boolean putArchiveDataAndMetadata(String accessToken, DataStream metadata, String filePath) {

        MultipartBody.Part fileMultiBodyPart = ApiUtils.getUploadFileMultipart(filePath);

        Call<ResponseBody> call = ccService.putArchiveDataStreamWithMetadata(accessToken, metadata, fileMultiBodyPart);

        try {
            return call.execute().isSuccessful();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

//        ccService.putArchiveDataStreamWithMetadata(accessToken, dataStreamMetadata, fileMultiBodyPart).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.isSuccessful()) {
//                    output.append("\n\nUpload Completed ");
//                } else {
//                    Gson gson = new Gson();
//                    CCApiErrorMessage errorBody = gson.fromJson(response.errorBody().charStream(), CCApiErrorMessage.class);
//                    output.append("Not successful " + errorBody.getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                output.append("Failed " + t.getMessage());
//                Log.d("Failed", "On Failure " + t.getMessage());
//
//            }
//        });
    }

//    public void putRawStream(String accessToken) {
//
//        MetadataBuilder metadataBuilder = new MetadataBuilder();
//
//        DataStream rawDataStreamMetadata = metadataBuilder.buildDataStreamMetadata("datastream", "33", "88", "sampleStream", "raw");
//
//        ccService.putRawDataStreamWithMetadata(accessToken, rawDataStreamMetadata).enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.isSuccessful()) {
//                    output.append("\n\nUpload Raw Stream Completed ");
//                } else {
//                    Gson gson = new Gson();
//                    CCApiErrorMessage errorBody = gson.fromJson(response.errorBody().charStream(), CCApiErrorMessage.class);
//                    output.append("Not successful " + errorBody.getMessage());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                output.append("Failed " + t.getMessage());
//                Log.d("Failed", "On Failure " + t.getMessage());
//
//            }
//        });
//    }
}
