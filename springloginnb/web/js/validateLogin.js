/* 
 * Document   : JavaScript validateLogin
 * Description: Ese archivo contiene las funciones para validar la página de login
 * Created on : oct 17, 2018, 12:38:17 p.m.
 * Author     : avilchis
 */
var usrpsw = document.getElementById('passwd');
var usrnm = document.getElementById('userName');
var btnLgn = document.getElementById('btnLogin');
var message = document.getElementById('message');
var usrMss = document.getElementById('userMessage');
var usrPss = document.getElementById('userPassword');

var patUser = new RegExp(/[A-Z]{4,12}$/);
var patPass = new RegExp(/[A-Za-z0-9._%$+-]{6,12}$/);

function validateLogin() {
    console.log('validateLogin()');
    if (usrnm.value !== null || usrnm.value !== '' ||
            usrpsw.value !== null || usrpsw.value !== ''){
        message.innerHTML = 'Ningún campo debe quedar vacio';
    }
}

function validaStringUser() {
    var compUser = patUser.test(usrnm.value);
    if (compUser !== true) {
        console.log(compUser);
        usrMss.innerHTML = 'Usuario: no cumple con la política solicitada.';
        usrMss.style.color = "rgb(229, 115, 115)";
    }else{
        usrMss.innerHTML = '';
    }
}
function validaStringPass() {
    var compPass = patPass.test(usrpsw.value);
    if (compPass !== true) {
        usrPss.innerHTML = 'Password: no cumple con la política solicitada.';
        usrPss.style.color = "rgb(229, 115, 115)";
    }else{
        usrPss.innerHTML = '';
    }
}

usrnm.addEventListener('focus', event => {
    usrMss.innerHTML = 'Puedes ingresar entre 4 y 12 letras';
    usrMss.style.color = "green";
    
}, false);

usrpsw.addEventListener('focus', event => {
    usrPss.innerHTML = 'Puedes ingresar entre 6 y 12 letras números y estos caracteres @$_-.';
    usrPss.style.color = "green";
}, false);

usrnm.addEventListener('blur', event => {
    validaStringUser();
    if (usrnm.value === null || usrnm.value === '' ){
        usrMss.innerHTML = 'El Usuario es obligatorio.';
        usrMss.style.color = "rgb(229, 115, 115)";
    }else{
        usrnm.value === usrnm.value.toUpperCase();
        //btnLgn.removeAttribute('disabled');
        //btnLgn.setAttribute('enabled');
    }
}, false);

usrpsw.addEventListener('blur', event => {
    validaStringPass();
    if (usrpsw.value === null || usrpsw.value === ''){
        usrPss.innerHTML = 'La Contraseña es obligatoria.';
        usrPss.style.color = "rgb(229, 115, 115)";
    }else{
        //btnLgn.removeAttribute('disabled');
        //btnLgn.setAttribute('enabled');
    }
}, false);


function validaUsuario(event) {
    var unicode = event.charCode ? event.charCode : event.keyCode;
    if (unicode == 8 || unicode == 9 || unicode == 13)
        return true;
    if (unicode >= 65 && unicode <= 90 || unicode >= 97 && unicode <= 122)  
    {
        return true;
    } else {
        return false;
    }
}

function validaPassword(event) {
    var unicode = event.charCode ? event.charCode : event.keyCode;
    if (unicode === 8 || unicode == 9 || unicode === 13)
        if (usrpsw.value != null || usrpsw.value != '')
            return true;
    if (unicode == 36 || unicode == 64 || unicode == 45 || unicode == 46 || unicode == 95 ||
            ((unicode >= 48) && (unicode <= 57)) ||
            ((unicode >= 65) && (unicode <= 90)) ||
            ((unicode >= 97) && (unicode <= 122)))
        return true;
    else
        return false;
}

function toMayus(event) {
    event.value = event.value.toUpperCase();
}

function loginPost(user, passwd) {
    console.log('loginPOST');
    console.log('usrnm', user);
    console.log('usrpsw', passwd);
    $.ajax({
        type: 'POST',
        url: ctx + '/login.htm',
        data: {
            userName: user,
            passwd: passwd
        },
        beforeSend: function () {
        },
        success: function (data) {
        },
        error: function (xhr, status, error) {
            //message.innerHTML = ('Error: ', error)
        }
    });
}

