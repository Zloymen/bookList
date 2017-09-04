/**
 * Created by Zloy on 04.09.2017.
 */
Ext.define('BookList.view.profile.ProfileController', {
    extend: 'Ext.app.ViewController',

    alias: 'controller.profile',

    onAfterRender : function( _self, eOpts){
        Ext.Ajax.request({
            url: '/authorize/user',
            method: 'GET',
            panel: this,
            success: function (response, opt) {
                var result = Ext.decode(response.responseText);
                if(result.error){
                    console.log(result.message);
                    return;
                }
                var login = opt.panel.lookupReference('login');
                login.setValue(result.object.login);
                var email = opt.panel.lookupReference('email');
                email.setValue(result.object.email);
            }
        });
    }
});