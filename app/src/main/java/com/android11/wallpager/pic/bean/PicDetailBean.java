package com.android11.wallpager.pic.bean;

import java.util.List;

/**
 * Created by zhoukang on 2017/7/3.
 */

public class PicDetailBean {


    /**
     * id : U8kQFsu9vzw
     * created_at : 2017-07-01T20:59:54-04:00
     * updated_at : 2017-07-02T22:34:29-04:00
     * width : 4093
     * height : 2426
     * color : #F4EEEB
     * slug : null
     * downloads : 634
     * likes : 84
     * views : 11
     * liked_by_user : false
     * description : null
     * exif : {"make":"Canon","model":"Canon EOS 5D","exposure_time":"30","aperture":null,"focal_length":null,"iso":1250}
     * current_user_collections : []
     * urls : {"raw":"https://images.unsplash.com/photo-1498957090711-6b3b32329fba","full":"https://images.unsplash.com/photo-1498957090711-6b3b32329fba?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=afccb0b2b58b4730038945e71bdd086a","regular":"https://images.unsplash.com/photo-1498957090711-6b3b32329fba?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=c8932111760dbb93c733be1b3fe57d71","small":"https://images.unsplash.com/photo-1498957090711-6b3b32329fba?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=cb6d9c3eba023ebe7bb0fbd74d8f84de","thumb":"https://images.unsplash.com/photo-1498957090711-6b3b32329fba?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=a0c7e22e3a7b6d393da61896368202de"}
     * categories : []
     * links : {"self":"https://api.unsplash.com/photos/U8kQFsu9vzw","html":"http://unsplash.com/photos/U8kQFsu9vzw","download":"http://unsplash.com/photos/U8kQFsu9vzw/download","download_location":"https://api.unsplash.com/photos/U8kQFsu9vzw/download"}
     * user : {"id":"WReBKGdTjw0","updated_at":"2017-07-02T22:34:29-04:00","username":"franciscomoreno","name":"Francisco  Moreno","first_name":"Francisco ","last_name":"Moreno","twitter_username":null,"portfolio_url":"http://www.instagram.com/sr_morenoo","bio":"","location":"Grazalema","total_likes":20,"total_photos":20,"total_collections":1,"profile_image":{"small":"https://images.unsplash.com/profile-1484175828587-c2c9c2e9b158?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=dd419f2929ab581f4fe4f5f61afe0561","medium":"https://images.unsplash.com/profile-1484175828587-c2c9c2e9b158?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=6f4cf5f524dcf86f949cf703b0fdbf10","large":"https://images.unsplash.com/profile-1484175828587-c2c9c2e9b158?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=c248982a63c9ad531b3cc828d9f7c98a"},"links":{"self":"https://api.unsplash.com/users/franciscomoreno","html":"http://unsplash.com/@franciscomoreno","photos":"https://api.unsplash.com/users/franciscomoreno/photos","likes":"https://api.unsplash.com/users/franciscomoreno/likes","portfolio":"https://api.unsplash.com/users/franciscomoreno/portfolio","following":"https://api.unsplash.com/users/franciscomoreno/following","followers":"https://api.unsplash.com/users/franciscomoreno/followers"}}
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
         * model : Canon EOS 5D
         * exposure_time : 30
         * aperture : null
         * focal_length : null
         * iso : 1250
         */

        private String make;
        private String model;
        private String exposure_time;
        private Object aperture;
        private Object focal_length;
        private int iso;

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

        public Object getAperture() {
            return aperture;
        }

        public void setAperture(Object aperture) {
            this.aperture = aperture;
        }

        public Object getFocal_length() {
            return focal_length;
        }

        public void setFocal_length(Object focal_length) {
            this.focal_length = focal_length;
        }

        public int getIso() {
            return iso;
        }

        public void setIso(int iso) {
            this.iso = iso;
        }
    }

    public static class UrlsBean {
        /**
         * raw : https://images.unsplash.com/photo-1498957090711-6b3b32329fba
         * full : https://images.unsplash.com/photo-1498957090711-6b3b32329fba?ixlib=rb-0.3.5&q=85&fm=jpg&crop=entropy&cs=srgb&s=afccb0b2b58b4730038945e71bdd086a
         * regular : https://images.unsplash.com/photo-1498957090711-6b3b32329fba?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=1080&fit=max&s=c8932111760dbb93c733be1b3fe57d71
         * small : https://images.unsplash.com/photo-1498957090711-6b3b32329fba?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=400&fit=max&s=cb6d9c3eba023ebe7bb0fbd74d8f84de
         * thumb : https://images.unsplash.com/photo-1498957090711-6b3b32329fba?ixlib=rb-0.3.5&q=80&fm=jpg&crop=entropy&cs=tinysrgb&w=200&fit=max&s=a0c7e22e3a7b6d393da61896368202de
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
         * self : https://api.unsplash.com/photos/U8kQFsu9vzw
         * html : http://unsplash.com/photos/U8kQFsu9vzw
         * download : http://unsplash.com/photos/U8kQFsu9vzw/download
         * download_location : https://api.unsplash.com/photos/U8kQFsu9vzw/download
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
         * id : WReBKGdTjw0
         * updated_at : 2017-07-02T22:34:29-04:00
         * username : franciscomoreno
         * name : Francisco  Moreno
         * first_name : Francisco
         * last_name : Moreno
         * twitter_username : null
         * portfolio_url : http://www.instagram.com/sr_morenoo
         * bio :
         * location : Grazalema
         * total_likes : 20
         * total_photos : 20
         * total_collections : 1
         * profile_image : {"small":"https://images.unsplash.com/profile-1484175828587-c2c9c2e9b158?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=dd419f2929ab581f4fe4f5f61afe0561","medium":"https://images.unsplash.com/profile-1484175828587-c2c9c2e9b158?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=6f4cf5f524dcf86f949cf703b0fdbf10","large":"https://images.unsplash.com/profile-1484175828587-c2c9c2e9b158?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=c248982a63c9ad531b3cc828d9f7c98a"}
         * links : {"self":"https://api.unsplash.com/users/franciscomoreno","html":"http://unsplash.com/@franciscomoreno","photos":"https://api.unsplash.com/users/franciscomoreno/photos","likes":"https://api.unsplash.com/users/franciscomoreno/likes","portfolio":"https://api.unsplash.com/users/franciscomoreno/portfolio","following":"https://api.unsplash.com/users/franciscomoreno/following","followers":"https://api.unsplash.com/users/franciscomoreno/followers"}
         */

        private String id;
        private String updated_at;
        private String username;
        private String name;
        private String first_name;
        private String last_name;
        private Object twitter_username;
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

        public Object getTwitter_username() {
            return twitter_username;
        }

        public void setTwitter_username(Object twitter_username) {
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
             * small : https://images.unsplash.com/profile-1484175828587-c2c9c2e9b158?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=32&w=32&s=dd419f2929ab581f4fe4f5f61afe0561
             * medium : https://images.unsplash.com/profile-1484175828587-c2c9c2e9b158?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=64&w=64&s=6f4cf5f524dcf86f949cf703b0fdbf10
             * large : https://images.unsplash.com/profile-1484175828587-c2c9c2e9b158?ixlib=rb-0.3.5&q=80&fm=jpg&crop=faces&cs=tinysrgb&fit=crop&h=128&w=128&s=c248982a63c9ad531b3cc828d9f7c98a
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
             * self : https://api.unsplash.com/users/franciscomoreno
             * html : http://unsplash.com/@franciscomoreno
             * photos : https://api.unsplash.com/users/franciscomoreno/photos
             * likes : https://api.unsplash.com/users/franciscomoreno/likes
             * portfolio : https://api.unsplash.com/users/franciscomoreno/portfolio
             * following : https://api.unsplash.com/users/franciscomoreno/following
             * followers : https://api.unsplash.com/users/franciscomoreno/followers
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
