// Call the dataTables jQuery plugin
$(document).ready(function() {
    loadUsers();
  $('#users').DataTable();
});

async function loadUsers(){

  const request = await fetch('api/users', {
    method: 'GET',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  const users = await request.json();

  let usersList = '';

  for(let user of users){
    let buttonDelete = '<a href="#" onclick="removeUserFE('+user.id+')" class="btn btn-danger btn-circle"><i class="fas fa-trash"></i></a>';
    let userHTML = '<tr><td>'+user.id+'</td> <td>'
        +user.name+' '+user.lastName+'</td><td>'
        +user.email+'</td><td>'
        +user.telephone+'</td><td>'
        +buttonDelete+'</td></tr>';

        usersList += userHTML;
    }

  document.querySelector("#users tbody").outerHTML = usersList;

  console.log(users);

}

async function removeUserFE(id){
//    alert(id);
    if(!confirm("do you want to delete this user?")){
        return;
    }

  const request = await fetch('api/users/' +id, {
    method: 'DELETE',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    }
  });

  location.reload();
}
