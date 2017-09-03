/**
 * This class is the controller for the main view for the application. It is specified as
 * the "controller" of the Main view class.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('BookList.view.main.MainController', {
    extend: 'Ext.app.ViewController',

    requires: [
        'BookList.component.bookgrid.BookGrid'
    ],

    alias: 'controller.main',

    onItemSelected: function (sender, record) {
        Ext.Msg.confirm('Confirm', 'Are you sure?', 'onConfirm', this);
    },

    onConfirm: function (choice) {
        if (choice === 'yes') {
            //
        }
    },

    onLogoutButton: function () {


        Ext.Ajax.request({
            url: 'logout',
            method: 'POST',
            extraParams: this,
            success: function (response, opts) {

                // Remove the localStorage key/value
                localStorage.removeItem('loggedIn');

                // Remove Main View
                opts.extraParams.getView().destroy();

                // Add the Login Window
                Ext.widget('login');
            },
            failure: function (response, opts) {
                console.log('ошибка');
            }
        });

    },

    onMainPanelClick: function(){
        var mainPanel = this.lookupReference('mainPanel');
        mainPanel.removeAll();
        var grid = Ext.create('BookList.component.bookgrid.BookGrid',{});
        mainPanel.add(grid);
    },

    onAboutClick: function(){
        var mainPanel = this.lookupReference('mainPanel');
        mainPanel.removeAll();
        var grid = Ext.create('Ext.panel.Panel',{title: 'О программе', layout: 'fit'});
        mainPanel.add(grid);
    },

    onBookmarksClick: function(){
        var mainPanel = this.lookupReference('mainPanel');
        mainPanel.removeAll();
        var grid = Ext.create('Ext.panel.Panel',{title: 'Закладки', layout: 'fit'});
        mainPanel.add(grid);
    },

    onSettingClick: function(){
        var mainPanel = this.lookupReference('mainPanel');
        mainPanel.removeAll();
        var grid = Ext.create('Ext.panel.Panel',{title: 'Настройки', layout: 'fit'});
        mainPanel.add(grid);
    }
});
