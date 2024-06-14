<template>
  <div class="hx-table hx-form-margin">
		    <!--高级查询-->
    <el-collapse-transition>
      <div v-show="showQuery" >
        <el-form label-width="5px"  :model="listQuery">
          <el-row>
            <el-col :span="4">
              <el-form-item>
                <el-input placeholder="查询字段3" v-model="listQuery.field3" clearable></el-input>
              </el-form-item>
            </el-col>            
            <el-col :span="4">
              <el-form-item>
                <el-input placeholder="查询字段4" v-model="listQuery.field4" clearable></el-input>                 
              </el-form-item>
            </el-col>
            <el-col :span="4">
              <el-form-item>
                <el-select v-model="listQuery.field5" placeholder="查询字段5" style="width:100%" clearable>
                  <el-option
                    v-for=""
                    :key=""
                    :label=""
                    :value=""
                    >
                  </el-option>
                </el-select>   
              </el-form-item>
            </el-col>
          </el-row>
        </el-form>
      </div>
    </el-collapse-transition>
		<el-form  :model="listQuery" label-width="5px">
		  <el-row>
				<!--查询列按需设置-->
				<el-col :span="4">
					<el-form-item>
					<el-input :placeholder="'查询字段1'" v-model="listQuery.field1" clearable />
					</el-form-item>
				</el-col>
				<el-col :span="4">
					<el-form-item>
					<el-input :placeholder="'查询字段2'" v-model="listQuery.field2" clearable />
					</el-form-item>
				</el-col>
				<el-col :span="14">
					<el-form-item style="float:right">
					<el-button-group>
						<el-button type="primary" size="mini" v-if="!noPermButton.includes('新增')"  @click="handleAdd">新增</el-button>
						<el-button type="primary" size="mini"  @click="handleQuery(1)">查询</el-button>
						<el-button type="primary" size="mini" @click="showQuery = !showQuery">高级查询</el-button>
						<el-button type="primary" size="mini" :disabled="canUpdate" v-if="!noPermButton.includes('修改')"  @click="handleUpdate">修改</el-button>
						<el-button type="primary" size="mini" :disabled="canDelete" v-if="!noPermButton.includes('删除')"  @click="handleDelete">删除</el-button>
						<el-button type="primary" size="mini"  @click="handleExportNoTemplateExcel">导出</el-button>
					</el-button-group>
					</el-form-item>
				</el-col>
		  </el-row>
		</el-form>

    <el-table
		:data="list"
		v-loading="listLoading"
		:height="tableHeight"
		:row-style="{height:'30px'}"
		border
		ref="InterviewRecordsTable"
		highlight-current-row
		stripe
		@selection-change="handleSelectionChange"
		style="width:100%"
		>
      <el-table-column type="selection"/>
      												      <el-table-column prop="consultantId" label="咨询师ID，关联consultants表中的咨询师" width="160" header-align="center" align="center" show-overflow-tooltip/>
			      									      <el-table-column prop="clientId" label="客户ID，关联clients表中的客户" width="160" header-align="center" align="center" show-overflow-tooltip/>
			      										  <el-table-column label="访谈日期" width="160" header-align="center" align="center">
        <template slot-scope="scope"><span>{{ scope.row.interviewDate | parseTime('{y}-{m}-{d}') }}</span></template>
      </el-table-column>
			      										  <el-table-column label="访谈开始时间" width="160" header-align="center" align="center">
        <template slot-scope="scope"><span>{{ scope.row.startTime | parseTime('{y}-{m}-{d}') }}</span></template>
      </el-table-column>
			      										  <el-table-column label="访谈结束时间" width="160" header-align="center" align="center">
        <template slot-scope="scope"><span>{{ scope.row.endTime | parseTime('{y}-{m}-{d}') }}</span></template>
      </el-table-column>
			      									      <el-table-column prop="interviewMode" label="访谈方式，线上或线下进行" width="160" header-align="center" align="center" show-overflow-tooltip/>
			      									      <el-table-column prop="topicsCovered" label="访谈覆盖的主题或讨论要点" width="160" header-align="center" align="center" show-overflow-tooltip/>
			      									      <el-table-column prop="clientConcerns" label="客户提出的主要问题或关心点" width="160" header-align="center" align="center" show-overflow-tooltip/>
			      									      <el-table-column prop="adviceProvided" label="咨询师提供的建议或解决方案" width="160" header-align="center" align="center" show-overflow-tooltip/>
			      									      <el-table-column prop="nextSteps" label="后续行动计划或建议的下一步" width="160" header-align="center" align="center" show-overflow-tooltip/>
			      									      <el-table-column prop="notes" label="其他备注或细节记录" width="160" header-align="center" align="center" show-overflow-tooltip/>
			      										  <el-table-column label="记录创建时间" width="160" header-align="center" align="center">
        <template slot-scope="scope"><span>{{ scope.row.createdAt | parseTime('{y}-{m}-{d}') }}</span></template>
      </el-table-column>
			      										  <el-table-column label="记录最后更新时间" width="160" header-align="center" align="center">
        <template slot-scope="scope"><span>{{ scope.row.updatedAt | parseTime('{y}-{m}-{d}') }}</span></template>
      </el-table-column>
			      			    </el-table>

    <pagination
		:total="total"
		:page.sync="listQuery.page"
		:limit.sync="listQuery.limit"
		@pagination="handleQuery"
    />
  </div>
</template>

<script>
import { queryInterviewRecords, deleteInterviewRecords,getInterviewRecords } from "@/api/interviewrecords/interviewrecords";
import { page2Ofset } from "@/utils";
import { exportNoTemplateExcel, getNoPermissionButton,setKeepAliveComponent,getCurrUserInfo, removeKeepAliveComponent,openloading } from "@/api/sys";
import Pagination from "@/components/Pagination"; // Secondary package based on el-pagination

export default {
  name: "InterviewRecordsList",
  components: { Pagination },
	data() {
		return {
			tableHeight: '430px',
			showQuery: false,
			list: null,
			total: 0,
			listLoading: true,
			listQuery: {
					page: 1,
					limit: 15
			},
			multipleSelection: [],
			noPermButton: "", //不能操作的按钮，多个以逗号分隔
			currUserId: '',
			canDelete: true,
			canUpdate: true
		};
	},
	beforeRouteEnter(to, from, next) {
		// 进入项目台账时，设置缓存组件
		next(vm => {
		  setKeepAliveComponent(vm, 'InterviewRecordsList') 
		})
	  },
	beforeMount(height) {
		// 设置列表高度
		var h = document.documentElement.clientHeight || document.body.clientHeight
		this.tableHeight = (h - 228) + 'px'
	  },
	created() {
		//获取无权限的按钮
		getNoPermissionButton(this.$router.currentRoute.path).then(ret => {
				this.noPermButton = ret;
		});
		// 获取当前登录人
		getCurrUserInfo().then(response => {
		  this.currUserId = response.userId
		})
		//数据获取
		this.handleQuery();
	},
  methods: {
		handleQuery(reset) {
			//点击查询回到第一页
			if (reset===1) {
					this.listQuery.page = 1;
					this.listQuery.limit = 20;
			}
			this.listLoading = true;
			this.listQuery.offset = page2Ofset(
					this.listQuery.page,
					this.listQuery.limit
			);
			queryInterviewRecords(this.listQuery).then(response => {
					this.list = response.data;
					this.total = response.total;
					this.listLoading = false;
			});
		},
		handleAdd() {
		removeKeepAliveComponent(this,'InterviewRecordsEdit')
			this.$router.push( { 
			name: "InterviewRecordsEdit"
			});
    },
    handleView(row) {
        removeKeepAliveComponent(this,'InterviewRecordsView')
			this.$router.push( { 
			name: "InterviewRecordsView",
			query: { appId: this.multipleSelection[0].recordId }
			});
    },
    handleUpdate(row) {
            removeKeepAliveComponent(this,'InterviewRecordsEdit')
			this.$router.push( { 
			name: "InterviewRecordsEdit",
					query: { appId: this.multipleSelection[0].recordId }
			});
    },
    handleSelectionChange(val) {
    if (val.length > 1) {
        this.$refs.InterviewRecordsTable.clearSelection()
        this.$refs.InterviewRecordsTable.toggleRowSelection(val.pop())
      } else {
        this.multipleSelection = val
      }
      if (this.multipleSelection.length > 0) {
      if (this.currUserId === this.multipleSelection[0].createUserid) {
        if (this.multipleSelection[0].workflowState === '1') {
          this.canUpdate = false
          this.canDelete = false
        } else {
          this.canDelete = true
          this.canUpdate = true
        }
      } else {
        this.canUpdate = true
        this.canDelete = true
      }
      } else {
        this.canUpdate = true
        this.canDelete = true
      }
    },
    //删除
    handleDelete() {
			if (this.multipleSelection.length == 0) {
					this.$message({
							message: "请选择记录！",
							type: "warning"
					});
					return;
			}
			this.$confirm("确定删除数据吗?", "提示", {
					confirmButtonText: "确定",
					cancelButtonText: "取消",
					type: "warning"
			}).then(() => {
					this.listLoading = true;
					deleteInterviewRecords({id:[this.multipleSelection[0].recordId]})
						.then(response => {
								this.$notify({
										title: "成功",
										message: "删除成功",
										type: "success",
										offset: 70,
										duration: 2000
								});
								this.handleQuery();
						})
						.catch(() => {
								this.listLoading = false;
						});
			});
    },
    //excel无模板导出
    handleExportNoTemplateExcel() {
	  var excelListQuery = {}
      excelListQuery = Object.assign(excelListQuery, this.listQuery)
      // 加载遮盖
      // 加载遮盖
      openloading(this, '.hx-table')
      excelListQuery.classfunction =
        "org.hx.aisite.interviewrecords.excel.InterviewRecordsHtmlExportService#exportExcel";
      excelListQuery.filename = "存储咨询访谈详细记录的表列表.xls";
      exportNoTemplateExcel(excelListQuery).then((response) => {
        this.loading.close()
      });
    }		
  }
};
</script>
