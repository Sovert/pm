  layui.use('table', function () {
    var table = layui.table;
    var queryData = [];
    layui.jquery.ajax({//异步请求返回给后台
            url:'/plan/query',
            type:'post',
            data:{},
            dataType:'json',
            contentType: "application/json; charset=utf-8",
            success:function(jsonData){
            //这里获取到数据执行显示
                if(jsonData.code == 0) {
                var tableDataList = jsonData.data;
                for(var index in tableDataList) {
                    tableDataMap = tableDataList[index];
//                    if(tableDataMap["confirmPerson"] == null) {
                        tableDataMap["opt"] = '<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a><a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>'
//                    }
                }
                    table.render({
                          elem: '#planGrid'
                          // , url: '/demo/table/user/'
                          , cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
                          ,toolbar:true
                          ,limit:400
                          ,defaultToolbar: ['filter', 'print', 'exports']
                          , cols: [[
                            { field: 'id', width: 55, title: 'ID', sort: true,print: false }
                            , { field: 'commitDate', width: 120, title: '提出日期' , sort: true}
                            , { field: 'commitPerson', width: 80, title: '提交人', sort: true }
                            , { field: 'confirmPerson', width: 80, title: '确认人', sort: true }
                            , { field: 'requirementType', title: '需求类型', width: 100, sort: true}
                            , { field: 'requirementModule', title: '需求模块', width: 100, sort: true}
                            , { field: 'requirementDescription', title: '需求描述', sort: true}
                            , { field: 'developPerson', title: '开发人员', width: 102, sort: true}
                            , { field: 'beginDate', title: '开始时间', width: 102, sort: true}
                            , { field: 'endDate', width: 102, title: '结束时间', width: 102, sort: true}
                            , { field: 'state', title: '状态', width: 102, sort: true}
                            , { field: 'notes', title: '备注', width: 102, sort: true}
                            , { field: 'opt', width: 137, title: '', width: 120 }
                          ]],data: tableDataList
                        });

                        //监听工具条
                          table.on('tool(planGrid)', function(obj){
                            var data = obj.data;
                            if(obj.event === 'del'){
                                var id = data.id;
                              layer.confirm('真的删除行么', function(index){
                                layui.jquery.ajax({//异步请求返回给后台
                                        url:'/plan/delete',
                                        type:'delete',
                                        data:JSON.stringify(id),
                                        dataType:'json',
                                        contentType: "application/json; charset=utf-8",
                                        success:function(data){
                                        //这里获取到数据执行显示
                                            if(data.code == 0) {
                                                obj.del();
                                                layer.close(index);
                                            }
                                            return false;
                                         }
                                     });

                              });
                            } else if(obj.event === 'edit'){
                              location.href="edit?id=" + data.id;
                            }
                          });
                }
             }
         });

        layui.jquery(document).on('click','#add',function(){
                             location.href="edit"
                     });

                layui.jquery(document).on('click','#export',function(){
                                             location.href="file"
                                     });
  });



