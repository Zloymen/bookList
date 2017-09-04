/**
 * Created by Zloy on 04.09.2017.
 */
Ext.define('BookList.model.BookMarkModel', {
    extend: 'Ext.data.Model',
    idProperty:'id',
    fields: ['id',
        'dateCreate',
        'dateDelete',
        'book']/*,
    hasMany: [{
            model: 'BookList.model.BookModel',
            name: 'book'
        }
    ]*/
});