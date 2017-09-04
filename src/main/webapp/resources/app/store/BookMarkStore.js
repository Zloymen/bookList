/**
 * Created by Zloy on 04.09.2017.
 */
Ext.define('BookList.store.BookMarkStore', {
    extend: 'Ext.data.Store',

    alias: 'store.BookMarkStore',

    autoLoad: true,
    autoSync: true,
    model: 'BookList.model.BookMarkModel',

    proxy: {
        type: 'memory',
        reader: {
            type: 'json',
            root : 'list',
            totalProperty : 'total'
        }
    }
});