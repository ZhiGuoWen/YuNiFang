package com.wenzhiguo.yunifang.bean;

import java.util.List;

/**
 * Created by dell on 2017/3/17.
 */

public class HomeBean {

    private int code;
    private String msg;
    private DataBean data;

    @Override
    public String toString() {
        return "HomeBean{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {

        private ActivityInfoBean activityInfo;
        private boolean creditRecived;
        private List<SubjectsBean> subjects;
        private List<BestSellersBean> bestSellers;
        private List<Ad1Bean> ad1;
        private List<Ad5Bean> ad5;
        private List<DefaultGoodsListBean> defaultGoodsList;

        @Override
        public String toString() {
            return "DataBean{" +
                    "activityInfo=" + activityInfo +
                    ", creditRecived=" + creditRecived +
                    ", subjects=" + subjects +
                    ", bestSellers=" + bestSellers +
                    ", ad1=" + ad1 +
                    ", ad5=" + ad5 +
                    ", defaultGoodsList=" + defaultGoodsList +
                    '}';
        }

        public ActivityInfoBean getActivityInfo() {
            return activityInfo;
        }

        public void setActivityInfo(ActivityInfoBean activityInfo) {
            this.activityInfo = activityInfo;
        }

        public boolean isCreditRecived() {
            return creditRecived;
        }

        public void setCreditRecived(boolean creditRecived) {
            this.creditRecived = creditRecived;
        }

        public List<SubjectsBean> getSubjects() {
            return subjects;
        }

        public void setSubjects(List<SubjectsBean> subjects) {
            this.subjects = subjects;
        }

        public List<BestSellersBean> getBestSellers() {
            return bestSellers;
        }

        public void setBestSellers(List<BestSellersBean> bestSellers) {
            this.bestSellers = bestSellers;
        }

        public List<Ad1Bean> getAd1() {
            return ad1;
        }

        public void setAd1(List<Ad1Bean> ad1) {
            this.ad1 = ad1;
        }

        public List<Ad5Bean> getAd5() {
            return ad5;
        }

        public void setAd5(List<Ad5Bean> ad5) {
            this.ad5 = ad5;
        }

        public List<DefaultGoodsListBean> getDefaultGoodsList() {
            return defaultGoodsList;
        }

        public void setDefaultGoodsList(List<DefaultGoodsListBean> defaultGoodsList) {
            this.defaultGoodsList = defaultGoodsList;
        }

        public static class ActivityInfoBean {

            private String activityAreaDisplay;
            private List<ActivityInfoListBean> activityInfoList;

            @Override
            public String toString() {
                return "ActivityInfoBean{" +
                        "activityAreaDisplay='" + activityAreaDisplay + '\'' +
                        ", activityInfoList=" + activityInfoList +
                        '}';
            }

            public String getActivityAreaDisplay() {
                return activityAreaDisplay;
            }

            public void setActivityAreaDisplay(String activityAreaDisplay) {
                this.activityAreaDisplay = activityAreaDisplay;
            }

            public List<ActivityInfoListBean> getActivityInfoList() {
                return activityInfoList;
            }

            public void setActivityInfoList(List<ActivityInfoListBean> activityInfoList) {
                this.activityInfoList = activityInfoList;
            }

            public static class ActivityInfoListBean {

                private String id;
                private String activityImg;
                private String activityType;
                private String activityData;
                private String activityDataDetail;
                private String startSeconds;
                private String endSeconds;
                private String activityStatus;
                private String activityAreaDisplay;
                private String countDownEnable;
                private String starttime;
                private String endtime;
                private int sort;
                private String remark;

                @Override
                public String toString() {
                    return "ActivityInfoListBean{" +
                            "id='" + id + '\'' +
                            ", activityImg='" + activityImg + '\'' +
                            ", activityType='" + activityType + '\'' +
                            ", activityData='" + activityData + '\'' +
                            ", activityDataDetail='" + activityDataDetail + '\'' +
                            ", startSeconds='" + startSeconds + '\'' +
                            ", endSeconds='" + endSeconds + '\'' +
                            ", activityStatus='" + activityStatus + '\'' +
                            ", activityAreaDisplay='" + activityAreaDisplay + '\'' +
                            ", countDownEnable='" + countDownEnable + '\'' +
                            ", starttime='" + starttime + '\'' +
                            ", endtime='" + endtime + '\'' +
                            ", sort=" + sort +
                            ", remark='" + remark + '\'' +
                            '}';
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getActivityImg() {
                    return activityImg;
                }

                public void setActivityImg(String activityImg) {
                    this.activityImg = activityImg;
                }

                public String getActivityType() {
                    return activityType;
                }

                public void setActivityType(String activityType) {
                    this.activityType = activityType;
                }

                public String getActivityData() {
                    return activityData;
                }

                public void setActivityData(String activityData) {
                    this.activityData = activityData;
                }

                public String getActivityDataDetail() {
                    return activityDataDetail;
                }

                public void setActivityDataDetail(String activityDataDetail) {
                    this.activityDataDetail = activityDataDetail;
                }

                public String getStartSeconds() {
                    return startSeconds;
                }

                public void setStartSeconds(String startSeconds) {
                    this.startSeconds = startSeconds;
                }

                public String getEndSeconds() {
                    return endSeconds;
                }

                public void setEndSeconds(String endSeconds) {
                    this.endSeconds = endSeconds;
                }

                public String getActivityStatus() {
                    return activityStatus;
                }

                public void setActivityStatus(String activityStatus) {
                    this.activityStatus = activityStatus;
                }

                public String getActivityAreaDisplay() {
                    return activityAreaDisplay;
                }

                public void setActivityAreaDisplay(String activityAreaDisplay) {
                    this.activityAreaDisplay = activityAreaDisplay;
                }

                public String getCountDownEnable() {
                    return countDownEnable;
                }

                public void setCountDownEnable(String countDownEnable) {
                    this.countDownEnable = countDownEnable;
                }

                public String getStarttime() {
                    return starttime;
                }

                public void setStarttime(String starttime) {
                    this.starttime = starttime;
                }

                public String getEndtime() {
                    return endtime;
                }

                public void setEndtime(String endtime) {
                    this.endtime = endtime;
                }

                public int getSort() {
                    return sort;
                }

                public void setSort(int sort) {
                    this.sort = sort;
                }

                public String getRemark() {
                    return remark;
                }

                public void setRemark(String remark) {
                    this.remark = remark;
                }
            }
        }

        public static class SubjectsBean {

            private String id;
            private String title;
            private String detail;
            private String image;
            private String start_time;
            private String end_time;
            private int show_number;
            private String state;
            private int sort;
            private List<GoodsListBean> goodsList;
            private List<String> goodsIdsList;

            @Override
            public String toString() {
                return "SubjectsBean{" +
                        "id='" + id + '\'' +
                        ", title='" + title + '\'' +
                        ", detail='" + detail + '\'' +
                        ", image='" + image + '\'' +
                        ", start_time='" + start_time + '\'' +
                        ", end_time='" + end_time + '\'' +
                        ", show_number=" + show_number +
                        ", state='" + state + '\'' +
                        ", sort=" + sort +
                        ", goodsList=" + goodsList +
                        ", goodsIdsList=" + goodsIdsList +
                        '}';
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getDetail() {
                return detail;
            }

            public void setDetail(String detail) {
                this.detail = detail;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public String getStart_time() {
                return start_time;
            }

            public void setStart_time(String start_time) {
                this.start_time = start_time;
            }

            public String getEnd_time() {
                return end_time;
            }

            public void setEnd_time(String end_time) {
                this.end_time = end_time;
            }

            public int getShow_number() {
                return show_number;
            }

            public void setShow_number(int show_number) {
                this.show_number = show_number;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public List<GoodsListBean> getGoodsList() {
                return goodsList;
            }

            public void setGoodsList(List<GoodsListBean> goodsList) {
                this.goodsList = goodsList;
            }

            public List<String> getGoodsIdsList() {
                return goodsIdsList;
            }

            public void setGoodsIdsList(List<String> goodsIdsList) {
                this.goodsIdsList = goodsIdsList;
            }

            public static class GoodsListBean {

                private String id;
                private String goods_name;
                private double shop_price;
                private int market_price;
                private String goods_img;
                private boolean reservable;
                private String efficacy;

                @Override
                public String toString() {
                    return "GoodsListBean{" +
                            "id='" + id + '\'' +
                            ", goods_name='" + goods_name + '\'' +
                            ", shop_price=" + shop_price +
                            ", market_price=" + market_price +
                            ", goods_img='" + goods_img + '\'' +
                            ", reservable=" + reservable +
                            ", efficacy='" + efficacy + '\'' +
                            '}';
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getGoods_name() {
                    return goods_name;
                }

                public void setGoods_name(String goods_name) {
                    this.goods_name = goods_name;
                }

                public double getShop_price() {
                    return shop_price;
                }

                public void setShop_price(double shop_price) {
                    this.shop_price = shop_price;
                }

                public int getMarket_price() {
                    return market_price;
                }

                public void setMarket_price(int market_price) {
                    this.market_price = market_price;
                }

                public String getGoods_img() {
                    return goods_img;
                }

                public void setGoods_img(String goods_img) {
                    this.goods_img = goods_img;
                }

                public boolean isReservable() {
                    return reservable;
                }

                public void setReservable(boolean reservable) {
                    this.reservable = reservable;
                }

                public String getEfficacy() {
                    return efficacy;
                }

                public void setEfficacy(String efficacy) {
                    this.efficacy = efficacy;
                }
            }
        }

        public static class BestSellersBean {
            /**
             * id : 2
             * name : 本周热销
             * descript : 1
             * state : 1
             * show_number : 6
             * begin_date : 2017.02.15 09:56:58
             * end_date : 2017.06.15 10:00:00
             * goodsList : [{"id":"6","goods_name":"好用不贵丨亮颜水润蚕丝面膜（寂地定制版）","shop_price":59.9,"market_price":239.9,"goods_img":"http://image.hmeili.com/yunifang/images/goods/6/goods_img/160819084594721181484473699.jpg","reservable":false,"efficacy":"深层补水 提亮肤色"},{"id":"189","goods_name":"热销套装丨清爽平衡护肤三件套","shop_price":99.9,"market_price":179.9,"goods_img":"http://image.hmeili.com/yunifang/images/goods/189/goods_img/160819091183119066095185335.jpg","reservable":false,"efficacy":"深层清洁 平衡水油"},{"id":"85","goods_name":"果味鲜饮|水果鲜润亮肤补水面膜套装17片","shop_price":59.9,"market_price":240,"goods_img":"http://image.hmeili.com/yunifang/images/goods/85/goods_img/160819085747012099748482408.jpg","reservable":false,"efficacy":"水嫩舒爽 鲜活亮颜"},{"id":"5","goods_name":"黑眼圈不见啦丨金桂花矿物眼膜贴60片","shop_price":69,"market_price":89,"goods_img":"http://image.hmeili.com/yunifang/images/goods/5/goods_img/16081908444051052195086751.jpg","reservable":false,"efficacy":"补水靓眼 改善熊猫眼"},{"id":"428","goods_name":"多彩水润亮颜蚕丝面膜套装21片","shop_price":79.9,"market_price":270.9,"goods_img":"http://image.hmeili.com/yunifang/images/goods/428/goods_img/160819094034113421009937866.jpg","reservable":false,"efficacy":"吸黑焕彩 补水保湿"},{"id":"1234","goods_name":"热销|樱桃鲜润补水矿物面膜7片","shop_price":39.9,"market_price":99,"goods_img":"http://image.hmeili.com/yunifang/images/goods/1234/goods_img/161122183456315727984418108.jpg","reservable":false,"efficacy":"补水保湿 润泽滋养"},{"id":"446","goods_name":"芦荟补水保湿凝胶150g","shop_price":49.9,"market_price":59,"goods_img":"http://image.hmeili.com/yunifang/images/goods/446/goods_img/16081909409518953549635059.jpg","reservable":false,"efficacy":"水水润润 修护受损"},{"id":"14","goods_name":"矿物泥浆鼻膜60g","shop_price":55,"market_price":69,"goods_img":"http://image.hmeili.com/yunifang/images/goods/14/goods_img/160819084841216186223194195.jpg","reservable":false,"efficacy":"草莓鼻小救星 收敛毛孔"},{"id":"9","goods_name":"玫瑰滋养矿物睡眠面膜180g","shop_price":59.9,"market_price":79.9,"goods_img":"http://image.hmeili.com/yunifang/images/goods/9/goods_img/160819084569920890610621654.jpg","reservable":false,"efficacy":"镇店之宝 彻夜补水"}]
             * goodsIdsList : ["6","189","85","5","428","1234","446","14","9"]
             */

            private String id;
            private String name;
            private String descript;
            private String state;
            private int show_number;
            private String begin_date;
            private String end_date;
            private List<GoodsListBeanX> goodsList;
            private List<String> goodsIdsList;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescript() {
                return descript;
            }

            public void setDescript(String descript) {
                this.descript = descript;
            }

            public String getState() {
                return state;
            }

            public void setState(String state) {
                this.state = state;
            }

            public int getShow_number() {
                return show_number;
            }

            public void setShow_number(int show_number) {
                this.show_number = show_number;
            }

            public String getBegin_date() {
                return begin_date;
            }

            public void setBegin_date(String begin_date) {
                this.begin_date = begin_date;
            }

            public String getEnd_date() {
                return end_date;
            }

            public void setEnd_date(String end_date) {
                this.end_date = end_date;
            }

            public List<GoodsListBeanX> getGoodsList() {
                return goodsList;
            }

            public void setGoodsList(List<GoodsListBeanX> goodsList) {
                this.goodsList = goodsList;
            }

            public List<String> getGoodsIdsList() {
                return goodsIdsList;
            }

            public void setGoodsIdsList(List<String> goodsIdsList) {
                this.goodsIdsList = goodsIdsList;
            }

            public static class GoodsListBeanX {
                /**
                 * id : 6
                 * goods_name : 好用不贵丨亮颜水润蚕丝面膜（寂地定制版）
                 * shop_price : 59.9
                 * market_price : 239.9
                 * goods_img : http://image.hmeili.com/yunifang/images/goods/6/goods_img/160819084594721181484473699.jpg
                 * reservable : false
                 * efficacy : 深层补水 提亮肤色
                 */

                private String id;
                private String goods_name;
                private double shop_price;
                private double market_price;
                private String goods_img;
                private boolean reservable;
                private String efficacy;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getGoods_name() {
                    return goods_name;
                }

                public void setGoods_name(String goods_name) {
                    this.goods_name = goods_name;
                }

                public double getShop_price() {
                    return shop_price;
                }

                public void setShop_price(double shop_price) {
                    this.shop_price = shop_price;
                }

                public double getMarket_price() {
                    return market_price;
                }

                public void setMarket_price(double market_price) {
                    this.market_price = market_price;
                }

                public String getGoods_img() {
                    return goods_img;
                }

                public void setGoods_img(String goods_img) {
                    this.goods_img = goods_img;
                }

                public boolean isReservable() {
                    return reservable;
                }

                public void setReservable(boolean reservable) {
                    this.reservable = reservable;
                }

                public String getEfficacy() {
                    return efficacy;
                }

                public void setEfficacy(String efficacy) {
                    this.efficacy = efficacy;
                }
            }
        }

        public static class Ad1Bean {
            /**
             * id : 884
             * image : https://image.yunifang.com/yunifang/images/goods/ad0/1703161916873522694824818.jpg
             * ad_type : 0
             * sort : 1058
             * position : 0
             * enabled : 1
             * createtime : 2017.03.16 18:54:53
             * createuser : hani
             * ad_type_dynamic : 2
             * ad_type_dynamic_data : 189
             * ad_type_dynamic_detail : 189
             * show_channel : 1,2
             * channelType : 1
             * title : 蒸汽眼罩
             */

            private String id;
            private String image;
            private int ad_type;
            private int sort;
            private int position;
            private int enabled;
            private String createtime;
            private String createuser;
            private String ad_type_dynamic;
            private String ad_type_dynamic_data;
            private String ad_type_dynamic_detail;
            private String show_channel;
            private String channelType;
            private String title;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getAd_type() {
                return ad_type;
            }

            public void setAd_type(int ad_type) {
                this.ad_type = ad_type;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public int getEnabled() {
                return enabled;
            }

            public void setEnabled(int enabled) {
                this.enabled = enabled;
            }

            public String getCreatetime() {
                return createtime;
            }

            public void setCreatetime(String createtime) {
                this.createtime = createtime;
            }

            public String getCreateuser() {
                return createuser;
            }

            public void setCreateuser(String createuser) {
                this.createuser = createuser;
            }

            public String getAd_type_dynamic() {
                return ad_type_dynamic;
            }

            public void setAd_type_dynamic(String ad_type_dynamic) {
                this.ad_type_dynamic = ad_type_dynamic;
            }

            public String getAd_type_dynamic_data() {
                return ad_type_dynamic_data;
            }

            public void setAd_type_dynamic_data(String ad_type_dynamic_data) {
                this.ad_type_dynamic_data = ad_type_dynamic_data;
            }

            public String getAd_type_dynamic_detail() {
                return ad_type_dynamic_detail;
            }

            public void setAd_type_dynamic_detail(String ad_type_dynamic_detail) {
                this.ad_type_dynamic_detail = ad_type_dynamic_detail;
            }

            public String getShow_channel() {
                return show_channel;
            }

            public void setShow_channel(String show_channel) {
                this.show_channel = show_channel;
            }

            public String getChannelType() {
                return channelType;
            }

            public void setChannelType(String channelType) {
                this.channelType = channelType;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }
        }

        public static class Ad5Bean {
            /**
             * id : 359
             * image : http://image.hmeili.com/yunifang/images/goods/ad0/160823172997710201253418883.png
             * ad_type : 4
             * sort : 106
             * position : 5
             * enabled : 0
             * ad_type_dynamic : 1
             * ad_type_dynamic_data : http://h.yunifang.com/sign/sign.html?login_check=2
             * ad_type_dynamic_detail : http%3A%2F%2Fh.yunifang.com%2Fsign%2Fsign.html%3Flogin_check%3D2
             * show_channel : 1,2
             * title : 每日签到
             * url : http://mobile.hmeili.com/yunifang/web/member/gift
             */

            private String id;
            private String image;
            private int ad_type;
            private int sort;
            private int position;
            private int enabled;
            private String ad_type_dynamic;
            private String ad_type_dynamic_data;
            private String ad_type_dynamic_detail;
            private String show_channel;
            private String title;
            private String url;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getImage() {
                return image;
            }

            public void setImage(String image) {
                this.image = image;
            }

            public int getAd_type() {
                return ad_type;
            }

            public void setAd_type(int ad_type) {
                this.ad_type = ad_type;
            }

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public int getPosition() {
                return position;
            }

            public void setPosition(int position) {
                this.position = position;
            }

            public int getEnabled() {
                return enabled;
            }

            public void setEnabled(int enabled) {
                this.enabled = enabled;
            }

            public String getAd_type_dynamic() {
                return ad_type_dynamic;
            }

            public void setAd_type_dynamic(String ad_type_dynamic) {
                this.ad_type_dynamic = ad_type_dynamic;
            }

            public String getAd_type_dynamic_data() {
                return ad_type_dynamic_data;
            }

            public void setAd_type_dynamic_data(String ad_type_dynamic_data) {
                this.ad_type_dynamic_data = ad_type_dynamic_data;
            }

            public String getAd_type_dynamic_detail() {
                return ad_type_dynamic_detail;
            }

            public void setAd_type_dynamic_detail(String ad_type_dynamic_detail) {
                this.ad_type_dynamic_detail = ad_type_dynamic_detail;
            }

            public String getShow_channel() {
                return show_channel;
            }

            public void setShow_channel(String show_channel) {
                this.show_channel = show_channel;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }

        public static class DefaultGoodsListBean {
            /**
             * id : 121
             * goods_name : 镇店之宝丨美白嫩肤面膜7片
             * shop_price : 49.9
             * market_price : 99
             * goods_img : https://image.yunifang.com/yunifang/images/goods/121/goods_img/170301091610311632161123479.jpg
             * reservable : false
             * efficacy : 镇店之宝 美白爆款
             */

            private String id;
            private String goods_name;
            private double shop_price;
            private int market_price;
            private String goods_img;
            private boolean reservable;
            private String efficacy;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getGoods_name() {
                return goods_name;
            }

            public void setGoods_name(String goods_name) {
                this.goods_name = goods_name;
            }

            public double getShop_price() {
                return shop_price;
            }

            public void setShop_price(double shop_price) {
                this.shop_price = shop_price;
            }

            public int getMarket_price() {
                return market_price;
            }

            public void setMarket_price(int market_price) {
                this.market_price = market_price;
            }

            public String getGoods_img() {
                return goods_img;
            }

            public void setGoods_img(String goods_img) {
                this.goods_img = goods_img;
            }

            public boolean isReservable() {
                return reservable;
            }

            public void setReservable(boolean reservable) {
                this.reservable = reservable;
            }

            public String getEfficacy() {
                return efficacy;
            }

            public void setEfficacy(String efficacy) {
                this.efficacy = efficacy;
            }
        }
    }
}
