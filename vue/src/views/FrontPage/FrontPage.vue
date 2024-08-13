<template>
  <div class="front-container" m="t-4">
    <Carousel></Carousel>
    <Search></Search>
    <OurService></OurService>
    <HotSales></HotSales>
    <AboutUs />

    <div class="bottom-menu-container" >
      <div class="bottom-menu-box el-icon-location">
        地址: 贵州大学东校区
      </div>
      <div class="bottom-menu-box el-icon-phone">
        联系电话: 15731066755
      </div>
      <div class="bottom-menu-box el-icon-s-comment">
        邮箱: 2422745544@qq.com
      </div>

    </div>

</div>

</template>
<script>
import OurService from "./OurService";
import HotSales from "./HotSales";
import Search from "./Search";
import Carousel from "./Carousel";
import AboutUs from "./AboutUs";

export default {
  components:{
    Carousel,
    OurService,
    HotSales,
    Search,
    AboutUs
  },

};
</script>

<style lang="less" scoped>

.bottom-menu-container{
  background-color: #4ab344;
  height: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  .bottom-menu-box{
    width: 280px;
    color: #ffffff;
    font-size:20px;
    margin: 0px 80px;
    text-align: center;
  }
}
</style>
