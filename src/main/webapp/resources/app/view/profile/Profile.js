/**
 * Created by Zloy on 04.09.2017.
 */
Ext.define('BookList.view.profile.Profile', {
    extend: 'Ext.panel.Panel',
    xtype: 'profile',
    controller: 'profile',
    title: 'Профиль',
    requires: [
        'BookList.view.profile.ProfileController'
    ],
    listeners:{
        afterrender: 'onAfterRender'
    },
    constructor: function (config) {

        var loginField = Ext.create('Ext.form.field.Text', {
            fieldLabel: 'Логин',
            valueField: 'login',
            editable: false,
            name: 'login',
            reference: 'login'
        });

        var mailField = Ext.create('Ext.form.field.Text', {
            fieldLabel: 'email',
            valueField: 'email',
            name: 'email',
            reference: 'email'
        });

        this.items = [loginField, mailField];
        this.callParent(arguments);
    }

});