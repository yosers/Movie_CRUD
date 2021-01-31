function validate() {
    var name = document.getElementById("name").value;
    var phone = document.getElementById("phone").value;
    var email = document.getElementById("email");
    var mailformat = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (document.myForm.name.value == "") {
        alert("Please input name !");
        document.myForm.name.focus();
        return false;
    }
    if (name.length >= 50) {
        alert("Maximum character name is 50 !");
        document.myForm.name.focus();
        return false;
    }
    if (document.myForm.phone.value == "") {
        alert("Please input phone !");
        document.myForm.phone.focus();
        return false;
    }
    if (phone.length <= 10) {
        alert("Minimum 10 number !");
        document.myForm.phone.focus();
        return false;
    }
    if (document.myForm.email.value == "") {
        alert("Please input email !");
        document.myForm.email.focus();
        return false;
    }
    if (!email.value.match(mailformat)) {
        alert("Please input correct email address !");
        document.myForm.email.focus();
        return false;
    }

    return  true ;
}