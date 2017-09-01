/**
 * Created by admin on 01.09.2017.
 */

Ext.define('BookList.view.registration.RegistrationController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.registration',

    onCancel : function(){
        this.getView().destroy();
        Ext.widget('login');
    }

});
