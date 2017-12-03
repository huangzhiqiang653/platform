$(function () {
    $("#jqGrid").jqGrid({
        url: '../sys/log/list',
        datatype: "json",
        colModel: [
            {label: 'id', name: 'id', key: true, hidden: true},
            {label: '用户名', name: 'userName', width: 50},
            {label: '用户操作', name: 'operation', width: 70},
            {label: '方法', name: 'title', width: 150},
            {label: '请求参数', name: 'params', width: 80},
            {label: 'IP地址', name: 'ip', width: 70},
            {
                label: '创建时间', name: 'createDate', width: 90, formatter: function (value) {
                return transDate(value);
            }
            }
        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: false,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            key: null
        },
        isLogin: []
    },
    methods: {
        query: function () {
            vm.reload();
        },
        reload: function (event) {
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');

            let operation = '';
            if (vm.isLogin && vm.isLogin.length > 0) {
                operation = vm.isLogin[0];
            }
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {'key': vm.q.key, 'operation': operation},
                page: page
            }).trigger("reloadGrid");
        },
        reloadSearch: function () {
            vm.q = {
                key: ''
            }
            vm.isLogin = [];
            vm.query();
        }
    }
});