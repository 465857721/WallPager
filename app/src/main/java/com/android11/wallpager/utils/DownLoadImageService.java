package com.android11.wallpager.utils;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.Target;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import static android.R.attr.bitmap;

/**
 * Created by alvis on 2017/4/14.
 */

public class DownLoadImageService implements Runnable {
    public interface ImageDownLoadCallBack {
        void onDownLoadSuccess(File file);

        void onDownLoadSuccess(Bitmap bitmap);

        void onDownLoadFailed();
    }

    private String url;
    private Context context;
    private ImageDownLoadCallBack callBack;
    private File currentFile;

    public DownLoadImageService(Context context, String url, ImageDownLoadCallBack callBack) {
        this.url = url;
        this.callBack = callBack;
        this.context = context;
    }

    @Override
    public void run() {
        Bitmap bitmap = null;
        try {
//            file = Glide.with(context)
//                    .load(url)
//                    .downloadOnly(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
//                    .get();
//            bitmap = Glide.with(context)
//                    .load(url)
//                    .asBitmap()
//                    .into(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
//                    .get();

            bitmap = BitmapFactory.decodeFile(url);



            if (bitmap != null) {
                // 在这里执行图片保存方法
                saveImageToGallery(context, bitmap);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
//            if (file != null) {
//                callBack.onDownLoadSuccess(file);
//            } else {
//                callBack.onDownLoadFailed();
//            }
            if (bitmap != null && currentFile.exists()) {
                callBack.onDownLoadSuccess(bitmap);
            } else {
                callBack.onDownLoadFailed();
            }
        }
    }

    public void saveImageToGallery(Context context, Bitmap bmp) {
        // 首先保存图片
        File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsoluteFile();//注意小米手机必须这样获得public绝对路径
        String fileName = "android11/download";
        File appDir = new File(file, fileName);
        if (!appDir.exists()) {
            appDir.mkdirs();
        }
        String fileName1 = System.currentTimeMillis() + ".jpg";
        currentFile = new File(appDir, fileName1);

        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(currentFile);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                Uri.fromFile(new File(currentFile.getPath()))));
    }
}
