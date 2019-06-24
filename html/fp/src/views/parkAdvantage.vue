<template>
  <div class="parkAdvantage">
     <div class="banner" ref="banner">
      <div class="swiper-container">
          <div class="swiper-wrapper">
              <div class="swiper-slide"> <img src="@/assets/image/talents.png" alt=""> </div>
          </div>
          <div class="swiper-pagination"></div>
      </div>
    </div>
    <div class=" w">
      <el-tabs v-model="activeName" @tab-click="handleClick">
        <el-tab-pane label="地理优势" name="1">
          <p class="retract">高新园区位于主城区东南部，地处紫金山与青龙山构成的生态走廊内，地理位置得天独厚。毗邻绕城公路，距城市中心-新街口仅8公里。内外交通极为便利，从园区到绕城公路、宁杭高速、沪宁高速均不超过3分钟车程，到江宁大学城、仙林大学城均不超过15分钟车程。</p>
          <p class="retract">园区作为南京市主城区内省级高新区，交通极为便利，经紧邻的绕城公路可在15-20分钟内直达长江二桥（新生圩码头）、三桥、南京禄口国际机场，随着周边纬六路、纬七路的贯通，将进一步提升园区周边的交通能力，便于园区人流、物流、信息流集散和产品口岸通关</p>
          <p class="img"><img src="@/assets/image/first.jpg" alt=""></p>
        </el-tab-pane>
        <el-tab-pane label="规划定位" name="2">
          <p class="retract">高新园区以“培育高效益主导产业集群、打造高品质科技产业设施、引入高水平创新创业主体、构建高效率运营服务体系”为主要抓手，加快推进落实一批重大项目，实现“长三角知名科技园区和创业创新活力社区”建设。</p>
          <p>（一）培育高效益新兴产业集群</p>
          <p class="retract">顺应产业融合化发展趋势，构建以“互联网信息技术+智慧”为内核的“2+2+X”新兴产业集群，打造长三角知名的创新型、融合型产业高地（新业态、新模式、新技术、新产品、新服务）。其中，智能交通和云计算产业通过实施“产业提升工程”，明确重点发展领域，提升产业国际竞争力；电子商务和设计产业通过实施“产业培育工程”，创新发展模式，打造成为园区新的增长极。</p>
          <p>（二）打造高品质科技产业设施</p>
          <p class="retract">“十三五”期间，围绕“创新创业活力社区”目标，加快推动科技载体建设，预计“十三五”期间白下高新板块新开工载体面积90万平方米，卡子门板块全面开工；实施环境提升工程，高标准完善相关规划设计，实施“美丽园区”工程，为产业发展、人才创业提供良好综合环境；加快推动科技园区、大学校区、公共社区“三区融合、联动发展”，不断优化园区功能结构，将园区打造成为现代化科技设施、商业设施、生活设施、休闲设施融为一体的高品质创新创业空间。</p>
          <p>（三）构建高效率运营服务体系</p>
          <p class="retract">围绕核心竞争力提升，加快完善“1+X”港湾式服务体系，构建“一站式加一网式”办公模式，与秦淮区行政服务中心实现联网运营，为创业创新提供良好的服务环境；加快推动科</p>
          <p class="img"><img src="@/assets/image/secend.jpg" alt=""></p>
        </el-tab-pane>
        <el-tab-pane label="基础优势" name="3">
          <p class="retract">南京白下高新技术产业开发区总占地191.29公顷，总建筑面积352万平方米，包括高新开发区板块和卡子门板块，地理位置得天独厚，人文生态特色明显。</p>
          <p class="retract">高新园区由创新园、服务园和创业园三部分构成。创新园占地150亩，位于南京理工大学南侧，光华路北侧，定位为国家级科技孵化基地。建有国际人才孵化器、南理工科研孵化楼、南理工创新工程中心、综合孵化楼等，总建筑面积约20万平方米。服务园占地150亩，规划建设12万平方米的现代化综合服务楼宇。位于光华路南侧，生产型服务业及综合配套服务区。建有必得科技研发中心、德兰科技大厦、星展科技大厦等，未来将建成约15万平方米的创业加速及配套服务设施。创业园占地2646亩，位于绕城公路和双麒路以东、运粮河以西区域内，总部、研发中心、加速器基地。建有软件信息服务中心、云计算孵化器、天安数码城以及十余个企业总部和研发中心。未来将建成240万平方米、适宜工作休闲的绿色生态区、配套完善的公共服务区。</p>
          <p class="retract"> 公交线路：51、93、180、181</p>
          <p class="retract">园区道路：紫霞路、紫光路、紫丹路、紫云大道、紫霄路、永慧路、永智路、永丰大道、永顺路</p>
          <p class="retract">公共会议中心：配套服务中心会议室、国际人才孵化器209会议室、4号楼B栋217会议室、行政服务中心218会议室等</p>
          <p class="img">
            <span>高新园区区位匹配图</span>
            <img src="@/assets/image/base_1.png" alt="">
          </p>
          <p class="img">
            <span>高新园区载体</span>
            <img src="@/assets/image/base_2.jpg" alt="">
          </p>
          <p class="img">
            <span>智能交通创新基地</span>
            <img src="@/assets/image/base_3.jpg" alt="">
          </p>
          <p class="img">
            <span>中国云计算创新基地</span>
            <img src="@/assets/image/base_4.jpg" alt="">
          </p>
          <p class="retract">
            卡子门板块板块由宜家南侧地块、大明路地块和普天地块构成。宜家南侧地块东至春天家园西侧道路，南至红星美凯龙，西至宁溧路，北至宜家家居和明匙路，占地面积约4万平方米，总建筑面积约31万平方米，其中地上建筑面积约20万平方米，地下建筑面积约11万平方米。拟建设孵化器、创业加速器和中试用房、人才公寓、总部基地和配套设施。大明路地块东至大明路，西至红星美凯龙东侧规划路，南至宁溧路，北至规划道路，用地面积约2.7万平方米，计划建成载体地上面积约15万平方米，该项目主要功能为创业加速器、孵化器、总部基地和配套设施。普天地块位于雨花东路北侧的普天路1号园区内，用地面积为约10.8万平方米，计划建成载体地上面积约20万平方米。地块内建设内容包括创业加速器、中试用房、孵化器、人才公寓、总部基地及配套设施。
          </p>
          <p class="img">
            <span>宜家南侧地块</span>
            <img src="@/assets/image/base_5.jpg" alt="">
          </p>
          <p class="img">
            <span>大明路地块</span>
            <img src="@/assets/image/base_6.jpg" alt="">
          </p>
          <p class="img">
            <span>普天地块</span>
            <img src="@/assets/image/base_7.jpg" alt="">
          </p>
          <p class="retract">
            园区紧紧围绕创新驱动发展的核心战略主线，瞄准“长三角知名科技园区和创业创新活力社区”愿景，以构建新时期园区核心竞争力为首要任务，以“融合化、市场化、服务化、品牌化”为战略路径，以培育高效益主导产业集群、打造高品质科技产业设施、构建高效率运营服务体系、引入高水平创新创业主体为主要抓手，加快推动园区工作重点由开发建设转向园区运营、工作机制由政府主导转向市场运作，为全区打造“三中心、一高地”提供强力支撑，打造成为南京创业创新要素集聚的标杆以及秦淮区创新驱动发展的核心板块、东部板块建设的动力引擎、全区经济发展的增长极点！
          </p>
        </el-tab-pane>
        <el-tab-pane label="招商优势" name="4">
          <p class="retract">园区是南京市主城区内首批省级开发区，优势极为突出</p>
          <p>一、区位优势优越</p>
          <p class="retract"> 园区位于主城区东南部，地处紫金山与青龙山构成的生态走廊内，地理位置得天独厚。毗邻绕城公路，距城市中心-新街口仅8公里。内外交通极为便利，从园区到绕城公路、宁杭高速、沪宁高速均不超过3分钟车程</p>
          <p>二、交通优势凸显</p>
          <p class="retract"> 园区经紧邻的绕城公路可在15-20分钟内直达长江二桥（新生圩码头）、三桥、南京南站，30分钟内可到达南京禄口国际机场，是目前南京市内外交通最为便利的省级开发区。园区建有公交场站，并已开通51、93、180、181等四个公交线路，连通地铁一二三号线。随着周边纬七路的贯通，将进一步提升园区周边的交通能力。</p>
          <p class="img"><img src="@/assets/image/businis_1.jpg" alt=""> </p>
          <p>三、规划布局合理</p>
          <p class="retract">园区按功能划分为创新园、创业园、服务园，并与南京理工大学校园构成独特的“四园合一”的有机整体。园区坚定不移地走精品路线，按照“总部加研发，特色鲜明、建筑风格独特、人文生态环境优美”的标准，不断提升园区的品质和内涵。</p>
          <p>四、品牌优势突出</p>
          <p class="retract">园区自成立以来先后被批准为“国家软件与集成电路公共服务平台——云计算应用与服务平台”、“首批中国产学研合作创新示范基地”、“国家专利产业化试点基地”、“国家大学科技园”、“江苏省重点小企业创业基地”、“南京白下高新技术产业园区”、“省级电子商务示范基地”、“江苏省互联网产业园”、“省级现代服务业（科技）集聚区”、“江苏省军民融合科技创新示范园”、“南京军民两用科技示范园”、”智能交通新兴产业基地“、”服务外包示范园“、”南京文化产业园“。园区拥有四个国家级、七个省级等众多品牌，不但为园区一区多园的发展提供了空间和政策支撑，而且为未来的快速发展奠定了坚实的基础。</p>
          <p>五、产业定位高端</p>
          <p class="retract">园区重点发展以云计算、智能交通等为主的新一代信息技术产业和高新技术服务业，适度发展电子商务、创意设计等新兴战略产业，突出军民融合特色。产业形态以孵化、加速以及研发中心加总部为主。目前，已引进省交通规划设计院、莱斯、南建院、省住建集团等一批成熟总部型企业以及杰迈视讯、云创存储、斯坦德、壹进制等一批高端人才团队孵化企业。</p>
          <p>六、科教实力雄厚</p>
          <p class="retract">园区周边聚集着南京理工大学、南京航空航天大学、解放军理工大学、南京农业大学和8511所、55所、28所等一批国家重点高校和科研机构及6万余名高科技人才，在科研、技术、专利、实验、检测、人才等方面对园区形成了强力的支撑，特别是与南京理工大学一墙之隔的特殊地理位置，为园区发展提供了得天独厚的条件。</p>
          <p class="img"><img src="@/assets/image/businis_2.jpg" alt=""></p>
          <p>七、现代服务业发达</p>
          <p class="retract">秦淮区作为南京市的商贸商务中心区，精品商贸、高端商务、会计金融、法律咨询、文化旅游等现代服务业极为发达，为园区高科技产业发展提供了完善的服务保障。</p>
          <p>八、生态环境优美</p>
          <p class="retract">园区地处紫金山与青龙山脉构成的生态走廊内，被运粮河、永丰河水系环抱，自然景色怡人。</p>
          <p class="img"><img src="@/assets/image/businis_3.jpg" alt=""></p>
          <p class="img"><img src="@/assets/image/businis_4.jpg" alt=""></p>
          <p>九、服务平台健全</p>
          <p class="retract">构筑以园区为主导、以企业为主体、以促进企业创新发展为目标、以高端综合服务为依托的服务体系。以帮助企业突破发展瓶颈为重点，创新服务理念和内涵，积极打造高端综合服务平台，全方位的为企业发展提供支持。融资平台。针对企业发展存在的资金瓶颈制约问题，园区除每年举办多场银企对接会为企业解决急需货款外，还成立了贷款担保公司，科技小额贷款公司，同时积极筹划成立风险投资基金，为园区企业发展提供金融支持。科技与人力资源平台。针对科技型企业技术创新和高端人才需求，园区正着手筹建科技与人力资源平台，将南京和科研院所的技术与专家资源进行整合，并与企业“无缝”对接，实现真正意义上的产学研紧密结合。社会化综合服务平台。已引进律师事务所、会计事务所、专利申请、海关报关等中介服务机构，为企业的发展需要提供便利、快捷、优质、高效的服务。</p>
          <!-- <p></p> -->
        </el-tab-pane>
      </el-tabs>
    </div>
  </div>
</template>
<script>
export default {
    data() {
      return {
        activeName: '1'
      };
    },
    mounted () {
      if(this.$route.query.activeName){
        this.activeName=this.$route.query.activeName
      }
    },
    methods: {
      handleClick(tab, event) {
        console.log(tab, event);
      }
    }
  };
</script>
<style lang="scss">
  .parkAdvantage{
    padding-top: 65px;
    .banner{
      position: relative;
      .swiper-button-prev, .swiper-button-next{
        display: block;
        width: 43px;
        height: 43px;
        border: 1px solid #fff;
        border-radius: 50%;
        background-size: 0 0;
        text-align: center;
        i{
          font-size: 36px;
          line-height: 44px;
          color:#fff;
        }
      }
      .swiper-button-next{
        right: 95px;
      }
      .swiper-button-prev{
        left:95px;
      }
    }
    .swiper-container-horizontal > .swiper-pagination-bullets .swiper-pagination-bullet{
      margin: 5px 4px;
    }
    .swiper-pagination-bullet{
      background-color: #fff;
      opacity: 0.5;
    }
    .swiper-pagination-fraction, .swiper-pagination-custom, .swiper-container-horizontal > .swiper-pagination-bullets{
        position: absolute;
        right: 152px;
        top: 0;
        left: auto;
        width: 1%;
      }
    .swiper-container{
      img{
        width:100%;
        vertical-align: middle;
      }
      .swiper-pagination{
        display: flex;
        flex-direction: column;
        justify-content: center;
      }
      .swiper-pagination-bullet-active{
        border-radius: 5px;
        height: 50px;
        background: #fff;
        opacity: 1;
      }
    }
    .retract{
      text-indent: 2em;
      line-height: 25px;
      font-size: 15px;
    }
    .el-tabs__item{
      font-size: 16px;
    }
    .img{
      margin-top: 30px;
      text-align: center;
      img{
        padding:30px;
        width: 90%;
        padding-top: 0;
      }
      span{
        display: inline-block;
        font-size: 14px;
        padding-bottom: 6px;
      }
    }
  }
</style>

