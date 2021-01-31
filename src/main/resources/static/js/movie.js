function validate() {
    var name = document.getElementById("name").value;
    var rating = document.getElementById("rating").value;
    var desc = document.getElementById("desc").value;

    if (document.myForm.name.value == "") {
        alert("Please input name !");
        document.myForm.name.focus();
        return false;
    }
    if (name.length >= 50) {
        alert("Maximum character name movies is 50 !");
        document.myForm.name.focus();
        return false;
    }
    if (rating == 0) {
        alert("Minimum rating 1 !");
        document.myForm.name.focus();
        return false;
    }
    if (document.myForm.rating.value == "") {
        alert("Please input phone !");
        document.myForm.rating.focus();
        return false;
    }
    if (desc.length >= 50) {
        alert("Maximum 50 Character !");
        document.myForm.desc.focus();
        return false;
    }

    return  true ;
}