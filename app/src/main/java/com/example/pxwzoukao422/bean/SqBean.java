package com.example.pxwzoukao422.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class SqBean {
      @Id
      Long id;
      @Unique
      String image;
      String name;
      @Generated(hash = 941362314)
      public SqBean(Long id, String image, String name) {
          this.id = id;
          this.image = image;
          this.name = name;
      }
      @Generated(hash = 761430409)
      public SqBean() {
      }
      public Long getId() {
          return this.id;
      }
      public void setId(Long id) {
          this.id = id;
      }
      public String getImage() {
          return this.image;
      }
      public void setImage(String image) {
          this.image = image;
      }
      public String getName() {
          return this.name;
      }
      public void setName(String name) {
          this.name = name;
      }

}
