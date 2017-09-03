/**
 * Created by admin on 01.09.2017.
 */
Ext.define("BookList.view.registration.Registration", {
    extend: 'Ext.window.Window',
    xtype: 'registration',

    requires: [
        'BookList.view.registration.RegistrationController',
        'Ext.form.Panel'
    ],

    controller: 'registration',
    bodyPadding: 10,
    title: 'Регистрация',
    closable: false,
    autoShow: true,

    items: {
        xtype: 'form',
        reference: 'form',
        items: [{
            xtype: 'textfield',
            reference: 'login',
            name: 'login',
            fieldLabel: 'Пользователь',
            allowBlank: false
        },
        {
            xtype: 'textfield',
            name: 'email',
            reference: 'email',
            fieldLabel: 'Емаил',
            allowBlank: false
        },
        {
            xtype: 'textfield',
            name: 'password',
            reference: 'password',
            inputType: 'password',
            fieldLabel: 'Пароль',
            allowBlank: false
        },
        {
            xtype: 'textfield',
            name: 'repassword',
            reference: 'repassword',
            inputType: 'password',
            fieldLabel: 'Повторить пароль',
            allowBlank: false
        }
        ],
        buttons: [{
            text: 'Создать',
            formBind: true,
            listeners: {
                click: 'onCreateClick'
            }
        }, {
            text: 'Отмена',
            listeners: {
                click: 'onCancel'
            }
        }]
    }
});