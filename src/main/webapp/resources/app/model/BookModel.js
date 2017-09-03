/**
 * Created by Zloy on 03.09.2017.
 */
Ext.define('BookList.model.BookModel', {
    extend: 'Ext.data.Model',
    idProperty:'id',
    fields: ['id',
        'name',
        'author',
        'year',
        'fileId']
});