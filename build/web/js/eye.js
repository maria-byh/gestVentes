e=true;


function changer1(){
    if(e){
        document.getElementById("pass1").setAttribute("type","text");
        document.getElementById("eye1").setAttribute("class","fa fa-eye show-pass");

        e=false;
    }else{
        document.getElementById("pass1").setAttribute("type","password");
        document.getElementById("eye1").setAttribute("class","fa fa-eye-slash show-pass");
       
       e=true;
    }
}
function changer2(){
    if(e){
        document.getElementById("pass2").setAttribute("type","text");
        document.getElementById("eye2").setAttribute("class","fa fa-eye show-pass");

        e=false;
    }else{
        document.getElementById("pass2").setAttribute("type","password");
        document.getElementById("eye2").setAttribute("class","fa fa-eye-slash show-pass");
       
       e=true;
    }
}