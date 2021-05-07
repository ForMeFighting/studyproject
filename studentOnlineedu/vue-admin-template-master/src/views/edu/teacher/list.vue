<template>
  <el-container>
    <el-main>
      <!--查询表单-->
      <el-form :inline="true" class="demo-form-inline">
        <el-form-item>
          <el-input v-model="queryParam.data.name" placeholder="讲师名"/>
        </el-form-item>

        <el-form-item>
          <el-select v-model="queryParam.data.level" clearable placeholder="讲师头衔">
            <el-option :value="1" label="高级讲师"/>
            <el-option :value="2" label="首席讲师"/>
          </el-select>
        </el-form-item>

        <el-form-item label="添加时间">
          <el-date-picker
            v-model="queryParam.data.begin"
            type="datetime"
            placeholder="选择开始时间"
            value-format="yyyy-MM-dd HH:mm:ss"
            default-time="00:00:00"
          />
        </el-form-item>
        <el-form-item>
          <el-date-picker
            v-model="queryParam.data.end"
            type="datetime"
            placeholder="选择截止时间"
            value-format="yyyy-MM-dd HH:mm:ss"
            default-time="00:00:00"
          />
        </el-form-item>

        <el-button type="primary" icon="el-icon-search" @click="fetchData()">查询</el-button>
        <el-button type="default" @click="resetData()">清空</el-button>
      </el-form>
      <!-- 表格 -->
      <el-table
        v-loading="listLoading"
        :data="list"
        element-loading-text="数据加载中"
        border
        fit
        highlight-current-row>

        <el-table-column
          label="序号"
          width="70"
          align="center"
          type="index">
        </el-table-column>
        <el-table-column prop="name" label="名称" width="80" />
        <el-table-column label="头衔" width="80">
          <template slot-scope="scope">
            {{ scope.row.level===1?'高级讲师':'首席讲师' }}
          </template>
        </el-table-column>

        <el-table-column prop="intro" label="资历" />

        <el-table-column prop="gmtCreate" label="添加时间" width="160"/>

        <el-table-column prop="sort" label="排序" width="60" />

        <el-table-column label="操作" width="200" align="center">
          <template slot-scope="scope">
            <router-link :to="'/edu/teacher/edit/'+scope.row.id">
              <el-button type="primary" size="mini" icon="el-icon-edit">修 改</el-button>
            </router-link>
            <el-button type="danger" size="mini" icon="el-icon-delete" @click="removeById(scope.row.id)">删 除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <!-- 分页 -->
      <el-pagination
        :current-page="queryParam.pageInfo.pageNum"
        :page-size="queryParam.pageInfo.pageSize"
        :total="total"
        style="padding: 30px 0; text-align: center;"
        layout="total, prev, pager, next, jumper"
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
      />
    </el-main>
  </el-container>
</template>

<script>
  import teacher from '../../../api/edu/teacher'
  export default {
    name: "list",
    data() {// 定义数据
      return {
        listLoading: true, // 是否显示loading信息
        list: null, // 数据列表
        queryParam: {
          data: {},
          pageInfo: {
            pageNum: 1,
            pageSize: 10,
          }
        },
      }
    },

    created() { // 当页面加载时获取数据
      this.fetchData()
    },

    methods: {
      fetchData() { // 调用api层获取数据库中的数据
        console.log('加载列表')
        this.listLoading = true
        teacher.getPageList(this.queryParam).then(response => {
          // debugger 设置断点调试
          if (response.success === true) {
            this.list = response.data.list
            this.queryParam.pageInfo.total = response.data.total
          }
          this.listLoading = false
        })
      },
      resetData() {
        this.queryParam.data = {}
        this.queryParam.pageInfo.pageNum = 1
        this.fetchData()
      },
      removeById(id) {
          this.$confirm('此操作将永久删除该记录, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            teacher.removeById(id).then(response => {
              if (response.success === 0) {
                this.$message({
                  type: 'success',
                  message: '删除成功!'
                })
              } else{
                this.$message({
                  type: 'warning',
                  message: response.message
                })
              }
            })
          }).then(() => {
            this.fetchData()
            this.$message({
              type: 'success',
              message: '删除成功!'
            })
          }).catch((response) => { // 失败
            if (response === 'cancel') {
              this.$message({
                type: 'info',
                message: '已取消删除'
              })
            } else {
              this.$message({
                type: 'error',
                message: '删除失败'
              })
            }
          })
        },
      handleSizeChange(val) {
        console.log(`每页 ${val} 条`)
        this.queryParam.pageInfo.pageSize = val
        this.fetchData()
      },
      handleCurrentChange(val) {
        console.log(`当前页: ${val}`)
        this.queryParam.pageInfo.pageNum = val
        this.fetchData()
      },
    }
  }
</script>

<style scoped>

</style>
