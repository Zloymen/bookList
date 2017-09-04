/**
 * Created by Zloy on 03.09.2017.
 */
Ext.define("BookList.component.bookgrid.BookGrid", {
    extend: 'Ext.grid.Panel',
    xtype: 'bookgrid',
    title: 'Книги',

    requires: [
        'BookList.store.BookStore'
    ],

    store: {
        type: 'BookStore'
    },
    constructor: function (config) {

        var self = this;

        config.columns = [{
            text: '№',
            width: 50,
            renderer: function(value, meta, record, rowIndex, colIndex){
                return rowIndex + 1;
            }
        }, { xtype: 'checkcolumn', text: 'Избранное', dataIndex: 'favorite', flex: 1, listeners:{
            checkchange : function( _self, rowIndex, checked ){
                var record = self.getStore().getAt(rowIndex);

                Ext.Ajax.request({
                    url: '/authorize/favorite',
                    method: 'POST',
                    record: record,
                    params: {id: record.get('id'), favorite: record.get('favorite')},
                    success: function (response, opt) {
                        console.log(opt.record);
                        if(opt.record) opt.record.commit();
                    },
                    failure: function (response, opt) {
                        //todo error
                        if(opt.record) opt.record.rollback();
                    }
                });

            }
        }
        },{
            text: 'Название',
            sortable: true,
            dataIndex: 'name',
            field: {
                xtype: 'textfield'
            },
            flex: 2
        }, {
            text: 'Автор',
            sortable: true,
            dataIndex: 'author',
            flex: 2
        },  {
            text: 'Обложка',
            sortable: false,
            dataIndex: 'fileId',
            renderer: function (value) {

              return '<img style="width-max: 200px; max-height: 200px" src="export/' + value + '"/>';
            },
            flex: 3
        },{
            header: 'Год',
            sortable: true,
            dataIndex: 'year',
            width: 100
        }];

        this.callParent(arguments);

        Ext.Ajax.request({
            url: '/authorize/books',
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