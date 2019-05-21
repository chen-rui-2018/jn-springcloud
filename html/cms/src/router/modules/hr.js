/** When your routing table is too long, you can split it into small modules**/
/* eslint-disable */

import Layout from '@/views/layout/Layout'

const hrRouter = {
  path: '/hr',
  component: Layout,
  redirect: 'noredirect',
  name: 'hr',
  meta: {
    title: '人力资源管理',
    icon: 'svg-icon'
  },
  children: [
    {
      path: 'employee',
      component: () => import('@/views/hr/employee/index'),
      name: 'employee',
      meta: { title: '员工管理', noCache: true },
      children: [
        {
          path: 'holiday',
          component: () => import('@/views/hr/employee/holiday/index'),
          name: 'holiday',
          meta: { title: '假期审查', noCache: true },
          children: [
            {
              path: 'holidayList',
              component: () => import('@/views/hr/employee/holiday/holidayList'),
              name: 'holidayList',
              meta: { title: '假期审查', noCache: true ,icon: 'list'}
            },
            {
              path: 'holidayRuleList',
              component: () => import('@/views/hr/employee/holiday/holidayRuleList'),
              name: 'holidayRuleList',
              meta: { title: '假期规则设置', noCache: true ,icon: 'list'}
            },
            {
              path: 'vacationList',
              component: () => import('@/views/hr/employee/holiday/vacationList'),
              name: 'vacationList',
              meta: { title: '假期管理', noCache: true ,icon: 'list'}
            }
          ]
        },
        {
          path: 'stat',
          component: () => import('@/views/hr/employee/stat/index'),
          name: 'stat',
          meta: { title: '统计分析', noCache: true }
        },
        {
          path: 'resumeDatabase',
          component: () => import('@/views/hr/employee/resumeDatabase/index'),
          name: 'resumeDatabase',
          meta: { title: '招聘配置', noCache: true },
          children: [
            {
              path: 'resumeDatabaseList',
              component: () => import('@/views/hr/employee/resumeDatabase/resumeDatabaseList'),
              name: 'resumeDatabaseList',
              meta: { title: '简历库', noCache: true ,icon: 'list'}
            },
            {
              path: 'resumeDatabaseAdd',
              component: () => import('@/views/hr/employee/resumeDatabase/resumeDatabaseAdd'),
              name: 'resumeDatabaseAdd',
              meta: { title: '新增简历库', noCache: true ,icon: 'list'}
            },
            {
              path: 'resumeDatabaseUpdate',
              component: () => import('@/views/hr/employee/resumeDatabase/resumeDatabaseAdd'),
              name: 'resumeDatabaseUpdate',
              meta: { title: '编辑简历库', noCache: true ,icon: 'list'}
            },
            {
              path: 'resumeDatabaseDetail',
              component: () => import('@/views/hr/employee/resumeDatabase/resumeDatabaseDetail'),
              name: 'resumeDatabaseDetail',
              meta: { title: '查看简历库详情', noCache: true ,icon: 'list'}
            }
          ]
        },
        {
          path: 'employeeFile',
          component: () => import('@/views/hr/employee/employeeFile/index'),
          name: 'employeeFile',
          meta: { title: '员工档案管理', noCache: true },
          children: [
            {
              path: 'employeeFileList',
              component: () => import('@/views/hr/employee/employeeFile/employeeFileList'),
              name: 'employeeFileList',
              meta: { title: '员工档案', noCache: true ,icon: 'list'}
            },
            {
              path: 'employeeFileAdd',
              component: () => import('@/views/hr/employee/employeeFile/employeeFileAdd'),
              name: 'employeeFileAdd',
              meta: { title: '新增员工档案', noCache: true ,icon: 'list'}
            },
            {
              path: 'employeeFileUpdate',
              component: () => import('@/views/hr/employee/employeeFile/employeeFileAdd'),
              name: 'employeeFileUpdate',
              meta: { title: '编辑员工档案', noCache: true ,icon: 'list'}
            },
            {
              path: 'attachmentList',
              component: () => import('@/views/hr/employee/employeeFile/attachmentList'),
              name: 'attachmentList',
              meta: { title: '附件管理', noCache: true ,icon: 'list'}
            }
          ]
        },
        {
          path: 'employeeBasicInfo',
          component: () => import('@/views/hr/employee/employeeBasicInfo/index'),
          name: 'employeeBasicInfo',
          meta: { title: '员工花名册管理', noCache: true },
          children: [
            {
              path: 'employeeBasicInfoList',
              component: () => import('@/views/hr/employee/employeeBasicInfo/employeeBasicInfoList'),
              name: 'employeeBasicInfoList',
              meta: { title: '员工花名册', noCache: true ,icon: 'list'}
            },
            {
              path: 'employeeBasicInfoAdd',
              component: () => import('@/views/hr/employee/employeeBasicInfo/employeeBasicInfoAdd'),
              name: 'employeeBasicInfoAdd',
              meta: { title: '新增员工花名册', noCache: true ,icon: 'list'}
            },
            {
              path: 'employeeBasicInfoUpdate',
              component: () => import('@/views/hr/employee/employeeBasicInfo/employeeBasicInfoAdd'),
              name: 'employeeBasicInfoUpdate',
              meta: { title: '编辑员工花名册', noCache: true ,icon: 'list'}
            },
            {
              path: 'employeeBasicInfoDetail',
              component: () => import('@/views/hr/employee/employeeBasicInfo/employeeBasicInfoDetail'),
              name: 'employeeBasicInfoDetail',
              meta: { title: '查看员工花名册详情', noCache: true ,icon: 'list'}
            }
          ]
        }
      ]
    },
    {
      path: 'attendance',
      component: () => import('@/views/hr/attendance/attendanceManagement/index'),
      name: 'attendance',
      meta: { title: '考勤管理', noCache: true },
      children: [
        {
          path: 'attendanceManagement',
          component: () => import('@/views/hr/attendance/attendanceManagement'),
          name: 'attendanceManagement',
          meta: { title: '考勤管理列表', noCache: true },
          children: [
            {
              path: 'attendanceList',
              component: () => import('@/views/hr/attendance/attendanceManagement/attendanceList'),
              name: 'attendanceList',
              meta: { title: '考勤管理列表', noCache: true ,icon: 'list'}
            },
            {
              path: 'absenceDetailList',
              component: () => import('@/views/hr/attendance/attendanceManagement/absenceDetailList'),
              name: 'absenceDetailList',
              meta: { title: '旷工明细', noCache: true ,icon: 'list'}
            },
            {
              path: 'comeLateDetailList',
              component: () => import('@/views/hr/attendance/attendanceManagement/comeLateDetailList'),
              name: 'comeLateDetailList',
              meta: { title: '迟到明细', noCache: true ,icon: 'list'}
            },
            {
              path: 'leaveEarlyDetailList',
              component: () => import('@/views/hr/attendance/attendanceManagement/leaveEarlyDetailList'),
              name: 'leaveEarlyDetailList',
              meta: { title: '早退明细', noCache: true ,icon: 'list'}
            },
            {
              path: 'notCardDetailList',
              component: () => import('@/views/hr/attendance/attendanceManagement/notCardDetailList'),
              name: 'notCardDetailList',
              meta: { title: '缺卡明细', noCache: true ,icon: 'list'}
            },
            {
              path: 'leaveDetailist',
              component: () => import('@/views/hr/attendance/attendanceManagement/leaveDetailist'),
              name: 'leaveDetailist',
              meta: { title: '请假明细', noCache: true ,icon: 'list'}
            },
            {
              path: 'attendanceTimeconfig',
              component: () => import('@/views/hr/attendance/attendanceManagement/attendanceTimeconfig'),
              name: 'attendanceTimeconfig',
              meta: { title: '考勤时间设置', noCache: true ,icon: 'list'}
            },
            {
              path: 'schedulist',
              component: () => import('@/views/hr/attendance/attendanceManagement/schedulist'),
              name: 'schedulist',
              meta: { title: '排班管理', noCache: true ,icon: 'list'}
            },
            {
              path: 'scheduDetailist',
              component: () => import('@/views/hr/attendance/attendanceManagement/scheduDetailist'),
              name: 'scheduDetailist',
              meta: { title: '排班明细', noCache: true ,icon: 'list'}
            }
          ]
        }
      ]
    },
    {
      path: 'exam',
      component: () => import('@/views/hr/exam/index'),
      name: 'exam',
      meta: { title: '在线考试', noCache: true },
      children: [
      {
          path: 'examManage',
          component: () => import('@/views/hr/exam/examManage'),
          name: 'examManage',
          meta: { title: '考试管理', noCache: true ,icon: 'list'},
          children: [
            {
              path: 'examManageList',
              component: () => import('@/views/hr/exam/examManage/examManageList'),
              name: 'examManageList',
              meta: { title: '考试管理', noCache: true ,icon: 'list'}
            },
            {
              path: 'addExamItem',
              component: () => import('@/views/hr/exam/examManage/addExamItem'),
              name: 'addExamItem',
              meta: { title: '创建考试', noCache: true ,icon: 'list'}
            },
            {
              path: 'viewScore',
              component: () => import('@/views/hr/exam/examManage/viewScore'),
              name: 'viewScore',
              meta: { title: '查看成绩', noCache: true ,icon: 'list'}
            },
          ]
        },
        {
          path: 'examination',
          component: () => import('@/views/hr/exam/examination'),
          name: 'examination',
          meta: { title: '试题库管理', noCache: true ,icon: 'list'},
          children: [
            {
              path: 'examinationList',
              component: () => import('@/views/hr/exam/examination/examinationList'),
              name: 'examinationList',
              meta: { title: '试题库', noCache: true ,icon: 'list'}
            },
            {
              path: 'examinationAdd',
              component: () => import('@/views/hr/exam/examination/examinationAdd'),
              name: 'examinationAdd',
              meta: { title: '新增试题', noCache: true ,icon: 'list'}
            },
            {
              path: 'examinationUpdate',
              component: () => import('@/views/hr/exam/examination/examinationAdd'),
              name: 'examinationUpdate',
              meta: { title: '新增试题', noCache: true ,icon: 'list'}
            }
          ]
        }
      ]
    },
    {
      path: 'assess',
      component: () => import('@/views/hr/assess/index'),
      name: 'assess',
      meta: { title: '考核评估', noCache: true },
      children: [
        {
          path: 'assessment',
          component: () => import('@/views/hr/assess/assessment'),
          name: 'assessment',
          meta: { title: '考核管理', noCache: true },
          children: [
            {
              path: 'assessment-list',
              component: () => import('@/views/hr/assess/assessment/assessment-list'),
              name: 'assessment-list',
              meta: { title: '考核管理', noCache: true ,icon: 'list'}
            },
            {
              path: 'assessment-add',
              component: () => import('@/views/hr/assess/assessment/assessment-add'),
              name: 'assessment-add',
              meta: { title: '发起考核', noCache: true ,icon: 'list'}
            },
            {
              path: 'assessment-detail',
              component: () => import('@/views/hr/assess/assessment/assessment-detail'),
              name: 'assessment-detail',
              meta: { title: '查看页面', noCache: true ,icon: 'list'}
            },
            {
              path: 'assessmentsub-add',
              component: () => import('@/views/hr/assess/assessment/assessmentsub-add'),
              name: 'assessmentsub-add',
              meta: { title: '开始考核', noCache: true ,icon: 'list'}
            },
            {
              path: 'assessmentsub-detail',
              component: () => import('@/views/hr/assess/assessment/assessmentsub-add'),
              name: 'assessmentsub-detail',
              meta: { title: '查看考核详情', noCache: true ,icon: 'list'}
            }
          ]
        },
        {
          path: 'assessmenttemp',
          component: () => import('@/views/hr/assess/assessmenttemp/index'),
          name: 'assessmenttemp',
          meta: { title: '考核模板', noCache: true },
          children: [
            {
              path: 'assessmenttemp-list',
              component: () => import('@/views/hr/assess/assessmenttemp/assessmenttemp-list'),
              name: 'assessmenttemp-list',
              meta: { title: '考核模板', noCache: true ,icon: 'list'}
            },
            {
              path: 'assessmenttemp-add',
              component: () => import('@/views/hr/assess/assessmenttemp/assessmenttemp-add'),
              name: 'assessmenttemp-add',
              meta: { title: '新增模板', noCache: true ,icon: 'list'}
            },
            {
              path: 'assessmenttemp-detail',
              component: () => import('@/views/hr/assess/assessmenttemp/assessmenttemp-detail'),
              name: 'assessmenttemp-detail',
              meta: { title: '查看模板详情', noCache: true ,icon: 'list'}
            }
          ]
        }
      ]
    },
    {
      path: 'remuneration',
      component: () => import('@/views/hr/remuneration/index'),
      name: 'remuneration',
      meta: {title: '薪资福利', noCache: true},
      children: [
        {
          path: 'salarymanagement',
          component: () => import('@/views/hr/remuneration/salarymanagement/index'),
          name: 'salarymanagement',
          meta: {title: '薪资管理', noCache: true},
          children: [
            {
              path: 'salarymanagement-list',
              component: () => import('@/views/hr/remuneration/salarymanagement/salarymanagement-list'),
              name: 'salarymanagement-list',
              meta: {title: '薪资管理', noCache: true}
            },
            {
              path: 'salarymanagement-add',
              component: () => import('@/views/hr/remuneration/salarymanagement/salarymanagement-add'),
              name: 'salarymanagement-add',
              meta: {title: '薪资新增', noCache: true}
            },
            {
              path: 'salarymanagement-edit',
              component: () => import('@/views/hr/remuneration/salarymanagement/salarymanagement-add'),
              name: 'salarymanagement-edit',
              meta: {title: '修改薪资', noCache: true}
            },
            {
              path: 'salarymanagement-view',
              component: () => import('@/views/hr/remuneration/salarymanagement/salarymanagement-add'),
              name: 'salarymanagement-view',
              meta: {title: '查看薪资', noCache: true}
            },
            {
              path: 'salaryanalysis',
              component: () => import('@/views/hr/remuneration/salarymanagement/salaryanalysis/index'),
              name: 'salaryanalysis',
              meta: {title: '薪酬分析', noCache: true},
              children: [
                {
                  path: 'salaryanalysis-list',
                  component: () => import('@/views/hr/remuneration/salarymanagement/salaryanalysis/salaryanalysis-list'),
                  name: 'salaryanalysis-list',
                  meta: {title: '工资概况', noCache: true}
                }
              ]
            }
          ]
        },
        {
          path: 'salaryIssue-list',
          component: () => import('@/views/hr/remuneration/salaryIssue-list'),
          name: 'salaryIssue-list',
          meta: {title: '薪资发放', noCache: true}
        },
        {
          path: 'welfareManagement',
          component: () => import('@/views/hr/remuneration/welfareManagement/index'),
          name: 'welfareManagement',
          meta: {title: '福利管理', noCache: true},
          children: [
            {
              path: 'insurancemanagement-list',
              component: () => import('@/views/hr/remuneration/welfareManagement/insurancemanagement-list'),
              name: 'insurancemanagement-list',
              meta: {title: '参保管理', noCache: true}
            },
            {
              path: 'increaseStaff-list',
              component: () => import('@/views/hr/remuneration/welfareManagement/increaseStaff-list'),
              name: 'increaseStaff-list',
              meta: {title: '增减员计划', noCache: true}
            },
            {
              path: 'autonomouslyInsure-list',
              component: () => import('@/views/hr/remuneration/welfareManagement/autonomouslyInsure-list'),
              name: 'autonomouslyInsure-list',
              meta: {title: '自主参保方案', noCache: true}
            },
            {
              path: 'insurance-add',
              component: () => import('@/views/hr/remuneration/welfareManagement/insurance-add'),
              name: 'insurance-add',
              meta: {title: '参保方案', noCache: true}
            },
            {
              path: 'insurance-edit',
              component: () => import('@/views/hr/remuneration/welfareManagement/insurance-add'),
              name: 'insurance-edit',
              meta: {title: '修改参保方案', noCache: true}
            },
            {
              path: 'insuranceAnalysis-list',
              component: () => import('@/views/hr/remuneration/welfareManagement/insuranceAnalysis-list'),
              name: 'insuranceAnalysis-list',
              meta: {title: '参保概况', noCache: true}
            },
            {
              path: 'insuredDetail-list',
              component: () => import('@/views//hr/remuneration/welfareManagement/insuredDetail-list'),
              name: 'insuredDetail-list',
              meta: {title: '参保明细', noCache: true}
            }
          ]
        }
      ]
    },
    // 培训发展
    {
      path: 'train',
      component: () => import('@/views/hr/train/index'),
      name: 'train',
      meta: { title: '培训发展', noCache: true },
      children: [
        {
          path: 'investigation',
          component: () => import('@/views/hr/train/investigation/index'),
          name: 'investigation',
          meta: { title: '调研分析', noCache: true },
          children: [
            {
              path: 'invest-analysis',
              component: () => import('@/views/hr/train/investigation/invest-analysis'),
              name: 'invest-analysis',
              meta: { title: '调研项目', noCache: true ,icon: 'list'}
            },
            {
              path: 'invest-page',
              component: () => import('@/views/hr/train/investigation/invest-page'),
              name: 'invest-page',
              meta: { title: '调研页面', noCache: true ,icon: 'list'}
            },
            {
              path: 'invest-add',
              component: () => import('@/views/hr/train/investigation/invest-add'),
              name: 'invest-add',
              meta: { title: '新建项目', noCache: true ,icon: 'list'}
            },
            {
              path: 'invest-edit',
              component: () => import('@/views/hr/train/investigation/invest-edit'),
              name: 'invest-edit',
              meta: { title: '编辑项目', noCache: true ,icon: 'list'}
            },
            {
              path: 'invest-give',
              component: () => import('@/views/hr/train/investigation/invest-give'),
              name: 'invest-give',
              meta: { title: '发放调研', noCache: true ,icon: 'list'}
            },
            {
              path: 'invest-result',
              component: () => import('@/views/hr/train/investigation/invest-result'),
              name: 'invest-result',
              meta: { title: '调研结果', noCache: true ,icon: 'list'}
            }
          ]
        },
        {
          path: 'question',
          component: () => import('@/views/hr/train/question/index'),
          name: 'question',
          meta: { title: '问卷调查', noCache: true },
          children: [
            {
              path: 'question-invest',
              component: () => import('@/views/hr/train/question/question-invest'),
              name: 'question-invest',
              meta: { title: '问卷项目', noCache: true ,icon: 'list'}
            },
            {
              path: 'question-page',
              component: () => import('@/views/hr/train/question/question-page'),
              name: 'question-page',
              meta: { title: '问卷页面', noCache: true ,icon: 'list'}
            },
            {
              path: 'question-add',
              component: () => import('@/views/hr/train/question/question-add'),
              name: 'question-add',
              meta: { title: '新建问卷', noCache: true ,icon: 'list'}
            },
            {
              path: 'question-edit',
              component: () => import('@/views/hr/train/question/question-edit'),
              name: 'question-edit',
              meta: { title: '编辑问卷', noCache: true ,icon: 'list'}
            },
            {
              path: 'question-give',
              component: () => import('@/views/hr/train/question/question-give'),
              name: 'question-give',
              meta: { title: '发放问卷', noCache: true ,icon: 'list'}
            },
            {
              path: 'question-result',
              component: () => import('@/views/hr/train/question/question-result'),
              name: 'question-result',
              meta: { title: '问卷结果', noCache: true ,icon: 'list'}
            }
          ]
        },
        {
          path: 'trainList',
          component: () => import('@/views/hr/train/trainList/index'),
          name: 'trainList',
          meta: { title: '培训列表', noCache: true },
          children: [
            {
              path: 'train-list',
              component: () => import('@/views/hr/train/trainList/train-list'),
              name: 'train-list',
              meta: { title: '培训列表', noCache: true ,icon: 'list'}
            },
            {
              path: 'train-addOrEdict',
              component: () => import('@/views/hr/train/trainList/train-addOrEdict'),
              name: 'train-addOrEdict',
              meta: { title: '制定课程', noCache: true ,icon: 'list'}
            },
            {
              path: 'train-detail',
              component: () => import('@/views/hr/train/trainList/train-detail'),
              name: 'train-detail',
              meta: { title: '课程详情', noCache: true ,icon: 'list'}
            },
            {
              path: 'train-record',
              component: () => import('@/views/hr/train/trainList/train-record'),
              name: 'train-record',
              meta: { title: '培训记录', noCache: true ,icon: 'list'}
            }
          ]
        },
        {
          path: 'email',
          component: () => import('@/views/hr/train/email'),
          name: 'email',
          meta: { title: '邮件发送', noCache: true }
        }
      ]

    }
  ]
}
export default hrRouter
