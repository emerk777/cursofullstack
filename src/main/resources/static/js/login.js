$(document).ready(function() {

});

async function loginFE(){

    let datos = {};
    datos.email = document.getElementById('txtInputEmail').value;
    datos.password = document.getElementById('txtInputPassword').value;

  const request = await fetch('api/login', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });

  const response = await request.text();

  if(response == "OK"){
//        alert("Ok");
        window.location.href = "users.html";
  }else{
        alert("Invalid Credentials");
  }
}
