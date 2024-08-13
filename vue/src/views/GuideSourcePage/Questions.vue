<template>
  <div class="questions-container">
    <Subtitle subtitle="常见问题" description="大家都在问的问题哦~"  style="margin-top:100px;"/>
    <div class="questions">
      <el-card
          v-for="(item,index) in cardList" :key="index"
          class="card"
          :style="{ backgroundImage: 'url(' + require('@/assets/page5/' + item.img) + ')' }"
          @click="handleTopicDetail('苹果果树种植方法')"
      >
        <div class="card-content">
          <span>{{ item.title }}</span>
        </div>
      </el-card>
  </div>
  </div>
</template>

<script>
import Subtitle from "../../components/Subtitle";
import GuideSource from "./GuideSource";

export default {
  name: "Questions",
  components:{
    Subtitle,

  },
  data() {
    return {
      cardList: [
        { id: 0, title: "苹果果树种植方法", img:"apple.png" },
        { id: 1, title: "新疆哈密瓜甜度控制", img:"melon.png"},
        { id: 2, title: "玉米苗灌溉", img: "corn.png" }
      ],
      searchValue: ""
    };
  },
  methods:{
    detailsClick(item) {
      this.$store.commit("updateOrderId", item);
      this.$router.push(`/home/details?id=${item.id}`).catch((err) => err);
    },
    pageClick(val){
      this.$emit('pageClick',val)
    },
    handleSearch(){
      this.$emit('handleSearch',this.searchValue)
    },
    handleDetail(item){
      this.$router.push(`/home/guide/${item.id}`)
    },
    handleTopicDetail(val){
      this.searchValue = val
      this.handleSearch()
    }
  }
}
</script>

<style scoped>
.questions-container{
  text-align: center;

}

.questions{
  width: 100%;
  display: flex;
  align-items: center;
  padding-left: 15%;
  padding-right: 15%;
  gap:5%;
  flex-wrap: nowrap;
}
.card{
  border-radius: 5px;
  width: 300px;
  height: 200px;
  cursor: pointer;
  display: flex;
  background-size:100% 100% ;
  align-items: center;
  justify-content: center;
  font-weight: bold;
  font-size: 20px;
  font-family: 鸿蒙字体Regular;
}
.card-content{
  width: 100%;
  height: 50px;
  display: flex;
  align-items: center;
  justify-content: center;
  color: #f1f1f1;
}

::v-deep .el-card{
  border-radius: 10px;
  background-color: #f1f1f1;
  box-shadow: 0px 0px 10px #959595;
}

::v-deep .el-card:hover{
  border-radius: 10px;
  box-shadow: 0px 0px 20px #828282;
}

</style>
