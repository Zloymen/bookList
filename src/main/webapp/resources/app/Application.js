/**
 * The main application class. An instance of this class is created by app.js when it
 * calls Ext.application(). This is the ideal place to handle application launch and
 * initialization details.
 */
Ext.define('BookList.Application', {
    extend: 'Ext.app.Application',

    name: 'BookList',

    quickTips: false,
    platformConfig: {
        desktop: {
            quickTips: true
        }
    },

    stores: [
        // TODO: add global / shared stores here
    ],

    views: [
        'BookList.view.login.Login',
        'BookList.view.registration.Registration'
    ],

    launch: function () {
        Ext.Ajax.on('requestexception', function(connection,response) {
            console.log('error exeption', response);
            if(response.status === 401) {
                localStorage.removeItem("loggedIn");
                document.location.reload(true);
            }
            Ext.create('Ext.window.Window', {
                title: 'Ошибка',
                height: 200,
                width: 400,
                layout: 'fit',
                html: 'Произошла ошибка! Обратитесь в службу поддержки'
            }).show();
        });
        var loggedIn  = localStorage.getItem("loggedIn");

        Ext.widget(loggedIn ? 'app-main' : 'login');
    },

    onAppUpdate: function () {
        Ext.Msg.confirm('Application Update', 'This application has an update, reload?',
            function (choice) {
                if (choice === 'yes') {
                    window.location.reload();
                }
            }
        );
    }
});
