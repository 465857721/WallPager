package com.android11.wallpager.utils;

/**
 * Created by zhoukang on 2017/6/29.
 */

public interface Const {
    //101 最新的作品https://api.unsplash.com/photos?
    // client_id=eb54e3b9dc12b9e0862b028b646085355d20b3442fbdfca4633ca0f7b01ef9a6
    // &page=1&per_page=15&order_by=latest
//    String CLIENT_ID = "6a844e0511f0db13c3b8af7ffedc9366f10299304dafcc3f097059e32252d13c";
//    String CLIENT_ID = "eb54e3b9dc12b9e0862b028b646085355d20b3442fbdfca4633ca0f7b01ef9a6";
//    String CLIENT_ID = "b13fe04d858ae66836b4e7a5dd00f7a78a90be528fb0c938cf2229c945db191b";
    String CLIENT_ID = "41f1f23556b01d63b1ae823bdf008cc32ce446f77c843e2daa2a80c770015df3";
    String BASEURL = "https://api.unsplash.com/";
    String LASTPHOTO = BASEURL + "photos";
    String COLLECTIONS = BASEURL + "collections/curated";
    String COLLECTIONS_ID = BASEURL + "collections/curated/%s/photos";

    String CURATEDPHOTO = BASEURL + "photos/curated";
    String PHOTODETAIL = BASEURL + "photos/";
}
