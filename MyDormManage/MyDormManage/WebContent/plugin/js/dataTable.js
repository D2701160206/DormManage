$(document).ready(function () {

    $('.datatable').dataTable({
        // 是否允许检索
        "searching": false,
        // 是否允许排序
        "ordering": false,
        // 是否显示情报 就是"当前显示1/100记录"这个信息
        "info": false,
        // 水平滚动条
        // "scrollX": false,
        // 垂直滚动条
        // "scrollY": false,
        // 水平滚动条
        // "scrollX": false,
        // 垂直滚动条
        // "scrollY": false,
        // 件数选择功能 默认true
        "lengthChange": false,
        // 件数选择下拉框内容
        // "lengthMenu": [10, 25, 50, 75, 100],
        // 每的页初期件数 用户可以操作lengthMenu上的值覆盖
        "pageLength": 6,
        //翻页按钮样式
        // numbers:数字
        // simple:前一页，后一页
        // simple_numbers:前一页，后一页，数字
        // full:第一页，前一页，后一页，最后页
        //full_numbers:第一页，前一页，后一页，最后页，数字
        //first_last_numbers:第一页，最后页，数字
        "pagingType": "full_numbers",
        // 行样式应用 指定多个的话，第一行tr的class为strip1，第二行为strip2，第三行为strip3.
        // 第四行以后又开始从strip1循环。。。 如果想指定成斑马条状，这里的class必须指定为2个。
        // "stripeClasses": ['strip1', 'strip2', 'strip3'],
        // 自动列宽
        // "autoWidth": true,
        // 每次创建是否销毁以前的DataTable,默认false
        "destroy": true,
        // "paging":false,
        // 服务器查询数据属性
        "serverSide": false,
        "language":{
              // 翻页按钮文字控制
              "paginate": {
                "first": "首页",
                "last": "尾页",
                "next": "下一页",
                "previous": "上一页"
            },
        }

        


        /* //自增列
         "fnDrawCallback": function () {
             this.api().column(0).nodes().each(function (cell, i) {
                 cell.innerHTML = i + 1;
             });
         },*/
    });
});
