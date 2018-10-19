/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var btnLogin = document.getElementById('linkLogin');
var message = document.getElementById('message');
console.log(btnLogin);

function loginGet() {
    console.log('loginGET');
    $.ajax({
        type: 'GET',
        data: {},
        url: ctx + '/login.htm',
        error: function (xhr, status, error) {
            message.innerHTML = ('Error: ', error);
        }
    });
}

btnLogin.addEventListener('click', function () {
    console.log('--- click');
    loginGet();
});