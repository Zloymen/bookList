/**
 * Created by admin on 31.08.2017.
 */
Ext.define('BookList.view.login.LoginController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.login',

    onLoginClick: function () {

        var login = this.lookupReference('username'),
            password = this.lookupReference('password');

        var request = {login: login.getValue(), password: password.getValue()};

        Ext.Ajax.request({
            url: 'login',
            method: 'POST',
            extraParams: this,
            jsonData: Ext.encode(request),
            success: function (response, opts) {

                // Set the localStorage value to true
                localStorage.setItem("TutorialLoggedIn", true);

                // Remove Login Window
                opts.extraParams.getView().destroy();

                // Add the main view to the viewport
                Ext.widget('app-main');
            },
            failure: function (response, opts) {
                console.log('ошибка');
            }
        });

    },
    onRegistationClick: function () {
        this.getView().destroy();
        Ext.widget('registration');
    }
});