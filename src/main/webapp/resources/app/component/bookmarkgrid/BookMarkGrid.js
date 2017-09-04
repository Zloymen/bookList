/**
 * Created by Zloy on 04.09.2017.
 */
Ext.define("BookList.component.bookmarkgrid.BookMarkGrid", {
    extend: 'Ext.grid.Panel',
    xtype: 'bookmarkgrid',
    title: 'Закладки',

    requires: [
        'BookList.store.BookMarkStore'
    ],

    store: {
        type: 'BookMarkStore'
    },
    constructor: function (config) {

        var dateRenderer = function (value, metaData, record) {
            var date = Ext.Date.parse(value, 'time');
            return Ext.Date.format(date, 'd.m.Y \TH:i:sP');
        };

        var self = this;

        config.columns = [{
            text: '№',
            width: 50,
            renderer: function(value, meta, record, rowIndex, colIndex){
                return rowIndex + 1;
            }
        },{
            text: 'Название',
            sortable: true,
            dataIndex: 'book',
            renderer: function (value, metaData, record) {
                return value ||  value.name ? value.name : "Нет названия";
            },
            flex: 2
        }, {
            text: 'Автор',
            sortable: true,
            dataIndex: 'book',
            renderer: function (value, metaData, record) {
                return value ||  value.author ? value.author : "Нет автора";
            },
            flex: 2
        },  {
            text: 'Добавлено',
            sortable: false,
            dataIndex: 'dateCreate',
            renderer: dateRenderer,
            width: 200
        },{
            header: 'Удалено',
            sortable: true,
            dataIndex: 'dateDelete',
            renderer: dateRenderer,
            width: 200
        }];

        this.callParent(arguments);

        Ext.Ajax.request({
            url: '/authorize/bookmarks',
            method: 'GET',
            storeImp: self.getStore(),
            success: function (response, opt) {
                var result = Ext.decode(response.responseText);
                opt.storeImp.proxy.data = {list : result.list, total : 0};
                opt.storeImp.load();
            }
        });



    }
});