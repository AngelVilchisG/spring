/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
console.log('carga js');
var usrnm = document.getElementById('userName');
var usrpsw = document.getElementById('passwd');
var message = document.getElementById('message');

function validateLogin() {
    console.log('VALIDATE');
    if (usrnm.value == null || usrpsw.value == null) {
        usrnm.style('border-bottom', '1px solid rgb(229, 115, 115');
        usrpsw.style('border-bottom', '1px solid rgb(229, 115, 115');
        message.innerHTML = "Ningún campo debe estar vacio";

    } else {
        loginPost();
    }
}
/*
function validaUsuario(event) {
    console.log('validaUsuario');
    var unicode = event.charCode ? event.charCode : event.keyCode;
    if (unicode == 8 || unicode == 13)
        return true;
    if (unicode >= 65 && unicode <= 90 || unicode >= 97 && unicode <= 122) {
        return true;
    } else {
        return false;
    }

}
*/
function validarPassword(event) {
    var unicode = event.charCode ? event.charCode : event.keyCode;
    if (unicode === 8 || unicode === 13)
        return true;
    if (unicode == 64 || unicode == 45 || unicode == 46 || unicode == 95 ||
            ((unicode >= 48) && (unicode <= 57)) ||
            ((unicode >= 65) && (unicode <= 90)) ||
            ((unicode >= 97) && (unicode <= 122)))
        return true;
    else
        return false;
}

function loginPost() {
    console.log('loginPOST');
    $.ajax({
        type: 'POST',
        data: {
            user: usrnm.value,
            pasword: usrpsw.value
        },
        url: ctx + '/login.htm',
        beforeSend: function () {
        },
        success: function (data) {
        },
        error: function (xhr, status, error) {
            message.innerHTML = ('Error: ', error)
        }
    });
}

function init(msgError) {
//    console.log(msgError);
}
