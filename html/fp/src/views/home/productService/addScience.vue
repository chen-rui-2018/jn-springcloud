<template>
  <div class="addScience">
    <div class="putaway_title">
      <div>新增特色产品</div>
      <div>返回列表</div>
    </div>
    <div class="addScience_main">

      <div class="addScience_form" v-if="territory===0" >
        <el-form label-position="right" label-width="150px">
          <div :model="addScienceData" class="finance_data_container">
            <el-form-item label="业务领域：">
              <span>{{ addScienceData.serialNumber }} </span>
            </el-form-item>
          </div>
          <div class="finance_data_container">
            <el-form-item label="服务顾问：" >
              <el-select v-model="addScienceData.isOnlineLoan" placeholder="请选择">
                <el-option label="是" value="1"/>
                <el-option label="否" value="0"/>
              </el-select>
            </el-form-item>
          </div>
          <div class="double_input">
            <el-form-item label="产品名称：" >
              <el-input v-model="addScienceData.refRateMin" placeholder="请输入产品名称" type="text" clearable/>
            </el-form-item>
          </div>
          <div class="double_input">
            <el-form-item label="参考价格：" >
              <el-input v-model="addScienceData.refRateMin" placeholder="请输入最低价格" type="text" clearable > <template slot="suffix">元</template> </el-input><span> -</span>
              <el-input v-model="addScienceData.refRateMin" placeholder="请输入最高价格" type="text" clearable> <template slot="suffix">元</template> </el-input>
              <span></span>
            </el-form-item>
          </div>
          <div class="product_img">
            <el-form-item label="产品图片：" >
              <el-upload
                action=""
                list-type="picture-card"
                :on-success="uploadsuccess"
                :headers="headers"
                :file-list="fileList"
                >
                <i class="el-icon-plus"></i>
              </el-upload>
            </el-form-item>
          </div>
          <div class="double_input">
            <el-form-item label="服务周期：" >
              <el-input v-model="addScienceData.refRateMin" placeholder="请输入产品名称" type="text" clearable/>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="产品描述：">
              <div class="content_textarea">
                <el-input
                  type="textarea"
                  placeholder="请输入产品详情描述"
                  v-model="addScienceData.te">
                </el-input>
              </div>
            </el-form-item>
          </div>
        </el-form>
      </div>
      <div class="addScience_form" v-else>
        <el-form label-position="right" label-width="150px">
          <div :model="addScienceData" class="finance_data_container">
            <el-form-item label="产品名称：">
              <span>{{ addScienceData.serialNumber }} </span>
            </el-form-item>
          </div>
          <div class="double_input">
            <el-form-item label="参考利率范围：" >
              <el-input v-model="addScienceData.refRateMin" placeholder="请输入最低价格" type="text" clearable > <template slot="suffix">%</template> </el-input><span> -</span>
              <el-input v-model="addScienceData.refRateMin" placeholder="请输入最高价格" type="text" clearable> <template slot="suffix">%</template> </el-input>
              <span></span>
            </el-form-item>
          </div>
          <div class="finance_data_container">
            <el-form-item label="是否网贷直联：" >
              <el-select v-model="addScienceData.isOnlineLoan" placeholder="请选择">
                <el-option label="是" value="1"/>
                <el-option label="否" value="0"/>
              </el-select>
            </el-form-item>
          </div>
          <div class="finance_data_container">
            <el-form-item label="是否政策性产品：" >
              <el-select v-model="addScienceData.isPolicyPro" placeholder="请选择">
                <el-option label="是" value="1"/>
                <el-option label="否" value="0"/>
              </el-select>
            </el-form-item>
          </div>
          <div class="finance_data_container">
            <el-form-item label="是否通用产品：" >
              <el-select v-model="addScienceData.isGeneralPro" placeholder="请选择">
                <el-option label="是" value="1"/>
                <el-option label="否" value="0"/>
              </el-select>
            </el-form-item>
          </div>
          <div class="finance_data_container">
            <el-form-item label="是否人民币：" >
              <el-select v-model="addScienceData.isRmb" placeholder="请选择">
                <el-option label="是" value="1"/>
                <el-option label="否" value="0"/>
              </el-select>
            </el-form-item>
          </div>
          <div class="finance_data_container">
            <el-form-item label="贷款类别：" >
              <!-- <el-select v-model="addScienceData.loanCategoryCode" placeholder="请选择">
                <el-option
                  v-for="(item,index) in loanCategoryNameList "
                  :key="index"
                  :label="loanCategoryNameList[index].loanName"
                  :value="loanCategoryNameList[index].loanCode"
                  @click.native="changeloanCategoryName(loanCategoryNameList[index].loanName,loanCategoryNameList[index].loanCode) "
                />
              </el-select> -->
            </el-form-item>
          </div>
          <div class="double_input">
            <el-form-item label="贷款额度：" >
              <el-input v-model="addScienceData.loanAmountMin" placeholder="请输入最小额度" type="text" clearable> <template slot="suffix">万元</template> </el-input>
              <span>-</span>
              <el-input v-model="addScienceData.loanAmountMax" placeholder="请输入最大额度" type="text" clearable> <template slot="suffix">万元</template> </el-input>
            </el-form-item>
          </div>
          <div class="double_input">
            <el-form-item label="贷款期限：" >
              <el-input v-model="addScienceData.referPrice" placeholder="请输入最小额度" type="text" clearable> <template slot="suffix">个月</template> </el-input>
              <span>-</span>
              <el-input v-model="addScienceData.referPrice" placeholder="请输入最大额度" type="text" clearable> <template slot="suffix">个月</template> </el-input>
            </el-form-item>
          </div>
          <div class="finance_data_container">
            <el-form-item label="担保方式：" >
              <!-- <el-select v-model="addScienceData.assureMethodCode" placeholder="请选择">
                <el-option
                  v-for="(item,index) in assureMethodNameList "
                  :key="index"
                  :label="assureMethodNameList[index].assureName"
                  :value="assureMethodNameList[index].assureCode"
                  @click.native="changeassureMethodName(assureMethodNameList[index].assureName,assureMethodNameList[index].assureCode) "
                />
              </el-select> -->
            </el-form-item>
          </div>
          <div class="product_img">
            <el-form-item label="产品图片：" >
              <el-upload
                action=""
                list-type="picture-card"
                :on-success="uploadsuccess"
                :headers="headers"
                :file-list="fileList"
                >
                <i class="el-icon-plus"></i>
              </el-upload>
            </el-form-item>
          </div>
          <div>
            <el-form-item label="产品特点：">
              <div class="content_textarea">
                <el-input
                  type="textarea"
                  placeholder="请输入内容"
                  v-model="addScienceData.te">
                </el-input>
              </div>
            </el-form-item>
          </div>
        </el-form>
      </div>
      <div class="submit">提交申请</div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      addScienceData:{},
      headers:{headers:''},
      fileList:[],
      territory:0
    }
  },
  mounted () {
    this.headers.headers=sessionStorage.getItem("token")
  },
  methods: {
    uploadsuccess(file, fileList){
      console.log(file)
      console.log(fileList)
    }
  }
}
</script>

<style lang="scss">
  .addScience{
    width: 100%;
    // 大标题
    .putaway_title{
     background-color: #fff;
      display: flex;
      justify-content: space-between;
      align-items: center;
      padding:17px;
      font-size: 16px;
      border-radius: 5px;
      div:nth-child(2){
        background-color: #ecfcf2;
        border-radius: 5px;
        border: solid 2px #41d787;
        padding:5px 22px;
        font-size: 14px;
        cursor: pointer;
        color:#00a041;
      }
    }
    // 主体
    .addScience_main{
      margin-top: 14px;
      background-color: #fff;
      padding: 17px;
      .addScience_form{
        width: 50%;
        margin: 0 auto;
        .double_input{
          .el-input{
            width:47%;
            input:focus{
              border:1px solid #00a041;
            }
          }
        }
        .product_img{
          .el-upload--picture-card{
            width: 100px;
            height: 100px;
            line-height: 100px;
          }
        }
        .content_textarea{
          textarea{
            padding: 8px 15px;
            resize: none;
            height: 96px;
            border-radius: 5px;
            background: #fff;
            &:focus{
              border:1px solid #00a041;
            }
          }
        }
        .el-form-item__label{
          padding: 0 25px 0 0;
          line-height:25px;
        }
        
        .el-select{
          display: block;
        }
        .el-form-item__content{
          color:#999999;
          // line-height:25px;
        }
        .el-select-dropdown__item{
          color:#999999;
        }
        .el-select .el-input.is-focus .el-input__inner{
          border-color:#00a041;
        }
        .el-form-item{
          margin-bottom: 14px;
        }
        .el-select .el-input__inner:focus{
          border-color:#00a041;
        }
      }
      .submit{
        background-color: #ecfcf2;
        border-radius: 5px;
        border: solid 2px #41d787;
        padding:7px 31px;
        font-size: 12px;
        cursor: pointer;
        width:5%;
        text-align: center;
        color:#00a041;
        margin:30px auto 15px;
      }
    }
  }
</style>
