:: һ������Ŀ��jar����ŵ�ָ��Ŀ¼
:: @author shenph
@echo off

::���Ŀ¼ %cd% �ǵ�ǰ��Ŀ¼
set jardir=%cd%\jardir

echo ɾ���ļ��� %jardir% �����jar��
del %jardir%\*.*
echo ɾ���ļ��� %jardir% �����jar��...

echo �������jar��Ŀ¼
md %jardir%
echo �������jar��Ŀ¼���...

echo ���ڸ��ƣ����Ժ�...
for /f "delims==" %%a in ('dir /b /s *-1.0.0-RELEASE.jar')do copy /-y "%%a" %jardir%
::/f����ʹ�����dir�����������������dir ��/s������Ѱ��Ŀ¼
echo �������...

echo ɾ������jar����ʼ�����Ժ�...
del %jardir%\*-api-1.0.0-RELEASE.jar
del %jardir%\springcloud-app-common-1.0.0-RELEASE.jar
del %jardir%\xxpay-reconciliation-1.0.0-RELEASE.jar
echo ɾ������jar�����...

pause