package com.android11.wallpager.pic.bean;

import java.util.List;

/**
 * Created by zhoukang on 2017/7/3.
 */

public class PicDetailBean {


    /**
     * id : zDFVEGflVFA
     * created_at : 2017-07-03T06:04:52-04:00
     * updated_at : 2017-07-03T23:04:40-04:00
     * width : 2000
     * height : 2437
     * color : #16191C
     * slug : null
     * downloads : 310
     * likes : 34
     * views : 12852
     * liked_by_user : false
     * description : null
     * exif : {"make":"Canon","model":"Canon EOS 100D","exposure_time":"1/4000","aperture":"6.3","focal_length":"41","iso":100}
     * location : {"title":"Lisbon, Portugal","name":"Lisbon","city":"Lisbon","country":"Portugal","position":{"latitude":38.7222524,"longitude":-9.13933659999998}}
     * current_user_collections : []
     * urls : {"raw":"https://images.unsplash.com/photo-1499076218749-7d639231170d","full":"https://images.unsplash.com/photo-1499076218749-7d639231170d?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=5ffe0779cee22d430ab33eb60a40f355","regular":"https://images.unsplash.com/photo-1499076218749-7d639231170d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=ad84f7329af952a6aef2ec3e200d5ad5","small":"https://images.unsplash.com/photo-1499076218749-7d639231170d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=896d34e7b7f93f2507eaa4850757239c","thumb":"https://images.unsplash.com/photo-1499076218749-7d639231170d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=8f5b1b827b43c16764538aa3838826c9"}
     * categories : []
     * links : {"self":"https://api.unsplash.com/photos/zDFVEGflVFA","html":"http://unsplash.com/photos/zDFVEGflVFA","download":"http://unsplash.com/photos/zDFVEGflVFA/download","download_location":"https://api.unsplash.com/photos/zDFVEGflVFA/download"}
     * user : {"id":"NBE_dppnu-0","updated_at":"2017-07-03T23:04:40-04:00","username":"joelfilip","name":"Joel Filipe","first_name":"Joel","last_name":"Filipe","twitter_username":"joelfilip","portfolio_url":"HTTP://joelfilipe.com","bio":"I am driven by a hunger for pixels, interfaces and beautiful web-based experiences. It would be awesome to see where my photos are being used. Show me: joelfilip@gmail.com Instagram: @joelfilip","location":"Madrid","total_likes":184,"total_photos":75,"total_collections":6,"profile_image":{"small":"https://images.unsplash.com/profile-1487585941294-a7378b997603?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=e6971067d0b24e8e5d903ab35441dbce","medium":"https://images.unsplash.com/profile-1487585941294-a7378b997603?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=9db6492ed8381982417006621f05eba2","large":"https://images.unsplash.com/profile-1487585941294-a7378b997603?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=36b397535985e38d8a6bf415d42e050d"},"links":{"self":"https://api.unsplash.com/users/joelfilip","html":"http://unsplash.com/@joelfilip","photos":"https://api.unsplash.com/users/joelfilip/photos","likes":"https://api.unsplash.com/users/joelfilip/likes","portfolio":"https://api.unsplash.com/users/joelfilip/portfolio","following":"https://api.unsplash.com/users/joelfilip/following","followers":"https://api.unsplash.com/users/joelfilip/followers"}}
     */

    private String id;
    private String created_at;
    private String updated_at;
    private int width;
    private int height;
    private String color;
    private Object slug;
    private int downloads;
    private int likes;
    private int views;
    private boolean liked_by_user;
    private Object description;
    private ExifBean exif;
    private LocationBean location;
    private UrlsBean urls;
    private LinksBean links;
    private UserBean user;
    private List<?> current_user_collections;
    private List<?> categories;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Object getSlug() {
        return slug;
    }

    public void setSlug(Object slug) {
        this.slug = slug;
    }

    public int getDownloads() {
        return downloads;
    }

    public void setDownloads(int downloads) {
        this.downloads = downloads;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public boolean isLiked_by_user() {
        return liked_by_user;
    }

    public void setLiked_by_user(boolean liked_by_user) {
        this.liked_by_user = liked_by_user;
    }

    public Object getDescription() {
        return description;
    }

    public void setDescription(Object description) {
        this.description = description;
    }

    public ExifBean getExif() {
        return exif;
    }

    public void setExif(ExifBean exif) {
        this.exif = exif;
    }

    public LocationBean getLocation() {
        return location;
    }

    public void setLocation(LocationBean location) {
        this.location = location;
    }

    public UrlsBean getUrls() {
        return urls;
    }

    public void setUrls(UrlsBean urls) {
        this.urls = urls;
    }

    public LinksBean getLinks() {
        return links;
    }

    public void setLinks(LinksBean links) {
        this.links = links;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public List<?> getCurrent_user_collections() {
        return current_user_collections;
    }

    public void setCurrent_user_collections(List<?> current_user_collections) {
        this.current_user_collections = current_user_collections;
    }

    public List<?> getCategories() {
        return categories;
    }

    public void setCategories(List<?> categories) {
        this.categories = categories;
    }

    public static class ExifBean {
        /**
         * make : Canon
         * model : Canon EOS 100D
         * exposure_time : 1/4000
         * aperture : 6.3
         * focal_length : 41
         * iso : 100
         */

        private String make;
        private String model;
        private String exposure_time;
        private String aperture;
        private String focal_length;
        private String iso;

        public String getMake() {
            return make;
        }

        public void setMake(String make) {
            this.make = make;
        }

        public String getModel() {
            return model;
        }

        public void setModel(String model) {
            this.model = model;
        }

        public String getExposure_time() {
            return exposure_time;
        }

        public void setExposure_time(String exposure_time) {
            this.exposure_time = exposure_time;
        }

        public String getAperture() {
            return aperture;
        }

        public void setAperture(String aperture) {
            this.aperture = aperture;
        }

        public String getFocal_length() {
            return focal_length;
        }

        public void setFocal_length(String focal_length) {
            this.focal_length = focal_length;
        }

        public String getIso() {
            return iso;
        }

        public void setIso(String iso) {
            this.iso = iso;
        }
    }

    public static class LocationBean {
        /**
         * title : Lisbon, Portugal
         * name : Lisbon
         * city : Lisbon
         * country : Portugal
         * position : {"latitude":38.7222524,"longitude":-9.13933659999998}
         */

        private String title;
        private String name;
        private String city;
        private String country;
        private PositionBean position;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public PositionBean getPosition() {
            return position;
        }

        public void setPosition(PositionBean position) {
            this.position = position;
        }

        public static class PositionBean {
            /**
             * latitude : 38.7222524
             * longitude : -9.13933659999998
             */

            private double latitude;
            private double longitude;

            public double getLatitude() {
                return latitude;
            }

            public void setLatitude(double latitude) {
                this.latitude = latitude;
            }

            public double getLongitude() {
                return longitude;
            }

            public void setLongitude(double longitude) {
                this.longitude = longitude;
            }
        }
    }

    public static class UrlsBean {
        /**
         * raw : https://images.unsplash.com/photo-1499076218749-7d639231170d
         * full : https://images.unsplash.com/photo-1499076218749-7d639231170d?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=5ffe0779cee22d430ab33eb60a40f355
         * regular : https://images.unsplash.com/photo-1499076218749-7d639231170d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=ad84f7329af952a6aef2ec3e200d5ad5
         * small : https://images.unsplash.com/photo-1499076218749-7d639231170d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=896d34e7b7f93f2507eaa4850757239c
         * thumb : https://images.unsplash.com/photo-1499076218749-7d639231170d?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=8f5b1b827b43c16764538aa3838826c9
         */

        private String raw;
        private String full;
        private String regular;
        private String small;
        private String thumb;

        public String getRaw() {
            return raw;
        }

        public void setRaw(String raw) {
            this.raw = raw;
        }

        public String getFull() {
            return full;
        }

        public void setFull(String full) {
            this.full = full;
        }

        public String getRegular() {
            return regular;
        }

        public void setRegular(String regular) {
            this.regular = regular;
        }

        public String getSmall() {
            return small;
        }

        public void setSmall(String small) {
            this.small = small;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }
    }

    public static class LinksBean {
        /**
         * self : https://api.unsplash.com/photos/zDFVEGflVFA
         * html : http://unsplash.com/photos/zDFVEGflVFA
         * download : http://unsplash.com/photos/zDFVEGflVFA/download
         * download_location : https://api.unsplash.com/photos/zDFVEGflVFA/download
         */

        private String self;
        private String html;
        private String download;
        private String download_location;

        public String getSelf() {
            return self;
        }

        public void setSelf(String self) {
            this.self = self;
        }

        public String getHtml() {
            return html;
        }

        public void setHtml(String html) {
            this.html = html;
        }

        public String getDownload() {
            return download;
        }

        public void setDownload(String download) {
            this.download = download;
        }

        public String getDownload_location() {
            return download_location;
        }

        public void setDownload_location(String download_location) {
            this.download_location = download_location;
        }
    }

    public static class UserBean {
        /**
         * id : NBE_dppnu-0
         * updated_at : 2017-07-03T23:04:40-04:00
         * username : joelfilip
         * name : Joel Filipe
         * first_name : Joel
         * last_name : Filipe
         * twitter_username : joelfilip
         * portfolio_url : HTTP://joelfilipe.com
         * bio : I am driven by a hunger for pixels, interfaces and beautiful web-based experiences. It would be awesome to see where my photos are being used. Show me: joelfilip@gmail.com Instagram: @joelfilip
         * location : Madrid
         * total_likes : 184
         * total_photos : 75
         * total_collections : 6
         * profile_image : {"small":"https://images.unsplash.com/profile-1487585941294-a7378b997603?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=e6971067d0b24e8e5d903ab35441dbce","medium":"https://images.unsplash.com/profile-1487585941294-a7378b997603?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=9db6492ed8381982417006621f05eba2","large":"https://images.unsplash.com/profile-1487585941294-a7378b997603?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=36b397535985e38d8a6bf415d42e050d"}
         * links : {"self":"https://api.unsplash.com/users/joelfilip","html":"http://unsplash.com/@joelfilip","photos":"https://api.unsplash.com/users/joelfilip/photos","likes":"https://api.unsplash.com/users/joelfilip/likes","portfolio":"https://api.unsplash.com/users/joelfilip/portfolio","following":"https://api.unsplash.com/users/joelfilip/following","followers":"https://api.unsplash.com/users/joelfilip/followers"}
         */

        private String id;
        private String updated_at;
        private String username;
        private String name;
        private String first_name;
        private String last_name;
        private String twitter_username;
        private String portfolio_url;
        private String bio;
        private String location;
        private int total_likes;
        private int total_photos;
        private int total_collections;
        private ProfileImageBean profile_image;
        private LinksBeanX links;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUpdated_at() {
            return updated_at;
        }

        public void setUpdated_at(String updated_at) {
            this.updated_at = updated_at;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getFirst_name() {
            return first_name;
        }

        public void setFirst_name(String first_name) {
            this.first_name = first_name;
        }

        public String getLast_name() {
            return last_name;
        }

        public void setLast_name(String last_name) {
            this.last_name = last_name;
        }

        public String getTwitter_username() {
            return twitter_username;
        }

        public void setTwitter_username(String twitter_username) {
            this.twitter_username = twitter_username;
        }

        public String getPortfolio_url() {
            return portfolio_url;
        }

        public void setPortfolio_url(String portfolio_url) {
            this.portfolio_url = portfolio_url;
        }

        public String getBio() {
            return bio;
        }

        public void setBio(String bio) {
            this.bio = bio;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public int getTotal_likes() {
            return total_likes;
        }

        public void setTotal_likes(int total_likes) {
            this.total_likes = total_likes;
        }

        public int getTotal_photos() {
            return total_photos;
        }

        public void setTotal_photos(int total_photos) {
            this.total_photos = total_photos;
        }

        public int getTotal_collections() {
            return total_collections;
        }

        public void setTotal_collections(int total_collections) {
            this.total_collections = total_collections;
        }

        public ProfileImageBean getProfile_image() {
            return profile_image;
        }

        public void setProfile_image(ProfileImageBean profile_image) {
            this.profile_image = profile_image;
        }

        public LinksBeanX getLinks() {
            return links;
        }

        public void setLinks(LinksBeanX links) {
            this.links = links;
        }

        public static class ProfileImageBean {
            /**
             * small : https://images.unsplash.com/profile-1487585941294-a7378b997603?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=e6971067d0b24e8e5d903ab35441dbce
             * medium : https://images.unsplash.com/profile-1487585941294-a7378b997603?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=9db6492ed8381982417006621f05eba2
             * large : https://images.unsplash.com/profile-1487585941294-a7378b997603?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=36b397535985e38d8a6bf415d42e050d
             */

            private String small;
            private String medium;
            private String large;

            public String getSmall() {
                return small;
            }

            public void setSmall(String small) {
                this.small = small;
            }

            public String getMedium() {
                return medium;
            }

            public void setMedium(String medium) {
                this.medium = medium;
            }

            public String getLarge() {
                return large;
            }

            public void setLarge(String large) {
                this.large = large;
            }
        }

        public static class LinksBeanX {
            /**
             * self : https://api.unsplash.com/users/joelfilip
             * html : http://unsplash.com/@joelfilip
             * photos : https://api.unsplash.com/users/joelfilip/photos
             * likes : https://api.unsplash.com/users/joelfilip/likes
             * portfolio : https://api.unsplash.com/users/joelfilip/portfolio
             * following : https://api.unsplash.com/users/joelfilip/following
             * followers : https://api.unsplash.com/users/joelfilip/followers
             */

            private String self;
            private String html;
            private String photos;
            private String likes;
            private String portfolio;
            private String following;
            private String followers;

            public String getSelf() {
                return self;
            }

            public void setSelf(String self) {
                this.self = self;
            }

            public String getHtml() {
                return html;
            }

            public void setHtml(String html) {
                this.html = html;
            }

            public String getPhotos() {
                return photos;
            }

            public void setPhotos(String photos) {
                this.photos = photos;
            }

            public String getLikes() {
                return likes;
            }

            public void setLikes(String likes) {
                this.likes = likes;
            }

            public String getPortfolio() {
                return portfolio;
            }

            public void setPortfolio(String portfolio) {
                this.portfolio = portfolio;
            }

            public String getFollowing() {
                return following;
            }

            public void setFollowing(String following) {
                this.following = following;
            }

            public String getFollowers() {
                return followers;
            }

            public void setFollowers(String followers) {
                this.followers = followers;
            }
        }
    }
}
