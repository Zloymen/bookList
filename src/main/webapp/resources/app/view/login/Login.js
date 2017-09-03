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
    title: 'Авторизация',
    closable: false,
    autoShow: true,

    items: {
        xtype: 'form',
        reference: 'form',
        items: [{
                xtype: 'textfield',
                reference: 'username',
                name: 'username',
                fieldLabel: 'Пользователь',
                allowBlank: false
            }, {
                xtype: 'textfield',
                name: 'password',
                reference: 'password',
                inputType: 'password',
                fieldLabel: 'Пароль',
                allowBlank: false
            }
        ],
        buttons: [{
            text: 'Войти',
            formBind: true,
            listeners: {
                click: 'onLoginClick'
            }
        }, {
            text: 'Регистрация',
            listeners: {
                click: 'onRegistationClick'
            }
        }]
    }
});