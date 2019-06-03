<template>
  <el-container style="background:#fff">
    <el-header style="height:60px;line-height:60px;font-size:14px;color:#000;display:none">
      <div>修改账号信息</div>
    </el-header>
    <el-main style="padding:0 30px;text-align:left" v-model="userData">
      <!-- <div>
                <div class="mainColor setTit">手机设置</div>
                <div class="setphone">
                    <div>
                        <span>手&nbsp;&nbsp;&nbsp;机：</span>
                        <input type="text" placeholder="" class="inputItem">
                        <button class="btn">更改</button>
                        <div class="tip">绑定手机号可以用于登录本平台，找回密码或其他安全验证</div>
                    </div>
                </div>
            </div> -->

      <div v-if="editFlag">
        <div class="mainColor setTit">个人资料</div>
        <div class="setphone">
          <div class="setdistance">
            <span class="textRight mg">头&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;像：</span>
            <img v-if="userData.avatar" :src="userData.avatar" class="imageItem" alt="">
            <img v-else src="@/../static/img/头像.png" class="imageItem" alt="">
          </div>
          <div class="setdistance">
            <span class="textRight mg">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</span>
            <span v-if="userData.nickName">{{userData.nickName}}</span>
            <span v-else>无</span>
          </div>
          <div class="setdistance">
            <span class="textRight mg">真实姓名：</span>
            <span v-if="userData.name">{{userData.name}}</span>
            <span v-else>无</span>
          </div>
          <div class="setdistance">
            <span class="textRight mg">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</span>
            <span v-if="userData.sex==1">男</span>
            <span v-else>女</span>
          </div>
          <div class="setdistance">
            <span class="textRight mg">个性签名：</span>
            <span v-if="userData.signature">{{userData.signature}}</span>
            <span v-else>无</span>
          </div>
          <div class="setdistance">
            <span class="textRight mg">爱好兴趣：</span>
            <template v-if="userData.hobbys!=null&&userData.hobbys.length>0">
              <span class="hobbySel" v-for="(i,k) in userData.hobbys" :key='k'>{{i}}</span>
            </template>
            <template v-else><span>无</span></template>
          </div>
          <div class="setdistance" style="margin-top:30px">
            <span class="textRight mg">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</span>
            <template v-if="userData.jobs!=null&&userData.hobbys.length>0">
            <span class="hobbySel" v-if="userData.jobs.length>0" v-for="(i,k) in userData.jobs" :key='k'>{{i}}</span>
            </template>
            <template v-else><span>无</span></template>
          </div>
          <el-button type="success" class="editBtn" @click="editClick">编&nbsp;&nbsp;辑</el-button>
        </div>
      </div>
      <div class="editBody" v-else>
        <div class="mainColor setTit">个人资料</div>
        <div class="setphone pr">
          <div class="setdistance uploadImgItem">
            <span class="textRight mg">选择文件：</span>
            <el-upload class="avatar-uploader avatarImg" :show-file-list="false" action="http://192.168.10.31:1101/springcloud-app-fastdfs/upload/fastUpload" :on-success="handleAvaSuccess" :headers="headers" :before-upload="beforeAvaUpload" style="display:inline-block">
              <img v-if="avarUrl" :src="avarUrl" class="avatar">
              <i v-else class="el-icon-plus avatar-uploader-icon"></i>
            </el-upload>
            <div class="textImg">只支持JPG格式，大小不要超过500k<br>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;建议使用一寸证件照70*100像素</div>
          </div>
          <div class="setdistance">
            <span class="textRight">昵&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;称：</span>
            <input type="text" class="infoInput" v-model="nickName">
          </div>
          <div class="setdistance">
            <span class="textRight">真实姓名：</span>
            <input type="text" class="infoInput" v-model="name">
          </div>
          <div class="setdistance">
            <span class="textRight">性&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;别：</span>
            <!-- <input type="radio"> -->
            <i class="iconfont icon-icon_xuanzhong" v-if="sexFlag == 1"></i>
            <i class="iconfont icon-weixuanzhong-01" v-else @click="sexFlag=1"></i>

            <span style="margin-right:20px">男</span>
            <i class="iconfont icon-icon_xuanzhong" v-if="sexFlag == 0"></i>
            <i class="iconfont icon-weixuanzhong-01" v-else @click="sexFlag=0"></i>

            <span>女</span>
          </div>
          <div class="setdistance">
            <span class="textRight">个性签名：</span>
            <el-input type="textarea" class="signInItem" :rows="3" placeholder="请输入内容" v-model="signature">
            </el-input>
          </div>
          <div class="setdistance">
            <span class="textRight">爱好兴趣：</span>
            <el-select v-model="value11" @change="changeSect" multiple placeholder="请选择" class="mulSel">
              <el-option v-for="item in options" :key="item.tagId" :label="item.tagVaule" :value="item.tagId">
              </el-option>
            </el-select>
            <div>
              <ul class="selUl clearfix">
                <li v-for="item in options" :key="item.tagId" @click="changeAH(item)">
                  <i class="iconfont icon-web_xuanzhong" v-if="item.flag" ></i>
                  <i class="iconfont icon-weixuanzhongkuang" v-else></i>
                  <span>{{item.tagVaule}}</span>
                </li>
              </ul>
            </div>
          </div>
          <div class="setdistance">
            <span class="textRight">职&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;业：</span>
            <el-select v-model="value5" multiple placeholder="请选择" class="mulSel">
              <el-option v-for="item in options1" :key="item.tagId" :label="item.tagVaule" :value="item.tagId">
              </el-option>
            </el-select>
          </div>
          <el-button type="success" class="editBtn1" @click="editSave()">保存修改</el-button>
          <el-button type="success" class="editBtn" @click="cancelEd()">取&nbsp;&nbsp;消</el-button>
        </div>
      </div>
      <div>
        <div class="mainColor setTit">密码修改</div>
        <div class="setphone setpw">
          <div>
            <span class="textRight">旧密码：</span>
            <input type="password" class="inputItem" v-model="oldPassword">
            <div class="tip">设置新密码之前，必须填写旧密码</div>
          </div>
          <div>
            <span class="textRight">新密码：</span>
            <input type="password" class="inputItem" v-model="newPassword">
            <div class="tip">密码至少为字母、数字、符号两种组成的8-16字符</div>
          </div>
          <div>
            <span class="textRight">确认密码：</span>
            <input type="password" class="inputItem" v-model="newPasswordB">
            <div class="tip">确认密码和新密码要相同</div>
          </div>
          <el-button type="success" class="subBtn" @click="submit()">提&nbsp;&nbsp;交</el-button>
        </div>
      </div>
    </el-main>
  </el-container>
</template>
<script>
import bus from '@/util/bus'
export default {
  props:['userData'],
  data() {
    return {
      signature: "",
      oldPassword: "",
      newPassword: "",
      newPasswordB: "",
      avarUrl: "",
      nickName: "",
      name: "",
      editFlag: true,
      sexFlag: "",
      options: [],
      options1: [],
      value5: [],
      value11: [],
      headers: {
        token: sessionStorage.token
      }
    };
  },
  created() {
    this.getTagCodeList();
  },
  methods: {
    editClick(){
      this.editFlag=false;
      this.init();
    },
    init(){
      this.nickName = this.userData.nickName;
      this.avarUrl = this.userData.avatar;
      this.name = this.userData.name;
      // this.name = this.userData.name;
      this.sexFlag = this.userData.sex;
      this.signature = this.userData.signature;
      this.value11 = [];
      this.value5 = [];
      for(let it in this.userData.hobbys){
        for(let it1 in this.options){
          if(this.userData.hobbys[it] == this.options[it1].tagVaule){
            this.options[it1].flag = true;
            this.value11.push(this.options[it1].tagId)
          }
        }
      }
      for(let it in this.userData.jobs){
        for(let it1 in this.options1){
          if(this.userData.jobs[it] == this.options1[it1].tagVaule){
            this.value5.push(this.options1[it1].tagId)
          }
        }
      }

    },
    cancelEd() {
      for(let it of this.options){
        it.flag=false
        }
        this.editFlag = true,
        this.avarUrl = "",
        this.nickName = "",
        this.name = "",
        this.sexFlag = "",
        this.value5 = [],
        this.value11 = [],
        this.signature = ""
    },
    editSave() {
      if (!this.nickName) {
        this.$message.error("请填写昵称");
        return;
      }
      if (this.sexFlag === "") {
        this.$message.error("请选择性别");
        return;
      }
      let _this = this;
      this.api.post({
        url: "saveUserInfo",
        data: {
          age: 0,
          avatar: _this.avarUrl,
          company: "",
          hobbys: _this.value11,
          jobs: _this.value5,
          name:_this.name,
          nickName: _this.nickName,
          sex: _this.sexFlag,
          signature: _this.signature
        },
        callback: function(res) {
          if (res.code == "0000") {
            _this.$message.success("保存成功");
            _this.editFlag = true;
            // _this.cancelEd();
            bus.$emit('getUserinfoF')
            bus.$emit('upUserData')
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    changeAH(item) {
      item.flag = !item.flag;
      this.value11 = [];
      for (let it of this.options) {
        if (it.flag) {
          this.value11.push(it.tagId);
        }
      }
    },
    changeSect(e) {
      for (let it of this.options) {
        it.flag = false;
      }
      for (let it of e) {
        for (let it1 of this.options) {
          if(it1.tagId == it){
            it1.flag = true
          }
        }
      }
    },
    beforeAvaUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isLt2M = file.size / 1024 < 500;

      if (!isJPG) {
        this.$message.error("上传头像图片只能是 JPG 格式!");
        return false;
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 500kb!");
        return false;
      }
    },
    handleAvaSuccess(file) {
      this.avarUrl = file.data;
    },
    submit() {
      let psw = /^(?!^\d+$)(?!^[A-Za-z]+$)(?!^[^A-Za-z0-9]+$)(?!^.*[\u4E00-\u9FA5].*$)^\S{8,16}$/;
      if (!psw.test(this.oldPassword)) {
        this.$message.error("请先输入旧密码");
        return;
      }
      if (!psw.test(this.newPassword)) {
        this.$message.error(
          "请输入新密码，密码至少为字母、数字、符号两种组成的8-16字符，不包含空格,不能输入中文"
        );
        return;
      }
      if (this.newPasswordB != this.newPassword) {
        this.$message.error("两次输入的密码不一致");
        return;
      }
      let _this = this;
      this.api.post({
        url: "modifyUserPassword",
        data: {
          // account: _this.$route.query.account,
          account:JSON.parse(sessionStorage.userInfo).account,
          newPassword: _this.newPassword,
          // newPasswordB: _this.newPasswordB,
          oldPassword: _this.oldPassword
        },
        // dataFlag: false,
        callback: function(res) {
          if (res.code == "0000") {
            _this.$message.success("修改密码成功");
            _this.oldPassword = "",
              _this.newPassword = "",
              _this.newPasswordB = ""
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    },
    getTagCodeList() {
      this.options = [];
      this.options1 = [];
      let _this = this;
      this.api.get({
        url: "getTagCodeList",
        data: {},
        callback: function(res) {
          if (res.code == "0000") {
            for(let it in res.data){
              res.data[it].flag = false;
              if(res.data[it].tagType == '0'){
                _this.options.push(res.data[it]);
              }else{
                _this.options1.push(res.data[it]);
              }
            }
          } else {
            _this.$message.error(res.result);
          }
        }
      });
    }
  }
};
</script>
<style lang="scss">
.el-select-dropdown.is-multiple .el-select-dropdown__item.selected {
  color: #00a041;
  background-color: #fff;
}
.el-select .el-input.is-focus .el-input__inner {
  border-color: #00a041;
}
.el-select .el-input__inner:focus {
  border-color: #00a041;
}
.setpw {
  .inputItem {
    background: #fff;
    height: 32px;
  }
}
.editBody {
  .iconfont {
    margin-right: 10px;
  }
  .icon-icon_xuanzhong {
    color: #00a041;
  }
  .icon-web_xuanzhong {
    color: #00a041;
  }
  .selUl {
    border: 1px solid #eee;
    padding: 10px;
    width: 685px;
    margin-left: 83px;
    border-radius: 3px;
    margin-top: 20px;
    > li {
      float: left;
      padding-right: 30px;
      width: 110px;
      margin-bottom: 10px;
      color: #999;
    }
    > li:nth-child(5n) {
      padding-right: 0;
    }
  }
  .mulSel {
    width: 705px;
  }
  .mulSel .el-select .el-input.is-focus .el-input__inner {
    border-color: none;
  }
  .mulSel .el-select .el-input__inner:focus {
    border-color: none;
  }
  .editBtn1 {
    background: #009f42;
    color: #fff;
    font-size: 13px;
    width: 100px;
    height: 35px;
    line-height: 5px;
    border-color: none;
    margin-left: 150px;
  }
  .editBtn {
    font-size: 13px;
  }
  .infoInput {
    height: 32px;
    border: 1px solid #eee;
    width: 250px;
    border-radius: 3px;
  }
  .infoInput:focus {
    border-color: #00a041;
  }
  // .infoInput:nth-child(2) {
  //   margin: 15px 0;
  // }
  .avatarImg {
    width: 100px;
    height: 100px;
  }
  .avatarImg .el-upload {
    // border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
    display: inline-block;
    vertical-align: middle;
  }
  .avatarImg .avatar-uploader-icon {
    border:2px dashed #eee;
    font-size: 28px;
    color: #8c939d;
    width: 100px;
    height: 100px;
    line-height: 100px;
    text-align: center;
  }
  .avatarImg .avatar {
    width: 100px;
    height: 100px;
    border-radius: 5px;
    display: inline-block;
  }
  .signInItem {
    display: inline-block;
    width: 80%;
    vertical-align: middle;
    font-size: 13px;
  }
  .signInItem .el-textarea__inner {
    background: #fff;
    border: 1px solid #eee;
  }
  .uploadImgItem {
    position: absolute;
    right: 92px;
    top: 36px;
    > .textRight {
      display: inline-block;
    }
    .textImg {
      color: #666;
      font-size: 12px;
      margin-left: 30px;
      margin-top: 18px;
    }
  }
}
</style>
