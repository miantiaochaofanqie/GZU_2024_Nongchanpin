<template>
  <div class="Background">
    <div id="myChart" :style="{ width: '800px', height: '500px',marginTop: '50px'}"></div>
  </div>
</template>

<script>
import { Report } from "@/api/Report";

export default {
  name: "Pc2FbEcharts",

  data() {
    return {
      roleData: null, // 存储原始数据
    };
  },

  mounted() {
    this.fetchData(); // 在组件挂载后获取数据
  },

  methods: {
    async fetchData() {
      try {
        const res = await Report();
        console.log('Fetched Data:', res.data);// 从后端获取数据
        this.roleData = res.data.map(item => ({
          name: item.title,
          value: item.total_price,
        })); // 将数据转换为 ECharts 所需格式
        this.drawPieChart(); // 绘制饼状图
      } catch (error) {
        console.log(error);
      }
    },

    drawPieChart() {
      if (!this.roleData) return;
      // 基于准备好的 dom，初始化 echarts 实例
      let myChart = this.$echarts.init(document.getElementById("myChart"));
      // 绘制图表
      myChart.setOption({
        title: {
          text: "农产品销售统计",
          left: "center",
        },
        tooltip: {
          trigger: "item",
          formatter: "{a} <br/>{b}: {c} ({d}%)",
        },
        legend: {
          top: "10%",
          left: "center",
        },
        color: ['#6eb158', '#cdcdcd', '#3f8cff', '#ff7f50', '#87cefa', '#da70d6', '#32cd32', '#6495ed', '#ff69b4'],
        series: [
          {
            name: "销售总额",
            type: "pie",
            radius: "50%",
            data: this.roleData, // 使用转换后的数据
            emphasis: {
              itemStyle: {
                shadowBlur: 10,
                shadowOffsetX: 0,
                shadowColor: "rgba(0, 0, 0, 0.5)",
              },
            },
            label: {
              formatter: "{b}: {c} ({d}%)",
              rich: {},
            },
          },
        ],
      });
    },
  },
};
</script>

<style lang="less" scoped>
.Background{
  width: 800px;
  height: 500px;
  marginTop: 20px;
  backgroundColor: white;// 白色背景框
  backgroundSize: cover; // 背景图片覆盖整个区域
  backgroundPosition: center; // 背景图片居中
  backgroundRepeat: no-repeat;// 不重复背景图片
  border: 1px solid #ddd;// 添加边框
  boxShadow: '0 4px 8px rgba(0, 0, 0, 0.1)' // 添加阴影
}
</style>
