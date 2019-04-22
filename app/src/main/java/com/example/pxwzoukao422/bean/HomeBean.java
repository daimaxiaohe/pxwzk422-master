package com.example.pxwzoukao422.bean;

import java.util.List;

public class HomeBean {

    private String message;
    private String status;
    private List<ResultBean> result;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {
        /**
         * collection : 32
         * id : 63
         * releaseTime : 1553064683000
         * share : 1
         * source : 哈哈网
         * summary : 我们不再依靠大量查询来寻求自己需要的知识，而是引导更多信息主动呈现在我们面前。
         * thumbnail : http://img.zhiding.cn/5/473/liiX2naemnf3A.jpg?rand=187
         * title : 脱离时代需求的搜索引擎，会不会被人工智能APP取代？
         * whetherAdvertising : 2
         * whetherCollection : 2
         * whetherPay : 2
         * infoAdvertisingVo : {"content":"八维教育","id":1,"pic":"http://mobile.bwstudent.com/images/tech/ad/bw.png","url":"http://www.bwie.com"}
         */

        private int collection;
        private int id;
        private long releaseTime;
        private int share;
        private String source;
        private String summary;
        private String thumbnail;
        private String title;
        private int whetherAdvertising;
        private int whetherCollection;
        private int whetherPay;
        private InfoAdvertisingVoBean infoAdvertisingVo;

        public int getCollection() {
            return collection;
        }

        public void setCollection(int collection) {
            this.collection = collection;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public long getReleaseTime() {
            return releaseTime;
        }

        public void setReleaseTime(long releaseTime) {
            this.releaseTime = releaseTime;
        }

        public int getShare() {
            return share;
        }

        public void setShare(int share) {
            this.share = share;
        }

        public String getSource() {
            return source;
        }

        public void setSource(String source) {
            this.source = source;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getThumbnail() {
            return thumbnail;
        }

        public void setThumbnail(String thumbnail) {
            this.thumbnail = thumbnail;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getWhetherAdvertising() {
            return whetherAdvertising;
        }

        public void setWhetherAdvertising(int whetherAdvertising) {
            this.whetherAdvertising = whetherAdvertising;
        }

        public int getWhetherCollection() {
            return whetherCollection;
        }

        public void setWhetherCollection(int whetherCollection) {
            this.whetherCollection = whetherCollection;
        }

        public int getWhetherPay() {
            return whetherPay;
        }

        public void setWhetherPay(int whetherPay) {
            this.whetherPay = whetherPay;
        }

        public InfoAdvertisingVoBean getInfoAdvertisingVo() {
            return infoAdvertisingVo;
        }

        public void setInfoAdvertisingVo(InfoAdvertisingVoBean infoAdvertisingVo) {
            this.infoAdvertisingVo = infoAdvertisingVo;
        }

        public static class InfoAdvertisingVoBean {
            /**
             * content : 八维教育
             * id : 1
             * pic : http://mobile.bwstudent.com/images/tech/ad/bw.png
             * url : http://www.bwie.com
             */

            private String content;
            private int id;
            private String pic;
            private String url;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }
        }
    }
}
