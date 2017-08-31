/**
 * Created by admin on 31.08.2017.
 */
Ext.define('BookList.view.login.LoginController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.login',

    onLoginClick: function () {
        // Set the localStorage value to true
        localStorage.setItem("TutorialLoggedIn", true);

        // Remove Login Window
        this.getView().destroy();

        // Add the main view to the viewport
        Ext.widget('app-main');
    }
});