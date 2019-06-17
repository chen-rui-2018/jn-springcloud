:: 一键把项目中jar包存放到指定目录
:: @author shenph
@echo off

::存放目录 %cd% 是当前的目录
set jardir=%cd%\jardir

echo 删除文件夹 %jardir% 下面的jar包
del %jardir%\*.*
echo 删除文件夹 %jardir% 下面的jar包...

echo 创建存放jar包目录
md %jardir%
echo 创建存放jar包目录完成...

echo 正在复制，请稍候...
for /f "delims==" %%a in ('dir /b /s *-1.0.0-RELEASE.jar')do copy /-y "%%a" %jardir%
::/f参数使其分析dir命令的输出结果，并用dir 的/s参数搜寻子目录
echo 复制完成...

echo 删除多余jar包开始，请稍候...
del %jardir%\*-api-1.0.0-RELEASE.jar
del %jardir%\springcloud-app-common-1.0.0-RELEASE.jar
del %jardir%\xxpay-reconciliation-1.0.0-RELEASE.jar
echo 删除多余jar包完成...

pause