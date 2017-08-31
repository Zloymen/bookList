/**
 * Created by admin on 31.08.2017.
 */
Ext.define("BookList.view.login.Login", {
    extend: 'Ext.window.Window',
    xtype: 'login',

    requires: [
        'BookList.view.login.LoginController',
        'Ext.form.Panel'
    ],

    controller: 'login',
    bodyPadding: 10,
    title: 'Login Window',
    closable: false,
    autoShow: true,

    items: {
        xtype: 'form',
        reference: 'form',
        items: [{
            xtype: 'textfield',
            name: 'username',
            fieldLabel: 'Пользователь',
            allowBlank: false
        }, {
            xtype: 'textfield',
            name: 'password',
            inputType: 'password',
            fieldLabel: 'Пароль',
            allowBlank: false
        }, {xtype: 'label',
            html: 'Нету учетной записи? <a href="#" onClick="javascript:appName.app.getController(\'myController\').showRegistration();">Регистрация</a>'
        }
        ],
        buttons: [{
            text: 'Войти',
            formBind: true,
            listeners: {
                click: 'onLoginClick'
            }
        }, {
            text: 'Отмена',
            listeners: {
                click: 'onCancel'
            }
        }]
    }
});