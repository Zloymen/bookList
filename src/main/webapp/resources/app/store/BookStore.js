/**
 * Created by Zloy on 03.09.2017.
 */
Ext.define('BookList.store.BookStore', {
    extend: 'Ext.data.Store',

    alias: 'store.BookStore',

    autoLoad: true,
    autoSync: true,
    model: 'BookList.model.BookModel',

    proxy: {
        type: 'memory',/*
         enablePaging:true,*/
        reader: {
            type: 'json',
            root : 'list',
            totalProperty : 'total'
        }
    }
});