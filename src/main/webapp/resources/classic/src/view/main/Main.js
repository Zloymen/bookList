/**
 * This class is the main view for the application. It is specified in app.js as the
 * "mainView" property. That setting automatically applies the "viewport"
 * plugin causing this view to become the body element (i.e., the viewport).
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */

Ext.define('BookList.view.main.Main', {
    extend: 'Ext.container.Container',
    plugins: 'viewport',
    requires: [
        'BookList.view.main.MainController',
        'BookList.view.main.MainModel'
    ],

    xtype: 'app-main',

    layout: 'border',

    controller: 'main',
    viewModel: {
        type: 'main'
    },


/*    items: [{xtype: 'mainPanel'}]*/

    items: [{
        xtype: 'panel',
        bind: {
            title: '{name}'
        },
        region: 'west',
        //html: '<ul><li>This area is commonly used for navigation, for example, using a "tree" component.</li></ul>',
        width: 250,
        split: true,
        items:[{
            xtype: 'button',
            text: 'Книги',
            style: {
                width: '100%',
                marginBottom: '5px',
                marginTop: '5px'
            },
            handler: 'onMainPanelClick'
        },{
            xtype: 'button',
            text: 'Закладки',
            style: {
                width: '100%',
                marginBottom: '5px',
                marginTop: '5px'
            },
            handler: 'onBookmarksClick'
        },{
            xtype: 'button',
            text: 'Настройки',
            style: {
                width: '100%',
                marginBottom: '5px',
                marginTop: '5px'
            },
            handler: 'onSettingClick'
        },{
            xtype: 'button',
            text: 'О программе',
            style: {
                width: '100%',
                marginBottom: '5px',
                marginTop: '5px'
            },
            handler: 'onAboutClick'
        }, {
            xtype: 'button',
            text: 'Выход',
            style: {
                width: '100%',
                marginBottom: '5px',
                marginTop: '5px'
            },
            handler: 'onLogoutButton'
        }]
    }, {
        region: 'center',
        xtype: 'panel',
        scrollable:'y',
        reference: 'mainPanel'/*,
        items: [{xtype: 'grid', title: 'Книги'}]*/
    }]
});

