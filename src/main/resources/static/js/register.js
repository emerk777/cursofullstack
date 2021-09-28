$(document).ready(function() {

});

async function registerUserFE(){

    let datos = {};
    datos.name = document.getElementById('txtFirstName').value;
    datos.lastName = document.getElementById('txtLastName').value;
    datos.telephone = document.getElementById('txtPhoneNumber').value;
    datos.email = document.getElementById('txtEmail').value;
    datos.password = document.getElementById('txtPassword').value;

    let repeatPassword = document.getElementById('txtRepeatPassword').value;

    if(repeatPassword != datos.password){
        alert("Passwords do not match");
        return;
    }

  const request = await fetch('api/users', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
  const users = await request.json();

}
