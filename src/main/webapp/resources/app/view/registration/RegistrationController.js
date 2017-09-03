/**
 * Created by admin on 01.09.2017.
 */

Ext.define('BookList.view.registration.RegistrationController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.registration',

    onCreateClick: function(){
        var request = this.lookupReference('form').getValues();
        //валидация
        Ext.Ajax.request({
            url: 'registration',
            method: 'POST',
            extraParams: this,
            params: request,
            success: function (response, opts) {

                opts.extraParams.getView().destroy();
                Ext.widget('login');
            },
            failure: function (response, opts) {
                console.log('ошибка');
            }
        });

    },

    onCancel : function(){
        this.getView().destroy();
        Ext.widget('login');
    }

});
